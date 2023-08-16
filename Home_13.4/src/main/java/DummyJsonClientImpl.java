import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.classic.methods.HttpUriRequestBase;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class DummyJsonClientImpl implements DummyJsonClient {
    public static final int id = 1;


    @Override
    public Response<User> getUser(int id) {
        Response<User> trueResponse = new Response<>();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpGet get = new HttpGet("https://dummyjson.com/users/" + id);
            JSONObject result = takeResponse(get);
            trueResponse.setStatusCode(httpClient.execute(get).getCode());
            trueResponse.setJson(new User(result.getLong("id"), result.getString("username"), result.getString("password")));
        } catch (IOException | ParseException | JSONException e) {
            throw new RuntimeException(e);
        }
        return trueResponse;
    }


    @Override
    public Response<Token> login(User u) {
        Response<Token> trueResponse = new Response<>();
        HttpPost post = new HttpPost("https://dummyjson.com/auth/login");
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            post.addHeader("Content-Type", "application/json");
            JSONObject jsonObject = new JSONObject();
            jsonObject = jsonObject.put("username", u.getLogin());
            jsonObject = jsonObject.put("password", u.getPassword());
            post.setEntity(new StringEntity(jsonObject.toString()));
            JSONObject result = takeResponse(post);
            trueResponse.setStatusCode(httpClient.execute(post).getCode());
            trueResponse.json = (new Token(result.getString("token")));
        } catch (IOException | JSONException | ParseException e) {
            throw new RuntimeException(e);
        }
        return trueResponse;
    }

    @Override
    public Response<List<Post>> getPosts(User u, Token token) {
        Response<List<Post>> trueResponse = new Response<>();
        List<Post> postList = new ArrayList<>();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            StringBuilder str = new StringBuilder();
            str.append("https://dummyjson.com/posts/user/");
            str.append(u.getId());
            HttpGet get = new HttpGet(str.toString());
            get.addHeader("Content-Type", "application/json");
            get.addHeader("Authorization", token);
            JSONObject result = takeResponse(get);
            trueResponse.setStatusCode(httpClient.execute(get).getCode());
            JSONArray jsonArray = result.getJSONArray("posts");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Post postResponse = new Post(jsonObject.getInt("id"), jsonObject.getString("title"), jsonObject.getInt("userId"));
                postList.add(postResponse);
                trueResponse.setJson(postList);
            }

        } catch (IOException | JSONException | ParseException e) {
            throw new RuntimeException(e);
        }
        return trueResponse;
    }

    public User getDataUser(Response<User> resp) {
        return new User(resp.json.getId(), resp.json.getLogin(), resp.json.getPassword());
    }

    public Token getToken(Response<Token> resp) {
        return new Token(resp.json.getTokenValue());
    }

    public JSONObject takeResponse(HttpUriRequestBase request) throws IOException, ParseException, JSONException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            CloseableHttpResponse resp = httpClient.execute(request);
            HttpEntity respEnt = resp.getEntity();
            JSONObject result = new JSONObject(EntityUtils.toString(respEnt));
            resp.close();
            return result;
        }

    }

}

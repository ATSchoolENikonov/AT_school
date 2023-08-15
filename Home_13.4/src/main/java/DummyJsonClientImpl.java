import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
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
            CloseableHttpResponse resp = httpClient.execute(get);
            HttpEntity respEnt = resp.getEntity();
            trueResponse.setStatusCode(resp.getCode());
            String result = EntityUtils.toString(respEnt);
            trueResponse.json = (new JSONObject(result));
        } catch (IOException | ParseException | JSONException e) {
            throw new RuntimeException(e);
        }
        return trueResponse;
    }


    @Override
    public Response<Token> login(User u) {
        Response<Token> trueResponse = new Response<>();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost post = new HttpPost("https://dummyjson.com/auth/login");
            post.addHeader("Content-Type", "application/json");
            String jsonBody = "{"
                    + "\"username\": " + "\"" + u.getLogin() + "\"" + ","
                    + "\"password\": " + "\"" + u.getPassword() + "\""
                    + "}";
            post.setEntity(new StringEntity(jsonBody));
            CloseableHttpResponse resp = httpClient.execute(post);
            HttpEntity respEnt = resp.getEntity();
            trueResponse.setStatusCode(resp.getCode());
            String result = EntityUtils.toString(respEnt);
            trueResponse.json = (new JSONObject(result));
        } catch (IOException | JSONException | ParseException e) {
            throw new RuntimeException(e);
        }
        return trueResponse;
    }

    @Override
    public Response<Post> getPosts(User u, Token token) {
        Response<Post> trueResponse = new Response<>();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            StringBuilder str = new StringBuilder();
            str.append("https://dummyjson.com/posts/user/");
            str.append(u.getId());
            HttpGet get = new HttpGet(str.toString());
            get.addHeader("Content-Type", "application/json");
            get.addHeader("Authorization", getToken(login(getDataUser(getUser(id)))));
            CloseableHttpResponse resp = httpClient.execute(get);
            HttpEntity respEnt = resp.getEntity();
            trueResponse.setStatusCode(resp.getCode());
            String result = EntityUtils.toString(respEnt);
            trueResponse.json = (new JSONObject(result));
        } catch (IOException | JSONException | ParseException e) {
            throw new RuntimeException(e);
        }
        return trueResponse;
    }

    public User getDataUser(Response<User> resp) {
        User customUser = new User();
        try {
            customUser.setId(resp.json.getLong("id"));
            customUser.setLogin(resp.json.getString("username"));
            customUser.setPassword(resp.json.getString("password"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return customUser;
    }

    public Token getToken(Response<Token> resp) {
        Token tokenCredit=new Token();
        try {
            tokenCredit.setTokenValue(resp.json.getString("token"));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
        return tokenCredit;
    }

    public List<Post> getPost(Response<Post> resp) {
        List<Post> postList = new ArrayList<>();
        Post customPostOne = new Post();
        try {
            JSONArray jsonArray = resp.json.getJSONArray("posts");
            for (int i = 0; i < jsonArray.length(); i++) {
                Post customPost = new Post();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                customPost.setId(jsonObject.getInt("id"));
                customPost.setTitle(jsonObject.getString("title"));
                customPost.setUserId(jsonObject.getInt("userId"));
                postList.add(customPost);
            }

        } catch (JSONException e) {
            try {
                customPostOne.setId(resp.json.getInt("id"));
                customPostOne.setTitle(resp.json.getString("title"));
                customPostOne.setUserId(resp.json.getInt("userId"));
                postList.add(customPostOne);
            } catch (JSONException ex) {
                throw new RuntimeException(ex);
            }
        }
        return postList;
    }
}

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
            JSONObject result = new JSONObject(EntityUtils.toString(respEnt));
            trueResponse.setJson(new User(result.getLong("id"), result.getString("username"), result.getString("password")));
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
            JSONObject result = new JSONObject(EntityUtils.toString(respEnt));
            trueResponse.json = (new Token(result.getString("token")));
        } catch (IOException | JSONException | ParseException e) {
            throw new RuntimeException(e);
        }
        return trueResponse;
    }

    @Override
    public List<Response<Post>> getPosts(User u, Token token) {
        List<Response<Post>> trueResponse = new ArrayList<>();
//        List<Post> postList = new ArrayList<>();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            StringBuilder str = new StringBuilder();
            str.append("https://dummyjson.com/posts/user/");
            str.append(u.getId());
            HttpGet get = new HttpGet(str.toString());
            get.addHeader("Content-Type", "application/json");
            get.addHeader("Authorization", getToken(login(getDataUser(getUser(id)))));
            CloseableHttpResponse resp = httpClient.execute(get);
            HttpEntity respEnt = resp.getEntity();
            JSONObject result = new JSONObject(EntityUtils.toString(respEnt));
            JSONArray jsonArray = result.getJSONArray("posts");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                Response<Post> postResponse= new Response<>();
                postResponse.setStatusCode(resp.getCode());
                postResponse.setJson(new Post(jsonObject.getInt("id"), jsonObject.getString("title"), jsonObject.getInt("userId")));
//                customPost.setId(jsonObject.getInt("id"));
//                customPost.setTitle(jsonObject.getString("title"));
//                customPost.setUserId(jsonObject.getInt("userId"));
//                postList.add(customPost);
                trueResponse.add(postResponse);
            }
//            trueResponse.json = (new Post(result.getInt("id"),result.getString("title"),result.getInt("userId")));
//            postList.add(trueResponse.json);
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

//    public List<Post> getPost(List<Response<Post>> resp) {
//
//        for (int i = 0; i < resp.size(); i++) {
//
//        }
////        try {
////            JSONArray jsonArray = resp.json.getJSONArray("posts");
////            for (int i = 0; i < jsonArray.length(); i++) {
////                Post customPost = new Post();
////                JSONObject jsonObject = jsonArray.getJSONObject(i);
////                customPost.setId(jsonObject.getInt("id"));
////                customPost.setTitle(jsonObject.getString("title"));
////                customPost.setUserId(jsonObject.getInt("userId"));
////                postList.add(customPost);
////            }
////
////        } catch (JSONException e) {
////            try {
////                customPostOne.setId(resp.json.getInt("id"));
////                customPostOne.setTitle(resp.json.getString("title"));
////                customPostOne.setUserId(resp.json.getInt("userId"));
////                postList.add(customPostOne);
////            } catch (JSONException ex) {
////                throw new RuntimeException(ex);
////            }
////        }
//        return postList;
//    }
}

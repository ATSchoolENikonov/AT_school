import org.apache.hc.client5.http.classic.methods.HttpGet;
import org.apache.hc.client5.http.classic.methods.HttpPost;
import org.apache.hc.client5.http.impl.classic.CloseableHttpClient;
import org.apache.hc.client5.http.impl.classic.CloseableHttpResponse;
import org.apache.hc.client5.http.impl.classic.HttpClients;
import org.apache.hc.core5.http.HttpEntity;
import org.apache.hc.core5.http.ParseException;
import org.apache.hc.core5.http.io.entity.EntityUtils;
import org.apache.hc.core5.http.io.entity.StringEntity;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class DummyJsonClientImpl implements DummyJsonClient {
    public static final int id = 1;

    @Override
    public Response getUser(int id) {
        Response trueResponse = new Response();
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
    public Response login(User u) {
        Response trueResponse = new Response();
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
    public Response getPosts(User u, Token token) {
        Response trueResponse = new Response();
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            StringBuilder str = new StringBuilder();
            str.append("https://dummyjson.com/posts/user/");
            str.append(u.getId());
            HttpGet get = new HttpGet(str.toString());
            get.addHeader("Content-Type", "application/json");
            get.addHeader("Authorization", token.getToken(login(u.getDataUser(getUser(id)))));
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
}

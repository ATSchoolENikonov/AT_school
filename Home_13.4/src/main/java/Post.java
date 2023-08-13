import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class Post {
    private int id;
    private String title;
    private Object userId;

    public List<Post> getPost(Response resp) {
        List<Post> postList = new ArrayList<>();
        Post customPostOne = new Post();
        try {
            JSONArray jsonArray = resp.json.getJSONArray("posts");
            for (int i = 0; i < jsonArray.length(); i++) {
                Post customPost = new Post();
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                customPost.id = jsonObject.getInt("id");
                customPost.title = jsonObject.getString("title");
                customPost.userId = jsonObject.getInt("userId");
                postList.add(customPost);
            }

        } catch (JSONException e) {
            try {
                customPostOne.id = resp.json.getInt("id");
                customPostOne.title = resp.json.getString("title");
                customPostOne.userId = resp.json.getInt("userId");
                postList.add(customPostOne);
            } catch (JSONException ex) {
                throw new RuntimeException(ex);
            }
        }
        return postList;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", userId=" + userId +
                '}';
    }
}

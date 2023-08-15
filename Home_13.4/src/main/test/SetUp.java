import java.util.ArrayList;
import java.util.List;

public class SetUp {

    public Response<User> getExpectedUser() {
        Response<User> response = new Response<>();
        response.setStatusCode(200);
        response.setJson(new User(1,"atuny0","9uQFF1Lh"));
        return response;
    }
    public List<Response<Post>> getExpectedPost() {
        List<Response<Post>> response = new ArrayList<>();
        Post post1=new Post(10,"They rushed out the door.",1);
        Post post2=new Post(14,"The paper was blank.",1);
        Post post3=new Post(95,"So what is the answer? How can you stand",1);
        List<Post> postList=List.of(post1,post2,post3);
        for (int i = 0; i < postList.size(); i++) {
            Response<Post> postResponse=new Response<>();
            postResponse.setStatusCode(200);
            postResponse.setJson(postList.get(i));
            response.add(postResponse);
        }
        return response;
    }


}

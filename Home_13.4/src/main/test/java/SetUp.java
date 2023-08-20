import java.util.List;

public class SetUp {
    DummyJsonClientImpl impl = new DummyJsonClientImpl();
    Response<User> response = impl.getUser(DummyJsonClientImpl.id);
    User user=impl.getDataUser(response);
    Token token=impl.getToken(impl.login(user));


    public Response<User> getExpectedUser() {
        Response<User> response = new Response<>();
        response.setStatusCode(200);
        response.setJson(new User(1,"atuny0","9uQFF1Lh"));
        return response;
    }
    public Response<List<Post>> getExpectedPost() {
        Response<List<Post>>  response = new Response<>();
        response.setStatusCode(200);
        Post post1=new Post(10,"They rushed out the door.",1);
        Post post2=new Post(14,"The paper was blank.",1);
        Post post3=new Post(95,"So what is the answer? How can you stand",1);
        List<Post> postList=List.of(post1,post2,post3);
        response.setJson(postList);
        return response;
    }


}

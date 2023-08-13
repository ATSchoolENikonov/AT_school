

public class Launch {
    public static void main(String[] args) {
        DummyJsonClientImpl impl = new DummyJsonClientImpl();
        User user = new User();
        Token token = new Token();
        Post post = new Post();
        Response response = impl.getUser(DummyJsonClientImpl.id);
        System.out.println(response);
        System.out.println(impl.login(user.getDataUser(response)));
        System.out.println(impl.getPosts(user.getDataUser(response), token));
        Response postResp = impl.getPosts(user.getDataUser(response), token);
        System.out.println(post.getPost(postResp));
    }
}

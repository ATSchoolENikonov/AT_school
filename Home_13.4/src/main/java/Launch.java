

public class Launch {
    public static void main(String[] args) {
        DummyJsonClientImpl impl = new DummyJsonClientImpl();
        Response<User> response = impl.getUser(DummyJsonClientImpl.id);
        User user=impl.getDataUser(response);
        Token token=impl.getToken(impl.login(user));
        System.out.println(response);
        System.out.println(impl.login(user));
        System.out.println(impl.getPosts(user, token));
        Response<Post> postResp = impl.getPosts(user, token);
        System.out.println(impl.getPost(postResp));
    }
}

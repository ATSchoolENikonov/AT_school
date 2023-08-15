import java.util.List;

public interface DummyJsonClient {
    // dummyjson.com/users/{id}
    Response<User> getUser(int id);

    // dummyjson.com/auth/login/
    Response<Token> login(User u);

    // dummyjson.com/auth/posts/{user.id}
   Response<List<Post>> getPosts(User u, Token token);
}

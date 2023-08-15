import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ApacheTest {
    SetUp setUp = new SetUp();
    DummyJsonClientImpl impl = new DummyJsonClientImpl();
    Response<User> response = impl.getUser(DummyJsonClientImpl.id);
    User user=impl.getDataUser(response);
    Token token=impl.getToken(impl.login(user));


    @Test
    void checkGetUser() {
        Response<User> expected = setUp.getExpectedUser();
        Response<User> actual=response;
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void checkGetToken() {
        Response<Token> actual= impl.login(user);
        Assertions.assertNotNull(actual);
    }
    @Test
    void checkGetPost() {
        Response<List<Post>> expected = setUp.getExpectedPost();
        Response<List<Post>> actual=impl.getPosts(user,token);
        Assertions.assertEquals(expected,actual);
    }
}

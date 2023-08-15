import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

public class ApacheTest {
    SetUp setUp = new SetUp();

    @Test
    void checkGetUser() {
        Response<User> expected = setUp.getExpectedUser();
        Response<User> actual=setUp.impl.getUser(DummyJsonClientImpl.id);
        Assertions.assertEquals(expected, actual);
    }
    @Test
    void checkGetToken() {
        Response<Token> actual= setUp.impl.login(setUp.user);
        Assertions.assertNotNull(actual);
    }
    @Test
    void checkGetPost() {
        Response<List<Post>> expected = setUp.getExpectedPost();
        Response<List<Post>> actual=setUp.impl.getPosts(setUp.user,setUp.token);
        Assertions.assertEquals(expected,actual);
    }
}

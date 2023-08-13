import org.json.JSONException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.skyscreamer.jsonassert.JSONAssert;

public class ApacheTest {
    DummyJsonClientImpl impl = new DummyJsonClientImpl();
    User user = new User();
    Token token = new Token();
    Post post = new Post();
    SetUp setUp = new SetUp();


    @Test
    void checkgetUser() {
        Response expected = setUp.getExpectedUser();
        Response actual=impl.getUser(DummyJsonClientImpl.id);
        Assertions.assertEquals(expected.getStatusCode(),actual.getStatusCode());
        try {
            JSONAssert.assertEquals(expected.getJson(),actual.getJson(),false);
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }


    }
}

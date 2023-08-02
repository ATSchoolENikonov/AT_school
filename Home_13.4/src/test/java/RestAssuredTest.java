import io.restassured.specification.RequestSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RestAssuredTest {
    RequestSpecification req = given().baseUri("http://httpbin.org/");

    @Test
    public void checkGet() {
        req
                .param("p1", "v1")
                .param("p2", "v2")
                .when()
                .get("/anything")
                .then()
                .assertThat()
                .statusCode(200)
                .body("args.p1", equalTo("v1"))
                .body("args.p2", equalTo("v2"));
    }

    @Test
    public void checkPost() {
        String body = "{\n" +
                "     \"parameter\": \"value\"\n" +
                "   }";
        req.body(body)
                .post("/anything")
                .then()
                .assertThat()
                .statusCode(200)
                .body("json.parameter",equalTo("value"));
    }
    @Test
    public void checkAuth(){
        req.given()
                .auth()
                .basic("user", "password")
                .when()
                .get("/basic-auth/user/password")
                .then()
                .assertThat()
                .statusCode(200);
    }
    @Test
    public void checkAuthToken(){
        req.given()
                .auth()
                .oauth2("wqerfafa")
                .when()
                .get("/bearer")
                .then()
                .assertThat()
                .statusCode(200);
    }
}

package apiMy;

import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;


public class RestAssuredTest {
    RequestSpecification req = given().baseUri("http://httpbin.org/");
    private static final Logger logger= LogManager.getLogger(RestAssuredTest.class);
    @BeforeAll
    public static void logLevel(){
        logger.info("RestAssured Test has begun");
    }

    @Test
    @DisplayName("Проверить гет")
    public void checkGet() {
        logger.debug("-----Step starts here-----");
        req.log().all()
                .param("p1", "v1")
                .param("p2", "v2")
                .when()
                .get("/anything")
                .then().log().ifValidationFails(LogDetail.BODY)
                .assertThat()
                .statusCode(200)
                .body("args.p1", equalTo("v1"))
                .body("args.p2", equalTo("v2"));
    }

    @Test
    @DisplayName("Проверить пост")
    public void checkPost() {
        logger.debug("-----Step starts here-----");
        String body = "{\n" +
                "     \"parameter\": \"value\"\n" +
                "   }";
        req.body(body).log().body()
                .post("/anything")
                .then().log().ifValidationFails(LogDetail.BODY)
                .assertThat()
                .statusCode(200)
                .body("json.parameter",equalTo("value"));
    }
    @Test
    @DisplayName("Проверить аутентификацию")
    public void checkAuth(){
        logger.debug("-----Step starts here-----");
        req.given().log().all()
                .auth()
                .basic("user", "password")
                .when()
                .get("/basic-auth/user/password")
                .then().log().ifValidationFails(LogDetail.BODY)
                .assertThat()
                .statusCode(200);
    }
    @Test
    @DisplayName("Проверить логин по токену")
    public void checkAuthToken(){
        logger.debug("-----Step starts here-----");
        req.given().log().all()
                .auth()
                .oauth2("wqerfafa")
                .when()
                .get("/bearer")
                .then().log().ifValidationFails(LogDetail.BODY)
                .assertThat()
                .statusCode(200);
    }
}

import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.given;

public class RestAssuredTEst {
    @Test
    void simpleTest() {
        RequestSpecification requestSpecification = given()
                .baseUri("https://stepik.org/");
        requestSpecification.when()
                .get("course/51562/")
                .then()
                .statusCode(200);
        System.out.println("Twst correct");
        requestSpecification.when()
                .get("egwgwg")
                .then()
                .statusCode(404);

        System.out.println("Twst %2151");
        ResponseSpecification responseSpecification = expect().statusCode(200);

        given()
                .baseUri("https://stepik.org/")
                .expect()
                .spec(responseSpecification)
                .when()
                .get("course/51562/");
        System.out.println("Test correct response");
    }
}

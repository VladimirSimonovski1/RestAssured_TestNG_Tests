package client;

import io.restassured.http.ContentType;

import static io.restassured.RestAssured.given;
import static validation.spec.ResponseSpec.expect201StatusCode;

public abstract class Base {

    public static void post(String token, Object body, String endpoint) {
        given().header("Content-Type", ContentType.JSON).header("Authorization", "Bearer " + token).
                and().body(body).
                when().post(endpoint).
                then().spec(expect201StatusCode);
    }
}

package client;

import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;
import model.RegisterLoginResponseModel;

import java.lang.reflect.Type;

import static io.restassured.RestAssured.given;

public abstract class Base {

    public static <T> T get(String token, String endpoint, ResponseSpecification statusCode, Type type) {
        return given().header("Content-Type", ContentType.JSON).header("Authorization", "Bearer " + token).
                when().get(endpoint).
                then().spec(statusCode).log().all().extract().body().as(type);
    }

    public static <T> T post(String token, Object body, String endpoint, ResponseSpecification statusCode, Type type) {
        return given().header("Content-Type", ContentType.JSON).header("Authorization", "Bearer " + token).
                and().body(body).
                when().post(endpoint).
                then().spec(statusCode).log().all().extract().body().as(type);
    }

    public static String post(Object body, String endpoint, ResponseSpecification statusCode) {
        return given().header("Content-Type", ContentType.JSON).
                and().body(body).
                when().post(endpoint).
                then().spec(statusCode).log().all().extract().body().as(RegisterLoginResponseModel.class).getToken();
    }

    public static void post(String endpoint, ResponseSpecification statusCode) {
        given().header("Content-Type", ContentType.JSON).
                when().post(endpoint).
                then().spec(statusCode).log().all();
    }

    public static <T> T put(String token, Object body, String endpoint, ResponseSpecification statusCode, Type type) {
        return given().header("Content-Type", ContentType.JSON).header("Authorization", "Bearer " + token).
                and().body(body).
                when().put(endpoint).
                then().spec(statusCode).log().all().extract().body().as(type);
    }

    public static void delete(String token, String endpoint, ResponseSpecification statusCode) {
        given().header("Content-Type", ContentType.JSON).header("Authorization", "Bearer " + token).
                when().delete(endpoint).
                then().spec(statusCode).log().all();
    }
}

import io.restassured.http.ContentType;
import model.RegisterLoginResponseModel;
import model.UsersResponseModel;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static client.Clients.createUser;
import static config.Endpoints.GET_USERS;
import static config.Endpoints.LOGIN;
import static io.restassured.RestAssured.given;
import static payload.RegisterLoginRequestPayload.registerLoginRequestBody;
import static payload.UserRequestPayload.userRequestBody;
import static validation.assertion.TestAssertion.assertSuccessfulGetUsersResponse;
import static validation.spec.ResponseSpec.expect200StatusCode;


public class RestAssuredTestNGTests {

    private static String loginToken;
    private UsersResponseModel userResponseBody;

    @BeforeClass
    public void login() {
        loginToken =
                given().header("Content-Type", ContentType.JSON).
                        and().body(registerLoginRequestBody).
                        when().post(LOGIN).
                        then().assertThat().spec(expect200StatusCode).
                        and().extract().body().as(RegisterLoginResponseModel.class).getToken();

        System.out.println("BODY: " + registerLoginRequestBody);
        System.out.println("LOGIN TOKEN: " + loginToken);
    }

    @Test
    public void getUsersTest(){
        userResponseBody = given().header("Authorization", "Bearer " + loginToken).
                        when().get(GET_USERS).
                        then().assertThat().spec(expect200StatusCode).
                        and().extract().body().as(UsersResponseModel.class);

        assertSuccessfulGetUsersResponse(userResponseBody);
    }

    @Test
    public void createUserTest(){
        createUser(loginToken, userRequestBody);

    }
}

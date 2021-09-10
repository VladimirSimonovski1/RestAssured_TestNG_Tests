import lombok.extern.java.Log;
import model.UserRequestModel;
import model.UserResponseModel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import util.UserDataProvider;

import static client.Clients.createUser;
import static client.Clients.getTokenFromApi;
import static client.Clients.getUser;
import static client.Clients.logoutFromApi;
import static payload.RegisterLoginRequestPayload.registerLoginRequestBody;
import static payload.UserRequestPayload.userRequestBody;
import static validation.assertion.TestAssertion.assertSuccessfulCreateUsersResponse;
import static validation.assertion.TestAssertion.assertSuccessfulGetUserResponse;

@Log
public class RestAssuredTestNGTestsDataProvider {

    private static String loginToken;

    @BeforeClass
    public void login() {
        loginToken = getTokenFromApi(registerLoginRequestBody);
        log.info("GET TOKEN RESPONSE BODY: " + registerLoginRequestBody);
        log.info("LOGIN TOKEN: " + loginToken);
    }

    @AfterClass
    public void logout() {
        logoutFromApi();
        log.info("LOGOUT SUCCESSFUL!");
    }

    @Test (dataProvider = "getUserPerIdDataProvider", dataProviderClass = UserDataProvider.class)
    public void shouldGetUsersPerId(int userId, String email, String firstName, String lastName, String avatar) {
        UserResponseModel userResponseBody = getUser(loginToken, userId);
        log.info("GET USER RESPONSE BODY: " + userResponseBody);
        assertSuccessfulGetUserResponse(userResponseBody, userId, email, firstName, lastName, avatar);
    }

    @Test (dataProvider = "createUsersDataProvider", dataProviderClass = UserDataProvider.class)
    public void shouldCreateUsers(String name, String job) {
        UserRequestModel userResponseBody = createUser(loginToken, userRequestBody(name, job));
        log.info("CREATE USER RESPONSE BODY: " + userResponseBody);
        assertSuccessfulCreateUsersResponse(userResponseBody, name, job);
    }
}

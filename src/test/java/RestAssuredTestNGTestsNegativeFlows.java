import lombok.extern.java.Log;
import model.UserRequestModel;
import model.UserResponseModel;
import model.UsersResponseModel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static client.Clients.createUser;
import static client.Clients.deleteUser;
import static client.Clients.getEmptyResponse;
import static client.Clients.getTokenFromApi;
import static client.Clients.getUser;
import static client.Clients.getUsers;
import static client.Clients.logoutFromApi;
import static client.Clients.updateUser;
import static payload.RegisterLoginRequestPayload.registerLoginRequestBody;
import static payload.UserRequestPayload.userCreateBody;
import static payload.UserRequestPayload.userUpdateBody;
import static validation.assertion.TestAssertion.assertSuccessfulCreateUsersResponse;
import static validation.assertion.TestAssertion.assertSuccessfulGetUserResponse;
import static validation.assertion.TestAssertion.assertSuccessfulGetUsersResponse;
import static validation.assertion.TestAssertion.assertSuccessfulUpdateUsersResponse;

@Log
public class RestAssuredTestNGTestsNegativeFlows {

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

    @Test
    public void shouldGetEmptyResponseForUserNotFound() {
        getEmptyResponse(loginToken, 1534036, 0);
    }
}

import lombok.extern.java.Log;
import model.RegisterLoginResponseModel;
import model.UserRequestModel;
import model.UserResponseModel;
import model.UsersResponseModel;
import model.submodel.UserDataModel;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static client.Clients.createUser;
import static client.Clients.deleteUser;
import static client.Clients.getTokenFromApi;
import static client.Clients.getUser;
import static client.Clients.getUsers;
import static client.Clients.logoutFromApi;
import static client.Clients.registerUser;
import static client.Clients.updateUser;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static payload.RegisterLoginRequestPayload.registerLoginRequestBody;
import static payload.UserRequestPayload.userCreateBody;
import static payload.UserRequestPayload.userUpdateBody;
import static validation.assertion.TestAssertion.assertSuccessfulCreateUsersResponse;
import static validation.assertion.TestAssertion.assertSuccessfulGetUserResponse;
import static validation.assertion.TestAssertion.assertSuccessfulGetUsersResponse;
import static validation.assertion.TestAssertion.assertSuccessfulRegisterUsersResponse;
import static validation.assertion.TestAssertion.assertSuccessfulUpdateUsersResponse;

@Log
public class RestAssuredTestNGTestsHappyFlows {

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
    public void shouldGetUsersTest() {
        UsersResponseModel userResponseBody = getUsers(loginToken);
        log.info("GET USERS RESPONSE BODY: " + userResponseBody);
        assertSuccessfulGetUsersResponse(userResponseBody);
    }

    @Test
    public void shouldGetUsersTestStream() {
        UsersResponseModel userResponseBody = getUsers(loginToken);
        log.info("GET USERS RESPONSE BODY: " + userResponseBody);
        userResponseBody.getData().stream().filter(item -> item.getFirst_name().equals("Eve"))
                .collect((Collectors.toList())).forEach(System.out::println);
        boolean isTrue = userResponseBody.getData().stream().allMatch(item -> item.getAvatar().contains("test"));
        assertThat(isTrue, is(equalTo(true)));
        userResponseBody.getData().stream()
                .filter(item -> item.getEmail().startsWith("e")).collect(Collectors.toList()).forEach(System.out::println);

    }

    @Test
    public void shouldGetUserTest() {
        UserResponseModel userResponseBody = getUser(loginToken, 1);
        log.info("GET USER RESPONSE BODY: " + userResponseBody);
        assertSuccessfulGetUserResponse(userResponseBody);
    }

    @Test
    public void shouldCreateUserTest() {
        UserRequestModel userResponseBody =  createUser(loginToken, userCreateBody);
        log.info("CREATE USER RESPONSE BODY: " + userResponseBody);
        assertSuccessfulCreateUsersResponse(userResponseBody);
    }

    @Test
    public void shouldUpdateUserTest() {
        UserRequestModel userResponseBody = updateUser(loginToken, userUpdateBody);
        log.info("UPDATE USER RESPONSE BODY: " + userResponseBody);
        assertSuccessfulUpdateUsersResponse(userResponseBody);
    }

    @Test
    public void shouldDeleteUserTest() {
        deleteUser(loginToken);
        log.info("SUCCESSFULLY DELETED USER!");
    }

    @Test
    public void shouldRegisterNewUser() {
        RegisterLoginResponseModel registerResponseBody = registerUser(loginToken, registerLoginRequestBody);
        log.info("REGISTER NEW USER RESPONSE BODY: " + registerResponseBody);
        assertSuccessfulRegisterUsersResponse(registerResponseBody);
    }
}

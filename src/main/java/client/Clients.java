package client;

import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import model.UserRequestModel;
import model.UserResponseModel;
import model.UsersResponseModel;

import static config.Endpoints.CREATE_USER;
import static config.Endpoints.DELETE_USER;
import static config.Endpoints.GET_USER;
import static config.Endpoints.GET_USERS;
import static config.Endpoints.LOGIN;
import static config.Endpoints.LOGOUT;
import static config.Endpoints.UPDATE_USER;
import static validation.spec.ResponseSpec.expect200StatusCode;
import static validation.spec.ResponseSpec.expect201StatusCode;
import static validation.spec.ResponseSpec.expect204StatusCode;

public class Clients extends Base {

    public static String getTokenFromApi(Object payload) {
        return post(payload, LOGIN, expect200StatusCode);
    }

    public static void logoutFromApi() {
        post(LOGOUT, expect200StatusCode);
    }

    public static UsersResponseModel getUsers(String token) {
        return get(token, GET_USERS, expect200StatusCode, UsersResponseModel.class);
    }

    public static UserResponseModel getUser(String token, int userId) {
        return get(token, GET_USER + userId, expect200StatusCode, UserResponseModel.class);
    }

    public static UserRequestModel createUser(String token, Object payload) {
        return post(token, payload, CREATE_USER, expect201StatusCode, UserRequestModel.class);
    }

    public static UserRequestModel updateUser(String token, Object payload) {
        return put(token, payload, UPDATE_USER, expect200StatusCode, UserRequestModel.class);
    }

    public static void deleteUser(String token) {
        delete(token, DELETE_USER, expect204StatusCode);
    }
}

package client;

import model.UserResponseModel;

import static config.Endpoints.CREATE_USER;

public class Clients extends Base {

    public static void createUser(String token, Object payload) {
        post(token, payload, CREATE_USER);
    }
}

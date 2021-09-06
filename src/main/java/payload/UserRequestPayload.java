package payload;

import model.UserRequestModel;

public class UserRequestPayload {

    public static UserRequestModel userCreateBody = UserRequestModel.builder()
            .name("Vladimir")
            .job("QA")
            .build();

    public static UserRequestModel userUpdateBody = UserRequestModel.builder()
            .name("Test")
            .job("Test")
            .build();
}

package payload;

import com.fasterxml.jackson.core.JsonProcessingException;
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

    public static UserRequestModel userRequestBody(String name, String job) {
        return UserRequestModel.builder()
                .name(name)
                .job(job)
                .build();
    }
}

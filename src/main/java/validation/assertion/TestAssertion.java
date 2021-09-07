package validation.assertion;

import io.restassured.response.Response;
import model.UserRequestModel;
import model.UserResponseModel;
import model.UsersResponseModel;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.empty;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.hasProperty;
import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class TestAssertion {

    public static void assertSuccessfulGetUsersResponse(UsersResponseModel usersResponseBody) {
        assertThat(usersResponseBody, allOf(
                hasProperty("page", is(equalTo(1))),
                hasProperty("per_page", is(equalTo(6))),
                hasProperty("total", is(equalTo(12))),
                hasProperty("total_pages", is(equalTo(2))),
                hasProperty("data", hasItem(allOf(
                                hasProperty("id", is(equalTo(1))),
                                hasProperty("email", is(equalTo("george.bluth@reqres.in"))),
                                hasProperty("first_name", is(equalTo("George"))),
                                hasProperty("last_name", is(equalTo("Bluth"))),
                                hasProperty("avatar", is(equalTo("https://reqres.in/img/faces/1-image.jpg")))
                        )
                )),
                hasProperty("support", allOf(
                        hasProperty("url", is(equalTo("https://reqres.in/#support-heading"))),
                        hasProperty("text", is(equalTo("To keep ReqRes free, contributions towards server costs are appreciated!")))
                ))
        ));
    }

    public static void assertSuccessfulGetUserResponse(UserResponseModel userResponseBody) {
        assertThat(userResponseBody, allOf(
                hasProperty("data", allOf(
                                hasProperty("id", is(equalTo(1))),
                                hasProperty("email", is(equalTo("george.bluth@reqres.in"))),
                                hasProperty("first_name", is(equalTo("George"))),
                                hasProperty("last_name", is(equalTo("Bluth"))),
                                hasProperty("avatar", is(equalTo("https://reqres.in/img/faces/1-image.jpg")))
                        )
                ),
                hasProperty("support", allOf(
                        hasProperty("url", is(equalTo("https://reqres.in/#support-heading"))),
                        hasProperty("text", is(equalTo("To keep ReqRes free, contributions towards server costs are appreciated!")))
                ))
        ));
    }

    public static void assertSuccessfulCreateUsersResponse(UserRequestModel userRequestBody) {
        assertThat(userRequestBody, allOf(
                hasProperty("name", is(equalTo("Vladimir"))),
                hasProperty("job", is(equalTo("QA"))),
                hasProperty("id", is(notNullValue())),
                hasProperty("createdAt", is(notNullValue()))
        ));
    }

    public static void assertSuccessfulUpdateUsersResponse(UserRequestModel userRequestBody) {
        assertThat(userRequestBody, allOf(
                hasProperty("name", is(equalTo("Test"))),
                hasProperty("job", is(equalTo("Test"))),
                hasProperty("updatedAt", is(notNullValue()))
        ));
    }
}

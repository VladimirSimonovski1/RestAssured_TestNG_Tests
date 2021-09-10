package util;

import org.testng.annotations.DataProvider;

public class UserDataProvider {

    @DataProvider(name = "getUserPerIdDataProvider")
    public static Object[][] getDataProvider() {
        return new Object[][]{
                {1, "george.bluth@reqres.in", "George", "Bluth", "https://reqres.in/img/faces/1-image.jpg"},
                {2, "janet.weaver@reqres.in", "Janet", "Weaver", "https://reqres.in/img/faces/2-image.jpg"},
                {3, "emma.wong@reqres.in", "Emma", "Wong", "https://reqres.in/img/faces/3-image.jpg"},
                {4, "eve.holt@reqres.in", "Eve", "Holt", "https://reqres.in/img/faces/4-image.jpg"},
                {5, "charles.morris@reqres.in", "Charles", "Morris", "https://reqres.in/img/faces/5-image.jpg"},
        };
    }

    @DataProvider(name = "createUsersDataProvider")
    public static Object[][] createDataProvider() {
        return new Object[][]{
                {"Roman Reigns", "superman punch"},
                {"Seth Rollins", "curb stomp"},
                {"Dean Ambrose", "dirty deeds"},
        };
    }
}

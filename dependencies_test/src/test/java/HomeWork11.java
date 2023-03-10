import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWork11 {

    @Test
    public void gettingCookie(){
        Response gettingCookie = RestAssured

                .get("https://playground.learnqa.ru/api/homework_cookie")
                .andReturn();

        String resultCookie = gettingCookie.getCookie("HomeWork");
        String expectedCookie = "hw_value";
        assertTrue((resultCookie.equals(expectedCookie)), "Unexpected Cookie");

    }

}

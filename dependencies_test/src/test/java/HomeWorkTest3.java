import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

public class HomeWorkTest3 {
    @Test
    public void testRedirect2 (){
        Response response = RestAssured
                .given()
                .redirects()
                .follow(false)
                .when()
                .get("https://playground.learnqa.ru/api/long_redirect")
                .andReturn();

        String locationHeaders = response.getHeader("Location");
        System.out.println(locationHeaders);
        int statusCode = response.getStatusCode();
        if (statusCode != 200) {
            Response response1 = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(locationHeaders)
                    .andReturn();
            String locationHeaders2 = response1.getHeader("Location");
            System.out.println(locationHeaders2);
        } else {
            System.out.println(locationHeaders);
        }
    }

}

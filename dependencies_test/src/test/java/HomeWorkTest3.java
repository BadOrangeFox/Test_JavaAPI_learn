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
        int statusCode = response.getStatusCode();
        String location;

        while (statusCode != 200) {
            Response response1 = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(locationHeaders)
                    .andReturn();
            locationHeaders = response1.getHeader("Location");

            if (locationHeaders != null)
                System.out.println("Status code " + statusCode);
            location = locationHeaders;
            statusCode = response1.getStatusCode();

            if (locationHeaders == null) {
                System.out.println("Итоговый редирект " + location);
                System.out.println("Status code: " + statusCode);
                break;

            } else {
                System.out.println("Перенаправление на " + locationHeaders);}
                System.out.println("Status code: " + statusCode);


        }
    }

}

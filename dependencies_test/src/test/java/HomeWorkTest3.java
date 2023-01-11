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
        System.out.println("Доступен переход на "+locationHeaders);
        int statusCode = response.getStatusCode();
        System.out.println("Status code "+statusCode);

        while (statusCode != 200) {
            Response response1 = RestAssured
                    .given()
                    .redirects()
                    .follow(false)
                    .when()
                    .get(locationHeaders)
                    .andReturn();
            locationHeaders = response1.getHeader("Location");
            statusCode = response1.getStatusCode();
            if (locationHeaders == null) {
                System.out.println("Итоговый переход "+locationHeaders);
                System.out.println("Status code "+statusCode);
                break;
            } else {
                System.out.println("Доступен переход на "+locationHeaders);}
                System.out.println("Status code "+statusCode);
        }

    }

}

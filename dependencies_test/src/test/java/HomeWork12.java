import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWork12 {

    @Test
    public void gettingHeaders(){
        Response gettingHeaders = RestAssured

                .get("https://playground.learnqa.ru/api/homework_header")
                .andReturn();

        String resultHeader = gettingHeaders.getHeader("x-secret-homework-header");

        String expectedHeader = "Some secret value";

        if (Objects.equals(resultHeader, expectedHeader)){
            System.out.println("Равенство корректно, чертов Ассерт");
        }   else {
            System.out.println("Беда, код не работает, хз че делать");
        }

        assertTrue ((resultHeader.equals(expectedHeader)), "Unexpected Header");

    }
}

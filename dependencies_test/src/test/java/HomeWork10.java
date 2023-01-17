import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class HomeWork10 {
    @ParameterizedTest
    @ValueSource (strings = {"John", "User", "Gregorbrnjejtikevich"})

    public void testForLength(String nameForTest){

        JsonPath getStatusAndTest = RestAssured
                .given()
                .queryParam("name", nameForTest)
                .get("https://playground.learnqa.ru/api/hello")
                .jsonPath();
        String expectedResultForTest = getStatusAndTest.getString("answer");
        int expectedResultForTestLength = expectedResultForTest.length () ;

        assertTrue(15 <= expectedResultForTestLength,  "Длинна ответа меньше, чем 15 символов");

    }
}

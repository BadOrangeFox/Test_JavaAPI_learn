import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

public class HomeWorkTest1 {
    @Test
    public void main(){
        JsonPath response = RestAssured
                .get("https://playground.learnqa.ru/api/get_json_homework")
                .jsonPath();
        Object testObject = response.get("messages");

        System.out.println(testObject);
    }

}

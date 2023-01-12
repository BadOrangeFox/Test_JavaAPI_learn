import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.junit.jupiter.api.Test;

import java.util.Objects;

public class TestTokenGet {
    @Test
    public void testRedirect2 () throws InterruptedException {
        JsonPath responseTokenAndCreateTusk = RestAssured  //создаем задачу и получаем токен
                .given()
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();

        String responsesToken = responseTokenAndCreateTusk.get("token"); //кладем токен в переменную
        int responseTime = responseTokenAndCreateTusk.get("seconds"); //кладем время в переменную

        JsonPath getTuskStatus = RestAssured  //проверяем статус по задаче согласно токену
                .given()
                .queryParams("token", responsesToken)
                .when()
                .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                .jsonPath();
        System.out.println("Задача создана");
        String responsesStatus = getTuskStatus.get("status");
        String shittyString = "Job is NOT ready";
        System.out.println("Статус выполнения задачи: "+ responsesStatus);

            if (Objects.equals(responsesStatus, shittyString)) {
            Thread.sleep(responseTime * 1000L);

            JsonPath putTuskTime = RestAssured //
                    .given()
                    .queryParams("token", responsesToken)
                    .when()
                    .get("https://playground.learnqa.ru/ajax/api/longtime_job")
                    .jsonPath();
                String status3 = putTuskTime.get("status");
                System.out.println("Статус выполнения задачи: "+ status3);
                String resultPutTuskTime = putTuskTime.get("result");
                System.out.println("Результат выполненной задачи: "+ resultPutTuskTime);

        }  else {
                String result = getTuskStatus.get("status");
                System.out.println(result);
        }
    }
}

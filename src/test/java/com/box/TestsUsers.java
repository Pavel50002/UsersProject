package com.box;

import EndPoints.EndPoints;
import io.restassured.http.ContentType;
import net.minidev.json.JSONObject;
import org.hamcrest.Matchers;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;


public class TestsUsers extends TestBase {
    int random = random();

    @Test(description = "Создаем пользователя")
    public void CreateUser() {
        String mail = "Pavel" + random + "@mail.ru";
        String name = "Pasha" + random;
        int password = 123;
        String Telefon = TelefonNumber();
        JSONObject requestBody = new JSONObject();
        requestBody.put("email", mail);
        requestBody.put("name", name);
        requestBody.put("password", password);
        given()

                .spec(rspec).body(requestBody.toString())
                .post(EndPoints.PostAddUser)
                .then()
                .assertThat()
                .body("name", Matchers.equalToIgnoringCase("Pasha" + random))
                .statusCode(200)
                .contentType(ContentType.JSON)
                .log().all();
    }

}

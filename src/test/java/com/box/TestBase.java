package com.box;
import EndPoints.EndPoints;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeTest;

import java.text.SimpleDateFormat;
import java.util.Random;       // метод рандома
import java.util.Date;      // метод даты

public class TestBase extends Exception {
    RequestSpecification rspec;
    RequestSpecBuilder build;

    @BeforeTest(description = "Создаем spec")
    public void RequestSpec(){
        build = new RequestSpecBuilder();
        build.setBaseUri("http://users.bugred.ru/tasks/rest/doregister");
        build.setContentType(ContentType.JSON);
        rspec = build.build();
    }
    public static int RandomNumberEmail() {
        int a = 5;
        int b = 123456;
        int email = a + (int) (Math.random() * b);
        return (email);
    }

    public static int RandomNumberName() {
        int a = 5;
        int b = 123456;
        int name = a + (int) (Math.random() * b);
        return (name);
    }

    public String NumberINN() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyMMddhhmmss");
        String INN = formatForDateNow.format(dateNow);
        return (INN);
    }


    public String TelefonNumber() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("dhh mm ss");
        String Telefon = "+7 " + formatForDateNow.format(dateNow);
        return (Telefon);
    }

    public String TestData() {
        Date dateNow = new Date();
        SimpleDateFormat formatForDateNow = new SimpleDateFormat("yyyy-MM-dd");
        String Data = formatForDateNow.format(dateNow);
        return (Data);

    }

    public int random() {
        Random random1 = new Random();
        int random = random1.nextInt(10000);
        return random;
    }

}

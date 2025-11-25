package com.example.api;

import com.example.utils.ConfigLoader;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class BaseClient {

    protected RequestSpecification request;

    public BaseClient() {
        String baseUrl = ConfigLoader.getProperty("base.url");
        RestAssured.baseURI = baseUrl;
        request = RestAssured.given()
                .header("Content-Type", "application/json");
    }
}

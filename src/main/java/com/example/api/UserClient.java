package com.example.api;

import io.restassured.response.Response;

/**
 * Facade client for interacting with FakerAPI endpoints.
 * Provides a clean, reusable wrapper around RestAssured calls.
 * This follows the Facade/Wrapper design pattern to separate HTTP concerns
 * from test logic.
 */
public class UserClient extends BaseClient {

    /**
     * Retrieve a list of users.
     * @param quantity number of users to fetch
     * @return RestAssured Response containing the users data
     */
    public Response getUsers(int quantity) {
        return request
                .queryParam("_quantity", quantity)
                .get("/v1/users");
    }

    /**
     * Retrieve a list of companies.
     * @param quantity number of companies to fetch
     * @return RestAssured Response containing the companies data
     */
    public Response getCompanies(int quantity) {
        return request
                .queryParam("_quantity", quantity)
                .get("/v1/companies");
    }

    /**
     * Retrieve a list of books.
     * @param quantity number of books to fetch
     * @return RestAssured Response containing the books data
     */
    public Response getBooks(int quantity) {
        return request
                .queryParam("_quantity", quantity)
                .get("/v1/books");
    }
}

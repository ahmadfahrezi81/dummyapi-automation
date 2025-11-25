package com.example.tests;

import com.example.api.UserClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Tests for the /v1/books endpoint.
 */
public class BookTests {

    private UserClient client;

    @BeforeClass
    public void setup() {
        client = new UserClient();
    }

    @Test(description = "Happy‑path: retrieve a specific number of books")
    public void testGetBooks() {
        Response response = client.getBooks(1);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("data").size() > 0);
    }

    @Test(description = "Boundary: quantity = 0 defaults to 10")
    public void testGetZeroBooks() {
        Response response = client.getBooks(0);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getList("data").size(), 10,
                "When quantity is 0, API should default to 10 books");
    }

    @Test(description = "Boundary: max quantity (e.g. 100)")
    public void testGetMaxBooks() {
        int max = 100;
        Response response = client.getBooks(max);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getList("data").size(), max);
    }

    @Test(description = "Validate a book object's basic fields")
    public void testBookStructure() {
        Response response = client.getBooks(1);
        Assert.assertEquals(response.statusCode(), 200);
        String title = response.jsonPath().getString("data[0].title");
        String author = response.jsonPath().getString("data[0].author");
        Assert.assertNotNull(title, "Book title should not be null");
        Assert.assertNotNull(author, "Book author should not be null");
    }
}

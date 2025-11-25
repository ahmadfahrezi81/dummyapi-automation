package com.example.tests;

import com.example.api.UserClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class UserTests {

    private UserClient client;

    @BeforeClass
    public void setup() {
        client = new UserClient();
    }

    @Test(description = "Verify that we can retrieve a specific number of users")
    public void testGetUsers() {
        Response response = client.getUsers(1);



        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("data").size() > 0);
    }

    @Test(description = "Verify boundary condition: requesting 0 users defaults to 10")
    public void testGetZeroUsers() {
        Response response = client.getUsers(0);
        Assert.assertEquals(response.statusCode(), 200);
        // FakerAPI ignores 0 and defaults to 10 users
        Assert.assertEquals(response.jsonPath().getList("data").size(), 10,
                "When quantity is 0, API should default to 10 users");
    }

    @Test(description = "Verify boundary condition: requesting max users (e.g. 100)")
    public void testGetMaxUsers() {
        int max = 100;
        Response response = client.getUsers(max);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getList("data").size(), max);
    }

    @Test(description = "Verify the structure of the user object")
    public void testUserStructure() {
        Response response = client.getUsers(1);
        Assert.assertEquals(response.statusCode(), 200);

        String firstName = response.jsonPath().getString("data[0].firstname");
        String email = response.jsonPath().getString("data[0].email");

        Assert.assertNotNull(firstName, "Firstname should not be null");
        Assert.assertNotNull(email, "Email should not be null");
    }
}

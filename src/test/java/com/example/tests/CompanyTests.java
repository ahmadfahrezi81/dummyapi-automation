package com.example.tests;

import com.example.api.UserClient;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Tests for the /v1/companies endpoint.
 */
public class CompanyTests {

    private UserClient client;

    @BeforeClass
    public void setup() {
        client = new UserClient();
    }

    @Test(description = "Happy‑path: retrieve a specific number of companies")
    public void testGetCompanies() {
        Response response = client.getCompanies(1);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertTrue(response.jsonPath().getList("data").size() > 0);
    }

    @Test(description = "Boundary: quantity = 0 defaults to 10")
    public void testGetZeroCompanies() {
        Response response = client.getCompanies(0);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getList("data").size(), 10,
                "When quantity is 0, API should default to 10 companies");
    }

    @Test(description = "Boundary: max quantity (e.g. 100)")
    public void testGetMaxCompanies() {
        int max = 100;
        Response response = client.getCompanies(max);
        Assert.assertEquals(response.statusCode(), 200);
        Assert.assertEquals(response.jsonPath().getList("data").size(), max);
    }

    @Test(description = "Validate a company object's basic fields")
    public void testCompanyStructure() {
        Response response = client.getCompanies(1);
        Assert.assertEquals(response.statusCode(), 200);
        String name = response.jsonPath().getString("data[0].name");
        String email = response.jsonPath().getString("data[0].email");
        Assert.assertNotNull(name, "Company name should not be null");
        Assert.assertNotNull(email, "Company email should not be null");
    }
}

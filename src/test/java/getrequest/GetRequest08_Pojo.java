package getrequest;

import baseurl.GoRest;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import pojodata.GoRestPOJO;

import static io.restassured.RestAssured.given;

public class GetRequest08_Pojo extends GoRest {
    /*
    Scenario:
    Given the API endpoint https://gorest.co.in/public/v2/users/5899610
    When the user sends a GET request
    Then the user should assert the status code is 200
    And the user should verify the response body matches the expected data:
    {
        "id": 5899610,
        "name": "Chandan Namboothiri",
        "email": "namboothiri_chandan@larson.example",
        "gender": "male",
        "status": "inactive"
    }
    */

    @Test
    public void verifyUserDetails() {
        try {
            // Step 1: Set the API endpoint URL
            specification.pathParams("usersPath", "users", "idPath", "5899610");

            // Step 2: Set the expected data
            GoRestPOJO expectedPojoData = new GoRestPOJO(
                    5899610,
                    "Chandan Namboothiri",
                    "namboothiri_chandan@larson.example",
                    "male",
                    "inactive");

            // Step 3: Send a GET request and get the response
            Response response = given().spec(specification).when().get("/{usersPath}/{idPath}");

            // Step 4: Perform assertions
            // Check if the status code is 200
            Assert.assertEquals("Unexpected status code", 200, response.getStatusCode());

            // Check if the response body is not null
            Assert.assertNotNull("Response body is null.", response.getBody());

            // Deserialize the response body to GoRestPOJO
            GoRestPOJO actualData = response.as(GoRestPOJO.class);

            // Step 5: Perform detailed assertions
            // Check if the ID in the response matches the expected ID
            Assert.assertEquals("Unexpected ID", expectedPojoData.getId(), actualData.getId());

            // Check if the name in the response matches the expected name
            Assert.assertEquals("Unexpected name", expectedPojoData.getName(), actualData.getName());

            // Check if the email in the response matches the expected email
            Assert.assertEquals("Unexpected email", expectedPojoData.getEmail(), actualData.getEmail());

            // Check if the gender in the response matches the expected gender
            Assert.assertEquals("Unexpected gender", expectedPojoData.getGender(), actualData.getGender());

            // Check if the status in the response matches the expected status
            Assert.assertEquals("Unexpected status", expectedPojoData.getStatus(), actualData.getStatus());
        } catch (Exception e) {
            // Log any exception that might occur
            e.printStackTrace();

            // Fail the test and provide an error message
            Assert.fail("An exception occurred: " + e.getMessage());
        }
    }
}

package postrequest;

import baseurl.GoRest;
import io.restassured.response.Response;
import org.junit.Test;
import pojodata.GoRestPOJO;

import static io.restassured.RestAssured.given;
import static org.junit.Assert.assertEquals;

/**
 * Test case for a POST request to create a user using the GoRest API.
 */
public class Post01 extends GoRest {
    /*
    Given
        API Endpoint: https://gorest.co.in/public/v2/users
    When
        A user sends a POST request
    Then
        The user should assert that the Status Code is 422

     POST BODY:
  {
    "id": 5900182,
    "name": "Tenali Trishka Mrishka",
    "email": "gmail@gmail.com",
    "gender": "male",
    "status": "active"
}

     HEADERS:
           Authorization: Bearer f67b8ea21086efa784d93e607b1aab898dba88061e62ba6a5953d23329d98956
     */

    @Test
    public void post01() {
        // Step 1: Set the API endpoint URL
        specification.pathParams("usersPath", "users");

        // Step 2: Set the expected data
        GoRestPOJO expectedData = new GoRestPOJO(
                "Tenali Trishka Mrishka",
                "gmail@gmail.com",
                "male",
                "active");

        // Step 3: Send a POST request and get the response
        Response response = given()
                .spec(specification)
                .header("Authorization", "Bearer f67b8ea21086efa784d93e607b1aab898dba88061e62ba6a5953d23329d98956")
                .body(expectedData)
                .when()
                .post("/{usersPath}");

        // Step 4: Perform assertions
        assertEquals("Unexpected status code", 422, response.getStatusCode());

        // You can add more assertions based on your requirements
        // For example, checking the response body or specific fields
    }
}

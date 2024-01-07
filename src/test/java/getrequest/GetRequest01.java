package getrequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Test;

import static io.restassured.RestAssured.given;

public class GetRequest01 {

    /*
    Given
       Base URL: https://restful-booker.herokuapp.com
       Endpoint: /booking/7
    When
       A user sends a GET request
    Then
       Assert the Status Code is 200
       And
       Assert the Content Type is "application/json"
       And
       Assert the Status Line is "HTTP/1.1 200 OK"
    */

    // Step 1: Set the Base URL and Endpoint
    String baseUrl = "https://restful-booker.herokuapp.com";
    String endpoint = "/booking/7";

    // Step 2: Send Request and Get Response
    @Test
    public void get01() {
        // Step 3: Send GET Request and Get Response
        Response response = given().when().get(baseUrl + endpoint);
        response.prettyPrint();

        // Step 4: Perform Assertions
        // Assert Status Code is 200
        response.then().assertThat().statusCode(200);

        // Assert Content Type is "application/json"
        response.then().assertThat().contentType("application/json");
        response.then().assertThat().contentType(ContentType.JSON);

        // Assert Status Line is "HTTP/1.1 200 OK"
        response.then().assertThat().statusLine("HTTP/1.1 200 OK");

        // Print the Status Code
        System.out.println("Status Code: " + response.statusCode());

        // Print the Headers
        System.out.println("Response Headers: " + response.getHeaders());
    }
}

package getrequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.*;

import static io.restassured.RestAssured.*;

public class GetRequest02 {
     /*
    Given
       https://restful-booker.herokuapp.com/booking/1001
    When
       User sends a request with GET Method to the URL
    Then
       HTTP Status Code should be 404
     And
       Status Line should be HTTP/1.1 404 Not Found
     And
       Response body contains "Not Found"
     And
       Assert the Headers Via "1.1 vegur"
     And
       Response body does not contain "CW"
     And
       Server is "Cowboy"
    */

    // 1. Step : Set the URL
    // 2. Step : Set Expected Data
    // 3. Step : Send Request and Get Response
    // 4. Step : Do Assertion

    @Test
    public void get01() {
        // 1. Step : Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/1001";


        // 2. Step : Set Expected Data
        // 3. Step : Send Request and Get Response
        Response response = given().when().get(url);
        System.out.println("RESPONSE");
        response.prettyPrint();

        // 4. Step : Do Assertion
        response.then().assertThat().statusCode(404);
        response.then().assertThat().statusLine("HTTP/1.1 404 Not Found");

        String responseBodyToString = response.asString();
        System.out.println("responseBodyToString = " + responseBodyToString);

        Assert.assertTrue(responseBodyToString.contains("Not Found"));
        Assert.assertFalse(responseBodyToString.contains("CW"));

        Assert.assertEquals("1.1 vegur", response.getHeader("Via"));

        Assert.assertEquals("Cowboy", response.getHeader("Server"));


    }

}

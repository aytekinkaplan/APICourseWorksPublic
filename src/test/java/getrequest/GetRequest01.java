package getrequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.*;

import static io.restassured.RestAssured.*;

public class GetRequest01 {
    /*
    Given
       https://restful-booker.herokuapp.com/booking/7
    When
       User sends a request with GET Method
    Then
       Assert the Status code 200
     And
       Assert the Content Type "application/json"
     And
       Assert the Status Line "HTTP/1.1 200 OK"
    */

    // 1. Step : Set the URL
    // 2. Step : Set Expected Data
    // 3. Step : Send Request and Get Response
    // 4. Step : Do Assertion

    @Test
    public void get01() {
        // 1. Step : Set the URL
        String url = "https://restful-booker.herokuapp.com/booking/7 ";

        // 2. Step : Set Expected Data

        // 3. Step : Send Request and Get Response
        Response response = given().when().get(url);
        response.prettyPrint();

        // 4. Step : Do Assertion
        response.then().assertThat().statusCode(200);
        response.then().assertThat().contentType("application/json");
        response.then().assertThat().contentType(ContentType.JSON);
        response.then().assertThat().statusLine("HTTP/1.1 200 OK");

        //Print the Status Code 200
        System.out.println(response.statusCode());
        //Print the headers
        System.out.println(response.getHeaders());


    }
}

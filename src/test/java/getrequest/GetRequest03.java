package getrequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.junit.Assert;
import org.junit.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest03 {
     /*
    Given
       https://jsonplaceholder.typicode.com/todos/23
    When
       User sends a request with GET Method to the URL
    Then
       HTTP Status Code should be 200
    Then
       Response format should be "application/json"
     And
       "title" is "et itaque necessitatibus maxime molestiae qui quas velit"
     And
       "completed" is false
     And
       "userid" is 2
 {
    "userId": 2,
    "id": 23,
    "title": "et itaque necessitatibus maxime molestiae qui quas velit",
    "completed": false
}
    */

    // 1. Step : Set the URL
    // 2. Step : Set Expected Data
    // 3. Step : Send Request and Get Response
    // 4. Step : Do Assertion

    @Test
    public void get01() {
        // 1. Step : Set the URL
        String url = "https://jsonplaceholder.typicode.com/todos/23";


        // 2. Step : Set Expected Data
        // 3. Step : Send Request and Get Response
        Response response = given().when().get(url);
        System.out.println("RESPONSE");
        response.prettyPrint();

        // 4. Step : Do Assertion
        response.then().assertThat()
                .statusCode(200)
                .contentType(ContentType.JSON).body("title", equalTo("et itaque necessitatibus maxime molestiae qui quas velit"),
                        "completed", equalTo(false),"userId",equalTo(2));


    }

}

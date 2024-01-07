package getrequest;

import baseurl.JsonPlaceHolder;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import testdata.JsonPlaceHolderTestData;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest07_TestData extends JsonPlaceHolder {
   /*
    Given
        URL: https://jsonplaceholder.typicode.com/todos/198
    When
        a GET request is sent to the specified URL
    Then
        HTTP Status Code should be 200
    And
        Response body should match the expected data:
        {
            "userId": 10,
            "id": 198,
            "title": "quis eius est sint explicabo",
            "completed": true
        }
*/

    @Test
    public void testGetTodoById() {
        // Step 1: Set the URL
        specification.pathParams("todosPath", "todos", "idPath", "198");

        // Step 2: Set Expected Data
        JsonPlaceHolderTestData jsonPlaceHolderTestData = new JsonPlaceHolderTestData();
        Map<String, Object> expectedMap = jsonPlaceHolderTestData.setUpDataTodos();

        // Step 3: Send Request and Get Response
        Response response = given().spec(specification).when().get("/{todosPath}/{idPath}");

        // Step 4: Deserialize Response Body to Map
        Map<String, Object> actualMap = response.as(HashMap.class);

        // Step 5: Perform Assertions
        Assert.assertEquals("Unexpected status code", 200, response.getStatusCode());
        Assert.assertEquals("userId does not match", expectedMap.get("userId"), actualMap.get("userId"));
        Assert.assertEquals("id does not match", expectedMap.get("id"), actualMap.get("id"));
        Assert.assertEquals("title does not match", expectedMap.get("title"), actualMap.get("title"));
        Assert.assertEquals("completed status does not match", expectedMap.get("completed"), actualMap.get("completed"));
    }


}

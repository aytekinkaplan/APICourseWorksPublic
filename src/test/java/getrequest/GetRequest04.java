package getrequest;

import baseurl.GoRest;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class GetRequest04 extends GoRest {
     /*
    Given
       https://gorest.co.in/public/v2/users/5886994
    When
       User sends a request with GET Method to the URL
    Then
       User should assert the HTTP as 200
    And
       Response body should as it seems

 {
    "id": 5886994,
    "name": "Rohan Bhat",
    "email": "bhat_rohan@tromp-goyette.example",
    "gender": "male",
    "status": "inactive"
}
    */

//     1. Step : Set the URL
//     2. Step : Set Expected Data
//     3. Step : Send Request and Get Response
//     4. Step : Do Assertion

    @Test
    public void get01() {
        // 1. Step : Set the URL
        // https://gorest.co.in/public/v2/users/5886063
        specification.pathParams("userPath", "users", "idpath", "5886063");


        // 2. Step : Set Expected Data
        String expectedData = " {\n" +
                "    \"id\": 5886063,\n" +
                "    \"name\": \"Trilochana Devar\",\n" +
                "    \"email\": \"devar_trilochana@block.example\",\n" +
                "    \"gender\": \"male\",\n" +
                "    \"status\": \"active\"\n" +
                "}";

        Map<String, Object> expectedMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);

        // 3. Step : Send Request and Get Response

        Response response = given().spec(specification).when().get("/{userPath}/{idpath}");
        Map<String, Object> actualMap = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);

        // 4. Step : Do Assertion
        Assert.assertEquals(expectedMap.get("id"), actualMap.get("id"));
        Assert.assertEquals(expectedMap.get("name"), actualMap.get("name"));
        Assert.assertEquals(expectedMap.get("email"), actualMap.get("email"));
        Assert.assertEquals(expectedMap.get("gender"), actualMap.get("gender"));
        Assert.assertEquals(expectedMap.get("status"), actualMap.get("status"));


    }
}

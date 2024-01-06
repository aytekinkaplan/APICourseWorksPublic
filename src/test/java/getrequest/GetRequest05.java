package getrequest;

import baseurl.GoRest;
import io.restassured.response.Response;
import org.junit.Assert;
import org.junit.Test;
import utilities.JsonToJava;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.Map;

import static io.restassured.RestAssured.given;

public class GetRequest05 extends GoRest {
    /*
    Base URL Spec olarak kullanılmalıdır
    Given
        https://gorest.co.in/public/v2/todos/28982
    When
        User sends Request with GET Methods
    Then
        User assert the Status Code as "200"
    And
        User assert Content Type as "application/json"
    And
        User assert Response Body as below

       {
        "id": 38322,
        "user_id": 5886277,
        "title": "Ratione asper conturbo victoria supellex confugo.",
        "due_on": "2024-01-22T00:00:00.000+05:30",
        "status": "completed"
    }

     1. Step : Set the URL
     2. Step : Set Expected Data
     3. Step : Send Request and Get Response
     4. Step : Do Assertion
            */


    @Test
    public void get05() {
//        1. Step : Set the URL

        specification.pathParams("todosPath", "todos", "idPath", "38322");
//        2. Step : Set Expected Data

//        Object mapper: Json--->Java
//        1 . pom.xml <dependency>
//        2 . Convert Json to Java
        String expectedData =" {\n" +
                "        \"id\": 38322,\n" +
                "        \"user_id\": 5886277,\n" +
                "        \"title\": \"Ratione asper conturbo victoria supellex confugo.\",\n" +
                "        \"due_on\": \"2024-01-22T00:00:00.000+05:30\",\n" +
                "        \"status\": \"completed\"\n" +
                "    }";

        Map<String, Object> expectedMap = JsonToJava.convertJsonToJavaObject(expectedData, HashMap.class);
//        3. Step : Send Request and Get Response
        Response response = given().spec(specification).when().get("/{todosPath}/{idPath}");
        Map<String, Object> actualMap = JsonToJava.convertJsonToJavaObject(response.asString(), HashMap.class);

//        4. Step : Do Assertion
        Assert.assertEquals(expectedMap.get("id"), actualMap.get("id"));
        Assert.assertEquals(expectedMap.get("user_id"), actualMap.get("user_id"));
        Assert.assertEquals(expectedMap.get("title"), actualMap.get("title"));
        Assert.assertEquals(expectedMap.get("due_on"), actualMap.get("due_on"));
        Assert.assertEquals(expectedMap.get("status"), actualMap.get("status"));


    }
}

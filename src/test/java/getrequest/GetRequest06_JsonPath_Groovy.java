package getrequest;

import baseurl.DummyRestApi;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.junit.Test;

import java.util.List;

import static io.restassured.RestAssured.given;

public class GetRequest06_JsonPath_Groovy extends DummyRestApi {
    @Test
    public void get06() {
        // Step 1: Set the URL
        specification.pathParams("productlistPath", "productsList");

        // Step 2: Set Expected Data (No expected data set in this case)

        // Step 3: Send Request and Get Response
        Response response = given().spec(specification).when().get("/{productlistPath}");
        response.prettyPrint();  // Print the response body for debugging or inspection

        // Step 4: Do Assertion

        // Extract product IDs from the response using JsonPath
        JsonPath jsonPath = response.jsonPath();
        List<Integer> productList = jsonPath.getList("products.id");

        // Print the list of product IDs for debugging or inspection
        System.out.println("Product List: " + productList);

        // Additional Assertions or validations can be added based on the specific requirements of your test.
        // For example, you might want to assert that the list is not empty or has a certain size.
        // Assert.assertNotEquals("Product list is empty", 0, productList.size());
        // Assert.assertEquals("Product list size is not as expected", expectedSize, productList.size());
    }


}

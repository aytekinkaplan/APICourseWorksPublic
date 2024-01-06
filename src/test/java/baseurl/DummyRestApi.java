package baseurl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class DummyRestApi {
    protected RequestSpecification specification;
    @Before
    public void setUpBaseUrl(){
        specification= new RequestSpecBuilder().setBaseUri("https://dummy.restapiexmaple.com/api/v1").build();
    }
}

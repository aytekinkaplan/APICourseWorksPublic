package baseurl;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.junit.Before;

public class GoRest {
    protected RequestSpecification specification;

    @Before
    public void setupBaseURL(){
        specification = new RequestSpecBuilder().setBaseUri("https://gorest.co.in/public/v2").build();
    }
}

package test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class SimpleTest {

    @Test
    public void myFirstTest() {
        Assert.assertEquals(1, 1, "[ERR] OMG, 1 is NOT 1 any more!");
    }

    @Test
    public void testTodo1DataFetching() {
        RequestSpecification request = given();
        String baseUri = "";
        String baseUriEnvVar = System.getProperty("baseUri");
        if(baseUriEnvVar != null ){
            baseUri = baseUriEnvVar;
        }

        if(baseUri.isEmpty())
            throw new RuntimeException("Please supply the baseUri value");

        request.baseUri(baseUri);
        request.basePath("/todos");

        final String FIRST_TODO = "/1";
        Response response = request.get(FIRST_TODO);
        response.prettyPrint();
        response.then().body("userId", equalTo(1));
        response.then().body("id", equalTo(1));
        response.then().body("title", equalTo("delectus aut autem"));
        response.then().body("completed", equalTo(false));
    }

}

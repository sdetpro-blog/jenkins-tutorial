package test;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class TestNothing {

    @Test
    public void myFirstTest() {
        Assert.assertEquals(1, 1, "[ERR] OMG, 1 is NOT 1 any more!");
    }

    @Test
    public void testTodo1DataFetching() {
        RequestSpecification request = given();
        request.baseUri("https://jsonplaceholder.typicode.com");
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

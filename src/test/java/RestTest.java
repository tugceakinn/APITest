import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;

public class RestTest {

    @Test
    public void test() {
        RestAssured.baseURI = "https://maps.googleapis.com";
        Response res =
                given().
                        param("location", "-33.8670522,151.1957362").
                        param("radius", "500").
                        param("key", "AIzaSyDdmNTROhyxhmkUdjGLOemdMN0FdABKVfI").
                        when().
                        get("maps/api/place/nearbysearch/json").
                        then().
                        assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                        body("results[1].name", equalTo("The Star Grand Residences (formerly Astral Residences)")).
                        extract().response();
        String responseString = res.asString();
        System.out.println(responseString);
        String accountId = res.jsonPath().getString("results[1].name");
        System.out.println(accountId);
        Assert.assertEquals(accountId, "The Star Grand Residences (formerly Astral Residences)");
    }

}

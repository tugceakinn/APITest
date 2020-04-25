import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class RestTest {

    static String lonasString, latasString;

    @Test
    public void test() {
        //...
        RestAssured.baseURI = "https://maps.googleapis.com";
        Response res =
                given().
                        param("location", Coordinate("İstanbul")).
                        param("radius", "500").
                        param("key", "AIzaSyDdmNTROhyxhmkUdjGLOemdMN0FdABKVfI").
                        when().
                        get("maps/api/place/nearbysearch/json").
                        then().
                        //assertThat().statusCode(200).and().contentType(ContentType.JSON).and().
                        //body("results[1].name", equalTo("The Star Grand Residences (formerly Astral Residences)")).
                                extract().response();
        String responseString = res.asString();
        System.out.println(responseString);
        //String accountId = res.jsonPath().getString("results[1].name");
        //System.out.println(accountId);
        //Assert.assertEquals(accountId, "The Star Grand Residences (formerly Astral Residences)");

    }


    public static String Coordinate(String city) {

        RestAssured.baseURI = "https://api.openweathermap.org";

        Response res = given().
                param("q", city).
                param("APPID", "1d1266b0fee4e66a86af7348c4355863").
                when().
                get("/data/2.5/weather").
                then().
                assertThat().statusCode(200).and().contentType(ContentType.JSON).
                extract().response();

        //String responseString = res.asString();
        //System.out.println(responseString);
        lonasString = res.jsonPath().getString("coord.lon");
        latasString = res.jsonPath().getString("coord.lat");
        String coordinate = lonasString + "," + latasString;

        return coordinate;


    }

}

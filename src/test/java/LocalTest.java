import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class LocalTest {


    @Test
    public void testLocal() {

        RestAssured.baseURI = "http://localhost:8080";

        PreemptiveBasicAuthScheme authScheme = new PreemptiveBasicAuthScheme();
        authScheme.setUserName("Tugce");
        authScheme.setPassword("pass");
        RestAssured.authentication = authScheme;
        Response token =
                when().
                        get("/token")
                        .then()
                        .extract().response();
        String res = token.asString();
        System.out.println(res);


    }

    @Test
    public void test2() {

        RestAssured.baseURI = "http://localhost:8093/api/1.0/user";
        Response res =
                when().
                        get().
                        then().
                        extract().
                        response();
        String res1=res.asString();
        System.out.println(res1);

    }


    @Test
    public void test() {

        String x = "{\n" +
                "\t\"username\":\"azra\",\n" +
                "\t\"email\":\"azra@gmail\",\n" +
                "\t\"password\":\"Tt123456.\",\n" +
                "\t\"name\":\"azra\",\n" +
                "\t\"surname\":\"akın\"\n" +
                "}";
        RestAssured.baseURI = "http://localhost:8093";
        Response res = given()
                .contentType("application/json")
                .accept(ContentType.JSON)
                .when()
                .body(x)
                .log().all()
                .request("POST","/api/1.0/user")
                .then().extract().response();
        String res2=res.asString();
        System.out.println(res2);

    }
}





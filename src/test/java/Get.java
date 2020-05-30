import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.when;

public class Get {
    @Test
    public void get() {

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
}

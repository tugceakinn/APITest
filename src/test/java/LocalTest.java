import io.restassured.RestAssured;
import io.restassured.authentication.PreemptiveBasicAuthScheme;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;

public class LocalTest {


        @Test
        public void getUser() {

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
        public void postUser() {

            String x = "{\n" +
                    "\t\"username\":\"tugce\",\n" +
                    "\t\"email\":\"tugce.akin@testinium.com\",\n" +
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

        @Test
        public void putUser() {
            String json="{\n" +
                    "\t\"username\":\"tugce\",\n" +
                    "\t\"email\":\"email@gmail\",\n" +
                    "\t\"password\":\"Tt123456.\",\n" +
                    "\t\"name\":\"hatice\",\n" +
                    "\t\"lastname\":\"akın\"\n" +
                    "}";
            RestAssured.baseURI="http://localhost:8093";
            Response res =given()
                    .contentType("application/json")
                    .accept(ContentType.JSON)
                    .when()
                    .body(json)
                    .log().all()
                    .request("PUT","/api/1.0/user/tugce")
                    .then().extract().response();
            String a=res.asString();
            System.out.println(a);
        }

        @Test
        public void deleteUser(){
            String json="{\n" +
                    "        \"username\": \"tugce\",\n" +
                    "        \"email\": \"email@gmail\",\n" +
                    "        \"password\": \"Tt123456.\",\n" +
                    "        \"name\": \"azra\",\n" +
                    "        \"lastname\": \"akın\",\n" +
                    "        \"id\": 1\n" +
                    "}";
            RestAssured.baseURI="http://localhost:8093";
            Response res= given()
                    .contentType("application/json")
                    .accept(ContentType.JSON)
                    .when()
                    .body(json)
                    .log().all()
                    .request("DELETE","/api/1.0/user/username")
                    .then().extract().response();
            String b=res.asString();
            System.out.println(b);

        }
}





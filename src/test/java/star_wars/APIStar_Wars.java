package star_wars;

import global.Global;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Test;


import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;





public class APIStar_Wars extends Global {

    RequestSpecification request;
    Response response;


    @Test
    public void testExample() {
    Response response = get(BASE_URL_STAR_WARS + "/people/1/");
    System.out.println("Response: " + response.asString());
    System.out.println("Status Code: " + response.getStatusCode());
    System.out.println("Time Taken: " + response.getTime());


    int statusCode = response.getStatusCode();
    String responseString = response.asString();

    assertEquals(statusCode, 200);
    assertTrue(response.asString(), true);
    assertNotNull(response);




}

    @Test
    public void getDemo(){
        given()
                    .header("Content-Type", "application/json")
                    .get(BASE_URL_STAR_WARS + "/planets/3/")
                .then()
                    .statusCode(200)
                .log().all();
    }
    @Test
    public void mustAccessAnotherAPI() {
                given()
                        .header("Content-Type", "application/json")
                        .get(BASE_URL_STAR_WARS + "/people/1")
                .then()
                        .log().all()
                        .statusCode(200)
                        .body("name", is("Luke Skywalker"))

                        .body("films", hasItem("https://swapi.dev/api/films/2/"));

       response = get(BASE_URL_STAR_WARS + "/people/1");
       assertEquals(response.getStatusCode(),200);
       assertNotNull(response.getBody());
       System.out.println("Status Code: " + response.getStatusCode());

    }



}

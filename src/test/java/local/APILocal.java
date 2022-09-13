package local;

import global.Global;
import io.restassured.http.ContentType;
import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.core.IsNull.notNullValue;

public class APILocal extends Global {

    @Test
    void getTest(){
        given()
                .header("Content-Type", "application/json")
                .get(BASE_URL_LOCAL + "/posts")
                .then()
                .statusCode(200)
                .body("zip", notNullValue())
                .log().all();
    }

    @Test
    void postTest(){
        JSONObject req = new JSONObject();
        req.put("id", 10);
        req.put("zip", "zipado7");
        req.put("title", "json-test4");

        String dados = req.toJSONString();

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(dados)
                .when()
                .post(BASE_URL_LOCAL + "/users/1")
                .then()
                .statusCode(201);
    }
}

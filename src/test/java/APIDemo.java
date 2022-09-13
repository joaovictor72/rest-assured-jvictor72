import global.Global;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

public class APIDemo extends Global {
    @Test
    void getDemo(){
        given()
                .header("Content-Type", "application/json")
                .get(BASE_DEMO + "/users?page=2")
                .then()
                .statusCode(200)
                .body("data.first_name[4]", equalTo("George"))
                .body("data.first_name", hasItems("George","Tobias", "Michael"))
                .log().all();
    }

    @Test
    void postDemo(){
        JSONObject req = new JSONObject();
        req.put("name", "Raghav");
        req.put("job", "Teacher");
        System.out.println(req.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .post(BASE_DEMO + "/api/users")
                .then()
                .statusCode(201);
    }

    @Test
    void putDemo(){
        JSONObject req = new JSONObject();
        req.put("name", "SuperMan");
        req.put("job", "Hero");
        System.out.println(req.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .put(BASE_DEMO + "/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }

    @Test
    void patchDemo(){
        JSONObject req = new JSONObject();
        req.put("name", "SoldierBoy");
        req.put("job", "Hero");
        System.out.println(req.toJSONString());

        given()
                .header("Content-Type", "application/json")
                .contentType(ContentType.JSON)
                .accept(ContentType.JSON)
                .body(req.toJSONString())
                .when()
                .put(BASE_DEMO + "/api/users/2")
                .then()
                .statusCode(200)
                .log().all();
    }
    @Test
    void deleteDemo(){
        when()
                .delete(BASE_DEMO + "/api/users/2")
                .then()
                .statusCode(204)
                .log().all();
    }

}

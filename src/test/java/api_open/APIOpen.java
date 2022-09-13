package api_open;

import dto.PersonDTO;
import global.Global;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class APIOpen extends Global {
    @Test
    public void postDemo(){
        PersonDTO people = new PersonDTO("Johnny Kevin", 175, 78, "black", "black");

        PersonDTO peopleInserted = given()
                    .log().all()
                    .header("Content-Type", "application/json")
                    .body(people)
                .when()
                    .post(BASE_DEMO + "/people/1")
                .then()
                    .log().all()
                    .statusCode(201)
                    .extract()
                .body()
                .as(PersonDTO.class);

        assertThat(peopleInserted.getHeight(), is(175));
    }
}

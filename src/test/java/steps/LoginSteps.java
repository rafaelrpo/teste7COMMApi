
package steps;

import io.cucumber.java.en.*;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class LoginSteps {

    private String body;
    private Response response;

    @Given("que possuo usuário {string} e senha {string}")
    public void credenciais(String usuario, String senha) {
        body = String.format("{\"username\":\"%s\",\"password\":\"%s\"}", usuario, senha);
    }

    @When("realizo o login")
    public void realizoLogin() {
        response = given()
            .contentType(ContentType.JSON)
            .body(body)
        .when()
            .post("/api/login");
    }

    @Then("o status code deve ser {int}")
    public void statusCode(int code) {
        response.then().statusCode(code);
    }

    @Then("deve retornar um token JWT")
    public void retornaToken() {
        response.then().body("token", notNullValue());
    }
}

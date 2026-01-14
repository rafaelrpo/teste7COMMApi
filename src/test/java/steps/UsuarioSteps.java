
package steps;

import io.cucumber.java.en.*;
import io.restassured.response.Response;
import utils.AuthToken;

import static io.restassured.RestAssured.given;

public class UsuarioSteps {

    private Response response;

    @Given("que estou autenticado")
    public void autenticado() {
        AuthToken.getToken();
    }

    @When("consulto meus dados")
    public void consultoDados() {
        response = given()
            .header("Authorization", "Bearer " + AuthToken.getToken())
        .when()
            .get("/api/users/me");
    }

    @Then("o status code deve ser {int}")
    public void validaStatus(int code) {
        response.then().statusCode(code);
    }
}

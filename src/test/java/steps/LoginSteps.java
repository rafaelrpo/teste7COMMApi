package steps;

import io.cucumber.java.pt.*;
import io.restassured.response.Response;
import utils.BaseTest;
import utils.ScenarioContext;

import static io.restassured.RestAssured.given;

public class LoginSteps extends BaseTest {

    @Dado("que informo usuario {string} e senha {string}")
    public void informoCredenciais(String usuario, String senha) {
        Response response = given()
                .contentType("application/json")
                .body("{\"username\":\"" + usuario + "\",\"password\":\"" + senha + "\"}")
                .post("/api/login");

        ScenarioContext.setResponse(response);
    }

    @Quando("realizo o login")
    public void realizoLogin() {
        // ação já executada no Given
    }
}

package steps;

import io.cucumber.java.pt.Então;
import io.restassured.response.Response;
import utils.ScenarioContext;

public class CommonSteps {

    @Então("o status code deve ser {int}")
    public void validoStatusCode(int status) {
        Response response = ScenarioContext.getResponse();
        response.then().statusCode(status);
    }
}

package steps;

import static com.github.tomakehurst.wiremock.client.WireMock.*;
import static io.restassured.RestAssured.*;

import com.github.tomakehurst.wiremock.WireMockServer;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.response.Response;

public class LoginSteps {

    private WireMockServer server;
    private Response response;
    private String body;

    @Before
    public void setup() {
        server = new WireMockServer(8089);
        server.start();
        configureFor("localhost", 8089);
        baseURI = "http://localhost";
        port = 8089;
    }

    @After
    public void tearDown() {
        server.stop();
    }

    @Given("que o usuário é válido")
    public void usuarioValido() {
        stubFor(post("/api/login").willReturn(okJson("{\"token\":\"jwt\",\"perfil\":\"ADMIN\"}")));
        body = "{\"usuario\":\"admin\",\"senha\":\"123\"}";
    }

    @Given("que as credenciais são inválidas")
    public void credenciaisInvalidas() {
        stubFor(post("/api/login").willReturn(aResponse().withStatus(401)));
        body = "{\"usuario\":\"x\",\"senha\":\"y\"}";
    }

    @Given("que o usuário não tem permissão")
    public void semPermissao() {
        stubFor(post("/api/login").willReturn(aResponse().withStatus(403)));
        body = "{\"usuario\":\"sem\",\"senha\":\"123\"}";
    }

    @Given("que o usuário está bloqueado")
    public void bloqueado() {
        stubFor(post("/api/login").willReturn(aResponse().withStatus(423)));
        body = "{\"usuario\":\"block\",\"senha\":\"123\"}";
    }

    @When("realiza login")
    @When("realiza login com credenciais corretas")
    public void login() {
        response = given().contentType("application/json").body(body).post("/api/login");
    }

    @Then("o sistema retorna status {int}")
    public void status(int code) {
        response.then().statusCode(code);
    }

    @Then("retorna um token e perfil do usuário")
    public void tokenPerfil() {
        response.then().statusCode(200);
    }
}

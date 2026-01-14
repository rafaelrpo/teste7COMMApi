
package utils;

import io.restassured.http.ContentType;
import static io.restassured.RestAssured.given;

public class AuthToken {

    private static String token;

    public static String getToken() {
        if (token == null) {
            token = given()
                .contentType(ContentType.JSON)
                .body("{\"username\":\"usuario.valido\",\"password\":\"senha.valida\"}")
            .when()
                .post("/api/login")
            .then()
                .statusCode(200)
                .extract()
                .path("token");
        }
        return token;
    }
}

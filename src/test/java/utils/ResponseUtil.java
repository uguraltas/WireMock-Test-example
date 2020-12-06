package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.json.simple.JSONObject;

public class ResponseUtil {

    public static RestAssured restAssured;
    public static Response response;

    public static Response getResponse(JSONObject requestJson) {

        restAssured.baseURI = "http://localhost:8089/user/add";

        response = restAssured.given()
                .header("Content-Type", "application/json")
                .body(requestJson.toJSONString())
                .when()
                .post();

        return response;
    }

}

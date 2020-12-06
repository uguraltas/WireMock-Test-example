package utils;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class ResponseUtil {

    public static RestAssured restAssured;
    public static Response response;

    public  static Response getResponse() {
        restAssured.baseURI = "http://localhost:8089/user/add";

        response = restAssured.given().when().post();
        return response;
    }

}

package Utils;

import io.restassured.http.ContentType;
import io.restassured.response.Response;

import static io.restassured.RestAssured.*;

public class ResourceHelper {

    public static Response get(String Url) {

        return given().when().get(Url);
    }


    public static Response create(String url, String json) {
        return given().header("Content-Type", "application/json")
                .when().body(json).post(url);
    }
}

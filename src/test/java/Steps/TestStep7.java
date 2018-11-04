package Steps;

import Page.basePage;
import cucumber.api.java8.En;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;

public class TestStep7 implements En {

    public TestStep7() {

        int petId = new Random().nextInt(1000) + 1;
        String petName = "petname" + petId;


        System.out.println(petId);
        System.out.println(petName);

        Given("^Launching pet store site for demo$", () -> {

            get(basePage.getURL("WEBURL"));
        });
        And("^create a pet in petstore$", () -> {


            Map<String, Object> petobj = new HashMap<String, Object>();


            petobj.put("id", petId);
            petobj.put("name", "petName" + petId);
            petobj.put("status", "available");


            JSONObject jsonObject = new JSONObject(petobj);
            System.out.println(jsonObject.toString());
            Response resp = given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jsonObject.toString()).when().post(basePage.getURL("MODIFYINVENTORYURL"));

            System.out.println(resp.asString());

        });
        Then("^fetch information based on some petid$", () -> {

            String sUrl = basePage.getURL("GETPETINFOURL") + "/" + petId;
            System.out.println(sUrl);

            Response givenResponse = get(sUrl);
            givenResponse.then().statusCode(200);
            /*ResponseBody resBody = givenResponse.getBody();
            String respBody = resBody.asString();
            respBody.contains("available");

            Assert.assertEquals(respBody.contains("available"), true);

            System.out.println(resBody.asString());


          //  way to get value for sincle response key

            JsonPath jsonPathEvaluator = givenResponse.jsonPath();

            System.out.println(jsonPathEvaluator.getInt("id"));
            Assert.assertEquals(jsonPathEvaluator.getInt("id"),petId);
            Assert.assertEquals(jsonPathEvaluator.get("status"),"available");


            //String status=jsonPathEvaluator.get("status");
            String content_value=givenResponse.header("content-type");
            System.out.println(content_value);


            Headers al=givenResponse.headers();

            for(Header i:al) {
                System.out.println(i.getName()   +":  "+ i.getValue());

            }*/
        });




    }
}

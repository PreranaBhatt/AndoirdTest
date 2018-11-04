package Steps;

import Page.basePage;
import cucumber.api.java8.En;
import io.restassured.http.ContentType;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;


public class TestStep5 implements En {
    String varPetId=null;

    public TestStep5() {
        Given("^Launch pet store site$", () -> {
            get(basePage.getURL("WEBURL"));
        });

        And("^Add new pet to store as \"([^\"]*)\"$", (String arg0) -> {
            System.out.println(arg0);

            varPetId=arg0;
            Map<String, String> petobj = new HashMap<String, String>();
            petobj.put("id", varPetId);
            petobj.put("name", "pettest16");
            petobj.put("status", "available");


            JSONObject jobj = new JSONObject(petobj);
            given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jobj.toString()).when().post(basePage.getURL("MODIFYINVENTORYURL")).then().statusCode(200);
        });
        And("^fetch data based on petID$", () -> {
            String sUrl = basePage.getURL("GETPETINFOURL") +"/"+varPetId;
            System.out.println(sUrl);
            get(sUrl).then().statusCode(200);
        });
        Then("^change status from available to sold based on petID$", () -> {

            Map<String, String> petobj1 = new HashMap<>();
            petobj1.put("id", varPetId);
            petobj1.put("status", "sold");

            JSONObject jobj1 = new JSONObject(petobj1);

            given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jobj1.toString()).when().put(basePage.getURL("MODIFYINVENTORYURL")).then().statusCode(200);
        });

        And("^get information based on changed status SOLD$", () -> {
            given().queryParam("status", "sold").when().get(basePage.getURL("FINDBYSTATUS")).then().statusCode(200);
        });
        And("^delete pet data from inventry based on petID$", () -> {
            String dUrl = basePage.getURL("MODIFYINVENTORYURL") +"/"+varPetId;
            given().accept(ContentType.JSON).when().delete(dUrl).then().statusCode(200);
        });


    }
}

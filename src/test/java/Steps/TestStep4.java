package Steps;

import cucumber.api.java8.En;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.json.JSONObject;
import org.testng.Assert;

import java.util.HashMap;
import java.util.Map;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;

public class TestStep4 implements En {

    public TestStep4() {


        Given("^Launch pet store web service$", () -> {

            Response petstoreResp = get("https://petstore.swagger.io/v2/swagger.json");
            System.out.println(petstoreResp.getStatusCode());

            Assert.assertTrue(petstoreResp.getStatusCode() == 200);

            // parameterised
            /*    given().queryParam("status", "sold").when().get("http://petstore.swagger.io/v2/pet/findByStatus").then().statusCode(200);*/


        });
        And("^user Add new pet to store$", () -> {


            System.out.println(" Add new pet to store" + "\n");


            Map<String, Object> petobj = new HashMap<String, Object>();
            petobj.put("id", "1617");
            petobj.put("name", "pettest16");


            JSONObject jobj = new JSONObject(petobj);
            given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jobj.toString()).when().post("https://petstore.swagger.io/v2/pet").then().statusCode(200);


        });
        And("^fetch information based on petID$", () -> {


            System.out.println("get the info based on petID" + "\n");
            get("https://petstore.swagger.io/v2/pet/1617").then().body("id", notNullValue()).statusCode(200);// with verification


        });
        Then("^change status from available to sold$", () -> {

            System.out.println("change status from available to sold" + "\n");

            Map<String, Object> petobj1 = new HashMap<String, Object>();
            petobj1.put("id", "1617");
            petobj1.put("status", "sold");

            JSONObject jobj1 = new JSONObject(petobj1);

            given().accept(ContentType.JSON).contentType(ContentType.JSON).body(jobj1.toString()).when().put("https://petstore.swagger.io/v2/pet").then().statusCode(200);
        });
        And("^delete from inventry based on petiD$", () -> {


            System.out.println("delete the info based on petiD");
            /*  given().accept(ContentType.JSON).contentType(ContentType.JSON).when().delete("https://petstore.swagger.io/v2/pet/1617").then().statusCode(200);*/
        });
        Then("^get name of pet based on petID$", () -> {

          /*  given().accept(ContentType.JSON).contentType(ContentType.JSON).when()*/
        });

    }

}
package Steps;

import Builders.CategoryBuilder;
import Builders.CreateNewPetRequestBuilder;
import Builders.TagsBuilder;
import Page.basePage;
import cucumber.api.java8.En;
import entities.request.Category;
import entities.request.Tags;
import entities.request.createPetRequest;
import io.restassured.http.ContentType;

import static io.restassured.RestAssured.get;
import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class TestStep6 implements En {


    public TestStep6() {
        Given("^Launch pet store site for demo$", () -> {
            get(basePage.getURL("WEBURL"));
        });
        And("^fetch data based on given petID as \"([^\"]*)\"$", (arg0) -> {
            String sURL = basePage.getURL("GETPETINFOURL") + "/" + arg0;

            get(sURL).then().body("id", equalTo(Integer.parseInt(arg0.toString()))).statusCode(200);

            //get(sURL).then().body("$",hasItem("sold")).statusCode(200);
        });


        And("^send post request to pet site$", () -> {


            System.out.println("Checking tutorial code");

            Category category = new CategoryBuilder()
                    .withId(1).withName("test1").build();

            Tags tags = new TagsBuilder().withId(1).withName("Tag 1").build();


            Tags[] taglist = new Tags[1];
            taglist[0] = tags;

            createPetRequest createPetRequest = new CreateNewPetRequestBuilder()
                    .withCategory(category)
                    .withTags(taglist)
                    .withId(1818)
                    .withName("testdog")
                    .withStatus("available")
                    .build();


            given().accept(ContentType.JSON).contentType(ContentType.JSON)
                    .body(createPetRequest).when().post(basePage.getURL("MODIFYINVENTORYURL"))
                    .then().assertThat().body("id",equalTo(Integer.parseInt("1818"))).statusCode(200);

          /*  String url=basePage.getURL("MODIFYINVENTORYURL");
            String json=RequestHelper.getJSONString(createPetRequest);

            Response response=ResourceHelper.create(url,json);


            Assert.assertEquals(response.getStatusCode(),200);*/

        });


    }
}

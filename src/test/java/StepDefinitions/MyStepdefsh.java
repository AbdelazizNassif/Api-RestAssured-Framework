package StepDefinitions;

import bodies.Location;
import bodies.LocationFullDescription;
import bodies.SuccessfulLocationAdditionResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import testDataBuild.TestDataBuilding;
import utilities.Utils;

import static io.restassured.RestAssured.*;


import java.util.ArrayList;
import java.util.List;

public class MyStepdefsh extends Utils {
    LocationFullDescription locationFullDescription;
    SuccessfulLocationAdditionResponse responseAsClass;
    Response response;
    RequestSpecification requestSpecification;
    JsonPath js;

    @Given("user init the request sucessfully")
    public void user_in_login_page() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("Given");
        requestSpecification = constructRequestSpecs();
    }

    @When("user created place body successfully")
    public void userEnterValidAnd() {
        // body crearation
        System.out.println("When I");
        locationFullDescription = TestDataBuilding.createAddPlacePostRequestBody();
    }

    @When("user make the post request")
    public void click_login_button() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When II");
        // Get Response
        responseAsClass =
                given().spec(requestSpecification)
                        .body(locationFullDescription).log().all()
                        .when()
                        .post().as(SuccessfulLocationAdditionResponse.class)
                ;
        response = given().spec(requestSpecification)
                .body(locationFullDescription).log().all()
                .when()
                .post()
                .then().log().all().extract().response();
    }

    @Then("{string} status will be {string}")
    public void statusWillBe(String statusKeyInResponse, String statusValueInResponse) {
        //statusKeyInResponse = responseAsClass.getStatus();
        //Assert.assertEquals(statusKeyInResponse , statusValueInResponse);
        js = new JsonPath(response.asString());
        Assert.assertEquals(js.get(statusKeyInResponse) , statusValueInResponse);
    }

    @And("{string} scope will be {string}")
    public void scopeWillBe(String scopeKeyInResponse, String scopeValueInResponse) {
        //scopeKeyInResponse = responseAsClass.getScope();
        //Assert.assertEquals( scopeKeyInResponse, scopeValueInResponse);
        Assert.assertEquals(js.get(scopeKeyInResponse) , scopeValueInResponse);
    }


    @And("status code will be {int}")
    public void statusCodeWillBe(int statusCodeOfAddPlaceRequest) {
        Assert.assertEquals(response.getStatusCode(), statusCodeOfAddPlaceRequest);
    }
}


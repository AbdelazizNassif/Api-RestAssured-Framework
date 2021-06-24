package StepDefinitions;

import apiBasePathes.ApiBasePathesAndEndPointsEnumClass;
import apisObjectModels.ApisObjectModels;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import bodies.LocationFullDescription;
import bodies.SuccessfulLocationAdditionResponse;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.junit.Assert;
import testDataBuild.TestDataBuilding;
import utilities.Utils;
import static io.restassured.RestAssured.*;

public class MyStepdefsDtDr extends Utils{
    LocationFullDescription locationFullDescription;
    SuccessfulLocationAdditionResponse responseAsClass;
    Response postResponseBody;
    Response getResponseBody;
    Response deleteResponseBody;
    RequestSpecification requestSpecification;
    JsonPath postRespJs;
    JsonPath getRespJs;
    public String place_id ;
    ApisObjectModels apisObjectModels;

    @Given("user init the request successfully data driven")
    public void userInitTheRequestSuccessfullyDataDriven() {
        System.out.println("Given");
        // initialize the request specification for the Places APIs
        requestSpecification = constructRequestSpecs("application/json");
        apisObjectModels = new ApisObjectModels(requestSpecification) ;
    }

    @When("user created place body successfully with data driven {string} {string} {string}")
    public void userCreatedPlaceBodySuccessfullyWithDataDriven(String name, String lang, String address) {
        System.out.println("When I");
        locationFullDescription = TestDataBuilding.createAddPlacePostRequestBodyDtDr(name, lang, address);
    }
    @And("user make the {string} request {string} data driven")
    public void userMakeTheRequestDataDriven(String api_method , String resource) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When II");
        ApiBasePathesAndEndPointsEnumClass api_basePath = ApiBasePathesAndEndPointsEnumClass.valueOf(resource);
        requestSpecification = constructRequestSpecs("application/json");
        if(api_method.equalsIgnoreCase("post")) {
            // Get Response
            // Save the post request body as POJO class
            responseAsClass =
                    given().spec(requestSpecification)
                            .basePath(api_basePath.getResource())
                            .queryParam("key", "qaclick123")
                            .body(locationFullDescription).log().all()
                            .when()
                            .post().as(SuccessfulLocationAdditionResponse.class)
            ;

            postResponseBody = apisObjectModels.add_a_place(requestSpecification, api_basePath.getResource()
                    , locationFullDescription, "qaclick123");
        }
        else if(api_method.equalsIgnoreCase("get")) {
            // call the Get Response
        }
    }


    @Then("{string} status will be {string} data driven")
    public void statusWillBeDataDriven(String statusKeyInResponse, String statusValueInResponse) {
        //statusKeyInResponse = responseAsClass.getStatus();
        //Assert.assertEquals(statusKeyInResponse , statusValueInResponse);
        System.out.println("VALUE OF STATUS IS: " + Utils.getJsonValueFromJsonResponse(postResponseBody, statusKeyInResponse));
        Assert.assertEquals(Utils.getJsonValueFromJsonResponse(postResponseBody, statusKeyInResponse), statusValueInResponse);
    }

    @And("{string} scope will be {string} data driven")
    public void scopeWillBeDataDriven(String scopeKeyInResponse, String scopeValueInResponse) {
        //scopeKeyInResponse = responseAsClass.getScope();
        Assert.assertEquals(Utils.getJsonValueFromJsonResponse(postResponseBody, scopeKeyInResponse), scopeValueInResponse);
    }
    @And("status code will be {int} data driven and get the {string} for the EndToEnd Scenario")
    public void statusCodeWillBeDataDrivenAndGetTheForTheEndToEndScenario(int statusCodeOfAddPlaceRequest, String place_id_key) {
        Assert.assertEquals(postResponseBody.getStatusCode(), statusCodeOfAddPlaceRequest);
        place_id = Utils.getJsonValueFromJsonResponse(postResponseBody, place_id_key);
    }


    @And("user make the {string} request {string} data driven to get the added place data")
    public void userMakeTheRequestDataDrivenToGetTheAddedPlaceData(String api_method, String resource) {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("When II");
        ApiBasePathesAndEndPointsEnumClass api_basePath = ApiBasePathesAndEndPointsEnumClass.valueOf(resource);
        RequestSpecification getRequestSpecification = constructRequestSpecs("application/json");
        if(api_method.equalsIgnoreCase("post")) {
            // call the post request
        }
        else if(api_method.equalsIgnoreCase("get")) {
            getResponseBody = apisObjectModels.get_a_place(requestSpecification, api_basePath.getResource()
                    , place_id, "qaclick123");
        }
    }

    @And("Check The get response status code should be {int}")
    public void checkTheGetResponseStatusCodeShouldBe(int getStatusCode) {
        Assert.assertEquals(getResponseBody.getStatusCode(), getStatusCode);
    }



    @And("user check the values of name {string} language {string} and address {string} equal to {string} {string} {string}")
    public void userCheckTheValuesOfNameLanguageAndAddressEqualTo(String name, String language, String address,
                                                                  String nameValue, String languageValue, String addressValue) {
        Assert.assertEquals(Utils.getJsonValueFromJsonResponse(getResponseBody, name), nameValue);
        Assert.assertEquals(Utils.getJsonValueFromJsonResponse(getResponseBody, language), languageValue);
        Assert.assertEquals(Utils.getJsonValueFromJsonResponse(getResponseBody, address), addressValue);
    }


    @And("user tries to delete {string} with path {string} the newly created places for the EndToEnd scenario")
    public void userTriesToDeleteWithPathTheNewlyCreatedPlacesForTheEndToEndScenario(String api_method, String resource) {
        System.out.println("When II");
        // Delete
        String deleteReqBody = "{\n" +
                "    \"place_id\": \""+place_id+"\"\n" +
                "    }";
        ApiBasePathesAndEndPointsEnumClass api_basePath = ApiBasePathesAndEndPointsEnumClass.valueOf(resource);
        RequestSpecification getRequestSpecification = constructRequestSpecs("application/json");
        if(api_method.equalsIgnoreCase("delete")) {

            deleteResponseBody = apisObjectModels.delete_a_place(requestSpecification, api_basePath.getResource() , TestDataBuilding.createDeletePlcaeBody(place_id).toString(), "qaclick123");
            Assert.assertEquals(Utils.getJsonValueFromJsonResponse(deleteResponseBody, "status"), "OK");
        }
        else if(api_method.equalsIgnoreCase("post"))
        {
            // call post request
        }
        else if(api_method.equalsIgnoreCase("get"))
        {
            // call get request
        }
    }
}

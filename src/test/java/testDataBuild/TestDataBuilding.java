package testDataBuild;

import bodies.Location;
import bodies.LocationFullDescription;
import bodies.SuccessfulLocationAdditionResponse;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;

public class TestDataBuilding {

    public static LocationFullDescription createAddPlacePostRequestBody() {
        LocationFullDescription requestBody = new LocationFullDescription();
        Location location = new Location();
        requestBody = new LocationFullDescription();

        location.setLat("30.009");
        location.setLng("39.90");
        requestBody.setLocation(location);
        requestBody.setAccuracy(50);
        requestBody.setName("Frontline house");
        requestBody.setPhone_number("(+91) 983 893 3937");
        requestBody.setAddress("29, side layout, cohen 09");
        List<String> typesInBody = new ArrayList();
        typesInBody.add("shop 1");
        typesInBody.add("shop 2");
        requestBody.setTypes(typesInBody);
        requestBody.setWebsite("http://google.com");
        requestBody.setLanguage("French-IN");
        return requestBody;
    }
    public static LocationFullDescription createAddPlacePostRequestBodyDtDr(
            String name, String language, String address
    ) {
        LocationFullDescription requestBody = new LocationFullDescription();
        Location location = new Location();
        requestBody = new LocationFullDescription();

        location.setLat("30.009");
        location.setLng("39.90");
        requestBody.setLocation(location);
        requestBody.setAccuracy(50);
        requestBody.setName(name);
        requestBody.setPhone_number("(+91) 983 893 3937");
        requestBody.setAddress(address);
        List<String> typesInBody = new ArrayList();
        typesInBody.add("shop 1");
        typesInBody.add("shop 2");
        requestBody.setTypes(typesInBody);
        requestBody.setWebsite("http://google.com");
        requestBody.setLanguage(language);
        return requestBody;
    }

}

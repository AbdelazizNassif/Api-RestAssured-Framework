package apisObjectModels;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import bodies.LocationFullDescription;

import static io.restassured.RestAssured.given;

public class ApisObjectModels {

    private RequestSpecification requestSpecification;

    public ApisObjectModels(RequestSpecification requestSpecification) {
        this.requestSpecification = requestSpecification;
    }

    public Response add_a_place(RequestSpecification requestSpecification, String base_path, LocationFullDescription locationFullDescription, String keyQP)
    {
        Response postResponseBody = given().spec(requestSpecification)
                .basePath(base_path)
                .queryParam("key", keyQP)
                .body(locationFullDescription).log().all()
                .when()
                .post()
                .then().log().all().extract().response();

        return  postResponseBody;
    }
    public Response get_a_place(RequestSpecification requestSpecification, String base_path, String place_idQP, String keyQP)
    {
        Response getResponseBody = given().spec(requestSpecification)
                .basePath(base_path)
                .queryParam("place_id", place_idQP)
                .queryParam("key" , keyQP).log().all()
                .when()
                .get()
                .then().log().all().extract().response();
        return getResponseBody ;
    }
    public Response delete_a_place(RequestSpecification requestSpecification, String base_path, String deleteRequestBody , String keyQP)
    {
        Response  deleteResponseBody = given().spec(requestSpecification)
                .basePath(base_path)
                .body(deleteRequestBody)
                .queryParam("key" , keyQP).log().all()
                .when()
                .delete()
                .then().log().all().extract().response();
        return deleteResponseBody ;
    }
}

package my.company.services.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class PeopleApi {

    private RequestSpecBuilder builder;
    private RequestSpecification requestSpecification;
    public static final String REQ_URI = "/people";

    private PeopleApi(RequestSpecBuilder builder) {
        this.builder = builder;
        requestSpecification = given().spec(builder.build());
    }

    public static PeopleApi peopleApi(RequestSpecBuilder builder) {
        return new PeopleApi(builder);
    }

    public ValidatableResponse getCharacterById(Object id) {
        return requestSpecification
                .when()
                .pathParam("id", String.valueOf(id))
                .get(REQ_URI + "/{id}")
                .then();
    }

}

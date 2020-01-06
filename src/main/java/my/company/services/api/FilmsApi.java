package my.company.services.api;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.response.ValidatableResponse;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class FilmsApi {

    private RequestSpecBuilder builder;
    private RequestSpecification requestSpecification;
    public static final String REQ_URI = "/films";

    private FilmsApi(RequestSpecBuilder builder) {
        this.builder = builder;
        requestSpecification = given().spec(builder.build());
    }

    public static FilmsApi filmApi(RequestSpecBuilder builder) {
        return new FilmsApi(builder);
    }

    public ValidatableResponse getFilmById(Object id) {
        return requestSpecification
                .when()
                .pathParam("id", String.valueOf(id))
                .get(REQ_URI + "/{id}")
                .then();
    }
}

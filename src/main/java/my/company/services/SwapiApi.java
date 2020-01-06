package my.company.services;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import my.company.services.api.FilmsApi;
import my.company.services.api.PeopleApi;

public class SwapiApi {

    RequestSpecBuilder builder;
    public final String defaultContentType = "application/json; charset=utf-8";

    public SwapiApi() {
        builder = new RequestSpecBuilder();
        builder.setContentType(defaultContentType);
        builder.addFilter(new RequestLoggingFilter());
        builder.addFilter(new ResponseLoggingFilter());
        builder.build();
    }

    public PeopleApi people() {
        return PeopleApi.peopleApi(builder);
    }

    public FilmsApi films() {
        return FilmsApi.filmApi(builder);
    }

}

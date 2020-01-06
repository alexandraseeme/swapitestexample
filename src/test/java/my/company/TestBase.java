package my.company;

import io.restassured.RestAssured;
import my.company.services.SwapiApi;
import org.junit.jupiter.api.BeforeAll;

public class TestBase {

    public static SwapiApi swapiApi;

    @BeforeAll
    public static void setUp() {
        RestAssured.baseURI = "https://swapi.co/api"; // It would be better to make it configurable, e.g. from .env file
        swapiApi = new SwapiApi();
    }
}

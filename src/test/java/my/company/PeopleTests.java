package my.company;

import io.restassured.RestAssured;
import my.company.models.Character;
import my.company.models.Film;
import my.company.models.GenderEnum;
import my.company.services.api.FilmsApi;
import my.company.services.api.PeopleApi;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static junit.framework.TestCase.assertTrue;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PeopleTests extends TestBase {

    private static PeopleApi peopleApi;
    private static FilmsApi filmsApi;

    @BeforeAll
    public static void initApis() {
        peopleApi = swapiApi.people();
        filmsApi = swapiApi.films();
    }

    @Test
    @DisplayName("Substitute movie links to title and compare")
    public void shouldMatchCharacterDataAfterFilmSubstitutionTest() {
        Character lukeSkywalker = peopleApi.getCharacterById(1)
                .extract().body().jsonPath().getObject("", Character.class);

        List<String> filmNames = lukeSkywalker.getFilmIds()
                .stream().map(id -> filmsApi
                        .getFilmById(id)
                        .extract().body().jsonPath().getObject("", Film.class)
                        .getTitle())
                .collect(Collectors.toList());

        lukeSkywalker.setFilms(filmNames);

        assertAll("Assert multiple conditions",
                () -> {
                    assertAll("Validate Luke Skywalker character properties",
                            () -> assertEquals("Luke Skywalker", lukeSkywalker.getName()),
                            () -> assertEquals("172", lukeSkywalker.getHeight()),
                            () -> assertEquals("77", lukeSkywalker.getMass()),
                            () -> assertEquals("blond", lukeSkywalker.getHairColor()),
                            () -> assertEquals("fair", lukeSkywalker.getSkinColor()),
                            () -> assertEquals("blue", lukeSkywalker.getEyeColor()),
                            () -> assertEquals("19BBY", lukeSkywalker.getBirthYear()),
                            () -> assertEquals(GenderEnum.MALE.toString(), lukeSkywalker.getGender()),
                            () -> assertTrue(lukeSkywalker.getHomeworld().endsWith("planets/1/")),
                            () -> assertTrue(Arrays.asList("The Empire Strikes Back", "Revenge of the Sith", "Return of the Jedi", "A New Hope", "The Force Awakens")
                                    .containsAll(lukeSkywalker.getFilms())),
                            () -> assertTrue(Arrays.asList(14, 30).containsAll(lukeSkywalker.getVehicleIds())),
                            () -> assertTrue(Arrays.asList(1).containsAll(lukeSkywalker.getSpeciesIds())),
                            () -> assertTrue(Arrays.asList(12, 22).containsAll(lukeSkywalker.getStarshipIds())),
                            () -> assertEquals("2014-12-09T13:50:51.644000Z", lukeSkywalker.getCreated()),
                            () -> assertEquals("2014-12-20T21:17:56.891000Z", lukeSkywalker.getEdited()),
                            () -> assertEquals(RestAssured.baseURI + "/people/1/", lukeSkywalker.getUrl())
                    );
                }
        );
    }

}

package my.company.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
import java.util.stream.Collectors;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Character {

    @JsonProperty("birth_year")
    private String birthYear;
    @JsonProperty("eye_color")
    private String eyeColor;
    @JsonProperty("films")
    private List<String> films;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("hair_color")
    private String hairColor;
    @JsonProperty("height")
    private String height;
    @JsonProperty("homeworld")
    private String homeworld;
    @JsonProperty("mass")
    private String mass;
    @JsonProperty("name")
    private String name;
    @JsonProperty("skin_color")
    private String skinColor;
    @JsonProperty("created")
    private String created;
    @JsonProperty("edited")
    private String edited;
    @JsonProperty("species")
    private List<String> species;
    @JsonProperty("starships")
    private List<String> starships;
    @JsonProperty("url")
    private String url;
    @JsonProperty("vehicles")
    private List<String> vehicles;

    public List<Integer> getSpeciesIds() {
        return getResourceIdsFromUrl(species);
    }

    public List<Integer> getFilmIds() {
        return getResourceIdsFromUrl(films);
    }

    public List<Integer> getStarshipIds() {
        return getResourceIdsFromUrl(starships);
    }

    public List<Integer> getVehicleIds() {
        return getResourceIdsFromUrl(vehicles);
    }

    private List<Integer> getResourceIdsFromUrl(List<String> list){
        List<Integer> ids = list.stream()
                .map(url -> Integer.valueOf(url.split("/")[url.split("/").length - 1]))
                .collect(Collectors.toList());
        return ids;
    }
}

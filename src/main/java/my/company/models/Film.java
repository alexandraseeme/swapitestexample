package my.company.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
@EqualsAndHashCode
@JsonIgnoreProperties(ignoreUnknown = true)
public class Film {

    @JsonProperty("characters")
    public List<String> characters = null;
    @JsonProperty("created")
    public String created;
    @JsonProperty("director")
    public String director;
    @JsonProperty("edited")
    public String edited;
    @JsonProperty("episode_id")
    public Integer episodeId;
    @JsonProperty("opening_crawl")
    public String openingCrawl;
    @JsonProperty("planets")
    public List<String> planets = null;
    @JsonProperty("producer")
    public String producer;
    @JsonProperty("release_date")
    public String releaseDate;
    @JsonProperty("species")
    public List<String> species = null;
    @JsonProperty("starships")
    public List<String> starships = null;
    @JsonProperty("title")
    public String title;
    @JsonProperty("url")
    public String url;
    @JsonProperty("vehicles")
    public List<String> vehicles = null;
}

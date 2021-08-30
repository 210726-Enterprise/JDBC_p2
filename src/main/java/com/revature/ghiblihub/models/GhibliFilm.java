package com.revature.ghiblihub.models;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ghibli_films")

@Getter
@Setter
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class GhibliFilm {

    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;

//    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Genre.class)
//    @JoinColumn(name = "genre_id", nullable = false)
//    private Genre genreId;

    @Column(name = "title", columnDefinition = "TEXT", nullable = false)
    @JsonProperty("title")
    private String title;

    @Column(name = "publication_year")
    @JsonProperty("release_date")
    private String release_date;

    @Column(name = "description", columnDefinition = "TEXT")
    @JsonProperty("description")
    private String description;

    @Column(name = "director", columnDefinition = "TEXT")
    @JsonProperty("director")
    private String director;

    @Override
    public String toString() {
        return "GhibliFilm{" +
                "filmId=" + filmId +
                ", title='" + title + '\'' +
                ", release_date=" + release_date +
                ", description='" + description + '\'' +
                ", director='" + director + '\'' +
                '}';
    }
}

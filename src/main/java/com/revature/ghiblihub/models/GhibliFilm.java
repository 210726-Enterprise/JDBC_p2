package com.revature.ghiblihub.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "ghibli_films")

@Getter
@Setter
@NoArgsConstructor
public class GhibliFilm {

    @Id
    @Column(name="film_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int filmId;

    @ManyToOne(cascade = CascadeType.ALL, targetEntity = Genre.class)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genreId;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "publication_year")
    private int publicationYear;

    @Column(name = "description")
    private String description;

    @Column(name = "director")
    private String director;

}

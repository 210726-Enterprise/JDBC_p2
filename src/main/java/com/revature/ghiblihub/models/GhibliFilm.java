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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "genre_id", nullable = false)
    private int genreId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "publication_year")
    private int publicationYear;

    @Column(name = "description")
    private String description;

    @Column(name = "director")
    private String director;

}

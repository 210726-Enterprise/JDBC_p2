package com.revature.ghiblihub.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "genres")

@Getter
@Setter
@NoArgsConstructor
public class Genre {

    @Id
    @Column(name="genre_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int genreId;

    @Column(name = "genre_type")
    private String genreType;
}

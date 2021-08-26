package com.revature.ghiblihub.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "reviews")

@Getter
@Setter
@NoArgsConstructor
public class Review {

    @Id
    @Column(name = "review_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int reviewId;

    @Column(name = "rating")
    private float rating;

    @Column(name = "content")
    private String content;

    @Column(name = "user_id", nullable = false)
    private int userId;

    @Column(name = "film_id", nullable = false)
    private int filmId;

}

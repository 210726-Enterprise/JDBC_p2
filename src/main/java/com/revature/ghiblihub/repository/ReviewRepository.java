package com.revature.ghiblihub.repository;

import com.revature.ghiblihub.models.GhibliFilm;
import com.revature.ghiblihub.models.Review;
import com.revature.ghiblihub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    @Query("select r from Review r where r.user = :user")
    List<Review> getReviewsByUser (@Param("user") User user);

    @Query("select r from Review r where r.film = :film")
    List<Review> getReviewsByFilm(@Param("film") GhibliFilm film);
}

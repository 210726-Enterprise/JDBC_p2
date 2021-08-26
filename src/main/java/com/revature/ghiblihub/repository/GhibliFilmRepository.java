package com.revature.ghiblihub.repository;

import com.revature.ghiblihub.models.GhibliFilm;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface GhibliFilmRepository extends JpaRepository<GhibliFilm, Integer> {
    Optional<GhibliFilm> findByTitle(String title);

}

package com.revature.ghiblihub.repository;

import com.revature.ghiblihub.models.Review;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReviewRepository extends JpaRepository<Review, Integer> {
    //Optional<Review> findByUserid(String userId);
}

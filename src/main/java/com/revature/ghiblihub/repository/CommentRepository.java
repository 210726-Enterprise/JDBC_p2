package com.revature.ghiblihub.repository;

import com.revature.ghiblihub.models.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    Optional<List<Comment>> findByReviewId(int reviewId);
    Optional<List<Comment>> findByUserId(int userId);
}

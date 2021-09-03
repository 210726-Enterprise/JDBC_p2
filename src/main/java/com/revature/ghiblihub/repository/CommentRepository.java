package com.revature.ghiblihub.repository;

import com.revature.ghiblihub.models.Comment;
import com.revature.ghiblihub.models.Review;
import com.revature.ghiblihub.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Integer> {
    @Query("select c from Comment c where c.review = :review")
    List<Comment> getCommentByReview(@Param("review") Review review);

    @Query("select c from Comment c where c.user = :user")
    List<Comment> getCommentsByUser(@Param("user") User user);
}

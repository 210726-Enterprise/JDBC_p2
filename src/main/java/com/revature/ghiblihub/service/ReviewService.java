package com.revature.ghiblihub.service;


import com.revature.ghiblihub.models.GhibliFilm;
import com.revature.ghiblihub.models.Review;
import com.revature.ghiblihub.models.User;
import com.revature.ghiblihub.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReviewService {

    private final ReviewRepository reviewRepository;

    @Autowired
    public ReviewService (ReviewRepository reviewRepository){
        this.reviewRepository = reviewRepository;
    }

    public Review saveReview (Review review){
        return reviewRepository.save(review);
    }

    public Review getReviewByReviewId (Integer id){
        return reviewRepository.findById(id).orElseThrow(RuntimeException::new);
    }

    public List<Review> getReviewsByUser(User user){
        return reviewRepository.getReviewsByUser(user);
    }

    public List<Review> getReviewByFilm(GhibliFilm film) {
        return reviewRepository.getReviewsByFilm(film);
    }

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public void deleteReview (Integer reviewId){
        reviewRepository.findById(reviewId).ifPresent(reviewRepository::delete);
    }



}

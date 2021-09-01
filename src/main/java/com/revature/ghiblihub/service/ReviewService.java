package com.revature.ghiblihub.service;


import com.revature.ghiblihub.models.GhibliFilm;
import com.revature.ghiblihub.models.Review;
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
        return reviewRepository.getById(id);
    }
//
//    public Review getReviewByUserID(String userId){
//        return reviewRepository.findByUserid(userId).orElseThrow(RuntimeException::new);
//    }

    public List<Review> getAllReviews(){
        return reviewRepository.findAll();
    }

    public boolean deleteReview (Integer reviewId){
        if(reviewRepository.findById(reviewId).isPresent()) {
            reviewRepository.delete(reviewRepository.getById(reviewId));
            return true;
        } else {
            return false;
        }
    }

    public float calculateAvgFilmScore(GhibliFilm filmId){
        List<Review> tempList = getAllReviewsByFilmId(filmId);
        float sum = 0;
        for(Review review: tempList){
            sum += review.getRating();
        }
        if(tempList.size() == 0){
            return 0;
        }
        sum = sum/tempList.size();

        return sum;
    }

    private List<Review> getAllReviewsByFilmId(GhibliFilm filmId){
        return reviewRepository.findAllByFilmId(filmId).orElseGet(ArrayList::new);
    }



}

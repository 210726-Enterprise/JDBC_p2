package com.revature.ghiblihub.controller;

import com.revature.ghiblihub.models.Review;
import com.revature.ghiblihub.service.ReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/reviews")
public class ReviewController {

    private final ReviewService reviewService;

    @Autowired
    public ReviewController(ReviewService reviewService){
        this.reviewService = reviewService;
    }

    @GetMapping
    public @ResponseBody
    List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping("/{id}")
    public @ResponseBody
    Review findReviewByReviewId(@PathVariable String id){
        return reviewService.getReviewByReviewId(Integer.parseInt(id));
    }

//    @GetMapping("/user/{userId}")
//    public @ResponseBody
//    Review findReviewByUserId(@PathVariable String userId){
//        return reviewService.getReviewByUserID(userId);
//    }

    @PostMapping
    public @ResponseBody
    Review createReview(@RequestBody Review r){
        return reviewService.saveReview(r);
    }

    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> deleteReview(@PathVariable String id){
        reviewService.deleteReview(Integer.parseInt(id));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

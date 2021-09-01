package com.revature.ghiblihub.controller;

import com.revature.ghiblihub.models.GhibliFilm;
import com.revature.ghiblihub.models.Review;
import com.revature.ghiblihub.service.GhibliFilmService;
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
    private final GhibliFilmService ghibliFilmService;

    @Autowired
    public ReviewController(ReviewService reviewService, GhibliFilmService ghibliFilmService){
        this.reviewService = reviewService;
        this.ghibliFilmService = ghibliFilmService;
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

    @GetMapping("/{filmName}")
    public @ResponseBody
    float getAvgReviewScore(@PathVariable String filmName){
        GhibliFilm film = ghibliFilmService.getFilmByTitle(filmName);
        return reviewService.calculateAvgFilmScore(film);
    }

//    @GetMapping("/user/{userId}")
//    public @ResponseBody
//    Review findReviewByUserId(@PathVariable String userId){
//        return reviewService.getReviewByUserID(userId);
//    }

    @RequestMapping(value = "/postReview", method = RequestMethod.POST)
    public String createReview(Review r){
        reviewService.saveReview(r);
        return "reviews";
    }

    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> deleteReview(@PathVariable String id){
        reviewService.deleteReview(Integer.parseInt(id));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

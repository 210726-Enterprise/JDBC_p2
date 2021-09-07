package com.revature.ghiblihub.controller;

import com.revature.ghiblihub.models.GhibliFilm;
import com.revature.ghiblihub.models.Review;
import com.revature.ghiblihub.models.User;
import com.revature.ghiblihub.service.GhibliFilmService;
import com.revature.ghiblihub.service.ReviewService;
import com.revature.ghiblihub.service.UserService;
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
    private final UserService userService;
    private final GhibliFilmService ghibliFilmService;

    @Autowired
    public ReviewController(ReviewService reviewService, UserService userService, GhibliFilmService ghibliFilmService){
        this.reviewService = reviewService;
        this.userService = userService;
        this.ghibliFilmService = ghibliFilmService;
    }

    @GetMapping()
    public @ResponseBody
    List<Review> getAllReviews(){
        return reviewService.getAllReviews();
    }

    @GetMapping("/reviewid/{id}")
    public @ResponseBody
    Review findReviewByReviewId(@PathVariable String id){
        return reviewService.getReviewByReviewId(Integer.parseInt(id));
    }

    @GetMapping("/userid/{userId}")
    public @ResponseBody
    List<Review> findReviewByUserId(@PathVariable String userId){
        User user = userService.getUserById(Integer.parseInt(userId));
        return reviewService.getReviewsByUser(user);
    }

    @GetMapping("/username/{username}")
    public @ResponseBody
    List<Review> findReviewByUsername(@PathVariable String username){
        User user = userService.getUserByUsername(username);
        return reviewService.getReviewsByUser(user);
    }

    @RequestMapping("/postreview")
    public String postReviewPage() {
        return "postreview";
    }

    @RequestMapping(method = RequestMethod.POST)
    public String createReview(@RequestParam String rating, @RequestParam String content, @RequestParam String userId, @RequestParam String filmId){
        Review r = new Review();
        User u = userService.getUserById(Integer.parseInt(userId));
        GhibliFilm f = ghibliFilmService.getFilmById(Integer.parseInt(filmId));
        r.setRating(Float.parseFloat(rating));
        r.setContent(content);
        r.setUser(u);
        r.setFilm(f);
        reviewService.saveReview(r);
        return "home";
    }

    @DeleteMapping("/{id}")
    ResponseEntity<HttpStatus> deleteReview(@PathVariable String id){
        reviewService.deleteReview(Integer.parseInt(id));
        return ResponseEntity.ok(HttpStatus.OK);
    }
}

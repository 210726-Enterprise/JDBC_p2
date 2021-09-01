package com.revature.ghiblihub.controller;

import com.revature.ghiblihub.models.Review;
import com.revature.ghiblihub.models.User;
import com.revature.ghiblihub.service.ReviewService;
import com.revature.ghiblihub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/users")
public class UserController {

    private final UserService userService;
    private final ReviewService reviewService;

    @Autowired
    public UserController(UserService userService,ReviewService reviewService) {
        this.userService = userService;
        this.reviewService = reviewService;
    }

    @GetMapping("/{id}")
    public @ResponseBody
    User findUserById(@PathVariable String id) {
        return userService.getUserById(Integer.parseInt(id));
    }

    @GetMapping("/username/{username}")
    public @ResponseBody
    User findUserByUsername(@PathVariable String username) {
        return userService.getUserByUsername(username);
    }

    @GetMapping
    public @ResponseBody
    List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @PostMapping
    public @ResponseBody
    User createUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @DeleteMapping("/admin/deleteUser")
    public @ResponseBody
    ResponseEntity<HttpStatus> deleteUser(@RequestBody String userId) {
        if(userService.deleteUser(Integer.parseInt(userId))) {
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/admin/deleteReview")
    public @ResponseBody
    ResponseEntity<HttpStatus> deleteReview(@RequestBody String reviewId){
        if(reviewService.deleteReview(Integer.parseInt(reviewId))){
            return ResponseEntity.ok(HttpStatus.OK);
        }
        return ResponseEntity.notFound().build();
    }

    @PutMapping
    public @ResponseBody
    User updateUser(@RequestBody User user) {
        return userService.saveUser(user);
    }
}

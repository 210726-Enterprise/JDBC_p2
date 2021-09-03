package com.revature.ghiblihub.controller;

import com.revature.ghiblihub.models.Comment;
import com.revature.ghiblihub.models.User;
import com.revature.ghiblihub.service.CommentService;
import com.revature.ghiblihub.service.ReviewService;
import com.revature.ghiblihub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/comments")
public class CommentController {

    private final CommentService commentService;
    private final UserService userService;
    private final ReviewService reviewService;

    @Autowired
    public CommentController(CommentService commentService, ReviewService reviewService, UserService userService){
        this.commentService = commentService;
        this.reviewService = reviewService;
        this.userService = userService;
    }

    @GetMapping("/review/{reviewId}")
    public @ResponseBody
    List<Comment> getAllCommentsFromReview(@PathVariable String reviewId){
        // Look at getAllCommentFromUser comment for solution
        return commentService.getAllCommentsByReviewId(Integer.parseInt(reviewId));
    }

    @GetMapping("/user/{userId}")
    public @ResponseBody
    List<Comment> getAllCommentsFromUser(@PathVariable String userId){
        User u = userService.getUserById(Integer.parseInt(userId));
        // Comment model takes userId as a User object, so we need to find a way to search comment by User which is a foreign key
        return commentService.getAllCommentsByUserId(Integer.parseInt(userId));
    }

    @RequestMapping("/postcomment")
    public String postReviewPage() {
        return "comments";
    }

    @PutMapping
    public @ResponseBody
    Comment updateComment(@RequestBody Comment c){
        if(commentService.getCommentByCommentId(c.getCommentId()).equals(null)){
            return null;
        }
        return commentService.saveComment(c);
    }

    @DeleteMapping
    public @ResponseBody
    ResponseEntity<HttpStatus> deleteComment(@RequestBody Integer commentId){
        commentService.deleteComment(commentId);
        return ResponseEntity.ok(HttpStatus.OK);
    }


}

package com.revature.ghiblihub.controller;

import com.revature.ghiblihub.WebUserDetails;
import com.revature.ghiblihub.models.Comment;
import com.revature.ghiblihub.models.Review;
import com.revature.ghiblihub.models.User;
import com.revature.ghiblihub.service.CommentService;
import com.revature.ghiblihub.service.ReviewService;
import com.revature.ghiblihub.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
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

    @GetMapping("/films/title/{title}/{reviewId}/comments")
    public @ResponseBody
    List<Comment> getAllCommentsFromReview(@PathVariable String reviewId){
        Review review = reviewService.getReviewByReviewId(Integer.parseInt(reviewId));
        return commentService.getAllCommentsByReview(review);
    }

    @GetMapping("/userid/{userId}")
    public @ResponseBody
    List<Comment> getAllCommentsFromUser(@PathVariable String userId){
        User u = userService.getUserById(Integer.parseInt(userId));
        return commentService.getAllCommentsByUser(u);
    }

    @GetMapping("/username/{username}")
    public @ResponseBody
    List<Comment> getAllCommentsFromUsername(@PathVariable String username){
        User u = userService.getUserByUsername(username);
        return commentService.getAllCommentsByUser(u);
    }

    @RequestMapping(value = "/films/title/{title}/{reviewId}", method = RequestMethod.GET)
    public String postReviewPage(@PathVariable String title, String reviewId) {
        return "comments";
    }

    @RequestMapping(value = "/films/title/{title}/{reviewId}", method=RequestMethod.POST)
    public String createComment(@RequestParam String content, @PathVariable String reviewId){
        Comment comment = new Comment();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        String username;
        if (principal instanceof WebUserDetails) {
            username = ((WebUserDetails) principal).getUsername();
        } else {
            username = principal.toString();
        }

        User uId = userService.getUserByUsername(username);
        Review rId = reviewService.getReviewByReviewId(Integer.parseInt(reviewId));
        comment.setContent(content);
        comment.setUser(uId);
        comment.setReview(rId);
        commentService.saveComment(comment);
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

    @DeleteMapping("/comments/{id}")
    public @ResponseBody
    ResponseEntity<HttpStatus> deleteComment(@PathVariable String commentId){
        commentService.deleteComment(Integer.parseInt(commentId));
        return ResponseEntity.ok(HttpStatus.OK);
    }


}

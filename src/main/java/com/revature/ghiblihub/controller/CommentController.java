package com.revature.ghiblihub.controller;

import com.revature.ghiblihub.models.Comment;
import com.revature.ghiblihub.service.CommentService;
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

    @Autowired
    public CommentController(CommentService commentService){
        this.commentService = commentService;
    }

    @GetMapping("/comments/review/{id}")
    public @ResponseBody
    List<Comment> getAllCommentsFromReview(@PathVariable Integer reviewId){
        return commentService.getAllCommentsByReviewId(reviewId);
    }

    @GetMapping("/comments/user/{id}")
    public @ResponseBody
    List<Comment> getAllCommentsFromUser(@PathVariable Integer userId){
        return commentService.getAllCommentsByUserId(userId);
    }

    @PostMapping
    public @ResponseBody
    Comment createComment(@RequestBody Comment c){
        return commentService.saveComment(c);
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

package com.revature.ghiblihub.service;

import com.revature.ghiblihub.models.Comment;
import com.revature.ghiblihub.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentService(CommentRepository commentRepository){
        this.commentRepository = commentRepository;
    }

    public Comment saveComment(Comment comment){
        return commentRepository.save(comment);
    }

    public Comment getCommentByCommentId(Integer commentId){
        return commentRepository.findById(commentId).orElseGet(null);
    }

    public List<Comment> getAllCommentsByReviewId(Integer reviewId){
        return commentRepository.findByReviewId(reviewId).orElseGet(ArrayList::new);
    }

    public List<Comment> getAllCommentsByUserId(Integer userId){
        return commentRepository.findByUserId(userId).orElseGet(ArrayList::new);
    }

    public void deleteComment(Integer commentId){
        commentRepository.findById(commentId).ifPresent(commentRepository::delete);
    }


}

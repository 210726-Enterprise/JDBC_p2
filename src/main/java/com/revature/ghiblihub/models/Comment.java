package com.revature.ghiblihub.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @Column(name="comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotBlank
    private int commentId;

    @Column(name="content_body")
    @Size(min = 10, max = 500)
    private String content;

    @ManyToOne(targetEntity = User.class)
    @JoinColumn(name="user_id")
    @NotBlank
    private User userId;

    @ManyToOne(targetEntity = Review.class)
    @JoinColumn(name="review_id")
    private Review reviewId;

    public Comment(User userId, Review reviewId){
        content = "";
        this.userId = userId;
        this.reviewId = reviewId;
    }
}

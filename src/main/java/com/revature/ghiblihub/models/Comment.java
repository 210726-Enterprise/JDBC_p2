package com.revature.ghiblihub.models;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "comments")
@Getter
@Setter
@NoArgsConstructor
public class Comment {

    @Id
    @Column(name="comment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int commentId;

    @Column(name="content_body")
    private String content;

    @ManyToOne(optional = false)
    @JoinColumn(name="user_id")
    private int userId;

    @ManyToOne(optional = false)
    @JoinColumn(name="review_id")
    private int reviewId;

    public Comment(int userId, int reviewId){
        content = "";
        this.userId = userId;
        this.reviewId = reviewId;
    }
}

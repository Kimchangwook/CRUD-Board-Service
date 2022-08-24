package com.changwook.boardservice.comment.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Comment {

    private Long id;
    private Long postId;
    private Long writerId;
    private String comment;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;

    public Comment(String comment) {
        this.postId = postId;
        this.writerId = writerId;
        this.comment = comment;
    }
}

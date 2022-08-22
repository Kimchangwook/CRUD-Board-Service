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

    public Comment(Long postId, Long writerId, String comment, LocalDateTime createTime, LocalDateTime modifiedTime) {
        this.postId = postId;
        this.writerId = writerId;
        this.comment = comment;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }
}

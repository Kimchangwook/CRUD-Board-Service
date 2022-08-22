package com.changwook.boardservice.post.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
public class Post {
    private Long id;
    private Long memberId;
    private String title;
    private String content;
    private Integer views;
    private String filePath;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;

    public Post(Long memberId, String title, String content, Integer views, LocalDateTime createTime, LocalDateTime modifiedTime) {
        this.title = title;
        this.content = content;
        this.views = views;
        this.createTime = createTime;
        this.modifiedTime = modifiedTime;
    }

}

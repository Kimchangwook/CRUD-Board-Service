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
    private String filePath;
    private LocalDateTime createTime;
    private LocalDateTime modifiedTime;

    public Post(String title, String content) {
        this.title = title;
        this.content = content;
    }

}

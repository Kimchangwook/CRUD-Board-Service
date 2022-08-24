package com.changwook.boardservice.post.dao;

import com.changwook.boardservice.post.entity.Post;

import java.util.List;

public interface PostDao {
    Post save(Post post, Long memberId);
    Post findById(Long id);
    List<Post> findAll();
    void delete(Long id);
    Post update(Long id, Post newPost);
}

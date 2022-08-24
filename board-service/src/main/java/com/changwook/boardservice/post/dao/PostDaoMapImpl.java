package com.changwook.boardservice.post.dao;

import com.changwook.boardservice.post.entity.Post;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@Repository
public class PostDaoMapImpl implements PostDao{

    private static final Map<Long, Post> store = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    @Override
    public Post save(Post post, Long memberId) {
        post.setId(++sequence);
        post.setMemberId(memberId);
        post.setCreateTime(LocalDateTime.now());
        post.setModifiedTime(LocalDateTime.now());
        store.put(post.getId(), post);

        return post;
    }

    @Override
    public Post findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Post> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }

    @Override
    public Post update(Long id, Post newPost) {
        Post post = store.get(id);
        post.setContent(newPost.getContent());
        post.setTitle(newPost.getTitle());
        post.setModifiedTime(LocalDateTime.now());

        return newPost;
    }
}























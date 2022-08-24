package com.changwook.boardservice.post.dao;

import com.changwook.boardservice.post.entity.Post;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class PostDaoImplTest {

    private PostDao postDao;

    @BeforeEach
    void init() {
        postDao = new PostDaoMapImpl();
    }

    @Test
    void save() {
        Post post = new Post("title", "content");
        postDao.save(post, 1L);
        Post findPost = postDao.findById(post.getId());

        assertThat(findPost.getContent()).isEqualTo(post.getContent());
        assertThat(findPost.getMemberId()).isEqualTo(post.getMemberId());
        assertThat(findPost.getTitle()).isEqualTo(post.getTitle());
        assertThat(findPost.getCreateTime()).isEqualTo(post.getCreateTime());
        assertThat(findPost.getModifiedTime()).isEqualTo(post.getModifiedTime());
    }

    @Test
    void findAll() {
        Post post1 = new Post("title1", "content1");
        Post post2 = new Post("title2", "content2");
        Post post3 = new Post("title3", "content3");

        postDao.save(post1, 1L);
        postDao.save(post2, 2L);
        postDao.save(post3, 3L);

        List<Post> posts = postDao.findAll();

        assertThat(posts).contains(post1, post2, post3);
    }

    @Test
    void delete() {
        Post post = new Post("title", "content");

        postDao.save(post, 1L);
        postDao.delete(post.getId());
        Post findPost = postDao.findById(post.getId());

        assertThat(findPost).isNull();
    }

    @Test
    void update() {
        Post post = new Post("title", "content");
        Post newPost = new Post("newTitle", "newContent");

        postDao.save(post, 1L);
        Post updatedPost = postDao.update(post.getId(), newPost);

        assertThat(updatedPost.getTitle()).isEqualTo(newPost.getTitle());
        assertThat(updatedPost.getContent()).isEqualTo(newPost.getContent());

    }
}
package com.changwook.boardservice.comment.dao;

import com.changwook.boardservice.comment.entity.Comment;
import com.changwook.boardservice.post.entity.Post;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class CommentDaoImplTest {

    private CommentDao commentDao;

    @BeforeEach
    void init() {
        commentDao = new CommentDaoMapImpl();
    }

    @Test
    void save() {
        Comment comment = new Comment("comment");

        commentDao.save(comment, 1L, 1L);
        Comment findComment = commentDao.findById(comment.getId());

        assertThat(findComment.getId()).isEqualTo(comment.getId());
        assertThat(findComment.getPostId()).isEqualTo(comment.getPostId());
        assertThat(findComment.getWriterId()).isEqualTo(comment.getWriterId());
        assertThat(findComment.getComment()).isEqualTo(comment.getComment());
        assertThat(findComment.getCreateTime()).isEqualTo(comment.getCreateTime());
        assertThat(findComment.getModifiedTime()).isEqualTo(comment.getModifiedTime());

    }

    @Test
    void findAll() {
        Comment comment1 = new Comment("comment1");
        Comment comment2 = new Comment("comment2");
        Comment comment3 = new Comment("comment3");

        commentDao.save(comment1, 1L, 1L);
        commentDao.save(comment2, 2L, 2L);
        commentDao.save(comment3, 3L, 3L);

        List<Comment> comments = commentDao.findAll();

        assertThat(comments).contains(comment1, comment2, comment3);
    }

    @Test
    void delete() {
        Comment comment = new Comment("comment");

        commentDao.save(comment, 1L, 2L);
        commentDao.delete(comment.getId());
        Comment findComment = commentDao.findById(comment.getId());

        assertThat(findComment).isNull();

    }

    @Test
    void update() {
        Comment comment = new Comment("comment");
        Comment newComment = new Comment("newComment");

        commentDao.save(comment, 1L, 2L);
        Comment updatedComment = commentDao.update(comment.getId(), newComment);

        assertThat(updatedComment.getComment()).isEqualTo(newComment.getComment());

    }
}
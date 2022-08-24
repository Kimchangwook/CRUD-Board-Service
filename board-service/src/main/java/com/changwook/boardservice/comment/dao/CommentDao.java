package com.changwook.boardservice.comment.dao;

import com.changwook.boardservice.comment.entity.Comment;

import java.util.List;

public interface CommentDao {
    Comment save(Comment comment, Long postId, Long writerId);
    Comment findById(Long id);
    List<Comment> findAll();
    void delete(Long id);
    Comment update(Long id, Comment newComment);


}

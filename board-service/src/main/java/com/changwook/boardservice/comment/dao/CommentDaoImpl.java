package com.changwook.boardservice.comment.dao;

import com.changwook.boardservice.comment.entity.Comment;
import com.changwook.boardservice.post.entity.Post;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CommentDaoImpl implements CommentDao{
    private static final Map<Long, Comment> store = new ConcurrentHashMap<>();
    private static Long sequence = 0L;

    @Override
    public Comment save(Comment comment, Long postId, Long writerId) {
        comment.setId(++sequence);
        comment.setPostId(postId);
        comment.setWriterId(writerId);
        comment.setCreateTime(LocalDateTime.now());
        comment.setModifiedTime(LocalDateTime.now());
        store.put(comment.getId(), comment);

        return comment;
    }

    @Override
    public Comment findById(Long id) {
        return store.get(id);
    }

    @Override
    public List<Comment> findAll() {
        return new ArrayList<>(store.values());
    }

    @Override
    public void delete(Long id) {
        store.remove(id);
    }

    @Override
    public Comment update(Long id, Comment newComment) {
        Comment comment = store.get(id);
        comment.setComment(newComment.getComment());
        comment.setModifiedTime(LocalDateTime.now());

        return newComment;
    }
}

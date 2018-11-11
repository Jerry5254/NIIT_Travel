package com.niit.travel.service;

import com.niit.travel.entity.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentList();
    Comment getCommentById(Integer commentId);
    Comment getCommentByUser(Integer userId);
    Comment getCommentByTN(Integer tnId);
    boolean addComment(Comment comment);
    boolean modifyComment(Comment comment);
    boolean deleteComment(Integer commentId);
}

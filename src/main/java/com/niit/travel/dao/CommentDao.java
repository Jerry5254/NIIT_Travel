package com.niit.travel.dao;

import com.niit.travel.entity.Comment;

import java.util.List;

public interface CommentDao {
    List<Comment> getCommentList();
    Comment getCommentById(int commentId);
    Comment getCommentByUser(int userId);
    Comment getCommentByTN(int tnId);
    int insertComment(Comment comment);
    int updateComment(Comment comment);
    int deleteComment(int commentId);
}

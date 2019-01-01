/*********************************************************
 * 文件名: CommentDao
 * 作者: 魏捷宇
 * 说明:
 *********************************************************/
package com.niit.travel.dao;

import com.niit.travel.entity.Comment;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentDao {
    List<Comment> getCommentList();
    Comment getCommentById(int commentId);
    Comment getCommentByUser(int userId);
    Comment getCommentByTN(int tnId);
    int insertComment(Comment comment);
    int updateComment(Comment comment);
    int deleteComment(int commentId);
}

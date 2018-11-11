package com.niit.travel.dao;

import com.niit.travel.entity.Comment;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CommentDaoTest {

    @Autowired
    private CommentDao commentDao;

    @Test
    public void getCommentList() {
        List<Comment> commentList=commentDao.getCommentList();
        assertEquals(1,commentList.size());
    }

    @Test
    public void getCommentById() {
        Comment comment=commentDao.getCommentById(1);
        assertEquals(1,(int)comment.getCOUser_id());
    }

    @Test
    public void getCommentByUser() {
        Comment comment=commentDao.getCommentByUser(1);
        assertEquals(1,(int)comment.getCOId());
    }

    @Test
    public void insertComment() {
        Comment comment=new Comment();
        comment.setCODate(new Date());
        comment.setCODetails("写的什么玩意");
        comment.setCOUser_id(1);
        int effectedNum=commentDao.insertComment(comment);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateComment() {
        Comment comment=new Comment();
        comment.setCOId(2);
        comment.setCOStatus("Y");
        int effectedNum=commentDao.updateComment(comment);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteComment() {
        int effectedNum=commentDao.deleteComment(2);
        assertEquals(1,effectedNum);
    }
}
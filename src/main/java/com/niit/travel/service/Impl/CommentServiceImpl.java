package com.niit.travel.service.Impl;

import com.niit.travel.dao.CommentDao;
import com.niit.travel.entity.Comment;
import com.niit.travel.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    @Autowired
    private CommentDao commentDao;
    @Override
    public List<Comment> getCommentList() {
        return commentDao.getCommentList();
    }

    @Override
    public Comment getCommentById(Integer commentId) {
        return commentDao.getCommentById(commentId);
    }

    @Override
    public Comment getCommentByUser(Integer userId) {
        return commentDao.getCommentByUser(userId);
    }

    @Override
    public Comment getCommentByTN(Integer tnId) {
        return commentDao.getCommentByTN(tnId);
    }

    @Transactional
    @Override
    public boolean addComment(Comment comment) {
        if(comment.getCODetails()!=null && "".equals(comment.getCODetails()))
        {
            try {
                int effectedNum = commentDao.insertComment(comment);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("评论失败");
                }
            }catch(Exception e)
            {
                throw new RuntimeException("评论失败"+e);
            }
        }else
        {
            throw new RuntimeException("评论信息不能为空");
        }
    }

    @Transactional
    @Override
    public boolean modifyComment(Comment comment) {
        if(comment.getCOId()!=null && comment.getCOId()>0)
        {
            try{
                int effectedNum= commentDao.updateComment(comment);
                if(effectedNum>0)
                {
                    return true;
                }else
                {
                    throw new RuntimeException("更新评论失败");
                }

            }catch(Exception e)
            {
                throw new RuntimeException("更新评论失败"+e);
            }

        }else
        {
            throw new RuntimeException("评论ID有误");
        }
    }

    @Transactional
    @Override
    public boolean deleteComment(Integer commentId) {
        if(commentId>0)
        {
            try{
                int effectedNum= commentDao.deleteComment(commentId);
                if(effectedNum>0)
                {
                    return true;
                }else
                {
                    throw new RuntimeException("删除评论失败");
                }
            }catch (Exception e)
            {
                throw new RuntimeException("删除评论失败"+e);
            }

        }else{
            throw new RuntimeException("评论ID有误");
        }

    }
}

package com.niit.travel.service.Impl;

import com.niit.travel.dao.CollectDao;
import com.niit.travel.entity.Collect;
import com.niit.travel.service.CollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CollectServiceImpl implements CollectService {
    @Autowired
    private CollectDao collectDao;

    @Override
    public List<Collect> getCollectList() {
        return collectDao.getCollectList();
    }

    @Override
    public Collect getCollectById(Integer collectId) {
        return collectDao.getCollectById(collectId);
    }

    @Override
    public Collect getCollectByUser(Integer userId) {
        return collectDao.getCollectByUserId(userId);
    }

    @Override
    public Collect getCollectByNote(Integer noteId) {
        return collectDao.getCollectByNoteId(noteId);
    }

    @Transactional
    @Override
    public boolean addCollect(Collect collect) {
        if(collect.getCollect_Noteid()!=null && collect.getCollect_Noteid()>0)
        {
            try {
                int effectedNum = collectDao.insertCollect(collect);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("收藏添加失败");
                }
            }catch(Exception e)
            {
                throw new RuntimeException("收藏添加失败"+e);
            }
        }else
        {
            throw new RuntimeException("收藏信息不能为空");
        }

    }

    @Transactional
    @Override
    public boolean modifyCollect(Collect collect) {
        if(collect.getCollect_Id()!=null && collect.getCollect_Id()>0)
        {
            try{
                int effectedNum= collectDao.updateCollect(collect);
                if(effectedNum>0)
                {
                    return true;
                }else
                {
                    throw new RuntimeException("收藏失败");
                }

            }catch(Exception e)
            {
                throw new RuntimeException("收藏失败"+e);
            }

        }else
        {
            throw new RuntimeException("收藏ID有误");
        }

    }

    @Transactional
    @Override
    public boolean deleteClooect(Integer collectId) {
        if(collectId>0)
        {
            try{
                int effectedNum= collectDao.deleteCollect(collectId);
                if(effectedNum>0)
                {
                    return true;
                }else
                {
                    throw new RuntimeException("取消收藏失败");
                }
            }catch (Exception e)
            {
                throw new RuntimeException("取消收藏失败"+e);
            }

        }else{
            throw new RuntimeException("收藏ID有误");
        }
    }
}

package com.travel.travel.service.Impl;

import com.travel.travel.dao.scoreDao;
import com.travel.travel.entity.score;
import com.travel.travel.service.scoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class scoreServiceImpl implements scoreService {
    @Autowired
    private scoreDao dao;

    @Override
    public List<score> queryScore() {
        return dao.queryScore();
    }

    @Override
    public List<score> queryScoreByNote(Integer scoreid) {
        return dao.queryScoreByNote(scoreid);
    }

    @Transactional
    @Override
    public boolean addScore(score score,Integer userid) {
        List<score> sc=dao.queryScoreByUser(userid);
        int num=sc.size();
        if(score.getSCScore() !=null && !"".equals(score.getSCScore()) && num==0){
            try{
                int effectedNum=dao.insertScore(score);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("评分失败！！");
                }
            } catch (Exception e){
                throw new RuntimeException("评分失败："+e.getMessage());
            }
        }else if(num==1){
            throw new RuntimeException("您已经评过分了！");
        }
        else{
            throw new RuntimeException("分数不能为空！");
        }
    }

    @Override
    public int queryAvgScoreByNote(Integer noteid) {
        return dao.queryAvgScoreByNote(noteid);
    }

}

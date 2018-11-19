package com.travel.travel.service.Impl;

import com.travel.travel.dao.scenicDao;
import com.travel.travel.entity.scenic;
import com.travel.travel.entity.score;
import com.travel.travel.service.scenicService;
import com.travel.travel.service.scoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class scenicServiceImpl implements scenicService {
    @Autowired
    private scenicDao dao;

    @Override
    public List<scenic> queryScenic() {
        return dao.queryScenic();
    }

    @Override
    public List<scenic> queryScenicByCity(String SCity) {
        return dao.queryScenicByCity(SCity);
    }

    @Transactional
    @Override
    public boolean insertScenic(scenic scenic) {
        if(scenic.getSDes() !=null && !"".equals(scenic.getSDes())){
            try{
                int effectedNum=dao.insertScenic(scenic);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("插入信息失败！");
                }
            } catch (Exception e){
                throw new RuntimeException("插入信息失败："+e.getMessage());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean updateScenic(scenic scenic) {
        if(scenic.getSDes() !=null){
            try{
                int effectedNum= dao.updateScenic(scenic);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("更新信息失败！");
                }
            } catch (Exception e){
                throw new RuntimeException("更新信息失败："+e.toString());
            }
        }else{
            throw new RuntimeException("区域信息不能为空！");
        }
    }

    @Override
    public boolean deleteTravelNote(int SId) {
        if(SId>0){
            try{
                int effectedNum=dao.deleteTravelNote(SId);
                if(effectedNum>0){
                    return true;
                }else{
                    throw new RuntimeException("删除信息失败！");
                }
            } catch (Exception e){
                throw new RuntimeException("删除信息失败："+e.toString());
            }
        }else{
            throw new RuntimeException("区域Id不能为空！");
        }
    }

}

package com.travel.travel.service.Impl;

import com.travel.travel.dao.tnDao;
import com.travel.travel.entity.tn;
import com.travel.travel.service.tnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class tnServiceImpl implements tnService {
    @Autowired
    private tnDao tndao;

    @Override
    public List<tn> queryTravelNote() {
        return tndao.queryTravelNote();
    }

    @Override
    public List<tn> queryTravelNoteByCity(String TNCity) {
        return tndao.queryTravelNoteByCity(TNCity);
    }

    @Transactional
    @Override
    public boolean addTravelNote(tn TN) {
        if(TN.getTN_Title() !=null && !"".equals(TN.getTN_Title())){
            try{
                int effectedNum=tndao.insertTravelNote(TN);
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
    public boolean modifyTravelNote(tn TN) {
        if(TN.getTNId() !=null && TN.getTNId()>0){
            try{
                int effectedNum= tndao.updateTravelNote(TN);
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
    public boolean deleteTravelNote(int TNId) {
        if(TNId>0){
            try{
                int effectedNum=tndao.deleteTravelNote(TNId);
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

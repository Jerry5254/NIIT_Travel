package com.travel.travel.service.Impl;

import com.travel.travel.dao.reasonDao;
import com.travel.travel.entity.reason;
import com.travel.travel.service.reasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class reasonServiceImpl implements reasonService {
    @Autowired
    private reasonDao dao;

    @Override
    public List<reason> queryReason() {
        return dao.queryReason();
    }

    @Override
    public List<reason> queryReasonByUserId(Integer userid) {
        return dao.queryReasonByUserId(userid);
    }

    @Transactional
    @Override
    public boolean insertReason(reason reason) {
        if(reason.getRDetails() !=null && !"".equals(reason.getRDetails())){
            try{
                int effectedNum=dao.insertReason(reason);
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
}

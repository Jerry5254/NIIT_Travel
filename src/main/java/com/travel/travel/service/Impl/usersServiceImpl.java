package com.travel.travel.service.Impl;


import com.travel.travel.dao.usersDao;
import com.travel.travel.entity.users;
import com.travel.travel.service.usersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class usersServiceImpl implements usersService {

    @Autowired
    private usersDao usersdao;
    @Override
    public List<users> queryUsers() {
        return usersdao.queryUsers();
    }

    @Override
    public users queryUsersById(int UId) {
        return usersdao.queryUsersById(UId);
    }

    @Transactional
    @Override
    public boolean addUsers(users user) {
        if(user.getUName() !=null && !"".equals(user.getUName())){
            try{
                int effectedNum=usersdao.insertUsers(user);
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
    public boolean modifyUsers(users user) {
        if(user.getUId() !=null && user.getUId()>0){
            try{
                int effectedNum=usersdao.updateUsers(user);
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
    public boolean deleteUsers(int UId) {
        if(UId>0){
            try{
                int effectedNum=usersdao.deleteUsers(UId);
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

    @Override
    public users queryUsersByMail(String UMail,String pass) {
        users user=usersdao.queryUsersByMail(UMail);
        if(user!=null)
        {
            String UPass=user.getUPwd();
            if(UPass.equals(pass))
                return user;
            else
                throw new RuntimeException("密码错误！");
        }
        else
            throw new RuntimeException("用户不存在！");


    }
}

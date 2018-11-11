package com.travel.travel.service;

import com.travel.travel.entity.users;

import java.util.List;

public interface usersService {
        List<users> queryUsers();
        users queryUsersById(int UId);
        boolean addUsers(users user);
        boolean modifyUsers(users user);
        boolean deleteUsers(int UId);
        users queryUsersByMail(String UMail,String pass);

}

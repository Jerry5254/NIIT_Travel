package com.niit.travel.dao;

import com.niit.travel.entity.Admin;


public interface AdminDao {
    Admin queryAdminById(int adminId);
    Admin queryAdminByMail(String adminMail);//可能不需要了
}

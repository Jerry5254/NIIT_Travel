package com.niit.travel.dao;

import com.niit.travel.entity.Admin;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminDaoTest {

    @Autowired
    private AdminDao adminDao;

    @Test
    public void queryAdminById() {
        Admin admin=adminDao.queryAdminById(1);
        assertEquals("admin@foxmail.com",admin.getAdmin_Mail());
    }

    @Test
    public void queryAdminByMail() {
        Admin admin=adminDao.queryAdminByMail("admin@foxmail.com");
        assertEquals(1,(int)admin.getAdmin_id());
    }
}
package com.travel.travel.dao;

import com.travel.travel.entity.users;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class usersDaoTest {
    @Autowired
    private usersDao usersdao;

    @Test
    public void queryUsers() {
        List<users> usersList=usersdao.queryUsers();
        assertEquals(1, usersList.size());
    }

    @Test
    @Ignore
    public void queryUsersById() {
        users user=usersdao.queryUsersById(1);
        assertEquals("Summer",user.getUName());
    }

    @Test
    @Ignore
    public void insertUsers() {
        users user=new users();
        user.setUName("Jerry");
        user.setUGender("女");
        user.setUIcon("11");
        user.setUMail("123@qq.com");
        user.setUMobile("12345");
        user.setUPwd("123");
        int efftectedNum= usersdao.insertUsers(user);
        assertEquals(1,efftectedNum);
    }

    @Test
    @Ignore
    public void updateUsers() {
        users user=new users();
        user.setUId(1);
        user.setUPwd("qwe123456");
        user.setUName("Summer");
        int efftectedNum= usersdao.updateUsers(user);
        assertEquals(1,efftectedNum);
    }

    @Test
    @Ignore
    public void deleteUseers() {
        int effectedNum=usersdao.deleteUsers(2);
        assertEquals(1,effectedNum);
    }
}
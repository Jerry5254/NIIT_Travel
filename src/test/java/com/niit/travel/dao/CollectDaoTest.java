package com.niit.travel.dao;

import com.niit.travel.entity.Collect;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectDaoTest {

    @Autowired
    private CollectDao collectDao;

    @Test
    public void getCollectList() {
        List<Collect> collectList=collectDao.getCollectList();
        assertEquals(1,collectList.size());
    }

    @Test
    public void getCollectById() {
        Collect collect=collectDao.getCollectById(1);
        assertEquals(1,(int)collect.getCollect_Noteid());
    }

    @Test
    public void getCollectByNoteId() {
        Collect collect=collectDao.getCollectByNoteId(1);
        assertEquals(1,(int)collect.getCollect_Id());
    }

    @Test
    public void getCollectByUserId() {
        Collect collect=collectDao.getCollectByUserId(1);
        assertEquals(1,(int)collect.getCollect_Id());
    }

    @Test
    public void insertCollect() {
        Collect collect=new Collect();
        collect.setCollect_Noteid(2);
        collect.setCollect_Userid(1);
        collect.setCollect_Date(new Date());
        int effectedNum=collectDao.insertCollect(collect);
        assertEquals(1,effectedNum);
    }

    @Test
    public void updateCollect() {
        Collect collect=new Collect();
        collect.setCollect_Userid(2);
        collect.setCollect_Id(2);
        int effectedNum=collectDao.updateCollect(collect);
        assertEquals(1,effectedNum);
    }

    @Test
    public void deleteCollect() {
        int effectedNum=collectDao.deleteCollect(2);
        assertEquals(1,effectedNum);
    }
}
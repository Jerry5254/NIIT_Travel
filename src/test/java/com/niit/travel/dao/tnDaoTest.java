package com.niit.travel.dao;


import com.niit.travel.entity.tn;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class tnDaoTest {
    @Autowired
    private tnDao tndao;

    @Test
    public void querytn() {
        List<tn> tnList=tndao.queryTravelNote();
        assertEquals(1, tnList.size());
    }

    @Test
    public void queryUsersById() {
        List<tn> tnList=tndao.queryTravelNoteByCity("Guangzhou");
        assertEquals(1,tnList.size());
    }

    @Test
    public void insertUsers() {
        tn tn=new tn();
        tn.setTN_Content("你好");
        tn.setTN_Title("世界");
        tn.setTN_Pics("12345");
        tn.setTNAuthor_id(1);
        tn.setTN_Date(new Date());
        tn.setTNCity("Qingdao");
        tn.setTNHit_Number(1);
        tn.setTN_Status("Z");
        int efftectedNum= tndao.insertTravelNote(tn);
        assertEquals(1,efftectedNum);
    }

    @Test
    public void updateUsers() {
        tn tn=new tn();
        tn.setTNId(2);
        tn.setTNHit_Number(3);
        int efftectedNum= tndao.updateTravelNote(tn);
        assertEquals(1,efftectedNum);
    }

    @Test
    public void deleteUseers() {
        int effectedNum=tndao.deleteTravelNote(2);
        assertEquals(1,effectedNum);
    }
}

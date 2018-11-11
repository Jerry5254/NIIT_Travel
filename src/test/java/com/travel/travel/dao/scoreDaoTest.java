package com.travel.travel.dao;

import com.travel.travel.entity.score;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class scoreDaoTest {

        @Autowired
        private scoreDao dao;

        @Test
        public void queryscore() {
            List<score> scoreList=dao.queryScore();
            assertEquals(1, scoreList.size());
        }

        @Test
        public void queryScoreByNote() {
            List<score> scoreList=dao.queryScoreByNote(1);
            assertEquals(1,scoreList.size());
        }

        @Test
        public void insertScore() {
            score score = new score();
            score.setSCNote_id(1);
            score.setSCScore(90);
            score.setSCUser_id(1);
            int efftectedNum = dao.insertScore(score);
            assertEquals(1, efftectedNum);
        }

}

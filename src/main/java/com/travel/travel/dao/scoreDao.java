package com.travel.travel.dao;

import com.travel.travel.entity.score;

import java.util.List;

public interface scoreDao {
    List<score> queryScore();
    List<score> queryScoreByNote(Integer scoreid);
    int insertScore(score score);
    int queryAvgScoreByNote(Integer noteid);
    List<score> queryScoreByUser(Integer userid);
}

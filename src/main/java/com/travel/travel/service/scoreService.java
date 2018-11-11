package com.travel.travel.service;

import com.travel.travel.entity.score;

import java.util.List;

public interface scoreService {
    List<score> queryScore();
    List<score> queryScoreByNote(Integer scoreid);
    boolean addScore(score score,Integer userid);
    int queryAvgScoreByNote(Integer noteid);
}

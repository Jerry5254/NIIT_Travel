package com.travel.travel.dao;

import com.travel.travel.entity.scenic;
import com.travel.travel.entity.score;

import java.util.List;

public interface scenicDao {
    List<scenic> queryScenic();
    List<scenic> queryScenicByCity(String SCity);
    int insertScenic(scenic scenic);
    int updateScenic(scenic scenic);
    int deleteTravelNote(int SId);
}

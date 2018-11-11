package com.travel.travel.dao;

import com.travel.travel.entity.tn;
import com.travel.travel.entity.users;

import java.util.List;

public interface tnDao {
        List<tn> queryTravelNote();
        List<tn> queryTravelNoteByCity(String TNCity);
        int insertTravelNote(tn TN);
        int updateTravelNote(tn TN);
        int deleteTravelNote(int TNId);
}

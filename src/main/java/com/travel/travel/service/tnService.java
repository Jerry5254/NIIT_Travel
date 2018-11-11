package com.travel.travel.service;

import com.travel.travel.entity.tn;

import java.util.List;

public interface tnService {
    List<tn> queryTravelNote();
    List<tn> queryTravelNoteByCity(String TNCity);
    boolean addTravelNote(tn TN);
    boolean modifyTravelNote(tn TN);
    boolean deleteTravelNote(int TNId);
}

package com.niit.travel.dao;

import com.niit.travel.entity.Collect;

import java.util.List;

public interface CollectDao {
    List<Collect> getCollectList();
    Collect getCollectById(int collectId);
    Collect getCollectByNoteId(int noteId);
    Collect getCollectByUserId(int userId);
    int insertCollect(Collect collect);
    int updateCollect(Collect collect);
    int deleteCollect(int collectId);
}

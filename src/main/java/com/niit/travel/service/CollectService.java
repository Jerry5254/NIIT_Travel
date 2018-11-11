package com.niit.travel.service;


import com.niit.travel.entity.Collect;

import java.util.List;

public interface CollectService {
    List<Collect> getCollectList();
    Collect getCollectById(Integer collectId);
    Collect getCollectByUser(Integer userId);
    Collect getCollectByNote(Integer noteId);
    boolean addCollect(Collect collect);
    boolean modifyCollect(Collect collect);
    boolean deleteClooect(Integer collectId);
}

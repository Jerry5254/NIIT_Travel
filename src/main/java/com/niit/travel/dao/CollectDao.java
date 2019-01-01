/*********************************************************
 * 文件名: CollectDao
 * 作者: 魏捷宇
 * 说明:
 *********************************************************/
package com.niit.travel.dao;

import com.niit.travel.entity.Collect;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CollectDao {
    List<Collect> getCollectList();
    Collect getCollectById(int collectId);
    Collect getCollectByNoteId(int noteId);
    Collect getCollectByUserId(int userId);
    int insertCollect(Collect collect);
    int updateCollect(Collect collect);
    int deleteCollect(int collectId);
}

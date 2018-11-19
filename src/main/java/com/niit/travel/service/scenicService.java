package com.travel.travel.service;

import com.travel.travel.entity.scenic;

import java.util.List;

public interface scenicService {
    List<scenic> queryScenic();
    List<scenic> queryScenicByCity(String SCity);
    boolean insertScenic(scenic scenic);
    boolean updateScenic(scenic scenic);
    boolean deleteTravelNote(int SId);
}

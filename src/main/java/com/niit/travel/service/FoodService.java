package com.niit.travel.service;

import com.niit.travel.entity.Food;

import java.util.List;

public interface FoodService {
    List<Food> getFoodList();
    Food getFoodById(Integer foodId);
    Food getFoodByCity(String cityName);
    boolean addFood(Food food);
    boolean modifyFood(Food food);
    boolean deleteFood(Integer foodId);
}

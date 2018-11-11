package com.niit.travel.dao;

import com.niit.travel.entity.Food;

import java.util.List;

public interface FoodDao {
    List<Food> getFoodList();
    Food getFoodById(int foodId);
    Food getFoodByCity(String cityName);
    int insertFood(Food food);
    int updateFood(Food food);
    int deleteFood(int foodId);
}

package com.niit.travel.dao;

import com.niit.travel.entity.City;

import java.util.List;

public interface CityDao {
    List<City> getCityList();
    City getCityById(int cityId);
    City getCityByName(String cityName);
    int insertCity(City city);
    int updateCity(City city);
    int deleteCity(int cityId);
    List<City> getCityListInOrder(String property);
}

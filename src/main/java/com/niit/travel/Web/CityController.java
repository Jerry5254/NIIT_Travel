package com.niit.travel.Web;

import com.niit.travel.entity.City;
import com.niit.travel.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    @RequestMapping(value="/citylist",method = RequestMethod.GET)
    public Map<String,Object> getCityList()
    {
        Map<String,Object> modelMap=new HashMap<>();
        List<City> cityList=cityService.getAllCity();
        List<City> effecedList= new ArrayList<>();
        for(City city:cityList)
        {
            if(city.getCStatus().equals("Y"))
            {
                effecedList.add(city);
            }
        }
        modelMap.put("cityList",effecedList);
        return modelMap;
    }

    @RequestMapping(value="/citylistinorder",method = RequestMethod.GET)
    public Map<String,Object> getCityListInOrder()
    {
        Map<String,Object> modelMap=new HashMap<>();
        List<City> cityList=cityService.getOrderCity("CHit_Number");
        modelMap.put("cityList",cityList);
        return modelMap;
    }

    @RequestMapping(value = "/city_id",method = RequestMethod.GET)
    public Map<String,Object> getCityById(Integer cityId)
    {
        Map<String,Object> modelMap=new HashMap<>();
        City city=cityService.getCityById(cityId);
        modelMap.put("city",city);
        return modelMap;
    }

    @RequestMapping(value="/city_name",method = RequestMethod.GET)
    public Map<String,Object> getCityByName(String cityName)
    {
        Map<String,Object> modelMap = new HashMap<>();
        City city=cityService.getCityByName(cityName);
        modelMap.put("city",city);
        return modelMap;
    }

    @RequestMapping(value = "/addcity",method = RequestMethod.POST)
    public Map<String,Object> insertCity(@RequestBody City city)
    {
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",cityService.addCity(city));
        return modelMap;
    }

    @RequestMapping(value="/modifycity",method = RequestMethod.POST)
    public Map<String, Object> modifyCity(@RequestBody City city)
    {
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",cityService.modifyCity(city));
        return modelMap;
    }

    @RequestMapping(value="/deletecity",method = RequestMethod.POST)
    public Map<String,Object> deleteCity(Integer cityId)
    {
        Map<String,Object> modelMap=new HashMap<>();
        modelMap.put("success",cityService.deleteCity(cityId));
        return modelMap;
    }

}

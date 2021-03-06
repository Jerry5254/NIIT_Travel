/*********************************************************
 * 文件名: CityController
 * 作者: 魏捷宇
 * 说明:
 *********************************************************/
package com.niit.travel.Web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.travel.entity.City;
import com.niit.travel.service.CityService;
import com.niit.travel.util.ImageUtil;
import com.niit.travel.util.PathUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
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
    @ResponseBody
    public Map<String,Object> getCityList()
    {
        Map<String,Object> modelMap=new HashMap<>();
        try {
            List<City> cityList = cityService.getAllCity();
            List<City> effecedList = new ArrayList<>();
            for (City city : cityList) {
                if (city.getCStatus().equals("Y")) {
                    city.setCStatus("审核通过");
                    effecedList.add(city);
                }
            }
            modelMap.put("cityList", effecedList);
            modelMap.put("success",true);
        }catch(Exception e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value="/ncitylist",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getNCityList()
    {
        Map<String,Object> modelMap=new HashMap<>();
        try {
            List<City> cityList = cityService.getAllCity();
            List<City> effecedList = new ArrayList<>();
            for (City city : cityList) {
                if (city.getCStatus().equals("N")) {
                    city.setCStatus("待审核");
                    effecedList.add(city);
                }
            }
            modelMap.put("cityList", effecedList);
            modelMap.put("success",true);
        }catch(Exception e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value="/allcitylist",method = RequestMethod.GET)
    @ResponseBody
    public Map<String,Object> getAllCityList()
    {
        Map<String,Object> modelMap=new HashMap<>();
        try {
            List<City> cityList = cityService.getAllCity();
            for (City city : cityList) {
                if (city.getCStatus().equals("Y")) {
                    city.setCStatus("审核通过");
                }else{
                    city.setCStatus("待审核");
                }
            }
            modelMap.put("cityList", cityList);
            modelMap.put("success",true);
        }catch(Exception e){
            modelMap.put("success", false);
            modelMap.put("errMsg", e.getMessage());
        }
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
    public Map<String,Object> getCityById(HttpServletRequest request)
    {

        Map<String, Object> modelMap = new HashMap<>();
        String cityIdString=request.getParameter("cityId");
        if(cityIdString!=null&&!"".equals(cityIdString)) {
            int cityId = Integer.parseInt(cityIdString);
            City city = cityService.getCityById(cityId);
            if(city!=null&&city.getCId()>0) {
                modelMap.put("city", city);
                modelMap.put("success", true);
            }else{
                modelMap.put("success",false);
                modelMap.put("errMsg","城市获取失败");
            }
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","城市获取失败");
        }
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
    public Map<String,Object> insertCity(HttpServletRequest request)
    {
        City city =null;
        Map<String,Object> modelMap=new HashMap<>();

        String newCityInfo = request.getParameter("newCityInfo");
        ObjectMapper mapper = new ObjectMapper();
        try {
            city = mapper.readValue(newCityInfo,City.class);
        } catch (IOException e) {
            modelMap.put("success",false);
            modelMap.put("errMsg", e.getMessage());
        }

        if(cityService.getCityByName(city.getCName())!=null)
        {
            modelMap.put("success",false);
            modelMap.put("errMsg", "已经存在该城市了");
        }else {
            modelMap.put("success", cityService.addCity(city));
        }
        return modelMap;
    }

    @RequestMapping(value="/modifycity",method = RequestMethod.POST)
    public Map<String, Object> modifyCity(HttpServletRequest request)
    {
        Map<String,Object> modelMap=new HashMap<>();
        City city = new City();
        int cityId =Integer.parseInt(request.getParameter("cityId"));
        String cityName = request.getParameter("cityName");
        String cityDesc = request.getParameter("cityDesc");
        city.setCId(cityId);
        city.setCName(cityName);
        city.setCDes(cityDesc);
        modelMap.put("success",cityService.modifyCity(city));
        return modelMap;
    }

    @RequestMapping(value="/changecitystatus",method = RequestMethod.POST)
    public Map<String, Object> changeCityStatus(HttpServletRequest request)
    {
        City city=new City();
        Map<String,Object> modelMap=new HashMap<>();
        int cityId=0;
        try {
            String cityIdString = request.getParameter("cityId");
            cityId = Integer.parseInt(cityIdString);
            city.setCId(cityId);
            city.setCStatus("Y");
            modelMap.put("success",cityService.modifyCity(city));
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value="/deletecity",method = RequestMethod.POST)
    public Map<String,Object> deleteCity(HttpServletRequest request)
    {
        Map<String,Object> modelMap=new HashMap<>();
        int cityId=0;
        try {
            String cityIdString = request.getParameter("cityId");
            cityId = Integer.parseInt(cityIdString);
            modelMap.put("success",cityService.deleteCity(cityId));
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg","城市ID有误");
        }
        return modelMap;
    }

    @RequestMapping(value="/addcitypic",method=RequestMethod.POST)
    public Map<String,Object> addCityPic(HttpServletRequest request){
        Map<String,Object> modelMap=new HashMap<>();
        int imgAmount =Integer.parseInt(request.getParameter("imgAmount"));
        int cityId=Integer.parseInt(request.getParameter("cityId"));
        String cityImagesAddr;
        if(cityService.getCityById(cityId).getCPic()==null||"".equals(cityService.getCityById(cityId).getCPic())) {
            cityImagesAddr = "";
        }else{
            cityImagesAddr = cityService.getCityById(cityId).getCPic();
        }
        for(int i=0;i<imgAmount;i++){
            MultipartFile file = ((MultipartHttpServletRequest)request).getFile("cityImg["+i+"]");
            String dest = PathUtil.getCityImagePath(cityId);
            String cityImgAddr = ImageUtil.addPicture(file,file.getOriginalFilename(),dest);
            cityImagesAddr+=cityImgAddr+";";
        }
        City city = new City();
        city.setCId(cityId);
        city.setCPic(cityImagesAddr);
        modelMap.put("success",cityService.modifyCity(city));
        return modelMap;
    }

    @RequestMapping(value="/getcitypic",method = RequestMethod.GET)
    public Map<String,Object> getCityPic(HttpServletRequest request){
        Map<String,Object> modelMap=new HashMap<>();
        int cityId=Integer.parseInt(request.getParameter("cityId"));
        City city = cityService.getCityById(cityId);
        if(city.getCPic()!=null&&!city.getCPic().equals("")) {
            String cityPics = city.getCPic();
            String pic[] = cityPics.split(";");
            List<String> picList = new ArrayList<>();
            for (String citypic : pic) {
                picList.add(citypic);
            }
            modelMap.put("success", true);
            modelMap.put("havePic",true);
            modelMap.put("picList",picList);
        }else{
            modelMap.put("success",true);
            modelMap.put("havePic",false);
        }
        return modelMap;
    }

    @RequestMapping(value="/deletepic",method = RequestMethod.POST)
    public Map<String,Object> deletePic(HttpServletRequest request)
    {
        Map<String,Object> modelMap=new HashMap<>();
        String path = request.getParameter("cityPath");
        int cityId = Integer.parseInt(request.getParameter("cityId"));
        boolean result = cityService.deletePic(cityId,path);
        if(result){
            modelMap.put("success",true);
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","删除图片失败");
        }
        return modelMap;
    }

}

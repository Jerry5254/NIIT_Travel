/*********************************************************
 * 文件名: FoodController
 * 作者: 魏捷宇
 * 说明:
 *********************************************************/
package com.niit.travel.Web;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.niit.travel.entity.Food;
import com.niit.travel.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @RequestMapping(value = "/addfood",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertFood(HttpServletRequest request)
    {
        Food food = null;
        Map<String,Object> modelMap=new HashMap<>();

        String foodStr=request.getParameter("foodStr");
        System.out.println(foodStr);
        ObjectMapper mapper=new ObjectMapper();

        try {
            food = mapper.readValue(foodStr, Food.class);
            System.out.println("food名字"+food.getFName());
        }catch(Exception e) {
            modelMap.put("success",false);
            modelMap.put("errMsg", e.getMessage());
            System.out.println("出错啦"+e);
            return modelMap;
        }
        MultipartFile file = ((MultipartHttpServletRequest)request).getFile("foodImg");
        String path="F:/ProjectTest";
        String realPath=path+"/"+file.getOriginalFilename();
        try {
            file.transferTo(new File(realPath));
        } catch (IOException e) {
            System.out.println("传输文件出错了"+e);
            modelMap.put("success",false);
            modelMap.put("errMsg", e.getMessage());
            return modelMap;
        }
//        CommonsMultipartFile foodImg = null;
//        CommonsMultipartResolver commonsMultipartResolver =new CommonsMultipartResolver(
//                request.getSession().getServletContext());
//        if(commonsMultipartResolver.isMultipart(request))
//        {
//            System.out.println("准备获取图片");
//            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest)request;
//            foodImg=(CommonsMultipartFile)multipartHttpServletRequest.getFile("foodImg");
//
//            System.out.println("已经获取图片");
//            System.out.println(foodImg);
//
//            try {
//
//                multipartHttpServletRequest.getFile("foodImg").transferTo(new File("F:\\IDEAProject\\travel\\Img",foodImg.getName()));
//                String foodPath="F:\\IDEAProject\\travel\\Img\\"+foodImg.getName();
//                Food.setFPic(foodPath);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }else {
//            modelMap.put("success", false);
//            modelMap.put("errMsg", "上传图片不能为空");
//            return modelMap;
//        }
        boolean result =foodService.addFood(food);
        modelMap.put("success",result);
        return modelMap;
    }

    @RequestMapping(value = "/getfoodlist",method = RequestMethod.GET)
    public Map<String,Object> getFoodList(HttpServletRequest request)
    {
        Map<String,Object> modelMap = new HashMap<>();
        List<Food> foodList=null;
        try {
            foodList = foodService.getFoodList();
            if(foodList!=null){
                modelMap.put("foodList",foodList);
                modelMap.put("success",true);
            }else{
                modelMap.put("success",false);
                modelMap.put("errMsg","暂时没有美食");
            }
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value="/cityfood",method = RequestMethod.GET)
    public Map<String,Object> getFoodByCity(HttpServletRequest request)
    {
        Map<String,Object> modelMap = new HashMap<>();
        String cityName = request.getParameter("cityName");
        List<Food> foodList = null;
        try{
            foodList = foodService.getFoodByCity(cityName);
            if(foodList!=null){
                modelMap.put("cityfoodList",foodList);
                modelMap.put("success",true);
            }else{
                modelMap.put("success",false);
                modelMap.put("errMsg","该城市暂时没有推荐美食哦");
            }
        }catch (Exception e){
            modelMap.put("success",false);
            modelMap.put("errMsg",e.getMessage());
        }
        return modelMap;
    }

    @RequestMapping(value="/food_id",method = RequestMethod.GET)
    public Map<String,Object> getFoodById(HttpServletRequest request){
        Map<String,Object> modelMap = new HashMap<>();
        String data = request.getParameter("foodId");
        int foodId =Integer.parseInt(data);
        Food food = null;
        if(foodId>0){
            try {
                food = foodService.getFoodById(foodId);
                if(food!=null){
                    modelMap.put("food",food);
                    modelMap.put("success",true);
                }else {
                    modelMap.put("success", false);
                    modelMap.put("errMsg", "没有美食哦");
                }
            }catch(Exception e){
                modelMap.put("success",false);
                modelMap.put("errMsg",e.getMessage());
            }
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","美食ID出错了哦");
        }
        return modelMap;
    }

    @RequestMapping(value="/deletefood",method = RequestMethod.POST)
    public Map<String,Object> deleteFood(HttpServletRequest request)
    {
        Map<String,Object> modelMap=new HashMap<>();
        String data = request.getParameter("foodId");
        int foodId = Integer.parseInt(data);
        if(foodId>0){
            modelMap.put("success",foodService.deleteFood(foodId));
        }else{
            modelMap.put("success",false);
            modelMap.put("errMsg","美食ID有误");
        }
        return modelMap;
    }

}

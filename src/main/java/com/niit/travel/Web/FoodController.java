package com.niit.travel.Web;

import com.fasterxml.jackson.databind.DeserializationFeature;
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
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/food")
public class FoodController {
    @Autowired
    private FoodService foodService;

    @RequestMapping(value = "/addfood",method = RequestMethod.POST)
    @ResponseBody
    public Map<String,Object> insertCity(HttpServletRequest request)
    {
        System.out.println("AddFood()正在启动");
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
        try {
            file.transferTo(new File(path+"/"+file.getOriginalFilename()));
        } catch (IOException e) {
            System.out.println("传输文件出错了"+e);
        }
        System.out.println(file.getOriginalFilename());


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
//                food.setFPic(foodPath);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }else {
//            modelMap.put("success", false);
//            modelMap.put("errMsg", "上传图片不能为空");
//            return modelMap;
//        }

//        modelMap.put("success",foodService.addFood(food));
        System.out.println("AddFood启动完毕");
        return modelMap;
    }
}

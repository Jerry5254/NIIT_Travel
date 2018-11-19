package com.travel.travel.web;

import com.travel.travel.entity.scenic;
import com.travel.travel.service.scenicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/scenic")
public class scenicController {
    @Autowired
    private scenicService scenicservice;

    @RequestMapping(value = "/listscenic",method = RequestMethod.GET)
    private Map<String,Object> listtn(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<scenic> list=scenicservice.queryScenic();
        modelMap.put("sceniclist",list);
        return modelMap;
    }

    @RequestMapping(value = "/getscenicbycity",method = RequestMethod.GET)
    private Map<String,Object> scn(String city){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<scenic> list=scenicservice.queryScenicByCity(city);
        modelMap.put("sceniclist_city",list);
        return modelMap;
    }

    @RequestMapping(value = "/addscenic",method = RequestMethod.POST)
    private Map<String, Object> addtn(@RequestBody scenic scenic){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        modelMap.put("success",scenicservice.insertScenic(scenic));
        return modelMap;
    }

    @RequestMapping(value = "/modifyscenic",method = RequestMethod.POST)
    private Map<String, Object> modifysc(@RequestBody scenic scenic){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        modelMap.put("success",scenicservice.updateScenic(scenic));
        return modelMap;
    }

    @RequestMapping(value = "/removescenic",method = RequestMethod.GET)
    private Map<String,Object> removesc(Integer SCId){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        modelMap.put("success",scenicservice.deleteTravelNote(SCId));
        return  modelMap;
    }
}

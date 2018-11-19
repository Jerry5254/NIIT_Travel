package com.travel.travel.web;

import com.travel.travel.entity.tn;
import com.travel.travel.entity.users;
import com.travel.travel.service.tnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/tn")
public class tnController {
    @Autowired
    private tnService tnservice;

    @RequestMapping(value = "/listtn",method = RequestMethod.GET)
    private Map<String,Object> listtn(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<tn> list=tnservice.queryTravelNote();
        modelMap.put("tnlist",list);
        return modelMap;
    }

    @RequestMapping(value = "/gettnbycity",method = RequestMethod.GET)
    private Map<String,Object> listtncity(String city){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<tn> list=tnservice.queryTravelNoteByCity(city);
        modelMap.put("tnlist_city",list);
        return modelMap;
    }

    @RequestMapping(value = "/addtravelnote",method = RequestMethod.POST)
    private Map<String, Object> addtn(@RequestBody tn tn){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        modelMap.put("success",tnservice.addTravelNote(tn));
        return modelMap;
    }

    @RequestMapping(value = "/modifyuser",method = RequestMethod.POST)
    private Map<String, Object> modifyuser(@RequestBody tn tn){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        modelMap.put("success",tnservice.modifyTravelNote(tn));
        return modelMap;
    }

    @RequestMapping(value = "/removeuser",method = RequestMethod.GET)
    private Map<String,Object> removeUser(Integer TNId){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        modelMap.put("success",tnservice.deleteTravelNote(TNId));
        return  modelMap;
    }
}

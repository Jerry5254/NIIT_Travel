package com.travel.travel.web;

import com.travel.travel.entity.reason;
import com.travel.travel.entity.scenic;
import com.travel.travel.service.reasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/reason")
public class reasonController {
    @Autowired
    private reasonService reasonservice;

    @RequestMapping(value = "/listreason",method = RequestMethod.GET)
    private Map<String,Object> listreason(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<reason> list=reasonservice.queryReason();
        modelMap.put("reasonlist",list);
        return modelMap;
    }

    @RequestMapping(value = "/getreasonbyuserid",method = RequestMethod.GET)
    private Map<String,Object> getre(Integer userid){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<reason> list=reasonservice.queryReasonByUserId(userid);
        modelMap.put("reasonlist_userid",list);
        return modelMap;
    }

    @RequestMapping(value = "/addreason",method = RequestMethod.POST)
    private Map<String, Object> addre(@RequestBody reason reason){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        modelMap.put("success",reasonservice.insertReason(reason));
        return modelMap;
    }

}

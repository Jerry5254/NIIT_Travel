package com.travel.travel.web;

import com.travel.travel.entity.users;
import com.travel.travel.service.usersService;
import javafx.beans.binding.ObjectExpression;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
public class usersController {
    @Autowired
    private usersService userservice;

    @RequestMapping(value = "/listusers",method = RequestMethod.GET)
    private Map<String,Object> listusers(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<users> list=userservice.queryUsers();
        modelMap.put("userslist",list);
        return modelMap;
    }

    @RequestMapping(value = "/getuserbyid",method = RequestMethod.GET)
    private Map<String,Object> getUserById(Integer userid){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        users user=userservice.queryUsersById(userid);
        modelMap.put("user",user);
        return modelMap;
    }

    @RequestMapping(value = "/adduser",method = RequestMethod.POST)
    private Map<String, Object> adduser(@RequestBody users user){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        modelMap.put("success",userservice.addUsers(user));
        return modelMap;
    }

    @RequestMapping(value = "/modifyuser",method = RequestMethod.POST)
    private Map<String, Object> modifyuser(@RequestBody users user){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        modelMap.put("success",userservice.modifyUsers(user));
        return modelMap;
    }

    @RequestMapping(value = "/removeuser",method = RequestMethod.GET)
    private Map<String,Object> removeUser(Integer userID){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        modelMap.put("success",userservice.deleteUsers(userID));
        return  modelMap;
    }

    @RequestMapping(value = "/login",method = RequestMethod.GET)
    private Map<String,Object> login(String mail,String password){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        users user=userservice.queryUsersByMail(mail,password);
        modelMap.put("success",user);
        return modelMap;
    }


}

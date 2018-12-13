package com.niit.travel.Web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IndexController {
    @RequestMapping(value="/index")
    public String testDemo(){
        return "index";
    }

    @RequestMapping(value="/addfood")
    public String addFood(){
        return "addfood";
    }
}

package com.travel.travel.web;

import com.travel.travel.entity.score;
import com.travel.travel.service.scoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/score")
public class scoreController {
    @Autowired
    private scoreService scoreservice;

    @RequestMapping(value = "/listscore",method = RequestMethod.GET)
    private Map<String,Object> listscore(){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<score> list=scoreservice.queryScore();
        modelMap.put("scorelist",list);
        return modelMap;
    }

    @RequestMapping(value = "/getscorebynote",method = RequestMethod.GET)
    private Map<String,Object> score(Integer noteid){
        Map<String,Object> modelMap=new HashMap<String,Object>();
        List<score> list=scoreservice.queryScoreByNote(noteid);
        modelMap.put("scorelist_note",list);
        return modelMap;
    }

    @RequestMapping(value = "/addscore",method = RequestMethod.POST)
    private Map<String, Object> addscore(@RequestBody score score,Integer userid){
        Map<String,Object>modelMap=new HashMap<String,Object>();
        modelMap.put("success",scoreservice.addScore(score,userid));
        return modelMap;
    }

    @RequestMapping(value="/getavgscorebynote",method = RequestMethod.GET)
    private Map<String,Object> getAvg(Integer noteid) {
        Map<String, Object> modelMap = new HashMap<String, Object>();
        modelMap.put("avg",scoreservice.queryAvgScoreByNote(noteid));
        return modelMap;
    }


}

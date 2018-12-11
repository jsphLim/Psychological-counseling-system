package com.ly.ssm.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ly.ssm.model.consultant;
import com.ly.ssm.service.consultantService;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

//import java.io.Console;


/**
 * Created by ly on 2018/11/30.
 */

@Controller
public class consultantController {

    private Logger log = Logger.getLogger(consultantController.class);
    @Resource
    private consultantService consultantService;



    @RequestMapping(value = "showAll")
    @ResponseBody
    public JSONArray showAll(HttpServletRequest request, HttpServletResponse response) {
        List<consultant> consultants = consultantService.getConsultant();

        JSONArray json = new JSONArray();

        for(consultant c : consultants){
            JSONObject tmp = new JSONObject();
            tmp.put("tno",c.getTno());
            tmp.put("tname", c.getConsultantName());
            tmp.put("email", c.getConsultantEmail());
            tmp.put("location", c.getLocation());
            tmp.put("dutytime",c.getDutyTime());
            tmp.put("currentnumber",c.getCurrenNumber());
            tmp.put("totalnumber",c.getTotalNumber());
            json.add(tmp);
        }

        return json;
    }

    @RequestMapping("searchTname")
    @ResponseBody
    public JSONArray searchTname(HttpServletResponse response,HttpServletRequest request){
        String tname = request.getParameter("tname");
        List<consultant> consultants = consultantService.selectByTname(tname);
        JSONArray json = new JSONArray();
        for(consultant c : consultants){
            JSONObject consult = new JSONObject();
            consult.put("tno",c.getTno());
            consult.put("tname", c.getConsultantName());
            consult.put("email", c.getConsultantEmail());
            consult.put("location", c.getLocation());
            consult.put("dutytime",c.getDutyTime());
            consult.put("currentnumber",c.getCurrenNumber());
            consult.put("totalnumber",c.getTotalNumber());
            json.add(consult);
        }
        return json;
    }





}

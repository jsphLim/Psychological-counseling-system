package com.ly.ssm.controller;


import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ly.ssm.model.appointment;
import com.ly.ssm.model.consultant;
import com.ly.ssm.model.student;
import com.ly.ssm.service.appointmentService;
import com.ly.ssm.service.consultantService;
import com.ly.ssm.utils.util;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
public class appointmentController {
    private Logger log = Logger.getLogger(appointmentController.class);
    @Resource
    private appointmentService appointmentService;
    @Resource
    private consultantService consultantService;

    @RequestMapping("search")
    @ResponseBody
    public JSONArray search(HttpServletRequest request, HttpServletResponse response){
        List<appointment> appointments = new ArrayList<appointment>();
        HttpSession session = request.getSession();
        student st = (student)session.getAttribute("user");
        appointments = appointmentService.selectBySno(st.getSno());

        JSONArray json = new JSONArray();

        for(appointment app : appointments){
            JSONObject tmp = new JSONObject();
            tmp.put("serialNumber",app.getSerialNumber());
            tmp.put("sno", app.getSno());
            tmp.put("tname",app.getTname());
            tmp.put("appointDate",app.getAppointDate());
            tmp.put("location",app.getLocation());
            json.add(tmp);
        }
        session.setAttribute("studentSearchResult",json);
        System.out.println(json.toString());
        return json;
    }

    @RequestMapping("createAppointment")
    @ResponseBody
    public JSONObject createAppointment(HttpServletRequest request,HttpServletResponse response){
        student st = (student)request.getSession().getAttribute("user");
        System.out.println(st.getSno());
        String sno  = st.getSno();
        String tno = request.getParameter("tno");
        consultant c = consultantService.selectByTno(tno);
        if(c.getCurrenNumber()>=c.getTotalNumber()){
            JSONObject code = util.errorCode(0,"该老师名额已满");
        }
        System.out.println(c.toString());
        appointment app = new appointment(null,sno,tno,c.getDutyTime(),"心理疾病问题",0,"",c.getConsultantName(),c.getLocation());
        boolean is_reserved = appointmentService.checkReservation(app);
        if(is_reserved) {
            appointmentService.createAppotintment(app);
            return util.errorCode(1,"成功预约!");

        }
        else{
            return util.errorCode(0,"您已预约该老师!");
        }

    }


    @RequestMapping("cancel")
    @ResponseBody
    public boolean cancel(HttpServletRequest request,HttpServletResponse response){
        String serialNumber = request.getParameter("serialnumber");
        String tno = appointmentService.selectBySerialNumber(new Integer(serialNumber));
        System.out.println("serialnumber:"+serialNumber.toString());
        appointmentService.cancel(new Integer(serialNumber));
        consultantService.finishReservation(tno);
        return true;
    }




}

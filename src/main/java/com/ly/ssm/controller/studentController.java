package com.ly.ssm.controller;

import com.alibaba.fastjson.JSONObject;
import com.ly.ssm.model.student;
import com.ly.ssm.service.studentService;
import com.ly.ssm.utils.util;
import org.apache.log4j.Logger;
import org.apache.log4j.Priority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import java.io.Console;


/**
 * Created by ly on 2018/11/30.
 */

@Controller
public class studentController {

    private Logger log = Logger.getLogger(studentController.class);
    @Resource
    private studentService studentService;



    @RequestMapping("login")
    @ResponseBody
    public JSONObject login(HttpServletRequest request, HttpServletResponse response) {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        password = util.encrypt(password);
        System.out.println(username+password);
        HttpSession session = request.getSession();
        student s=studentService.checkLogin(username,password);

        if(s!=null){
            session.setAttribute("user", s);
            return util.errorCode(1,"登录成功");
        }
//        System.out.print(111);
        return util.errorCode(0,"账号密码错误");
    }

    @RequestMapping("register")
    @ResponseBody
    public JSONObject register(HttpServletRequest request, HttpServletResponse response) {
        String sno = request.getParameter("username");
        String password = request.getParameter("password");
        String email = request.getParameter("email");
        String deptno = request.getParameter("deptno");
        String username = request.getParameter("name");
//        System.out.println(username+password+email);email
        password = util.encrypt(password);
        HttpSession session = request.getSession();
        boolean flag =studentService.checkRegister(sno,username,password,email,deptno);
        if(flag){
            return util.errorCode(1,"注册成功!");
        }
//        System.out.print(111);
        return util.errorCode(0,"注册失败，请检查网络");
    }

    @RequestMapping("logout")
    @ResponseBody
    public boolean logout(HttpServletRequest request,HttpServletResponse response){
        Object student = request.getSession().getAttribute("user");
        if(student!=null){
            request.getSession().removeAttribute("user");
            return true;
        }
        return false;
    }

    @RequestMapping("online")
    @ResponseBody
    public String online(HttpServletRequest request,HttpServletResponse response){
        student st = (student)request.getSession().getAttribute("user");

        if (st != null) {
            log.log(Priority.toPriority("session:"),st);
            return st.getSno();
        } else {
            return null;
        }
    }
    @RequestMapping("changepw")
    @ResponseBody
    public JSONObject changePw(HttpServletRequest request, HttpServletResponse response){
        student user = (student)request.getSession().getAttribute("user");
        if(user==null){
            return util.errorCode(0,"请重新登录");
        }
        String oldPassword = util.encrypt(request.getParameter("oldpw"));
        String newPassword = util.encrypt(request.getParameter("newpw"));
        if(studentService.checkLogin(user.getSno(),oldPassword)!=null){
            studentService.updatePassword(user.getSno(),newPassword);
            request.getSession().removeAttribute("user");
            return util.errorCode(1,"修改成功!请重新登录!");
        }
        else{
            return util.errorCode(0,"输入密码错误");
        }
    }

}

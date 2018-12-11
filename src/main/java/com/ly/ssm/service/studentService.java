package com.ly.ssm.service;

import com.ly.ssm.model.student;

/**
 * Created by ly on 2018/11/30.
 */
public interface studentService {


    public void register(student s);

    public student checkLogin(String sno, String password);

    public boolean checkRegister(String sno, String username, String email,String password,String deptno);

    public void updatePassword(String sno, String newpw);
}

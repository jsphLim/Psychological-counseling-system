package com.ly.ssm.model;

public class student {


    public student(String sno,String studentName, String studentEmail, String studentPassword, String deptno) {
        this.studentName = studentName;
        this.studentEmail = studentEmail;
        this.studentPassword = studentPassword;
        this.deptno = deptno;
        this.sno=sno;
    }

    public student(){}

    public String getSno() {
        return sno;
    }

    public void setISno(String sno) {
        this.sno = sno;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }

    private String sno;
    private String studentName;
    private String studentEmail;
    private String studentPassword;
    private String deptno;




}

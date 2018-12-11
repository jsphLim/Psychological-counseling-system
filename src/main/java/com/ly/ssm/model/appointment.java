package com.ly.ssm.model;

import java.util.Date;

public class appointment {

    public appointment(Integer serialNumber, String sno, String tno, String appointDate, String detail, int status, String sname, String tname,String location) {
        this.serialNumber = serialNumber;
        this.sno = sno;
        this.tno = tno;
        this.appointDate = appointDate;
        this.detail = detail;
        this.status = status;
        this.sname = sname;
        this.tname = tname;
        this.location=location;
    }
    public appointment(){}

    public Integer getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(Integer serialNumber) {
        this.serialNumber = serialNumber;
    }

    public String getSno() {
        return sno;
    }

    public void setSno(String sno) {
        this.sno = sno;
    }

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getAppointDate() {
        return appointDate;
    }

    public void setAppointDate(String appointDate) {
        this.appointDate = appointDate;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSname() {
        return sname;
    }

    public void setSname(String sname) {
        this.sname = sname;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    private Integer serialNumber;
    private String sno;
    private String tno;
    private String appointDate;
    private String detail;
    private int status;
    private String sname;
    private String tname;
    private String location;



}

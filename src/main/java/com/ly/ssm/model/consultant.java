package com.ly.ssm.model;

public class consultant {


    public consultant(String tno, String consultantName, String consultantEmail, int currentNumber, int totalNumber, String location, String consultantInformation,String dutyTime) {
        this.tno = tno;
        this.consultantName = consultantName;
        this.consultantEmail = consultantEmail;
        this.currentNumber = currentNumber;
        this.totalNumber = totalNumber;
        this.location = location;
        this.consultantInformation = consultantInformation;
        this.dutyTime = dutyTime;
    }
    public consultant(){}

    public String getTno() {
        return tno;
    }

    public void setTno(String tno) {
        this.tno = tno;
    }

    public String getConsultantName() {
        return consultantName;
    }

    public void setConsultantName(String consultantName) {
        this.consultantName = consultantName;
    }

    public String getConsultantEmail() {
        return consultantEmail;
    }

    public void setConsultantEmail(String consultantEmail) {
        this.consultantEmail = consultantEmail;
    }

    public int getCurrenNumber() {
        return currentNumber;
    }

    public void setCurrentNumber(int currentNumber) {
        this.currentNumber = currentNumber;
    }

    public int getTotalNumber() {
        return totalNumber;
    }

    public void setTotalNumber(int totalNumber) {
        this.totalNumber = totalNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getConsultantInformation() {
        return consultantInformation;
    }

    public void setConsultantInformation(String consultantInformation) {
        this.consultantInformation = consultantInformation;
    }

    public String getDutyTime() {
        return dutyTime;
    }

    public void setDutyTime(String dutyTime) {
        this.dutyTime = dutyTime;
    }


    private String tno;
    private String consultantName;
    private String consultantEmail;
    private int currentNumber;
    private int totalNumber;
    private String location;
    private String consultantInformation;
    private String dutyTime;

}

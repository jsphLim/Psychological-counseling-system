package com.ly.ssm.service;

import com.ly.ssm.model.appointment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface appointmentService {
    List<appointment> selectBySno(String sno);
    List<appointment> selectByTno(String tno);
    void confirmStatus(Integer serialNumber);
    void rejectStatus(Integer serialNumber);
    void cancel(Integer serialNumber);
    void createAppotintment(appointment app);
    String selectBySerialNumber(Integer serialnumber);
    boolean checkReservation(appointment app);
}

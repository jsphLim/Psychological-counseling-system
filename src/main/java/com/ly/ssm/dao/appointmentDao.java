package com.ly.ssm.dao;

import com.ly.ssm.model.appointment;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface appointmentDao {

    List<appointment> selectBySno(@Param("sno") String sno);
    List<appointment> selectByTno(@Param("tno") String tno);
    void confirmStatus(@Param("serialNumber") Integer serialNumber);
    void rejectStatus(@Param("serialNumber") Integer serialNumber);
    appointment selectBySerialNumber(@Param("serialNumber") Integer serialNumber);
    void cancel(@Param("serialNumber") Integer serialNumber);
    void createAppotintment(appointment app);
    appointment checkReserved(@Param("sno") String sno,@Param("tname") String tname);

}

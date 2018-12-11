package com.ly.ssm.service.impl;

import com.ly.ssm.dao.appointmentDao;
import com.ly.ssm.dao.consultantDao;
import com.ly.ssm.model.appointment;
import com.ly.ssm.model.consultant;
import com.ly.ssm.service.appointmentService;
import com.ly.ssm.service.consultantService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ly on 2018/11/30.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class appointmentServiceImpl implements appointmentService {
    
    @Resource
    private appointmentDao appointmentDao;
    @Resource
    private consultantDao consultantDao;

    public List<appointment> selectBySno(String sno){
        return appointmentDao.selectBySno(sno);
    }

    public List<appointment> selectByTno(String tno){
        return appointmentDao.selectByTno(tno);
    }

    public void confirmStatus(Integer serialNumber){
        appointmentDao.confirmStatus(serialNumber);
    }

    public void rejectStatus(Integer serialNumber){
        appointmentDao.rejectStatus(serialNumber);
    }

    public void cancel(Integer serialNumber){
        appointmentDao.cancel(serialNumber);
    }

    public void createAppotintment(appointment app) {
        appointmentDao.createAppotintment(app);
        consultantDao.reserve(app.getTno());
    }

    public String selectBySerialNumber(Integer serialnumber) {
        System.out.println(serialnumber);
        String tno =  appointmentDao.selectBySerialNumber(serialnumber).getTno();
        System.out.println("tno:"+tno);
        return tno;
    }

    public boolean checkReservation(appointment app) {
        appointment app_in = appointmentDao.checkReserved(app.getSno(),app.getTname());
        if(app_in == null){
            return true;
        }
        return false;
    }


}

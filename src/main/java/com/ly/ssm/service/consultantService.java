package com.ly.ssm.service;

import com.ly.ssm.model.consultant;

import java.util.List;

/**
 * Created by ly on 2018/11/30.
 */
public interface consultantService {


    public List<consultant> getConsultant();
    public consultant selectByTno(String tno);
    public void finishReservation(String tno);
    public List<consultant> selectByTname(String tname);
}

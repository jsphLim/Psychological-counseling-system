package com.ly.ssm.service.impl;

import com.ly.ssm.dao.consultantDao;
import com.ly.ssm.model.consultant;
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
public class consultantServiceImpl implements consultantService {
    
    @Resource
    private consultantDao consultantDao;


    public List<consultant> getConsultant() {
        return consultantDao.selectConsultant();
    }

    public consultant selectByTno(String tno) {
        return consultantDao.selectByTno(tno);
    }

    public void getReservation(String tno) {
        consultantDao.reserve(tno);

    }

    public void finishReservation(String tno) {
        consultantDao.cancel(tno);
    }

    public List<consultant> selectByTname(String tname) {
        return consultantDao.selectByTname(tname);
    }
}

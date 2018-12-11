package com.ly.ssm.dao;

import com.ly.ssm.model.consultant;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface consultantDao {

    List<consultant> selectConsultant();
    List<consultant> selectByTname(@Param("consultantName") String tname);
    consultant selectByTno(@Param("tno") String tno);
    void reserve(@Param("tno")String tno);
    void cancel(@Param("tno")String tno);


}

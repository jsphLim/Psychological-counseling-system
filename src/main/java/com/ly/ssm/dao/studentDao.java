package com.ly.ssm.dao;

import com.ly.ssm.model.student;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface studentDao {

    student selectStudent(@Param("sno") String sno);
    void register(student s);
    void updatePassword(@Param("sno") String sno,@Param("studentPassword") String pw);

}

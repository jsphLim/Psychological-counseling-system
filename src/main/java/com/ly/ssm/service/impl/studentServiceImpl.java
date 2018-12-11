package com.ly.ssm.service.impl;

import com.ly.ssm.dao.studentDao;
import com.ly.ssm.model.student;
import com.ly.ssm.service.studentService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by ly on 2017/11/30.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class studentServiceImpl implements studentService {
    
    @Resource
    private studentDao studentDao;

//    public User getUserById(Long userId) {
//        return userDao.selectUserById(userId);
//    }

//    public List<User> findUserName(String userName,String userPhone) {
//        List<User> userList=userDao.findUserName(userName,userPhone);
//        return userList;
//    }

    public void register(student s) {
         studentDao.register(s);
    }

//    public void update(student s) {
//        studentDao.update(s);
//    }

    
//    public List<User> getAllUser() {
//        return userDao.selectAllUser();
//    }

    public student checkLogin(String sno, String password) {
        //根据用户名实例化用户对象
        student s = studentDao.selectStudent(sno);
        if (s != null && s.getStudentPassword().equals(password)) {
            return s;
        }
        return null;
    }

    public boolean checkRegister(String sno, String name,String password,String email,String deptno) {
        //根据用户名实例化用户对象
        student s = studentDao.selectStudent(sno);
        if(s!=null){
            return false;
        }
        else{
            student new_s = new student(sno,name,email,password,deptno);
            register(new_s);
            return true;
        }
    }


    public void updatePassword(String sno,String newpw) {
        studentDao.updatePassword(sno,newpw);
    }
}

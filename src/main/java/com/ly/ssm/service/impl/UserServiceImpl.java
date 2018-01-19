package com.ly.ssm.service.impl;

import com.ly.ssm.dao.UserDao;
import com.ly.ssm.model.User;
import com.ly.ssm.service.UserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by ly on 2017/11/30.
 */
@Service
@Transactional(rollbackFor = Exception.class)
public class UserServiceImpl implements UserService {
    
    @Resource
    private UserDao userDao;

//    public User getUserById(Long userId) {
//        return userDao.selectUserById(userId);
//    }

//    public List<User> findUserName(String userName,String userPhone) {
//        List<User> userList=userDao.findUserName(userName,userPhone);
//        return userList;
//    }

    public void save(User user) {
         userDao.save(user);
    }

    public void update(User user) {
        userDao.update(user);
    }

    
//    public List<User> getAllUser() {
//        return userDao.selectAllUser();
//    }

    public User checkLogin(String userName, String userPwd) {
        //根据用户名实例化用户对象
        User user = userDao.selectUser(userName);
        if (user != null && user.getUserPwd().equals(userPwd)) {
            return user;
        }
        return null;
    }

    public boolean checkRegister(String userName, String userPwd,String email) {
        //根据用户名实例化用户对象
        User user = userDao.selectUser(userName);
        if(user!=null){
            return false;
        }
        else{
            User updateuser = new User();
            updateuser.setUserName(userName);
            updateuser.setUserPwd(userPwd);
            updateuser.setUserEmail(email);
            save(updateuser);
            return true;
        }
    }

    public boolean updatePass(String newPass,String username) {
        userDao.updatePass(newPass,username);
        return true;
    }
}

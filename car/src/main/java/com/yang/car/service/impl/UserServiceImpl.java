package com.yang.car.service.impl;


import com.yang.car.dao.UserDao;
import com.yang.car.model.UserModel;
import com.yang.car.service.IUserService;

public class UserServiceImpl implements IUserService {
    // 用户注册
    @Override
    public boolean register(UserModel user) {
        UserDao userDao = new UserDao();
        return userDao.register(user);
    }
    // 用户登录
    @Override
    public UserModel login(String username, String password,String role) {
        UserDao userDao = new UserDao();
        return userDao.login(username,password,role);
    }
    // 删除用户
    @Override
    public boolean delete(String username) {
        UserDao userDao = new UserDao();
        return userDao.delete(username);
    }

    @Override
    public boolean change(String username, UserModel user) {
        UserDao userDao = new UserDao();
        return userDao.change(username,user);
    }
}

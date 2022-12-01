package com.yang.car.service;


import com.yang.car.model.UserModel;

public interface IUserService {
    // 用户注册信息
    boolean register(UserModel user);
    // 用户登录
    UserModel login(String username,String password,String role);
    // 删除用户
    boolean delete(String username);
    // 修改用户信息
    boolean change(String username,UserModel user);
}

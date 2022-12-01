package com.yang.car.dao;


import com.yang.car.model.UserModel;
import com.yang.car.utils.C3P0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    private static final String registerSQL = "insert into user(username,password,gender,idCard,phone,address) values(?,?,?,?,?,?)";
    private static final String loginSQL = "select * from user where username=? and password=? and role=?";
    private static final String deleteSQL = "DELETE FROM user where username=?";
    private static final String upDataSQL = "UPDATE user SET password=?, gender=?,idCard=?,phone=?,address=? WHERE username=?";
    // 用户注册信息
    public boolean register(UserModel user){
        Connection con = null;
        PreparedStatement ps = null;
        int rows = 0;
        try {
            con = C3P0Utils.getConnection();
            ps = con.prepareStatement(registerSQL);
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getGender());
            ps.setString(4, user.getIdCard());
            ps.setString(5, user.getPhone());
            ps.setString(6, user.getAddress());
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Utils.close(con,ps, null);
        }
        return rows>0?true:false;
    }
    // 用户登录
    public UserModel login(String username,String password,String role){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<UserModel> userList = null;
        try {
            con = C3P0Utils.getConnection();
            ps = con.prepareStatement(loginSQL);
            ps.setString(1,username);
            ps.setString(2,password);
            ps.setString(3,role);
            rs = ps.executeQuery();
            userList = new ArrayList<>();
            while (rs.next()){
                UserModel user = new UserModel();
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                userList.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Utils.close(con,ps,rs);
        }
        return userList.size()==0?null:userList.get(0);
    }
    // 删除用户
    public boolean delete(String username){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int i = 0;
        try {
            con = C3P0Utils.getConnection();
            ps = con.prepareStatement(deleteSQL);
            ps.setString(1, username);
            i = ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Utils.close(con,ps,rs);
        }
        return i>0?true:false;
    }
    // 修改用户信息
    public boolean change(String username,UserModel user){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = C3P0Utils.getConnection();
            ps = con.prepareStatement(upDataSQL);
            ps.setString(6, username);
            ps.setString(1, user.getPassword());
            ps.setString(2, user.getGender());
            ps.setString(3, user.getIdCard());
            ps.setString(4, user.getPhone());
            ps.setString(5, user.getAddress());
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Utils.close(con,ps, null);
        }
        return rows>0?true:false;
    }
}

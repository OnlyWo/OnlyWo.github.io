package com.yang.car.utils;

import java.sql.*;
import java.util.ResourceBundle;

public class DBUtils {
    public static  String driver;
    public static  String url;
    public static  String username;
    public static  String password;

    //获取配置文件
    public static ResourceBundle bd=ResourceBundle.getBundle("info");
    static{
        driver=bd.getString("driver");
        url=bd.getString("url");
        username=bd.getString("username");
        password=bd.getString("pwd");
    }
    public static void release(Connection con, PreparedStatement pr, ResultSet rs){
        // 关闭结果集
        try {
            if (con!=null){
                con.close();
            }
            if (pr!=null){
                pr.close();
            }
            if (rs!=null){
                rs.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    // 创建连接对象
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        // 加载Driver驱动
        Class.forName(DBUtils.driver);
        // 2.获取数据库连接
        return DriverManager.getConnection(DBUtils.url, DBUtils.username, DBUtils.password);

    }
}

package com.yang.car.servlet;


import com.yang.car.model.UserModel;
import com.yang.car.service.IUserService;
import com.yang.car.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 设置编码集
        request.setCharacterEncoding("UTF-8");
        /*response.setCharacterEncoding("UTF-8");*/
        response.setHeader("Content-Type", "text/html; charset=utf-8");
        response.setContentType("text/html; charset=utf-8");
        response.setHeader("pragma", "no-cache");
        response.setHeader("cache-control", "no-cache");
        response.setDateHeader("expires", 0);

        // 接收前端提交的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String role = request.getParameter("role");
        // 控制台打印是否正确接收前端提交的数据完整性
        System.out.println("username:"+username+"\tpassword:"+password+"\trole"+role);

        // 将数据存入实体类中
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(password);
        // 打印实体类userModel中是否存username和password信息
        System.out.println(userModel);
        // 调用service
        IUserService userService = new UserServiceImpl();
        UserModel flagLogin;
        flagLogin = userService.login(username,password,role);

        if ("普通用户".equals(role)){
            if (flagLogin==null){
                response.getWriter().write("用户名密码错误，登录失败");
            }else{
                response.sendRedirect("/html/home.html");
            }
        }else {
            if (flagLogin==null){
                response.getWriter().write("用户名密码错误，登录失败");
            }else{
                response.sendRedirect("/QueryCarServlet");
            }
        }
        System.out.println("登录代码执行完毕");

    }
}

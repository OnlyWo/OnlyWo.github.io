package com.yang.car.servlet;

import com.yang.car.model.UserModel;
import com.yang.car.service.IUserService;
import com.yang.car.service.impl.UserServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserDeleteServlet", value = "/UserDeleteServlet")
public class UserDeleteServlet extends HttpServlet {
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
        // 控制台打印是否正确接收前端提交的数据完整性
        System.out.println("username:"+username+"\tpassword:"+password);

        // 将数据存入实体类中
        UserModel userModel = new UserModel();
        userModel.setUsername(username);
        userModel.setPassword(password);
        // 打印实体类userModel中是否存username和password信息
        System.out.println(userModel);
        // 调用service
        IUserService userService = new UserServiceImpl();
        boolean flag = userService.delete(username);


        if (!flag){
            response.getWriter().write("删除信息失败");
        }else {
            response.getWriter().write("删除信息成功");
//            response.sendRedirect("/QueryCarServlet");
        }
    }
}

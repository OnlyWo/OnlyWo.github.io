package com.yang.car.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UserServlet", value = "/UserServlet")
public class UserServlet extends HttpServlet {
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

        String action = request.getParameter("action");
        if (action.equals("查询汽车名")){
            response.sendRedirect("/html/search.html");
        }else if(action.equals("查询汽车类别")){
            response.sendRedirect("/html/brand.html");
        }else if (action.equals("按价格查询")){
            response.sendRedirect("/html/price.html");
        }else {
            System.out.println("输入有误");
        }
    }
}

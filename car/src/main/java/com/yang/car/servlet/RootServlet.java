package com.yang.car.servlet;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "RootServlet", value = "/RootServlet")
public class RootServlet extends HttpServlet {
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
        if (action.equals("添加汽车")){
            response.sendRedirect("/jsp/carAdd.jsp");
        }else if(action.equals("修改汽车")){
            response.sendRedirect("/html/carchange.html");
        }else if (action.equals("删除汽车")){
            response.sendRedirect("/jsp/cardelete.jsp");
        }else if (action.equals("修改用户信息")){
            response.sendRedirect("/html/userchange.html");
        }else if (action.equals("删除用户")){
            response.sendRedirect("/html/userdelete.html");
        }else if(action.equals("上传图片")){
            response.sendRedirect("/html/file.html");
        }else if(action.equals("退出")){
            response.sendRedirect(request.getHeader("Referer"));
        }
    }
}

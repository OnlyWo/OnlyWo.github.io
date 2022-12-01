package com.yang.car.servlet;

import com.yang.car.service.ICarService;
import com.yang.car.service.impl.CarServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CarDeleteServlet", value = "/CarDeleteServlet")
public class CarDeleteServlet extends HttpServlet {
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

        String id = request.getParameter("id");
        String carName = request.getParameter("car_name");
        System.out.println("id:"+id+"\tcar_name:"+carName);

        // 调用修改方法
        ICarService carService = new CarServiceImpl();
        boolean delete = carService.delete(id, carName);
        if (delete){
            response.getWriter().write("删除成功");
        }else {
            response.getWriter().write("删除失败");
        }

    }
}

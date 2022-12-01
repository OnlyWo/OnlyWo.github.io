package com.yang.car.servlet;

import com.yang.car.model.CarModel;
import com.yang.car.service.ICarService;
import com.yang.car.service.impl.CarServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "CarChangeServlet", value = "/CarChangeServlet")
public class CarChangeServlet extends HttpServlet {
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
        String remark = request.getParameter("remark");
        String brand = request.getParameter("brand");
        String type = request.getParameter("type");
        String price = request.getParameter("price");
        String rentable = request.getParameter("rentable");
        String state = request.getParameter("state");
        System.out.println("id:"+id+"\tcar_name:"+carName);
        // 将数据填充到实体类中
        CarModel carModel = new CarModel();
        carModel.setCar_name(carName);
        carModel.setRemark(remark);
        carModel.setBrand(brand);
        carModel.setType(type);
        carModel.setPrice(Double.valueOf(price));
        carModel.setRentable(rentable);
        carModel.setState(state);
        System.out.println("实体类填充内容："+carModel);

        // 调用修改方法
        ICarService carService = new CarServiceImpl();
        boolean change = carService.change(id, carModel);
        if (change){
            response.getWriter().write("修改成功");
        }else {
            response.getWriter().write("修改失败");
        }


    }
}

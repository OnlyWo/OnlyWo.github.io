package com.yang.car.servlet;

import com.yang.car.model.CarModel;
import com.yang.car.service.ICarService;
import com.yang.car.service.impl.CarServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "SearchServlet", value = "/SearchServlet")
public class SearchServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String car_name = request.getParameter("car_name");
        // 调用service
        System.out.println("car_name:"+car_name);
        ICarService carService = new CarServiceImpl();
        List<CarModel> carList = carService.queryCarName(car_name);
        System.out.println("id*********"+car_name);
        System.out.println("carList:"+carList); // 打印carList数据

        request.setAttribute("carList",carList);
        request.getRequestDispatcher("/jsp/search.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}

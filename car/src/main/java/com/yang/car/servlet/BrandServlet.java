package com.yang.car.servlet;

import com.yang.car.model.CarModel;
import com.yang.car.service.ICarService;
import com.yang.car.service.impl.CarServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "BrandServlet", value = "/BrandServlet")
public class BrandServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String brand = request.getParameter("brand");
        // 调用service
        System.out.println("brand:"+brand);
        ICarService carService = new CarServiceImpl();
        List<CarModel> carList = carService.queryBrand(brand);
        System.out.println("id*********"+brand);
        System.out.println("carList:"+carList); // 打印carList数据

        request.setAttribute("carList",carList);
        request.getRequestDispatcher("/jsp/brand.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

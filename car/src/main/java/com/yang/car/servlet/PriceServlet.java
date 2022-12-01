package com.yang.car.servlet;

import com.yang.car.model.CarModel;
import com.yang.car.service.ICarService;
import com.yang.car.service.impl.CarServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "PriceServlet", value = "/PriceServlet")
public class PriceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String min = request.getParameter("min");
        String max = request.getParameter("max");
        // 调用service
        System.out.println("min:"+min+"max"+max);
        ICarService carService = new CarServiceImpl();
        List<CarModel> carList = carService.queryPrice(min,max);
        System.out.println("id*********"+min+"^^^^^"+max);
        System.out.println("carList:"+carList); // 打印carList数据

        request.setAttribute("carList",carList);
        request.getRequestDispatcher("/jsp/price.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}

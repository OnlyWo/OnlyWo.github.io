package com.yang.car.servlet;

import com.yang.car.model.CarModel;
import com.yang.car.service.ICarService;
import com.yang.car.service.impl.CarServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "JSPServlet", value = "/JSPServlet")
public class JSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 获取页面传递过来的type
        String id = request.getParameter("id");
        ICarService carService = new CarServiceImpl();
        List<CarModel> carList = carService.queryId(id); // 按id查询汽车
        System.out.println("id*********"+id);
        System.out.println("carList:"+carList); // 打印carList数据

        request.setAttribute("carList",carList);
        request.getRequestDispatcher("/jsp/details.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}

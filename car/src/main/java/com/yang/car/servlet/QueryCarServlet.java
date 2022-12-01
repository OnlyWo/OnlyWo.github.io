package com.yang.car.servlet;

import com.yang.car.dao.CarDao;
import com.yang.car.model.CarModel;
import com.yang.car.service.ICarService;
import com.yang.car.service.impl.CarServiceImpl;
import com.yang.car.utils.AjaxUtils;
import net.sf.json.JSONArray;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "QueryCarServlet", value = "/QueryCarServlet")
public class QueryCarServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 域形式返回前端数据
        CarDao carDao = new CarDao();
        List<CarModel> carListA = carDao.queryAll();
        request.setAttribute("carList",carListA);
        request.getRequestDispatcher("/jsp/car.jsp").forward(request,response);
        System.out.println("返回car.jsp页面");
        // 调用接口方法
        ICarService carService = new CarServiceImpl();
        List<CarModel> carList = carService.queryAll(); // 查询全部汽车
        System.out.println("carList:"+carList); // 打印carList数据

        JSONArray jsonArray = JSONArray.fromObject(carList); // 把汽车集合转为json对象
        response.setContentType("application/json;charset=utf-8");
        /*response.getWriter().write(jsonArray.toString());   // 向前端打印数据*/
        // 告知浏览器你要用json的格式来解析我返回的数据类型
        AjaxUtils.ajaxJson(jsonArray.toString(),response);
        System.out.println("返回@@@@@@@@@@@@@@@@");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }

}

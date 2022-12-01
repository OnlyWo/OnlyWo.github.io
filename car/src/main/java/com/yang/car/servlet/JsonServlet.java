package com.yang.car.servlet;

import com.yang.car.model.CarModel;
import com.yang.car.service.ICarService;
import com.yang.car.service.impl.CarServiceImpl;
import com.yang.car.utils.AjaxUtils;
import net.sf.json.JSONArray;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "JsonServlet", value = "/JsonServlet")
public class JsonServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 获取页面传递过来的type
        String type = request.getParameter("type");
        // 调用service
        System.out.println("type:"+type);
        ICarService carService = new CarServiceImpl();
        List<CarModel> carList = carService.query(type);
        System.out.println("1234"+carList);
        // 把集合转为json
        JSONArray array = JSONArray.fromObject(carList);
        // 告知浏览器你要用json的格式来解析我返回的数据类型
        AjaxUtils.ajaxJson(array.toString(),response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }
}

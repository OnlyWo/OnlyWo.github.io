package com.yang.car.servlet;

import com.yang.car.model.CarModel;
import com.yang.car.service.ICarService;
import com.yang.car.service.impl.CarServiceImpl;
import com.yang.car.utils.AjaxUtils;
import com.yang.car.utils.QueryUtils;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "JsonGetServlet", value = "/JsonGetServlet")
public class JsonGetServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        // 获取页面传递过来的type
        String car_name = request.getParameter("car_name");
        // 调用service
        System.out.println("car_name:"+car_name);
        ICarService carService = new CarServiceImpl();
        List<CarModel> carList = carService.queryCarName(car_name);
        System.out.println("1234"+carList);
        // 把集合转为json
        JSONArray arrays = JSONArray.fromObject(carList);

        JSONObject obj = new JSONObject();
        System.out.println("~~~~~~~~~~~~~~"+arrays);
        obj.put("success",true);
        obj.put("data",arrays);
        obj.put("msg","查询成功");
        // 告知浏览器你要用json的格式来解析我返回的数据类型
        AjaxUtils.ajaxJson(obj.toString(),response);
        System.out.println("@@@@@@@@@@@@@@"+obj.toString());


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request,response);
    }
}

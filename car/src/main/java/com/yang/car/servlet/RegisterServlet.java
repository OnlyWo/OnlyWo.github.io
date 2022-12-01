package com.yang.car.servlet;

import com.yang.car.model.UserModel;
import com.yang.car.service.IUserService;
import com.yang.car.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

@WebServlet(name = "RegisterServlet", value = "/RegisterServlet")
public class RegisterServlet extends HttpServlet {
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

        /*//  接收前端提交的数据
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String gender = request.getParameter("gender");
        String idCard = request.getParameter("idCard");
        String phone = request.getParameter("phone");
        String address = request.getParameter("address");
        // 控制台打印是否正确接收数据完整
        System.out.println("username："+username+"\tpassword："+password+"\tgender："+gender+"\tidCard："+idCard+"\tphone："+phone+"\taddress："+address);*/

        // 将数据存入实体类中
        UserModel userModel = new UserModel();
        // 用第三方jar包BeanUtils中的populate方法将数据填充到userModel实体类中
        try {
            BeanUtils.populate(userModel,request.getParameterMap());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        // 打印实体类userModel是否正确填充数据
        System.out.println("userModel信息打印："+userModel);
        // 调用service
        IUserService userService = new UserServiceImpl();
        boolean flag = userService.register(userModel);
        if (flag){
            response.getWriter().write("恭喜注册成功");
        }else {
            response.getWriter().write("注册失败");
        }

    }
}

package com.yang.car.servlet;


import com.yang.car.common.Constants;

import com.yang.car.service.ICarService;
import com.yang.car.service.impl.CarServiceImpl;
import com.yang.car.utils.PicUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.List;

@WebServlet(name = "FileUploadServlet", value = "/FileUploadServlet")
public class FileUploadServlet extends HttpServlet {
    private String fileName=null;

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

        String id = null;
        String content = null;

        // 1-构建工厂类
        DiskFileItemFactory factory=new DiskFileItemFactory();
        //2-构建ServletFileUplaod
        ServletFileUpload sf=new ServletFileUpload(factory);
        //3-解析request
        try {
            List<FileItem> fileItems = sf.parseRequest(request);
            //4-循环所有的文件对象
            for (FileItem fileItem : fileItems) {
                //5-如果是普通的表单对象title,直接输出
                if(fileItem.isFormField()){
                    String title=fileItem.getString();
                    byte[] bytes = title.getBytes("ISO-8859-1");
                    System.out.println(new String(bytes,"UTF-8"));
                    content = title;
                }else{
                    handleFile(fileItem);
                }
                fileName = fileItem.getName();
                id = content;
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }finally {
            String carUrl = Constants.lastPath+"/"+PicUtils.getImgName(fileName);
            System.out.println("id:"+id+"carUrl"+carUrl);
            ICarService carService = new CarServiceImpl();
            boolean change = carService.urlCar(id, carUrl);
            if (change){
                response.getWriter().write("修改成功");
            }else {
                response.getWriter().write("修改失败");
            }
        }

    }
    //文件上传处理
    public void handleFile(FileItem fileItem)  {
        FileOutputStream out=null;
        InputStream in=null;
        try{
            //获取文件流
            in = fileItem.getInputStream();
            // this.getServletContext().getRealPath("/car_pic");
            //上传的地址
            File file=new File(Constants.filePath, PicUtils.getImgName(fileItem.getName()));
            //文件名称
            System.out.println("上传的文件名字:"+fileItem.getName());
            System.out.println("上传的文件的新名字："+PicUtils.getImgName(fileItem.getName()));
            System.out.println("图片存放路径："+Constants.lastPath);
            out = new FileOutputStream(file);
            //开始上传
            byte [] by=new byte[1024*20];//20kb
            int length=0;
            while((length=in.read(by))!=-1){
                out.write(by,0,length);
                out.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            try {
                out.close();
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}

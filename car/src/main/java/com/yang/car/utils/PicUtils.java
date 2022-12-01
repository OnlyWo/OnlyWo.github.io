package com.yang.car.utils;

public class PicUtils {
    //修改图片名称
    public static String getImgName(String oldName){
        //oldName=1.jpg;
        //把图片名称改成毫秒数+.jpg
        int index = oldName.lastIndexOf(".");
        String suffex = oldName.substring(index);
        return System.currentTimeMillis()+suffex;
    }

}

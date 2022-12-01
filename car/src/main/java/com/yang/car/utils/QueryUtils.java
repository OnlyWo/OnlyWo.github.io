package com.yang.car.utils;

import com.yang.car.model.CarModel;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class QueryUtils {
    public QueryUtils() {
    }

    public static void main(String... args) throws NoSuchFieldException, InstantiationException, IllegalAccessException {
        /*Class c = CarModel.class;
        Object o = c.newInstance();
        Field sname = c.getDeclaredField("sname");
        sname.setAccessible(true);
        sname.set(o, "张靓颖");
        sname.setAccessible(false);
        System.out.println(o);
        (new Object[]{1, "张三", null})[2] = new Date();*/










        String sql = "select * from emp where  sal>?";
        List<CarModel> carList = QueryUtils.queryData(sql, CarModel.class, new Object[]{2000});
        Iterator var3 = carList.iterator();

        while(var3.hasNext()) {
            CarModel car = (CarModel)var3.next();
            System.out.println(car);
        }
    }

    public static <T> List<T> queryData(String sql, Class<T> c, Object... args) {
        Connection con = null;
        List<T> tList = new ArrayList();
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = C3P0Utils.getConnection();
            ps = con.prepareStatement(sql);

            for(int i = 0; i < args.length; ++i) {
                ps.setObject(i + 1, args[i]);
            }

            rs = ps.executeQuery();
            ResultSetMetaData metaData = rs.getMetaData();
            int columnCount = metaData.getColumnCount();

            while(rs.next()) {
                T obj = c.newInstance();

                for(int i = 1; i <= columnCount; ++i) {
                    String columnName = metaData.getColumnName(i);
                    Object value = rs.getObject(columnName);
                    if (value != null) {
                        Field field = c.getDeclaredField(columnName);
                        field.setAccessible(true);
                        field.set(obj, value);
                        field.setAccessible(false);
                    }
                }

                tList.add(obj);
            }
        } catch (Exception var17) {
            var17.printStackTrace();
        } finally {
            DBUtils.release(con, ps, rs);
        }

        return tList;
    }

}

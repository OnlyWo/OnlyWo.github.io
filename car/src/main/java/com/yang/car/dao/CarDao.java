package com.yang.car.dao;


import com.yang.car.model.CarModel;
import com.yang.car.utils.C3P0Utils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CarDao {
    private static final String queryAllSQL = "select * from car"; // 查询全部汽车语句
    private static final String addCalSQL = "INSERT INTO car (car_name,remark,brand,type,price,rentable,state) values (?,?,?,?,?,?,?)";
    private static final String querySQL = "select * from car where type=?";    // 按类型查车
    private static final String queryBrandSQL = "select * from car where brand=?";    // 按品牌查车
    private static final String queryIdSQL = "select * from car where id=?";    // 按id查车
    private static final String queryPriceSQL = "select * from car where price between ? and ?";    // 按价格查车
    private static final String queryPriceMaxSQL = "select * from car where price <= ?";    // 按价格查车
    private static final String queryPriceMinSQL = "select * from car where price >= ?";    // 按价格查车
    private static final String queryNameSQL = "select * from car where car_name like ?";
    private static final String upDataSQL = "UPDATE car SET car_name=?, remark=?,brand=?,type=?,price=?,rentable=?,state=? WHERE id=?";
    private static final String deleteSQL = "DELETE FROM car where id=? and car_name=?";
    private static final String urlCarSQL = "UPDATE car SET carUrl=? WHERE id=?";
    // 查询全部汽车
    public List<CarModel> queryAll(){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CarModel> carList = null;
        try {
            con = C3P0Utils.getConnection();
            ps = con.prepareStatement(queryAllSQL);
            rs = ps.executeQuery();
            carList = new ArrayList<>();
            while (rs.next()){
                CarModel car = new CarModel();
                car.setId(rs.getString("id"));
                car.setCar_name(rs.getString("car_name"));
                car.setRemark(rs.getString("remark"));
                car.setBrand(rs.getString("brand"));
                car.setType(rs.getString("type"));
                car.setPrice(rs.getDouble("price"));
                car.setRentable(rs.getString("rentable"));
                car.setState(rs.getString("state"));
                car.setCarUrl(rs.getString("carUrl"));
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Utils.close(con,ps,rs);
        }
        return carList;
    }
    // 添加汽车
    public boolean addCar(CarModel car){
        Connection con = null;
        PreparedStatement ps = null;
        int rs = 0;
        try {
            con = C3P0Utils.getConnection();
            ps = con.prepareStatement(addCalSQL);
            ps.setString(1, car.getCar_name());
            ps.setString(2, car.getRemark());
            ps.setString(3, car.getBrand());
            ps.setString(4, car.getType());
            ps.setDouble(5,car.getPrice());
            ps.setString(6, car.getRentable());
            ps.setString(7, car.getState());
            rs = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Utils.close(con,ps,null);
        }
        return rs>0?true:false;
    }
    // 按汽车名模糊查询
    public List<CarModel> queryCarName(String carName){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CarModel> carList = new ArrayList<>();
        try {
            con = C3P0Utils.getConnection();

            ps = con.prepareStatement(queryNameSQL);
            ps.setString(1,"%"+carName+"%");

            rs = ps.executeQuery();
            while (rs.next()){
                CarModel car = new CarModel();
                car.setId(rs.getString("id"));
                car.setCar_name(rs.getString("car_name"));
                car.setRemark(rs.getString("remark"));
                car.setBrand(rs.getString("brand"));
                car.setType(rs.getString("type"));
                car.setPrice(rs.getDouble("price"));
                car.setRentable(rs.getString("rentable"));
                car.setState(rs.getString("state"));
                car.setCarUrl(rs.getString("carUrl"));
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Utils.close(con,ps,rs);
        }
        return carList;
    }
    // 按类型查询
    public List<CarModel> query(String type){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CarModel> carList = new ArrayList<>();
        try {
            con = C3P0Utils.getConnection();
            if (Objects.equals(type, "全部")){
                ps = con.prepareStatement(queryAllSQL);
            }else {
                ps = con.prepareStatement(querySQL);
                ps.setString(1,type);
            }
            rs = ps.executeQuery();
            while (rs.next()){
                CarModel car = new CarModel();
                car.setId(rs.getString("id"));
                car.setCar_name(rs.getString("car_name"));
                car.setRemark(rs.getString("remark"));
                car.setBrand(rs.getString("brand"));
                car.setType(rs.getString("type"));
                car.setPrice(rs.getDouble("price"));
                car.setRentable(rs.getString("rentable"));
                car.setState(rs.getString("state"));
                car.setCarUrl(rs.getString("carUrl"));
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Utils.close(con,ps,rs);
        }
        return carList;

    }
    // 按品牌查询车
    public List<CarModel> queryBrand(String brand){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CarModel> carList = new ArrayList<>();
        try {
            con = C3P0Utils.getConnection();
            if (Objects.equals(brand, "全部")){
                ps = con.prepareStatement(queryAllSQL);
            }else {
                ps = con.prepareStatement(queryBrandSQL);
                ps.setString(1,brand);
            }
            rs = ps.executeQuery();
            while (rs.next()){
                CarModel car = new CarModel();
                car.setId(rs.getString("id"));
                car.setCar_name(rs.getString("car_name"));
                car.setRemark(rs.getString("remark"));
                car.setBrand(rs.getString("brand"));
                car.setType(rs.getString("type"));
                car.setPrice(rs.getDouble("price"));
                car.setRentable(rs.getString("rentable"));
                car.setState(rs.getString("state"));
                car.setCarUrl(rs.getString("carUrl"));
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Utils.close(con,ps,rs);
        }
        return carList;

    }
    // 按价格查询车
    public List<CarModel> queryPrice(String min,String max){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        System.out.println("已接受最小值："+min+"已接受最大值"+max);
        List<CarModel> carList = new ArrayList<>();
        try {
            con = C3P0Utils.getConnection();
            if (max==""){
                ps = con.prepareStatement(queryPriceMinSQL);
                ps.setString(1,min); // 查大于这个价格的车
            }else if(min=="") {
                ps = con.prepareStatement(queryPriceMaxSQL);
                ps.setString(1,max);    // 查小于这个价格的车
            }else if(max=="" && min==""){
                ps = con.prepareStatement(queryAllSQL);
            } else {
                ps = con.prepareStatement(queryPriceSQL);
                ps.setString(1,min);
                ps.setString(2,max);
            }
            rs = ps.executeQuery();
            while (rs.next()){
                CarModel car = new CarModel();
                car.setId(rs.getString("id"));
                car.setCar_name(rs.getString("car_name"));
                car.setRemark(rs.getString("remark"));
                car.setBrand(rs.getString("brand"));
                car.setType(rs.getString("type"));
                car.setPrice(rs.getDouble("price"));
                car.setRentable(rs.getString("rentable"));
                car.setState(rs.getString("state"));
                car.setCarUrl(rs.getString("carUrl"));
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Utils.close(con,ps,rs);
        }
        return carList;

    }
    // 按id查询车
    public List<CarModel> queryId(String id){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<CarModel> carList = new ArrayList<>();
        try {
            con = C3P0Utils.getConnection();
            if (Objects.equals(id, "全部")){
                ps = con.prepareStatement(queryAllSQL);
            }else {
                ps = con.prepareStatement(queryIdSQL);
                ps.setString(1,id);
            }
            rs = ps.executeQuery();
            while (rs.next()){
                CarModel car = new CarModel();
                car.setId(rs.getString("id"));
                car.setCar_name(rs.getString("car_name"));
                car.setRemark(rs.getString("remark"));
                car.setBrand(rs.getString("brand"));
                car.setType(rs.getString("type"));
                car.setPrice(rs.getDouble("price"));
                car.setRentable(rs.getString("rentable"));
                car.setState(rs.getString("state"));
                car.setCarUrl(rs.getString("carUrl"));
                carList.add(car);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Utils.close(con,ps,rs);
        }
        return carList;

    }
    // 修改汽车
    public boolean change(String id,CarModel car){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = C3P0Utils.getConnection();
            ps = con.prepareStatement(upDataSQL);
            ps.setString(8, id);
            ps.setString(1, car.getCar_name());
            ps.setString(2, car.getRemark());
            ps.setString(3, car.getBrand());
            ps.setString(4, car.getType());
            ps.setDouble(5, car.getPrice());
            ps.setString(6,car.getRentable());
            ps.setString(7,car.getState());
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Utils.close(con,ps, null);
        }
        return rows>0?true:false;
    }
    // 删除汽车
    public boolean delete(String id,String carName){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int i = 0;
        try {
            con = C3P0Utils.getConnection();
            ps = con.prepareStatement(deleteSQL);
            ps.setString(1, id);
            ps.setString(2, carName);
            i = ps.executeUpdate();
        }catch (SQLException e) {
            e.printStackTrace();
        }finally {
            C3P0Utils.close(con,ps,rs);
        }
        return i>0?true:false;
    }
    // 修改汽车图片地址
    public boolean urlCar(String id,String carUrl){
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        int rows = 0;
        try {
            con = C3P0Utils.getConnection();
            ps = con.prepareStatement(urlCarSQL);
            ps.setString(2, id);
            ps.setString(1, carUrl);
            rows = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            C3P0Utils.close(con,ps, null);
        }
        return rows>0?true:false;
    }
}

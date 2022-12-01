package com.yang.car.service;

import com.yang.car.model.CarModel;
import com.yang.car.model.Page;

import java.util.List;

public interface ICarService {
    // 查询全部汽车
    List<CarModel> queryAll();
    // 添加汽车信息
    boolean addCar(CarModel carModel);
    // 选择性查询汽车
    List<CarModel> query(String type);
    // 删除汽车
    boolean delete(String id,String carName);
    // 修改汽车
    boolean change(String id,CarModel car);
    // 按汽车名查询
    List<CarModel> queryCarName(String carName);
    // 修改汽车路径图片
    boolean urlCar(String id,String carUrl);

    List<CarModel> queryId(String id);

    List<CarModel> queryBrand(String brand);

    List<CarModel> queryPrice(String min,String max);
}

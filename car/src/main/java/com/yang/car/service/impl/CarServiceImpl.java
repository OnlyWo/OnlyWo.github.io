package com.yang.car.service.impl;


import com.yang.car.dao.CarDao;
import com.yang.car.model.CarModel;
import com.yang.car.model.Page;
import com.yang.car.service.ICarService;

import java.util.List;

public class CarServiceImpl implements ICarService {
    // 查询全部汽车
    @Override
    public List<CarModel> queryAll() {
        CarDao carDao = new CarDao();
        return carDao.queryAll();
    }
    // 添加汽车信息
    @Override
    public boolean addCar(CarModel carModel) {
        CarDao carDao = new CarDao();
        return carDao.addCar(carModel);
    }
    // 选择性查询
    @Override
    public List<CarModel> query(String type) {
        CarDao carDao = new CarDao();
        return carDao.query(type);
    }

    @Override
    public boolean delete(String id, String carName) {
        CarDao carDao = new CarDao();
        return carDao.delete(id,carName);
    }

    @Override
    public boolean change(String id, CarModel car) {
        CarDao carDao = new CarDao();
        return carDao.change(id,car);
    }

    @Override
    public List<CarModel> queryCarName(String carName) {
        CarDao carDao = new CarDao();
        return carDao.queryCarName(carName);
    }

    @Override
    public boolean urlCar(String id, String carUrl) {
        CarDao carDao = new CarDao();
        return carDao.urlCar(id,carUrl);
    }

    @Override
    public List<CarModel> queryId(String id) {
        CarDao carDao = new CarDao();
        return carDao.queryId(id);
    }

    @Override
    public List<CarModel> queryBrand(String brand) {
        CarDao carDao = new CarDao();
        return carDao.queryBrand(brand);
    }

    @Override
    public List<CarModel> queryPrice(String min, String max) {
        CarDao carDao = new CarDao();
        return carDao.queryPrice(min,max);
    }
}

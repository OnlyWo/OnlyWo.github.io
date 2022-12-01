package com.yang.car.model;

public class CarModel {
    private String id;
    private String car_name;
    private String remark;
    private String brand;
    private String type;
    private Double price;
    private String rentable;
    private String state;
    private String carUrl;

    public CarModel() {
    }

    public CarModel(String id,String car_name, String remark, String brand, String type, Double price, String rentable, String state, String carUrl) {
        this.id = id;
        this.car_name = car_name;
        this.remark = remark;
        this.brand = brand;
        this.type = type;
        this.price = price;
        this.rentable = rentable;
        this.state = state;
        this.carUrl = carUrl;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCar_name() {
        return car_name;
    }

    public void setCar_name(String car_name) {
        this.car_name = car_name;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getRentable() {
        return rentable;
    }

    public void setRentable(String rentable) {
        this.rentable = rentable;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCarUrl() {
        return carUrl;
    }

    public void setCarUrl(String carUrl) {
        this.carUrl = carUrl;
    }

    @Override
    public String toString() {
        return "CarModel{" +
                "id='" + id + '\'' +
                ", car_name='" + car_name + '\'' +
                ", remark='" + remark + '\'' +
                ", brand='" + brand + '\'' +
                ", type='" + type + '\'' +
                ", price=" + price +
                ", rentable='" + rentable + '\'' +
                ", state='" + state + '\'' +
                ", carUrl='" + carUrl + '\'' +
                '}';
    }
}

package com.buaa.model;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:22
 * To change this template use File | Settings | File Templates.
 */
public class Car {
    private String carId;
    public Car(String carId){
        this.carId = carId;
    }

    public String getCarId(){
        return this.carId;
    }
}

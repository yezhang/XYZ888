package com.buaa.model;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:22
 * To change this template use File | Settings | File Templates.
 */
public class Car {
    private String carId;//车牌号

    public ParkingTicket getTicket() {
        return ticket;
    }

    public void setTicket(ParkingTicket ticket) {
        this.ticket = ticket;
    }

    private ParkingTicket ticket;

    public Car() {
        this.carId = "";
    }

    public Car(String carId) {
        this.carId = carId;
    }

    public String getCarId() {
        return this.carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

}

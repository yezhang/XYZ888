package com.buaa.interfaces;

import com.buaa.exception.NoCarException;
import com.buaa.exception.NoSpaceParkingException;
import com.buaa.model.Car;
import com.buaa.model.ParkingTicket;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午2:35
 * To change this template use File | Settings | File Templates.
 */
public interface IPark {
    public ParkingTicket parkCar(Car car) throws NoSpaceParkingException;
    public int getAvailableNumber();
    public int getCapacity();
    public Car getCarByTicket(ParkingTicket ticket) throws NoCarException;
    public void report(String indent);
}

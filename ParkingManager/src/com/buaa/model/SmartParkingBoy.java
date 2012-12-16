package com.buaa.model;

import com.buaa.exception.NoSpaceParkingException;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 */
public class SmartParkingBoy extends ParkingBoy {

    public Parklot getParkWithMaxSpace(){
        Parklot parkWithMaxAvailableNumber = (Parklot) Collections.max(this.parksManaged, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Parklot left = (Parklot) o1;
                Parklot right = (Parklot) o2;
                return left.getAvailableNumber() - right.getAvailableNumber();
            }
        });
        return parkWithMaxAvailableNumber;
    }
     @Override
    public ParkingTicket parkCar(Car car) throws NoSpaceParkingException {

        Parklot parkWithMaxAvailableNumber = getParkWithMaxSpace();

        ParkingTicket ticket = null;
        try {
            ticket = parkWithMaxAvailableNumber.parkCar(car);
        } catch (NoSpaceParkingException ex) {
            throw ex;
        }finally{
             return ticket;
        }
    }
}

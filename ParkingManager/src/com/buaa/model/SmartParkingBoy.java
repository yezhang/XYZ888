package com.buaa.model;

import com.buaa.exception.NoSpaceParkingException;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午4:23
 * To change this template use File | Settings | File Templates.
 */
public class SmartParkingBoy extends ParkingBoy {

    public Park getParkWithMaxSpace(){
        Park parkWithMaxAvailableNumber = (Park) Collections.max(this.parksManaged, new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Park left = (Park) o1;
                Park right = (Park) o2;
                return left.getAvailableNumber() - right.getAvailableNumber();
            }
        });
        return parkWithMaxAvailableNumber;
    }



    @Override
    public ParkingTicket parkCar(Car car) throws NoSpaceParkingException {
        Park parkWithMaxAvailableNumber = getParkWithMaxSpace();

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

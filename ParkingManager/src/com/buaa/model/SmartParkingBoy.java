package com.buaa.model;

import com.buaa.exception.NoSpaceParkingException;
import com.buaa.interfaces.IParkingStrategy;
import com.buaa.model.strategy.SmartParkStrategy;

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
    public SmartParkingBoy() {
        this.parkingStrategy = new SmartParkStrategy();
    }

    public ParkingSpace getParkWithMaxSpace() {
        ParkingSpace parkWithMaxAvailableNumber = this.parkingStrategy.choose(this.parksManaged);
        return parkWithMaxAvailableNumber;
    }

    @Override
    public ParkingTicket parkCar(Car car) throws NoSpaceParkingException {
        ParkingSpace parkWithMaxAvailableNumber = this.parkingStrategy.choose(this.parksManaged);

        ParkingTicket ticket = null;
        try {
            ticket = parkWithMaxAvailableNumber.parkCar(car);
        } catch (NoSpaceParkingException ex) {
            throw ex;
        } finally {
            return ticket;
        }
    }
}

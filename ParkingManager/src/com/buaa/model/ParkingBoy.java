package com.buaa.model;

import com.buaa.exception.NoCarException;
import com.buaa.exception.NoSpaceParkingException;
import com.buaa.interfaces.IPark;
import com.buaa.interfaces.IParkingStrategy;
import com.buaa.model.strategy.CommonParkStrategy;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-25
 * Time: 下午2:21
 * To change this template use File | Settings | File Templates.
 */
public class ParkingBoy implements IPark {
    protected List parksManaged;
    protected IParkingStrategy parkingStrategy;


    public ParkingBoy() {
        this.parksManaged = new ArrayList();
        parkingStrategy = new CommonParkStrategy();
    }

    public void addParkToManage(ParkingSpace p) {
        if (parksManaged == null) {
            parksManaged = new ArrayList(0);
        }
        parksManaged.add(p);
    }

    public void removeParkManaged(ParkingSpace p) {
        if (parksManaged == null) {
            return;
        }
        parksManaged.remove(p);
    }


    @Override
    public ParkingTicket parkCar(Car car) throws NoSpaceParkingException {
        boolean parked = false;
        ParkingTicket ticket = null;
        ParkingSpace parkingSpace = this.parkingStrategy.choose(this.parksManaged);
        if (parkingSpace != null) {
            ticket = parkingSpace.parkCar(car);
            parked = true;
        }

        if (parked == false) {
            throw new NoSpaceParkingException();
        }
        return ticket;
    }

    @Override
    public int getAvailableNumber() {
        int availableNumber = 0;
        Iterator it = this.parksManaged.iterator();
        ParkingSpace p = null;
        while (it.hasNext()) {
            p = (ParkingSpace) it.next();
            availableNumber += p.getAvailableNumber();
        }
        return availableNumber;
    }

    @Override
    public Car getCarByTicket(ParkingTicket ticket) throws NoCarException {
        Iterator it = this.parksManaged.iterator();
        ParkingSpace p = null;
        Car car = null;
        boolean carIsGetted = false;
        while (it.hasNext()) {
            p = (ParkingSpace) it.next();
            if (p.hasCar(ticket)) {
                car = p.getCarByTicket(ticket);
                carIsGetted = true;
                break;
            }
        }

        if (carIsGetted == false) {
            throw new NoCarException();
        }

        return car;
    }

    @Override
    public void report() {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}

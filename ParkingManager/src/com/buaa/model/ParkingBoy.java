package com.buaa.model;

import com.buaa.exception.NoCarException;
import com.buaa.exception.NoSpaceParkingException;
import com.buaa.interfaces.IPark;

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

    public ParkingBoy() {
        this.parksManaged = new ArrayList();
    }

    public void addParkToManage(Park p) {
        if (parksManaged == null) {
            parksManaged = new ArrayList(0);
        }
        parksManaged.add(p);
    }

    public void removeParkManaged(Park p) {
        if (parksManaged == null) {
            return;
        }
        parksManaged.remove(p);
    }


    @Override
    public ParkingTicket parkCar(Car car) throws NoSpaceParkingException {
        Iterator it = this.parksManaged.iterator();
        Park p = null;
        boolean parked = false;
        ParkingTicket ticket = null;
        while (it.hasNext()) {
            p = (Park) it.next();
            if (p.getAvailableNumber() > 0) {
                ticket = p.parkCar(car);
                parked = true;
                break;
            }
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
        Park p = null;
        while (it.hasNext()) {
            p = (Park) it.next();
            availableNumber += p.getAvailableNumber();
        }
        return availableNumber;
    }

    @Override
    public Car getCarByTicket(ParkingTicket ticket) throws NoCarException {
        Iterator it = this.parksManaged.iterator();
        Park p = null;
        Car car = null;
        boolean carIsGetted = false;
        while (it.hasNext()) {
            p = (Park) it.next();
            if(p.hasCar(ticket)){
                car =  p.getCarByTicket(ticket);
                carIsGetted = true;
                break;
            }
        }

        if(carIsGetted == false){
            throw new NoCarException();
        }

        return car;
    }
}

package com.buaa.model;

import com.buaa.exception.NoCarException;
import com.buaa.exception.NoSpaceParkingException;
import com.buaa.interfaces.IPark;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
public class Park implements IPark {
    /*
    * 停车厂总停车位
    * */
    private int capacity = 0;
    private Map<ParkingTicket, Car> parkingCarMap = new HashMap<ParkingTicket, Car>();

    public Park(int capacity) {
        this.capacity = capacity;
    }

    public ParkingTicket parkCar(Car car) throws NoSpaceParkingException {
        if (getAvailableNumber() <= 0) {
            throw new NoSpaceParkingException();
        }
        ParkingTicket ticket = new ParkingTicket();
        car.setTicket(ticket);

        this.parkingCarMap.put(ticket, car);
        return ticket;
    }

    public int getAvailableNumber() {
        return this.capacity - parkingCarMap.size();
    }

    public Car getCarByTicket(ParkingTicket ticket) throws NoCarException {
        if (hasCar(ticket)) {
            Car car = parkingCarMap.get(ticket);
            parkingCarMap.remove(ticket);
            return car;
        } else {
            throw new NoCarException();
        }
    }

    public boolean hasCar(ParkingTicket ticket){
        if(this.parkingCarMap.containsKey(ticket)){
            return true;
        }
        return false;
    }
<<<<<<< HEAD

    public double getVacancyRate() {
        double vacancyRate = 1.0*this.getAvailableNumber()/this.capacity;
        return vacancyRate;
    }
=======
>>>>>>> decce5794ab1d38c9d17aa95f37dc62432e8cc5e
}

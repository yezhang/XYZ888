package com.buaa.model;

import com.buaa.exception.NoCarException;
import com.buaa.exception.NoSpaceParkingException;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:09
 * To change this template use File | Settings | File Templates.
 */
public class Parking {
    private int parkingSpaceNumber;
    private Map<Integer,Car> parkingCarMap = new HashMap<Integer,Car>();
    
    public Parking(){

    }

    public int parkCar(Car car) throws NoSpaceParkingException {
        if(this.parkingSpaceNumber <= 0){
            throw new NoSpaceParkingException();
        }
        this.parkingCarMap.put(car.hashCode(),car);
        this.parkingSpaceNumber--;

        int cardId = car.hashCode();

        return cardId;
    }

    public void setParkingSpaceNumber(int parkingSpaceNumber) {

       this.parkingSpaceNumber = parkingSpaceNumber;
    }

    public int getParkingSpaceNumber() {
        return parkingSpaceNumber;
    }

    public Car getCarByCardID(int cardId) throws NoCarException {
        if(this.parkingCarMap.containsKey(cardId)){
            this.parkingSpaceNumber ++;
            Car car = parkingCarMap.get(cardId);
            parkingCarMap.remove(cardId);
            return car;
        }else{
            throw new NoCarException();
        }
    }
}

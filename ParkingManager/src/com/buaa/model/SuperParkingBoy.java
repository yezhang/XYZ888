package com.buaa.model;

import com.buaa.exception.NoSpaceParkingException;

import java.util.Collections;
import java.util.Comparator;

/**
 * Created with IntelliJ IDEA.
 * User: betterSoft
 * Date: 12-12-16
 * Time: 下午1:02
 * To change this template use File | Settings | File Templates.
 */
public class SuperParkingBoy extends ParkingBoy {

    @Override
    public ParkingTicket parkCar(Car car) throws NoSpaceParkingException {
        Parklot park = getParkWithMaxVacancyRate();
        return park.parkCar(car);
    }

    public Parklot getParkWithMaxVacancyRate() {
        Parklot park = (Parklot) Collections.max(this.parksManaged, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Parklot left = (Parklot) o1;
                Parklot right = (Parklot) o2;
                int result =  (int)(left.getVacancyRate()*100 - right.getVacancyRate()*100);
                return result;
            }
        });

        return park;
    }


}

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
        return super.parkCar(car);    //To change body of overridden methods use File | Settings | File Templates.
    }

    public Park getParkWithMaxVacancyRate() {
        Park park = (Park) Collections.max(this.parksManaged, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                Park left = (Park) o1;
                Park right = (Park) o2;
                int result =  (int)(left.getVacancyRate()*100 - right.getVacancyRate()*100);
                return result;
            }
        });

        return park;
    }


}

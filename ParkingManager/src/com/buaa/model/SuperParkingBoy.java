package com.buaa.model;

import com.buaa.exception.NoSpaceParkingException;
import com.buaa.interfaces.IParkingStrategy;
import com.buaa.model.strategy.SuperParkStrategy;

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
    private IParkingStrategy parkingStrategy;

    public SuperParkingBoy() {
        this.parkingStrategy = new SuperParkStrategy();
    }

    @Override
    public ParkingTicket parkCar(Car car) throws NoSpaceParkingException {
        ParkingSpace park = this.parkingStrategy.choose(this.parksManaged);
        return park.parkCar(car);
    }

    public ParkingSpace getParkWithMaxVacancyRate() {
        ParkingSpace park = this.parkingStrategy.choose(this.parksManaged);

        return park;
    }


}

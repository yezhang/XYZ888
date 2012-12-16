package com.buaa.model.strategy;

import com.buaa.interfaces.IParkingStrategy;
import com.buaa.model.ParkingSpace;
import com.buaa.model.Parklot;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-16
 * Time: 下午3:38
 * To change this template use File | Settings | File Templates.
 */
public class SuperParkStrategy implements IParkingStrategy {
    @Override
    public ParkingSpace choose(List<ParkingSpace> parkingSpaceList) {
        ParkingSpace park = (ParkingSpace) Collections.max(parkingSpaceList, new Comparator() {

            @Override
            public int compare(Object o1, Object o2) {
                ParkingSpace left = (ParkingSpace) o1;
                ParkingSpace right = (ParkingSpace) o2;
                int result = (int) (left.getVacancyRate() * 100 - right.getVacancyRate() * 100);
                return result;
            }
        });

        return park;
    }
}

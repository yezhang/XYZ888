package com.buaa.interfaces;

import com.buaa.model.ParkingSpace;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-16
 * Time: 下午3:32
 * To change this template use File | Settings | File Templates.
 */
public interface IParkingStrategy {
    public ParkingSpace choose(List<ParkingSpace> parkingSpaceList);
}

package com.buaa.model.strategy;

import com.buaa.interfaces.IParkingStrategy;
import com.buaa.model.ParkingSpace;
import com.buaa.model.Parklot;

import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-16
 * Time: 下午3:38
 * To change this template use File | Settings | File Templates.
 */
public class CommonParkStrategy implements IParkingStrategy{
    @Override
    public ParkingSpace choose(List<ParkingSpace> parkingSpaceList) {
        Iterator it = parkingSpaceList.iterator();
        ParkingSpace p = null;
        while (it.hasNext()) {
            p = (ParkingSpace) it.next();
            if (p.getAvailableNumber() > 0) {
                break;
            }
        }

        return p;
    }
}

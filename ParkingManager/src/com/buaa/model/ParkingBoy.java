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
    private List<ParkingBoy> parkingBoys;


    public ParkingBoy() {
        this.parksManaged = new ArrayList();
        this.parkingBoys = new ArrayList<ParkingBoy>();
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
        if (this.getAvailableNumber() > 0) {
            ParkingSpace parkingSpace = this.parkingStrategy.choose(this.parksManaged);
            if (parkingSpace != null) {
                ticket = parkingSpace.parkCar(car);
                parked = true;
            }
        }
        ParkingBoy parkingBoy = null;
        for (int i = 0; parked == false && i < this.parkingBoys.size(); i++) {
            parkingBoy = this.parkingBoys.get(i);
            if (parkingBoy.getAvailableNumber() > 0) {
                parkingBoy.parkCar(car);
                parked = true;
            } else {
                continue;
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
        ParkingSpace p = null;
        while (it.hasNext()) {
            p = (ParkingSpace) it.next();
            availableNumber += p.getAvailableNumber();
        }
        return availableNumber;
    }

    @Override
    public int getCapacity() {
        int capacity = 0;
        Iterator it = this.parksManaged.iterator();
        ParkingSpace p = null;
        while (it.hasNext()) {
            p = (ParkingSpace) it.next();
            capacity += p.getCapacity();
        }
        return capacity;
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

    public void addParkingBoyToManage(ParkingBoy parkingBoy) {
        if (this.parkingBoys == null) {
            this.parkingBoys = new ArrayList<ParkingBoy>();
        }
        this.parkingBoys.add(parkingBoy);
    }

    public void removeManagedParkingBoy(ParkingBoy parkingBoy) {
        if (this.parkingBoys == null || this.parkingBoys.size() < 1) {
            return;
        }
        if (this.parkingBoys.contains(parkingBoy)) {
            this.parkingBoys.remove(parkingBoy);
        }
    }

    @Override
    public void report(String indent) {
        int totalCapacity = 0;
        int totalAvailableNumber = 0;
        ParkingSpace parkingSpace = null;
        for (int i = 0; i < this.parksManaged.size(); i++) {
            if (this.parksManaged.get(i) instanceof ParkingSpace) {
                parkingSpace = (ParkingSpace) this.parksManaged.get(i);
                totalAvailableNumber += parkingSpace.getAvailableNumber();
                totalCapacity += parkingSpace.getCapacity();
                System.out.println(indent + "停车场编号：" + parkingSpace.hashCode());
                parkingSpace.report(indent + "   ");
            }
        }
        ParkingBoy parkingBoy = null;
        if (this.parkingBoys != null) {
            for (int i = 0; i < this.parkingBoys.size(); i++) {
                if (this.parkingBoys.get(i) instanceof ParkingBoy) {
                    parkingBoy = this.parkingBoys.get(i);
                    totalAvailableNumber += parkingBoy.getAvailableNumber();
                    totalCapacity += parkingBoy.getCapacity();
                    System.out.println("停车仔编号：" + parkingBoy.hashCode());
                    parkingBoy.report("    ");
                }

            }
        }
        System.out.println(indent + "Total车位数：" + totalCapacity);
        System.out.println(indent + "Total空位数：" + totalAvailableNumber);
    }

}

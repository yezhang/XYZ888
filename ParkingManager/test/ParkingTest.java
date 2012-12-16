import com.buaa.model.*;
import com.buaa.exception.*;

import junit.framework.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-11-11
 * Time: 下午3:06
 * To change this template use File | Settings | File Templates.
 */
public class ParkingTest {

    private ParkingBoy parkingBoy;
    private Car car;

    SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
    Park park1 = new Park(1);
    Park park2 = new Park(2);
    Park park3 = new Park(2);
    Park parkMax = new Park(3);

    @Before
    public void init_parking() {
        this.parkingBoy = new ParkingBoy();
        Park p = new Park(100);
        this.parkingBoy.addParkToManage(p);
        this.car = new Car("10000");

        smartParkingBoy.addParkToManage(park1);
        smartParkingBoy.addParkToManage(park2);
        smartParkingBoy.addParkToManage(park3);
        smartParkingBoy.addParkToManage(parkMax);

    }

    @Test
    public void should_return_a_ticket() throws NoSpaceParkingException {
        ParkingTicket ticket = parkingBoy.parkCar(car);
        Assert.assertNotNull(ticket);
    }

    @Test
    public void should_get_a_car_and_carNumber_minus_1() throws NoSpaceParkingException, NoCarException {
        Car A = new Car("10000");
        ParkingTicket ticket = parkingBoy.parkCar(A);
        Car B = parkingBoy.getCarByTicket(ticket);

        Assert.assertEquals(A, B);
        Assert.assertEquals(100, parkingBoy.getAvailableNumber());
    }

    @Test(expected = NoSpaceParkingException.class)
    public void should_return_fail_add_car_to_no_space_parking() throws NoSpaceParkingException {
        parkingBoy = new ParkingBoy();
        Park park = new Park(0);
        parkingBoy.addParkToManage(park);

        parkingBoy.parkCar(car);

    }

    @Test(expected = NoCarException.class)
    public void should_throw_No_Car_Exception_when_get_a_car_from_empty_park() throws NoCarException {
        ParkingTicket ticket = new ParkingTicket();
        parkingBoy.getCarByTicket(ticket);
    }

    @Test
    public void should_get_original_car_by_correct_carId() throws NoSpaceParkingException, NoCarException {
        Car c = new Car("");

        ParkingTicket ticket = parkingBoy.parkCar(c);

        Car myCar = parkingBoy.getCarByTicket(ticket);
        //Assert.assertEquals(c, myCar);
        Assert.assertSame(c, myCar);
    }

    @Test(expected = NoCarException.class)
    public void should_get_exception_by_wrong_carId() throws NoSpaceParkingException, NoCarException {
        Car c = new Car("");
        ParkingTicket ticket = parkingBoy.parkCar(c);

        Car myCar = parkingBoy.getCarByTicket(new ParkingTicket());
    }

    @Test(expected = NoCarException.class)
    public void should_get_exception_in_second_time_to_get_a_car() throws NoSpaceParkingException, NoCarException {
        Car c = new Car("");
        ParkingTicket ticket = parkingBoy.parkCar(c);

        Car myCar = null;
        try {
            myCar = parkingBoy.getCarByTicket(ticket);
        } catch (Exception e) {
            Assert.fail();
        }

        myCar = parkingBoy.getCarByTicket(ticket);
    }

    @Test
    public void should_get_a_lot_with_max_space() {


        Assert.assertSame(parkMax, smartParkingBoy.getParkWithMaxSpace());
    }

    @Test
    public void should_park_a_car_in_a_lot_with_max_space() {
        Car c = new Car("");
        Park park = smartParkingBoy.getParkWithMaxSpace();

        ParkingTicket ticket = smartParkingBoy.parkCar(c);
//        park.hasCar(ticket);

        Assert.assertEquals(true, park.hasCar(ticket));
    }
<<<<<<< HEAD


=======
>>>>>>> decce5794ab1d38c9d17aa95f37dc62432e8cc5e
}

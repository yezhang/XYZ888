import com.buaa.model.*;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: software
 * Date: 12-12-16
 * Time: 下午2:57
 * To change this template use File | Settings | File Templates.
 */
public class ParkingManagerTest {
    private ParkingManager parkingManager;
    private ParkingSpace park;

    @Before
    public void setUp() {
        this.park = new ParkingSpace(1);
        this.parkingManager = new ParkingManager();
    }

    @After
    public void tearDown() {

    }

    @Test
    public void should_park_a_car_in_a_lot_owned_by_manager() {
        this.parkingManager.addParkToManage(this.park);
        int oldAvailableNumber = this.parkingManager.getAvailableNumber();
        this.parkingManager.parkCar(new Car());
        Assert.assertEquals(oldAvailableNumber, this.parkingManager.getAvailableNumber() + 1);
    }

    @Test
    public void should_report_parkingBoy_parkingSpaceInfo() {
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingSpace parkingSpace = new ParkingSpace(1);
        Car car = new Car();
        parkingBoy.addParkToManage(parkingSpace);
        parkingBoy.parkCar(car);

        parkingBoy.report("");
    }

    @Test
    public void should_report_parkingManager_parkingSpaceInfo() {
        ParkingManager parkingManager = new ParkingManager();
        ParkingSpace parkingSpace1 = new ParkingSpace(1);
        parkingManager.addParkToManage(parkingSpace1);

        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingSpace parkingSpace2 = new ParkingSpace(1);
        Car car = new Car();
        parkingBoy.addParkToManage(parkingSpace2);

        parkingManager.addParkingBoyToManage(parkingBoy);

        parkingBoy.parkCar(car);

        parkingManager.report("");
    }

    @Test
    public void should_command_smartParkingBoy_to_park_a_car() {
        ParkingManager parkingManager = new ParkingManager();
        SmartParkingBoy smartParkingBoy = new SmartParkingBoy();
        ParkingSpace parkingSpace = new ParkingSpace(1);
        smartParkingBoy.addParkToManage(parkingSpace);
        parkingManager.addParkingBoyToManage(smartParkingBoy);

        parkingManager.letParkingBoyToParkCar(smartParkingBoy, new Car());

        Assert.assertEquals(0, smartParkingBoy.getAvailableNumber());
    }

    @Test
    public void should_command_superParkingBoy_to_park_a_car() {
        ParkingManager parkingManager = new ParkingManager();
        SuperParkingBoy superParkingBoy = new SuperParkingBoy();
        ParkingSpace parkingSpace = new ParkingSpace(1);
        superParkingBoy.addParkToManage(parkingSpace);
        parkingManager.addParkingBoyToManage(superParkingBoy);

        parkingManager.letParkingBoyToParkCar(superParkingBoy, new Car());

        Assert.assertEquals(0, superParkingBoy.getAvailableNumber());
    }

    @Test
    public void should_command_parkingBoy_to_park_a_car() {
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingSpace parkingSpace = new ParkingSpace(1);
        parkingBoy.addParkToManage(parkingSpace);
        parkingManager.addParkingBoyToManage(parkingBoy);

        parkingManager.letParkingBoyToParkCar(parkingBoy, new Car());

        Assert.assertEquals(0, parkingBoy.getAvailableNumber());
    }

    @Test
    public void should_command_parkingBoy_to_get_a_car() {
        ParkingManager parkingManager = new ParkingManager();
        ParkingBoy parkingBoy = new ParkingBoy();
        ParkingSpace parkingSpace = new ParkingSpace(1);
        parkingBoy.addParkToManage(parkingSpace);
        parkingManager.addParkingBoyToManage(parkingBoy);

        ParkingTicket ticket = parkingManager.letParkingBoyToParkCar(parkingBoy, new Car());
        parkingBoy.getCarByTicket(ticket);
        Assert.assertEquals(1, parkingBoy.getAvailableNumber());
    }
}

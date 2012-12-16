import com.buaa.model.Car;
import com.buaa.model.ParkingSpace;
import com.buaa.model.ParkingManager;
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
    public void should_park_a_car_in_a_lot_owned_by_manager(){
        this.parkingManager.addParkToManage(this.park);
        int oldAvailableNumber = this.parkingManager.getAvailableNumber();
        this.parkingManager.parkCar(new Car());
        Assert.assertEquals(oldAvailableNumber,this.parkingManager.getAvailableNumber()+1);
    }
}

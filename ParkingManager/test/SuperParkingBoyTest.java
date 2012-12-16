import com.buaa.model.Car;
import com.buaa.model.Parklot;
import com.buaa.model.SuperParkingBoy;
import junit.framework.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: betterSoft
 * Date: 12-12-16
 * Time: 下午1:16
 * To change this template use File | Settings | File Templates.
 */
public class SuperParkingBoyTest {
    private SuperParkingBoy superParkingBoy;
    private Parklot parkWith50PercentVacancyRate;
    private Parklot parkWith100PercentVacancyRate;

    @Before
    public void setUp() {
        this.superParkingBoy = new SuperParkingBoy();
        this.parkWith50PercentVacancyRate = new Parklot(2);
        this.parkWith100PercentVacancyRate = new Parklot(2);
        this.parkWith50PercentVacancyRate.parkCar(new Car());

        this.superParkingBoy.addParkToManage(this.parkWith50PercentVacancyRate);
        this.superParkingBoy.addParkToManage(this.parkWith100PercentVacancyRate);
    }

    @After
    public void tearDown() {

    }

    @Test
    public void should_have_100_percent_vacancy_rate(){
        Assert.assertEquals(1.0, this.parkWith100PercentVacancyRate.getVacancyRate());
    } @Test
    public void should_have_50_percent_vacancy_rate(){
        Assert.assertEquals(0.5, this.parkWith50PercentVacancyRate.getVacancyRate());
    }
    @Test
    public void should_get_a_lot_with_max_vacancy_rate() {
       Assert.assertEquals(this.parkWith100PercentVacancyRate, this.superParkingBoy.getParkWithMaxVacancyRate());
    }

    @Test
    public void should_park_a_car_in_a_lot_with_max_vacancy_rate() {
       Parklot parkWithMaxVacancyRate = this.superParkingBoy.getParkWithMaxVacancyRate();
        int availableNumber = parkWithMaxVacancyRate.getAvailableNumber();
        //parkWithMaxVacancyRate.parkCar(new Car());
        this.superParkingBoy.parkCar(new Car());
        Assert.assertEquals(availableNumber,parkWithMaxVacancyRate.getAvailableNumber()+1);
    }
}

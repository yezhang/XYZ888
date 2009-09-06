import com.buaa.model.Car;
import com.buaa.exception.*;

import com.buaa.model.Parking;
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

    private Parking park;
    private Car car;

    @Before
    public void init_parking(){
        this.park = new Parking();
        park.setParkingSpaceNumber(100);
        this.car = new Car("10000");
    }

    @Test
    public void should_return_101_after_add_a_car() throws NoSpaceParkingException {
        park.parkCar(car);

        Assert.assertEquals(99,park.getParkingSpaceNumber());
    }

    @Test
    public void should_get_A_car_and_carNumber_minus_1() throws NoSpaceParkingException, NoCarException {
        Car A = new Car("10000");

        int cardId = park.parkCar(A);

        Car B = park.getCarByCardID(cardId);
        Assert.assertEquals(A,B);
        Assert.assertEquals(100,park.getParkingSpaceNumber());
    }

    @Test(expected = NoSpaceParkingException.class)
    public void should_return_fail_add_car_to_no_space_parking() throws NoSpaceParkingException{
        park.setParkingSpaceNumber(0);

        park.parkCar(car);

    }

    @Test(expected = NoCarException.class)
    public void should_throw_No_Car_Exception_when_get_a_car_from_empty_park() throws NoCarException{
        park.getCarByCardID(123);
    }

    @Test
    public void should_get_original_car_by_correct_card_id() throws NoSpaceParkingException, NoCarException {
        Car c = new Car("");
        int cardId;
        cardId = park.parkCar(c);

        Car myCar = park.getCarByCardID(cardId);
        Assert.assertEquals(c,myCar);
    }

    @Test(expected = NoCarException.class)
    public void should_get_exception_by_wrong_cardId() throws NoSpaceParkingException, NoCarException {
        Car c = new Car("");
        int cardId;
        cardId = park.parkCar(c);

        Car myCar = park.getCarByCardID(cardId+1);

    }

    @Test(expected = NoCarException.class)
    public void should_get_exception_in_second_time_to_get_a_car() throws NoSpaceParkingException, NoCarException {
        Car c = new Car("");
        int cardId;
        cardId = park.parkCar(c);
        Car myCar = null;
        try{
            myCar = park.getCarByCardID(cardId);
        }catch (Exception e){
            Assert.fail();
        }

        myCar = park.getCarByCardID(cardId);
    }
}

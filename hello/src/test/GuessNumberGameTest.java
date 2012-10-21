import junit.framework.Assert;
import static junit.framework.Assert.assertEquals;

import org.junit.Test;

/**
 * Created with IntelliJ IDEA.
 * User: STU
 * Date: 12-10-21
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */
public class GuessNumberGameTest {

    @Test
    public void should_return_4a0b_if_input_match_exactly(){
        String serverNumber = "9305";
        GuessNumberGame guessNumber = new GuessNumberGame(serverNumber);
        String userInput = "9305";

        String result = guessNumber.validate(userInput);
        Assert.assertEquals("4a0b",result);
    }

    @Test
    public void should_return_0a1b_if_input_include_one_correct_number_with_wrong_place(){
        String serverNumber = "1234";
        GuessNumberGame guessNumber = new GuessNumberGame(serverNumber);
        String userInput = "1234";
        String result = guessNumber.validate(userInput);
        assertEquals("0a1b",result);
    }

}

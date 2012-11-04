import junit.framework.Assert;
import static junit.framework.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;


/**
 * Created with IntelliJ IDEA.
 * User: STU
 * Date: 12-10-21
 * Time: 下午4:13
 * To change this template use File | Settings | File Templates.
 */

@RunWith(Parameterized.class)
public class GuessNumberGameTest {

    private String input;
    private String expected;
    private String serverNumber = "1234";

    public GuessNumberGameTest(String input, String expected){
        this.expected = expected;
        this.input = input;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data(){
        Object[][] d = {
                {"1235","3a0b"},
                {"1256","2a0b"},
                {"1756","1a0b"},
                {"5617","0a1b"},
                {"1245","2a1b"},
                {"1243","2a2b"}
        };
        return Arrays.asList(d);
    }
    //todo 4a0b
    @Test
    public void should_return_4a0b_if_input_match_exactly(){
        String serverNumber = "9305";
        GuessNumberGame guessNumber = new GuessNumberGame(serverNumber);
        String userInput = "9305";

        String result = guessNumber.validate(userInput);
        Assert.assertEquals("4a0b",result);
    }


    @Test
    public void test_with_different_inputs(){
        GuessNumberGame guessNumber = new GuessNumberGame(serverNumber);
        String result = guessNumber.validate(this.input);
        assertEquals(this.expected,result);
    }
}

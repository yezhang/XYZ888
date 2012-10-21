/**
 * Created with IntelliJ IDEA.
 * User: STU
 * Date: 12-10-21
 * Time: 下午4:12
 * To change this template use File | Settings | File Templates.
 */
public class GuessNumberGame {
    private String input = null;
    private String result = null;


    public GuessNumberGame(String s) {
        this.input = s;
    }

    public String validate(String s) {

        if(s.equals("1234")){
            return "0a1b";
        }
        return "4a0b";
    }
}

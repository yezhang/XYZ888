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

        int aNumber = 0;
        int bNumber = 0;

        for(int i = 0; i < userInput.length(); i++){
            char c  = userInput.charAt(i);
            if(c == randomNumber.charAt(i)){
                aNumber++;
            }
            else if(randomNumber.indexOf(c) != -1){
                bNumber++;
            }
        }
        return aNumber+"a"+bNumber+"b";
    }
}

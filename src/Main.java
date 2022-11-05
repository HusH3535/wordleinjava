import java.awt.*;

public class Main {


    private Color miss = new Color(100,100,100);
    private  Color present = new Color(180,180,40);
    private  Color correct = new Color(98,166,100);

    public static void main(String[] args) {

        new gameState();

        }

    public static void displayGuess(String user,int attempt){
//        char[] guess = {user.charAt(0),user.charAt(1),user.charAt(2),user.charAt(3),user.charAt(4)};
//
//        for (int i = 0; i < 5; i++) {
//            guesses[attempt][i].setText(String.valueOf(guess[i]));
//
//            if(map.containsKey(guess[i])){
//                guesses[attempt][i].setBackground(present);
//                if(map.get(guess[i])==i){
//                    guesses[attempt][i].setBackground(correct);
//                }
//            }
//            else {
//                guesses[attempt][i].setBackground(miss);
//            }
//        }
    }
}
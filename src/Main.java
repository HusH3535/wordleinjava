import javax.swing.*;
import java.util.HashMap;
//import java.util.Random;
import java.util.Scanner;
import java.awt.*;
import javax.swing.border.Border;

public class Main {
    public static String word = "PEACH";
    public static char[] arr = {word.charAt(0),word.charAt(1),word.charAt(2),word.charAt(3),word.charAt(4)};
    public static Scanner kb = new Scanner(System.in);
    //public static Random ran = new Random();
    public static JFrame window = new JFrame();
    public static JLabel label = new JLabel("WORDLE");
    public static JPanel[] guessesP = new JPanel[6];
    public static JLabel[][] guesses = new JLabel[6][5];
    public static Border border = BorderFactory.createLineBorder(new Color(100,100,100),2);
    public static Color miss = new Color(100,100,100);
    public static Color present = new Color(180,180,40);
    public static Color correct = new Color(98,166,100);
    public static HashMap<Character,Integer> map = new HashMap<>();

    public static void main(String[] args) {

        for(int i = 0; i < 5; i++)
        {
            map.put(arr[i],i);
        }

        window.setSize(1000,1000);


        window.setTitle("Wordle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        window.getContentPane().setBackground(new Color(23,23,23));
        window.setLayout(null);


        final int PER = window.getHeight()/100;
        final int GUESSTHICKNESS = 9;

        for(int i = 0; i <6; i++){
            guessesP[i] = new JPanel();
            guessesP[i].setBounds(25*PER,(13+(i*(GUESSTHICKNESS+1)))*PER,54*PER,GUESSTHICKNESS*PER);
            guessesP[i].setBackground(new Color(23, 23, 23));
            guessesP[i].setLayout(null);

            for(int j = 0; j <5; j++)
            {
                guesses[i][j] = new JLabel("");
                guesses[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
                guesses[i][j].setBackground(new Color(23, 23, 23));
                guesses[i][j].setForeground(new Color(0xFFFFFF));
                guesses[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                guesses[i][j].setVerticalAlignment(SwingConstants.CENTER);
                guesses[i][j].setOpaque(true);
                guesses[i][j].setBounds(((j*10)+1)*PER,0,9*PER,(GUESSTHICKNESS)*PER);
                guesses[i][j].setBorder(border);
                guesses[i][j].setFont(new Font("roboto mono",Font.BOLD,34));
                guessesP[i].add(guesses[i][j]);


            }
        }



        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setForeground(new Color(199, 199, 199));
        label.setFont(new Font("roboto mono",Font.BOLD,34));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.NORTH);
        label.setBounds(0,60,window.getWidth(),window.getHeight());



        window.add(label);
        for(int i = 0; i <6; i++)
        {
            window.add(guessesP[i]);
        }

        int i = 0;
        while(i<6)
        {
            String user = kb.next();
            user = user.toUpperCase();
            if(user.length()!=5)
            {
                System.out.println("The word needs to be 5 letters");
                continue;
            }

            displayGuess(user,i);
            i++;
        }


    }


    public static void displayGuess(String user,int attempt){
        char[] guess = {user.charAt(0),user.charAt(1),user.charAt(2),user.charAt(3),user.charAt(4)};

        for (int i = 0; i < 5; i++) {
            guesses[attempt][i].setText(String.valueOf(guess[i]));

            if(map.containsKey(guess[i])){
                guesses[attempt][i].setBackground(present);
                if(map.get(guess[i])==i){
                    guesses[attempt][i].setBackground(correct);
                }
            }
            else {
                guesses[attempt][i].setBackground(miss);
            }
        }
    }


}
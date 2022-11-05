import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.HashMap;
import java.util.Scanner;

public class window {

    int windowSize = 1000;
    final int PER = windowSize/100;
    final int GUESSTHICKNESS = 9;

    //private static Random ran = new Random();
    private  JFrame window = new JFrame();
    private  JLabel label = new JLabel("WORDLE");
    private  JPanel[] guessesP = new JPanel[6];
    private  JLabel[][] guesses = new JLabel[6][5];
    private  Border border = BorderFactory.createLineBorder(new Color(100,100,100),2);

    public  HashMap<Character,Integer> map = new HashMap<>();

    public window()
    {

        setUpWindow();
        setUpBoard();
        setUpTitle();

    }

    public void setUpBoard()
    {

        for(int i = 0; i <6; i++){
            guessesP[i] = new JPanel();
            guessesP[i].setBounds(25*PER,(13+(i*(GUESSTHICKNESS+1)))*PER,54*PER,GUESSTHICKNESS*PER);
            guessesP[i].setBackground(new Color(23, 23, 23));
            guessesP[i].setLayout(null);

            for(int j = 0; j <5; j++)
            {
                guesses[i][j] = new JLabel("");
                setUpTile(i,j);
                guessesP[i].add(guesses[i][j]);


            }
        }

        for(int i = 0; i <6; i++)
        {
            window.add(guessesP[i]);
        }

    }

    private void setUpTile(int i, int j) {
        guesses[i][j].setHorizontalTextPosition(SwingConstants.CENTER);
        guesses[i][j].setBackground(new Color(23, 23, 23));
        guesses[i][j].setForeground(new Color(0xFFFFFF));
        guesses[i][j].setHorizontalAlignment(SwingConstants.CENTER);
        guesses[i][j].setVerticalAlignment(SwingConstants.CENTER);
        guesses[i][j].setOpaque(true);
        guesses[i][j].setBounds(((j*10)+1)*PER,0,9*PER,(GUESSTHICKNESS)*PER);
        guesses[i][j].setBorder(border);
        guesses[i][j].setFont(new Font("roboto mono",Font.BOLD,34));
    }

    private void setUpWindow(){
        window.setSize(windowSize,windowSize);
        window.setTitle("Wordle");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setVisible(true);
        window.getContentPane().setBackground(new Color(23,23,23));
        window.setLayout(null);
    }

    private void setUpTitle()
    {
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setForeground(new Color(199, 199, 199));
        label.setFont(new Font("roboto mono",Font.BOLD,34));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.NORTH);
        label.setBounds(0,60,window.getWidth(),window.getHeight());
        window.add(label);
    }


}

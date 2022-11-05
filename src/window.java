import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class window extends JFrame implements KeyListener {

    final int windowSize = 1000;
    final int PER = windowSize/100;
    final int GUESSTHICKNESS = 9;

    //private static Random ran = new Random();
    private  final JLabel label = new JLabel("WORDLE");
    private  JPanel[] guessesP = new JPanel[6];
    private  JLabel[][] guesses = new JLabel[6][5];
    private  final Border border = BorderFactory.createLineBorder(new Color(100,100,100),2);

    private final Color empty = new Color(23,23,23);
    private final Color miss = new Color(100,100,100);
    private  final Color present = new Color(180,180,40);
    private  final Color correct = new Color(98,166,100);
    private gameState game;

    public window()
    {

        setUpWindow();
        setUpBoard();
        setUpTitle();
        this.addKeyListener(this);
        game = new gameState();

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
            this.add(guessesP[i]);
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
        this.setSize(windowSize,windowSize);
        this.setTitle("Wordle");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
        this.getContentPane().setBackground(new Color(23,23,23));
        this.setLayout(null);
    }

    private void setUpTitle()
    {
        label.setHorizontalTextPosition(SwingConstants.CENTER);
        label.setForeground(new Color(199, 199, 199));
        label.setFont(new Font("roboto mono",Font.BOLD,34));
        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setVerticalAlignment(SwingConstants.NORTH);
        label.setBounds(0,60,windowSize,windowSize);
        this.add(label);
    }

    public void setTile(int i, int j, char value, Color color)
    {
        guesses[i][j].setText(String.valueOf(value));
        guesses[i][j].setForeground(Color.white);
        guesses[i][j].setBackground(color);
    }

    public void clearTile(int i, int j)
    {
        guesses[i][j].setText("");
        guesses[i][j].setForeground(Color.white);
        guesses[i][j].setBackground(empty);
    }


    @Override
    public void keyTyped(KeyEvent e) {
        pressKey(e.getKeyChar());

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode()==8&&game.currentLetter>0)
        {
            game.currentLetter--;
            clearTile(game.numGuess,game.currentLetter);
        }
        if(e.getKeyCode()==10&& game.currentLetter==5)
        {
            testWord();
        }

    }

    private void pressKey(char keyChar) {
        if(game.canType()){
            if( (keyChar >= 'a' && keyChar <= 'z') || (keyChar >= 'A' && keyChar <= 'Z')) {
                setTile(game.numGuess, game.currentLetter, keyChar, empty);
                game.currentGuess[game.currentLetter] = keyChar;
                game.currentLetter++;
            }
        }

    }
    //TODO complete method
    public void testWord() {

        for(int i =0; i<5; i++)
        {
            if(game.map.containsKey(game.currentGuess[i])){
                setTile(game.numGuess,i,game.currentGuess[i],present);
                if(game.currentGuess[i]==game.randomWord.charAt(i)){
                    setTile(game.numGuess,i,game.currentGuess[i],correct);
                }
            }
        }
        if(checkWin())displayVictory();
        if(game.numGuess==5)displayLost();
        game.numGuess++;
        game.currentLetter=0;

    }

    private void displayLost() {
        System.out.println("you lost");
    }

    private void displayVictory() {
        System.out.println("you won");
    }

    public boolean checkWin()
    {
        for(int i =0;i<5;i++)
        {
            if(!guesses[game.numGuess][i].getBackground().equals(correct)){
                return false;
            }

        }
        return true;

    }


}

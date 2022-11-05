import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class gameState

{
    Random rand = new Random();
    HashMap<Character, Integer> map = new HashMap<>();
    String randomWord;
    Character[] currentGuess = new Character[5];
    int numGuess = 0;
    int currentLetter = 0 ;

    gameState()
    {
        chooseWord();
        for(int i =0; i<5;i++)
        {
            map.put(randomWord.charAt(i),i);
        }
        System.out.println(randomWord);
    }

    public boolean canType()
    {
        if(currentLetter<5)
        {
            return true;
        }
        return false;
    }

    private void chooseWord(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Angel/IdeaProjects/wodle/src/wordPool.txt"));
            String line = reader.readLine();
            List<String> words = new ArrayList<String>();
            while(line != null) {
                String[] wordsLine = line.split(" ");
                for(String word : wordsLine) {
                    words.add(word);
                }
                line = reader.readLine();
            }

            Random rand = new Random(System.currentTimeMillis());
            randomWord  = words.get(rand.nextInt(words.size()));
        } catch (Exception e) {
            // Handle this
        }

    }



}

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Random;

public class gameState

{
    HashMap<String, Integer> words;
    HashMap<Character, Integer> map = new HashMap<>();
    String randomWord;
    Character[] currentGuess = new Character[5];
    public static int numGuess = 0;
    int currentLetter = 0 ;

    gameState()
    {
        chooseWord();
        loadGuessPool();
        for(int i =0; i<5;i++)
        {
            map.put(randomWord.charAt(i),i);
        }
        System.out.println(randomWord);
    }

    public boolean canType()
    {
        if(currentLetter<5)return true;
        return false;
    }

    private void chooseWord(){
        try{
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Angel/IdeaProjects/wodle/src/wordPool.txt"));
            String line = reader.readLine();
            List<String> words = new ArrayList<>();
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

    private void loadGuessPool()
    {
        try{
            BufferedReader reader = new BufferedReader(new FileReader("C:/Users/Angel/IdeaProjects/wodle/src/guessPool.txt"));
            String line = reader.readLine();
            words = new HashMap<>();
            while(line != null) {
                String[] wordsLine = line.split(" ");
                for(String word : wordsLine) {
                    words.put(word,1);
                }
                line = reader.readLine();
            }

        } catch (Exception e) {
            // Handle this
        }
    }



}

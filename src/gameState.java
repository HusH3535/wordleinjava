import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class gameState


{

    Random rand = new Random();
    String randomWord;
    char[] word;
    gameState()
    {
        chooseWord();
        System.out.println(randomWord);
        window game = new window();
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

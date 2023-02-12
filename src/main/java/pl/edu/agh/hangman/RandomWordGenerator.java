package pl.edu.agh.hangman;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class RandomWordGenerator {
    private List<String> availableWords = new ArrayList<>();

    private void getWordsFromFile() throws FileNotFoundException {
        File poemFile = new File("src/main/resources/slowa.txt");
        Scanner scanner = new Scanner(poemFile);
        while (scanner.hasNext()) {
            String next = scanner.next();
            if(!next.contains(" ")) {
                this.availableWords.add(next);
            }
        }
        scanner.close();
    }

    public String randomWord() throws FileNotFoundException {
        this.getWordsFromFile();
        Random rnd = new Random();
        int index = rnd.nextInt(this.availableWords.size());
        return this.availableWords.get(index);
    }
}

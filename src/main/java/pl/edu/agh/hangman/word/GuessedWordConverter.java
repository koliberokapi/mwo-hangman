package pl.edu.agh.hangman.word;

import java.util.ArrayList;

public class GuessedWordConverter {
    char[] letters;
    ArrayList<Character> foundLetters;

    public GuessedWordConverter(char[] letters, ArrayList<Character> foundLetters) {
        this.letters = letters;
        this.foundLetters = foundLetters;
    }

    public String getHiddenWord(char hiddenSign) {
        String hiddenWord = "";
        for (char letter : letters) {
            if (foundLetters.contains(Character.toLowerCase(letter))) {
                hiddenWord = hiddenWord.concat(Character.toString(letter));
            }
            else {
                hiddenWord = hiddenWord.concat(Character.toString(hiddenSign));
            }
        }
        return hiddenWord;
    }
}

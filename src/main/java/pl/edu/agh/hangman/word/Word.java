package pl.edu.agh.hangman.word;

import java.util.ArrayList;

public class Word {
    String word;
    char[] letters;
    ArrayList<Character> foundLetters;
    char hiddenSign;

    public Word(String word) {
        this.word = word.trim().toLowerCase();
        this.letters = this.word.toCharArray();
        this.foundLetters = new ArrayList<>();
        this.hiddenSign = '_';
    }

    public Word(String word, char hiddenSign) {
        this.letters = word.toCharArray();
        this.foundLetters = new ArrayList<>();
        this.hiddenSign = hiddenSign;
    }

    public String getHiddenWord() {
        GuessedWordConverter converter = new GuessedWordConverter(this.letters, this.foundLetters);
        return converter.getHiddenWord(this.hiddenSign);
    }

    public String getWord() {
        return this.word;
    }

    public void addFoundLetter (char letter) {
        letter = Character.toLowerCase(letter);
        if(foundLetters.contains(letter)) {
            return;
        }
        foundLetters.add(letter);
    }

    public boolean isLetterInWord(char specificLetter) {
        specificLetter = Character.toLowerCase(specificLetter);
        for(char letter : letters) {
            if(letter == specificLetter) {
                return true;
            }
        }
        return false;
    }

    public boolean isLetterAlreadyFound(char specificLetter) {
        specificLetter = Character.toLowerCase(specificLetter);
        for(char letter : foundLetters) {
            if(letter == specificLetter) {
                return true;
            }
        }
        return false;
    }

    public boolean isWordFullyGuessed() {
        for (char letter : letters) {
            if(!foundLetters.contains(Character.toLowerCase(letter))) {
                return false;
            }
        }
        return true;
    }
}

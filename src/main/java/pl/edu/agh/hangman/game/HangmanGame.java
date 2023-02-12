package pl.edu.agh.hangman.game;

import pl.edu.agh.hangman.MessageDisplayer;
import pl.edu.agh.hangman.RandomWordGenerator;
import pl.edu.agh.hangman.UserInterface;
import pl.edu.agh.hangman.word.Word;

import java.io.FileNotFoundException;

public class HangmanGame {
    RandomWordGenerator wordGenerator;
    UserInterface userInterface;
    Word word;

    int points;

    public HangmanGame() {
        this.wordGenerator = new RandomWordGenerator();
        this.userInterface = new UserInterface();
        this.startGame();
    }

    private void startGame() {
        userInterface.welcomeMessage();
        this.points = 0;

        try {
            this.word = new Word(wordGenerator.randomWord());
        }
        catch (FileNotFoundException e) {
            System.out.println("Nie znaleziono pliku z hasłami. Nie możemy rozpocząć zabawy :(");
            return;
        }
        userInterface.printLetterPlaces(word.getHiddenWord());

        while(this.points < MessageDisplayer.HANGMANPICS.length - 1) {
            String givenCharacter = userInterface.inputChar();
            char character = givenCharacter.toCharArray()[0];

            if (word.isLetterInWord(character)) {
                word.addFoundLetter(character);

            }
            else {
                this.points++;
            }

            MessageDisplayer.displayCurrentState(this.points);
            userInterface.printLetterPlaces(word.getHiddenWord());

            if(word.isWordFullyGuessed()) {
                userInterface.printGameWin(word.getWord());
                this.startGame();
            }
        }

        userInterface.printGameDefeat(word.getWord());
        this.startGame();
    }
}

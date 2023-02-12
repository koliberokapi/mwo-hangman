package pl.edu.agh.hangman;

import java.util.Scanner;

import static pl.edu.agh.hangman.MessageDisplayer.displayCurrentState;

public class UserInterface {
    private String character;
    public String inputChar() {
        Scanner scan = new Scanner(System.in);
        System.out.print("guess> ");
        character = scan.nextLine();
        while (character.length() > 1) {
            System.out.println("Podales wiecej niz jedna litere. Sprobuj jeszcze raz :)");
            character = scan.nextLine();
        }
        return character;
    }

    public void printGameDefeat() {
        //System.out.println("\\( ᴼ  ᴼ )/");
        System.out.println("Przegrales gre :(");
    }

    public void printGameWin() {
        //System.out.println("\\( ᴼ  ᴼ )/");
        System.out.println("Wygrales gre! :)");
    }

    public void printLetterPlaces(String word) {
        System.out.println("Aktualny stan gry: " + word);
    }

}

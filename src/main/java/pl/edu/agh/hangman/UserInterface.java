package pl.edu.agh.hangman;

import java.util.Scanner;

import static pl.edu.agh.hangman.MessageDisplayer.displayCurrentState;

public class UserInterface {
    private String character;

    public void welcomeMessage() {
        System.out.println("\n\n!!! ------ Welcome in Hangman game ------ !!!");
        System.out.println("                ! Have fun !");
    }
    public String inputChar() {
        Scanner scan = new Scanner(System.in);
        System.out.print("guess> ");
        character = scan.nextLine();

        while (character.length() != 1) {
            System.out.println("Podaj jedną literę. :)");
            character = scan.nextLine();
        }
        return character;
    }

    public void printGameDefeat(String word) {
        System.out.println("Przegrales gre :(");
        System.out.println("Poprawne haslo: " + word);
    }

    public void printGameWin(String word) {
        System.out.println("Wygrales gre! :)");
        System.out.println("Poprawne haslo: " + word);
    }

    public void printLetterPlaces(String word) {
        System.out.println("Aktualny stan gry: " + word);
    }

}

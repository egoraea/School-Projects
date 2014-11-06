/**
 * @author  Eric Erickson
 * @version 10/16/13
 * CS312 Assignment 6.
 *
 * On my honor, Eric Erickson, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *
 * A program to allow a human player to play Hangman
 * against the computer.
 *
 *  email address: egoraea@gmail.com
 *  UTEID: eje444
 *  Section 5 digit ID:53700	
 *  Grader name:Megan Avery
 *  Number of slip days used on this assignment:0
 */

import java.util.Scanner;

public class Hangman {
	//number they can get wrong
 public static int wrongLimit = 5;

    public static void main(String[] args) {
        intro();
        PhraseBank phrases = new PhraseBank();
        Scanner keyboard = new Scanner(System.in);
        game(phrases,keyboard);
    }

    // shows the intro to the program
    public static void intro() {
        System.out.println("This program plays the game of hangman.");
        System.out.println("When the window opens select the file");
        System.out.println("with the phrases you want to use.\n");
        System.out.println("The computer will pick a random phrase.");
        System.out.println("Enter capital letters as your guesses.");
        System.out.println("After 5 wrong guesses you lose.");
    }
    //gets the topic
    public static void topic (PhraseBank phrases) {
    	String topic = phrases.getTopic();
    	System.out.printf("I am thinking of a %s ...\n", topic);
    	System.out.println();
    }
    //plays the game
    public static void game (PhraseBank phrases, Scanner keyboard) {
    	boolean play = true;
    	while (play){
    		topic (phrases);
    		round(phrases, keyboard);
    		play = again(keyboard);
    	}
    }
    //turns phrase into what is shown to player
    public static String encode (String phrase){
    	String encoded = "";
    	for (int i=0;i<phrase.length();i++){
    		if (phrase.charAt(i)!=('_')){
    			encoded += "*";
    		} else encoded += "_";
    	}
    	return encoded;
    }
    //plays one round of the game
    public static void round(PhraseBank phrases, Scanner keyboard) {
    	String phrase = phrases.getNextPhrase();
    	String guessing = encode(phrase);
    	String notGuessed = "A B C D E F G H I J K L M N O P Q R S T U V W X Y Z ";
    	int wrong = 0;
    	while (!(guessing.equals(phrase)) && wrong < wrongLimit) {
    		System.out.printf("The current phrase is %s\n", guessing);
    		System.out.println("The letters you have not guessed yet are: ");
    		System.out.println(notGuessed);
    		System.out.print("Enter your next guess: ");
    		String guessed = keyboard.next().substring(0, 1);
    		keyboard.nextLine();
    		System.out.println();
    		while (!(notGuessed.contains(guessed))){
    			System.out.println(guessed + " is not a valid guess.");
    			System.out.println("The letters you have not guessed yet are: ");
        		System.out.println(notGuessed);
        		System.out.print("Enter your next guess: ");
        		guessed = keyboard.next().substring(0, 1);
        		keyboard.nextLine();
        		System.out.println();
    		}
    		String guessingTemp = guess (keyboard, phrase, guessing, notGuessed,guessed);
    		if (guessingTemp.equals(guessing)) wrong++;
    		else guessing = guessingTemp;
    		notGuessed = guessTwo (guessed, notGuessed);
    		if (wrong == 1) System.out.println("You have made 1 wrong guess.") ;
    		else System.out.println("You have made " + wrong + " wrong guesses.");
    		System.out.println();
    	}
    	if (wrong>=wrongLimit) {
    		System.out.println("You lose. The phrase was "+phrase+".");
    		System.out.println();
    	} else {
    		System.out.println("The phrase is "+phrase+".");
    		System.out.println("YOU WIN!!!!");

    	}
    }
    //Takes their guess out of the not guessed string
    public static String guessTwo (String guessed,String notGuessed){
    	int post = notGuessed.indexOf(guessed);
    	if (post == notGuessed.length()-2) return notGuessed = notGuessed.substring(0,post);
    	else if (post != -1) return notGuessed = notGuessed.substring(0, post)+notGuessed.substring(post+2);
    	return notGuessed;
    }
    //tests their guess and prints out if its in the phrase
	public static String guess(Scanner keyboard,String phrase, String guessing, String notGuessed,String guessed) {
		String temp ="";
		System.out.printf("You guessed %s. \n", guessed);
		if (phrase.contains(guessed))System.out.println("That is present in the secret phrase.");
		else 	System.out.println("That is not present in the secret phrase.");
		
		for (int i=0;i<phrase.length();i++){
    		if (phrase.substring(i,i+1).equals(guessed)){
    			temp += guessed;
    		} else temp += guessing.charAt(i);
    	}
		return temp;
	}
	//asks if they want to play again
	public static boolean again (Scanner keyboard){
		System.out.println("Do you want to play again?");
		System.out.print("Enter 'Y' or 'y' to play again: ");
		String answer = keyboard.next();
		keyboard.nextLine();
		System.out.println();
		return answer.equalsIgnoreCase("Y");
	}
}
/**
 * @author  Eric Erickson
 * @version 10/01/13
 * CS312 Assignment 4.
 *
 * On my honor, Eric Erickson, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *
 * A program to allow a human player to play rock - paper - scissors
 * against the computer.
 *
 *  email address: egoraea@gmail.com
 *  UTEID:eje444
 *  Section 5 digit ID:53700
 *  Grader name:Megan Avery
 *  Number of slip days used on this assignment:0
 */
import java.util.Scanner;
public class RockPaperScissors {

	//returns random for computer
	public static int randComp () {
	    RandomPlayer comp = new RandomPlayer();
	    return comp.play();
	}
	//gets name
	public static String introduction (Scanner s){
		System.out.println("Welcome to Rock Paper Scissors Lizard Spock. I, Computer, will be your opponent.");
		System.out.print("Please type in your name and press return: ");
		return s.nextLine();
	
	}
	//gets number of rounds
	public static int numRounds (Scanner s, String name){
		System.out.println();
		System.out.println("Welcome "+name);
		System.out.println("All right "+ name +". How many rounds would you like to play? ");
		System.out.print("Enter the number of rounds you want to play and press return: ");
		return s.nextInt();
	}
	//plays the game and figures out who won
	public static int game (Scanner s,String name, int rounds) {
		int compWins=0;
		int playWins=0;
		int draws=0;
		for (int i=1; i<=rounds;i++){
			int result=round(s,name,i);
			if (result==1){
				compWins++;
			} else if (result ==2){
				playWins++;
			} else{
				draws++;
			}
		}
		System.out.println("Number of games of Rock Paper Scissors Lizard Spock: "+rounds);
		System.out.println("Number of times Computer won: "+compWins);
		System.out.println("Number of times "+name+" won: "+playWins);
		System.out.println("Number of draws: "+draws);
		if (playWins>compWins){
			return 1;
		} else if (compWins>playWins) {
			return 2;
		} else {
			return 3;
		}
	
	
	}
	//plays each round
	public static int round (Scanner s, String name, int round){
		int playChoice;
		int compChoice;
			System.out.println("Round "+round);
			System.out.println(name+", please enter your choice for this round.");
			System.out.print("1 for rock, 2 for paper, 3 for scissors, 4 for lizard, and 5 for Spock: ");
			playChoice=s.nextInt();
			compChoice=randComp();
			s.nextLine();
			System.out.println();
			//System.out.printf(format, args)
			if (compChoice==1){
				if (playChoice==1) {
					System.out.println("Computer picked rock and "+name+" picked rock");
					System.out.println();
					System.out.println("This round is a draw.");
					return 3;
				} else if (playChoice==2){
					System.out.println("Computer picked rock and "+name+" picked paper");
					System.out.println();
					System.out.println("Paper covers rock. You win.");
					return 2;
				} else if (playChoice==3) {
					System.out.println("Computer picked rock and "+name+" picked scissors");
					System.out.println();
					System.out.println("Rock breaks scissors. I win.");
					return 1;
				} else if (playChoice==4){
					System.out.println("Computer picked rock and "+name+" picked lizard");
					System.out.println();
					System.out.println("Rock crushes lizard. I win.");
					return 1;
				} else {
					System.out.println("Computer picked rock and "+name+" picked Spock");
					System.out.println();
					System.out.println("Spock vaporizes rock. You win.");
					return 2;
				}
			} else if (compChoice ==2){
				if (playChoice==1) {
					System.out.println("Computer picked paper and "+name+" picked rock");
					System.out.println();
					System.out.println("Paper covers rock. I win.");
					return 1;
				} else if (playChoice==2){
					System.out.println("Computer picked paper and "+name+" picked paper");
					System.out.println();
					System.out.println("This round is a draw.");
					return 3;
				} else if (playChoice==3) {
					System.out.println("Computer picked paper and "+name+" picked scissors");
					System.out.println();
					System.out.println("Scissors cuts paper. You win.");
					return 2;
				} else if (playChoice==4){
					System.out.println("Computer picked paper and "+name+" picked lizard");
					System.out.println();
					System.out.println("Lizard eats paper. You win.");
					return 2;
				} else {
					System.out.println("Computer picked paper and "+name+" picked Spock");
					System.out.println();
					System.out.println("Paper disproves Spock. I win.");
					return 1;
				} 
			}else if (compChoice==3 ){
				if (playChoice==1) {
					System.out.println("Computer picked scissors and "+name+" picked rock");
					System.out.println();
					System.out.println("Rock breaks scissors. You win.");
					return 2;
				} else if (playChoice==2){
					System.out.println("Computer picked scissors and "+name+" picked paper");
					System.out.println();
					System.out.println("Scissors cuts paper. I win.");
					return 1;
				} else if (playChoice==3) {
					System.out.println("Computer picked scissors and "+name+" picked scissors");
					System.out.println();
					System.out.println("This round is a draw.");
					return 3;
				} else if (playChoice==4) {
					System.out.println("Computer picked scissors and "+name+" picked lizard");
					System.out.println();
					System.out.println("Scissors decapitates lizard. I win");
					return 1;
				} else {
					System.out.println("Computer picked scissors and "+name+" picked Spock");
					System.out.println("Spock smashes Scissors. You win.");
					return 2;
				}
			} else if (compChoice==4) {
				if (playChoice==1) {
					System.out.println("Computer picked lizard and "+name+" picked rock");
					System.out.println();
					System.out.println("Rock crushes lizard. "+ "You win.");
					return 2;
				} else if (playChoice==2){
					System.out.println("Computer picked lizard and "+name+" picked paper");
					System.out.println();
					System.out.println("Lizard eats paper. I win");
					return 1;
				} else if (playChoice==3) {
					System.out.println("Computer picked lizard and "+name+" picked scissors");
					System.out.println();
					System.out.println("Scissors decapitates lizard. You win.");
					return 2;
				} else if (playChoice==4){
					System.out.println("Computer picked lizard and "+name+" picked lizard");
					System.out.println();
					System.out.println("This round is a draw.");
					return 3;
				} else {
					System.out.println("Computer picked lizard and "+name+" picked Spock");
					System.out.println();
					System.out.println("Lizard poisons Spock. I win");
					return 1;
				} 
			} else {
				if (playChoice==1) {
					System.out.println("Computer picked Spock and "+name+" picked rock");
					System.out.println();
					System.out.println("Spock vaporizes rock. I win.");
					return 1;
				} else if (playChoice==2){
					System.out.println("Computer picked Spock and "+name+" picked paper");
					System.out.println();
					System.out.println("Paper disproves Spock. You win.");
					return 2;
				} else if (playChoice==3) {
					System.out.println("Computer picked Spock and "+name+" picked scissors");
					System.out.println();
					System.out.println("Spock smashes Scissors. I win.");
					return 1;
				} else if (playChoice==4){
					System.out.println("Computer picked Spock and "+name+" picked lizard");
					System.out.println();
					System.out.println("Lizard poisons Spock. You win.");
					return 2;
				} else {
					System.out.println("Computer picked Spock and "+name+" picked Spock");
					System.out.println();
					System.out.println("This round is a draw.");
					return 3;					
				} 
			}
	}
	//prints out ending stats
	public static void ending (int result) {

		if (result==1){
			System.out.println("You are a master at Rock, Paper, Scissors, Lizard, Spock.");
		} else if (result==2){
			System.out.println("I, Computer, am a master at Rock, Paper, Scissors, Lizard, Spock.");
		} else {
			System.out.println("We are evenly matched at this game.");
		}
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String name=introduction(s);
		int rounds= numRounds(s,name);
		int result=game(s,name,rounds);
		ending(result);
	}

}
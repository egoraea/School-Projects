import java.util.Scanner;


public class Game {
    private Colors[] usedColors = {Colors.Blue,Colors.Green,Colors.Orange,Colors.Purple,Colors.Red,Colors.Yellow};
    private int turns = 12;
    private int pegs = 4;
    private boolean play = true;
    private Scanner s = new Scanner(System.in);
	// if showCode is true then the secret code is revealed before
	// the gane starts. This will be used by graders of the program
	// to test the feedback of guesses
    private boolean showCode;

    public Game(boolean easy){
        showCode = easy;
    }

    public void runGames(){
    	intro();
    	while(play){
    		System.out.println("Generating Secret Code...");
    		Turns t = new Turns(showCode,turns,pegs,usedColors);
        	t.play();
    		play = again();
    	}
     }
    public void intro (){
    	String colors = "";
    	for (int i = 0; i<usedColors.length-1;i++){
    		colors+=usedColors[i].toString().toLowerCase()+", ";
    	}
    	colors += "or "+usedColors[usedColors.length-1].toString().toLowerCase()+".";
    	System.out.println("Welcome to Mastermind\n");
    	System.out.println("This is a text version of the classic board game Mastermind.");
    	System.out.println("The computer will think of a secret code.");
    	System.out.println("The code consists of "+pegs+" colored pegs.");
    	System.out.println("The pegs may be one of "+usedColors.length+" colors: "+colors);
    	System.out.println("A color may appear more than once in the code.\n");
    	System.out.println("You try to guess what colored pegs are in the code and what order they are in");
    	System.out.println("After making a guess the result will be displayed.");
    	System.out.println("A result consists of a black peg(displayed as K) for each peg "
    			+ "you have exactly correct (color and position) in your guess.");
    	System.out.println("For each peg in the guess that is the correct color, but is out of position, you get a white peg.\n");
    	System.out.println("Only the first letter of the color is displayed. B for Blue, R for Red, and so forth.");
    	System.out.println("When entering guesses you only need to enter the first character of the color as a capital letter.\n");
    	System.out.println("You have "+turns+" to guess the answer or you lose the game.\n");
    }
	public boolean again (){
		System.out.println("Do you want to play again?");
		System.out.print("Enter 'Y' or 'y' to play again: ");
		String answer = s.next();
		s.nextLine();
		System.out.println();
		return answer.equalsIgnoreCase("Y");
	}

}
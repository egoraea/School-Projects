import java.util.Scanner;


public class Turns {
    private Scanner s = new Scanner(System.in);
    private int turns;
    private int pegs;
    private Board b;
    private boolean showCode;
    private String colors = "";
    private Colors[] usedColors;
    //plays through game until they dont want to play anymore
    public Turns (boolean ShowCode,int Turns,int Pegs,Colors[] UsedColors){
    	b = new Board(Turns,new Piece(UsedColors, Pegs));
    	turns = Turns;
    	pegs = Pegs;
    	showCode=ShowCode;
    	usedColors = UsedColors;
    	for (int i = 0; i<UsedColors.length;i++){
    		colors+=UsedColors[i].toString().substring(0,1);
    	}
    }
    //plays the entire game
	public void play(){
		while(!b.isDone()||!b.isWon()){ 			
			playTurn();
   		}
		System.out.println(b);
		if (b.isWon()){
			System.out.println("You solved the puzzle! Good job.");
		} else {
			System.out.println("You did not solve the puzzle. Too bad.");
		}
	}
	//plays one turn
	public void playTurn(){
		if (showCode){
			System.out.println("The Secret Code is "+b.answer());
		}
		if (b.turnsLeft()<turns){
			System.out.println(b.toString());
		}
		System.out.println("You have "+b.turnsLeft()+" guesses left or you lose.\n");
		String guess = "";
		boolean done = false;
		while (!done){
			System.out.println("What is your next guess?");
			System.out.println("Type in the characters for your guess and press enter.");
			System.out.print("Enter guess: ");
			guess = s.nextLine().toUpperCase();  
			System.out.println();
			if (guess.length()!=pegs){
				System.out.println("Your guess does not have exactly "+4+" characters. Try again.\n");
			} else if (!checkChars(guess)){
				System.out.println("There are invalid characters in your guess. Try again.\n");
			} else {
				done = true;
				Colors[] guessConverted = new Colors[guess.length()];
				for (int i = 0;i<guess.length(); i++){
					guessConverted[i]=usedColors[colors.indexOf(guess.charAt(i))];
				}
				b.guess(new Piece(guessConverted));
			}
		}
	}
	//checks if the chars in answer are in the colors
	public boolean checkChars(String guess){
		boolean result = true;
		for (int i = 0; i<guess.length()-1;i++){
			if (result && colors.contains(guess.substring(i, i+1))){
				result = true;
			} else {
				result = false;
			}
		}
		return result;
		
	}
}

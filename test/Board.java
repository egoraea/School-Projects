
public class Board {
	private Piece[] guesses;
	private Piece[] hints;
	private Piece answer;
	private int turn = 0;
	private boolean right = false;
	//for testing if something is the right answer
	private String test = "";
	private String nullPiece = "";
	public Board(int turns, Piece ans){
		guesses = new Piece[turns];
		hints = new Piece[turns];
		answer = ans;
		for (int i = 0;i<ans.toString().length();i++){
			test+="K";
			nullPiece+="-";
		}
	}
	//puts in a guess
	public void guess(Piece guess){
		guesses[turn] = guess;
		hints[turn] = guess.compare(answer);
		if (test.equals(hints[turn].toString())){
			right = true;
		}
		turn++;
	}
	//checks if game on this board is done
	public boolean isDone(){
		return turn==guesses.length;
	}
	public boolean isWon(){
	return right;	
	}
	//returns the number of turns left in a game
	public int turnsLeft(){
		return guesses.length-turn;
	}
	//for showing answer if debugging
	public Piece answer(){
		return answer;
	}
	
	public String toString(){
		String result = "";
		if (right){
			result += answer+" Secret Code\n";
			for (int i = 0; i<turn;i++){
					result+=guesses[i]+" Result: "+hints[i]+"\n";
			}
		} else {
			result += nullPiece+" Secret Code\n";
			for (int i = 0; i<guesses.length;i++){
				if (guesses[i]!=null){
					result+=guesses[i]+" Result: "+hints[i]+"\n";
				} else {
					result+= nullPiece+"\n";
				}
			}
		}
		result += "\n";
		return result;
	}
}

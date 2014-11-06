import java.util.Random;

public class Piece {
	private Colors[] pegs;
	public Piece(Colors[] colors, int numPegs){
		pegs = new Colors[numPegs];
		Random r = new Random();
		//fills pegs with random colors from the colors list
		//for that game
		for (int i = 0; i<numPegs; i++){
			pegs[i]=colors[r.nextInt(colors.length)];
		}
	}
	//for testing
	public Piece(Colors[] test){
		pegs=test;
	}
	//compares to pieces
	//pre same size as pegs
	//post same size as pegs
	public Piece compare(Piece other){
		if (pegs.length!=other.pegs.length){
    		throw new IllegalArgumentException("Violation of precondition must be same length" );
    	}
		int rightPlace = 0;
		int same = 0;
		String original = toString();
		String comparedToo = other.toString();
		Colors[] result = new Colors[pegs.length];
		for (int i =0; i<original.length();i++){
			if (original.charAt(i)==comparedToo.charAt(i)){
				rightPlace++;
			}
			if (original.contains(comparedToo.substring(i,i+1))){
				same++;
			}
		}
		//puts a black piece in for each piece in the rightPlace
		for (int i = 0; i<rightPlace;i++){
			result[i]= Colors.KBlack;
		}
		//puts a white piece in starting at the end of the black
		//pieces for each same piece that's not in the right place
		for (int i = rightPlace;i<same;i++){
			result[i]=Colors.White;
		}
		return new Piece(result);
	}
	//new toString
	public String toString(){
		String result = "";
		for (Colors c: pegs){
			if (c!=null){
			result+=c.toString().substring(0,1);
			} else {
				result+="-";
			}
		}
		return result;
	}
}

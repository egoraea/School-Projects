
public class MasterMindTest {

	public static void main(String[] args) {
		int test = 1;
		boolean testing = false;
		//tests for Piece
		//test 1
		Piece ptest1 = new Piece(new Colors[]{Colors.Aqua,Colors.Blue,Colors.Charcoal});
		Piece ptest2 = new Piece(new Colors[]{Colors.Charcoal,Colors.Blue,Colors.Aqua});
		testing = ptest1.compare(ptest2).toString().equals("KWW");
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 2
		Piece ptest3 = new Piece (new Colors[]{Colors.Flax,Colors.Zucchini,Colors.Blue});
		testing = ptest1.compare(ptest3).toString().equals("W--");
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 3
		testing = ptest1.toString().equals("ABC");
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 4 
		Piece ptest4 = new Piece(new Colors[]{null,null,null});
		testing = ptest4.toString().equals("---");
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//tests for Board
		//test 5
		Board b1 = new Board(3, ptest1);
		b1.guess(ptest1);
		testing = b1.isDone();
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 6
		b1 = new Board(0, ptest1);
		testing=b1.isDone();
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 7
		testing = b1.toString().equals("--- Secret Code\n\n");
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 8
		Board b2 = new Board(2,ptest1);
		testing = b2.toString().equals("--- Secret Code\n---\n---\n\n");
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 9
		b2.guess(ptest2);
		b2.guess(ptest3);
		testing = b2.toString().equals("--- Secret Code\nCBA Result: KWW\nFZB Result: W--\n\n");
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 10
		Board b3 = new Board(3,ptest1);
		b3.guess(ptest2);
		b3.guess(ptest1);
		testing = b3.toString().equals("ABC Secret Code\nCBA Result: KWW\nABC Result: KKK\n\n");
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//Tests for Turns
		//test 11
		Turns t1 = new Turns(true, 3, 2,new Colors[]{Colors.Blue,Colors.Red});
		t1.playTurn();
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 12
		t1.playTurn();
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 13
		testing=t1.checkChars("BR");
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 14
		testing = !t1.checkChars("BC");
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test for Game
		//test 15
		Game g1 = new Game(true);
		testing =g1.again();
		//test 16
		testing = !g1.again();
	}

}

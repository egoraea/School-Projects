/*  Student information for assignment:
 *
 *  Number of slip days used:0
 *
 *  Name:Eric Erickson
 *  email address:egoraea@gmail.com
 *  UTEID:eje444
 *  Section 5 digit ID: 53595 
 *  Grader name: Aaron
 *
 */


import java.util.ArrayList;
import java.util.Collections;

public class RecursiveTester {
    public static void main(String[] args) {
        Recursive r = new Recursive();
        studentTests(r);
    }

    // pre: r != null
    // post: run student test
    private static void studentTests(Recursive r) {
        // CS314 students put your tests here
    	//test 1
    	int test = 1;
    	boolean success = r.getBinary(16).equals("10000");
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 2
    	success = r.getBinary(6).equals("110");
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 3
    	success = r.getBinary(573).equals("1000111101");
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 4
    	success = r.revString("a").equals("a");
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 5
    	success = r.revString("cat").equals("tac");
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 6
    	success = r.revString("three blind mice").equals("ecim dnilb eerht");
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 7
    	success = r.nextIsDouble(new int[]{1,2,1,2,1,2}) == 3;
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 8
    	success = r.nextIsDouble(new int[]{2,1,3,2,1,3,2,1}) ==0;
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 9
    	success = r.nextIsDouble(new int[]{1,2,4,5,10,7,14}) == 4;
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 10
    	ArrayList<String> list = new ArrayList<String>();
    	ArrayList<String> mnemonics = new ArrayList<String>();
    	mnemonics = r.listMnemonics("732");
    	Collections.sort(mnemonics);
    	list.add("PDA");
    	list.add("PDB");
    	list.add("PDC");
    	list.add("PEA");
    	list.add("PEB");
    	list.add("PEC");
    	list.add("PFA");
    	list.add("PFB");
    	list.add("PFC");
    	list.add("QDA");
    	list.add("QDB");
    	list.add("QDC");
    	list.add("QEA");
    	list.add("QEB");
    	list.add("QEC");
    	list.add("QFA");
    	list.add("QFB");
    	list.add("QFC");
    	list.add("RDA");
    	list.add("RDB");
    	list.add("RDC");
    	list.add("REA");
    	list.add("REB");
    	list.add("REC");
    	list.add("RFA");
    	list.add("RFB");
    	list.add("RFC");
    	list.add("SDA");
    	list.add("SDB");
    	list.add("SDC");
    	list.add("SEA");
    	list.add("SEB");
    	list.add("SEC");
    	list.add("SFA");
    	list.add("SFB");
    	list.add("SFC");
    	Collections.sort(list);
    	success = list.equals(mnemonics);
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	///test 11
    	list.clear();
    	mnemonics = r.listMnemonics("101010");
    	list.add("101010");
    	success = list.equals(mnemonics);
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 12
    	list.clear();
    	mnemonics = r.listMnemonics("1122");
    	list.add("11AA");
    	list.add("11AB");
    	list.add("11AC");
    	list.add("11BA");
    	list.add("11BB");
    	list.add("11BC");
    	list.add("11CA");
    	list.add("11CB");
    	list.add("11CC");
    	Collections.sort(list);
    	Collections.sort(mnemonics);
    	success=list.equals(mnemonics);
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 13
    	String board = 
    			  "000260701"
    			+ "680070090"
    			+ "190004500"
    			+ "820100040"
    			+ "004602900"
    			+ "050003028"
    			+ "009300074"
    			+ "040050036"
    			+ "703018000";
    	String answer = 
  			  "435269781"
  			+ "682571493"
  			+ "197834562"
  			+ "826195347"
  			+ "374682915"
  			+ "951743628"
  			+ "519326874"
  			+ "248957136"
  			+ "763418259";
    	success = answer.equals(boardToString(r.getSudokoSolution(stringToBoard(board))));
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 14
    		board = 
  			  "008004005"
  			+ "040010070"
  			+ "200300600"
  			+ "600100800"
  			+ "090030010"
  			+ "004009003"
  			+ "001007002"
  			+ "070020080"
  			+ "300800500";
    		answer = 
			  "768294135"
			+ "943516278"
			+ "215378694"
			+ "637142859"
			+ "892735416"
			+ "154689723"
			+ "481957362"
			+ "576423981"
			+ "329861547";
  		success = answer.equals(boardToString(r.getSudokoSolution(stringToBoard(board))));
  		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 15
  		board = 
			  "100700800"
			+ "003004000"
			+ "080010003"
			+ "500600080"
			+ "006040700"
			+ "020008009"
			+ "600070010"
			+ "000200900"
			+ "004006007";
  		answer = 
		  "165723894"
		+ "973864125"
		+ "482519673"
		+ "541697382"
		+ "896342751"
		+ "327158469"
		+ "639475218"
		+ "758231946"
		+ "214986537";
  		success = answer.equals(boardToString(r.getSudokoSolution(stringToBoard(board))));
  		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 16
    	int[][] map = new int[][]{
    			{100,100,100,100,100,100,100},
    			{100,100,100,100,100,100,100},
    			{100,100,100,100,100,100,100},
    			{100,100,95,94,100,100,100},
    			{100,100,94,93,92,100,100},
    			{100,100,93,100,100,99,98},
    			{90,91,92,100,100,100,100},
    			{100,100,100,100,100,100,100}};
    			
    	success = r.canFlowOffMap(map, 2, 2);
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 17
    	success = !r.canFlowOffMap(map, 3, 3);
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 18
    	success = r.canFlowOffMap(map, 6, 5);
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 19
    	success = r.minDifference(2, new int[]{1,1})==0;
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 20 
    	success = r.minDifference(5, new int[]{1,2,3,4,5,6})==3;
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    	//test 21
    	success = r.minDifference(2, new int[]{1,1,3,2,2})==1;
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    }

    private static String boardToString(int[][] board) {
        StringBuilder result = new StringBuilder(81);
        for(int r = 0; r < board.length; r++)
            for(int c = 0; c < board[r].length; c++)
                result.append(board[r][c]);
        return result.toString();
    }

    private static int[][] stringToBoard(String puzzle) {
        int[][] result = new int[Recursive.BOARD_SIZE][Recursive.BOARD_SIZE];
        int index = 0;
        for(int r = 0; r < result.length; r++)
            for(int c = 0; c < result.length; c++, index++)
                result[r][c] = puzzle.charAt(index) - '0';
        return result;
    }

    private static void printBoard(int[][] board) {
        for(int r = 0; r < board.length; r++) {
            for(int c = 0; c < board[r].length; c++) {
                System.out.print(board[r][c]);
                System.out.print(" ");
            }
            System.out.println();
        }
    }
}


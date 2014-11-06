
/*
 * CS312 Assignment 10
 * A program to play connect four.
 *
 * On my honor this program is my own work:
 * Eric Erickson
 *
 *  email address: egoraea@gmail.com
 *  UTEID: eje444
 *  Section 5 digit ID: 53700
 *  Grader name: Megan Avery
 *  Number of slip days used on this assignment:
 *
 * Number of slip days I am using:
 */

import java.util.Scanner;
import java.util.Arrays;
public class ConnectFour
{

    public static void main(String[] args)
    {
    	Scanner s = new Scanner(System.in);
    	char [][] board = new char[6][7];
    	for (char[]row : board){
    	Arrays.fill(row, '.');
    	}
    	String [] names = getNames(s);
    	char [] pieces = {'r','b'};
    	int [] indexofCol = new int [7];
    	Arrays.fill(indexofCol, 5);
    	int turn = -1;
    	boolean draw = false;
    	boolean win = false;
    	while (!win && !draw){
    		System.out.println();
    		displayBoard(board, win || draw );	
    		turn++;
    		int [] coords = playTurn(turn%2,board,indexofCol,names[turn%2],pieces[turn%2],s);
    		win = checkWin(board, coords,pieces[turn%2]);
    		draw = checkDraw(indexofCol);
    	}
    	if (win) System.out.println(names[turn%2]+" wins!!");
    	else if (draw) System.out.println("This game is a draw");
    	System.out.println();
    	displayBoard(board, win || draw );	
    	
    }
    //checks if game drawed
    public static boolean checkDraw(int[] indexofCol) {
		int [] draw = new int [7];
		Arrays.fill(draw, -1);
    	return Arrays.equals(indexofCol, draw);
	}
    //checks if game was won
	public static boolean checkWin(char[][] board, int[] coords, char piece) {
		boolean vert = checkVert(board, coords,piece);
		boolean horz = checkHorz(board, coords,piece);
		boolean diag1 = checkDiag1(board, coords,piece);
		boolean diag2 = checkDiag2(board, coords, piece);
		return vert || horz || diag1 || diag2 ;
	}
	//checks for vertical win
	public static boolean checkVert(char[][] board, int[] coords, char piece){
		int count = 0;
		int y = coords [0];
		boolean chain = true;
		while ((chain || count<4) && y<=5){
			if (board[y][coords[1]]==piece) count++;
			else chain = false;
			y++;
		}
		return count>=4;		
	}
	//checks for horizontal win
	public static boolean checkHorz(char[][] board, int[] coords, char piece){
		int count = 0;
		int left = coords[1];
		int right = coords[1]+1;
		boolean leftChain = true;
		boolean rightChain = true;
		while ((leftChain || count<4) && left>=0){
			if (board[coords[0]][left]==piece) count++;
			else leftChain = false;
			left--;
		}
		while ((rightChain || count<4) && right<=6){
			if (board[coords[0]][right]==piece) count++;
			else rightChain = false;
			right++;
		}
		return count>=4;		
	}
	//checks one diagonal
	public static boolean checkDiag1(char[][] board, int[] coords, char piece){
		int count = 0;
		int y1 =coords[0];
		int y2=coords[0]+1;
		int x1=coords[1];
		int x2=coords[1]+1;
		boolean upChain = true;
		boolean downChain = true;
		while ((upChain || count<4) && y1>=0 && x1 >=0){
			if (board[y1][x1]==piece) count++;
			else upChain = false;
			y1--;
			x1--;
		}
		while ((downChain || count<4) && y2<=5 && x2<=6){
			if (board[y2][x2]==piece) count++;
			else downChain = false;
			y2++;
			x2++;
		}
		return count>=4;		
	}
	//checks the other diagonal
	public static boolean checkDiag2(char[][] board, int[] coords, char piece){
		int count = 0;
		int y1 =coords[0]+1;
		int y2=coords[0];
		int x1=coords[1];
		int x2=coords[1]+1;
		boolean upChain = true;
		boolean downChain = true;
		while ((upChain || count<4) && y1<=5 && x1 >=0){
			if (board[y1][x1]==piece) count++;
			else upChain = false;
			y1++;
			x1--;
		}
		while ((downChain || count<4) && y2>=0 && x2<=6){
			if (board[y2][x2]==piece) count++;
			else downChain = false;
			y2--;
			x2++;
		}	
		return count>=4;		
	}
	//plays a turn
    public static int[] playTurn(int player, char[][] board, int[] indexofCol,
			String name, char piece, Scanner s) {
		System.out.println(name+" it is your turn.");
		System.out.println("Your pieces are the "+piece+"'s.");
		
		int col = pickCol(s,name,indexofCol);
		board[indexofCol[col]][col] = piece;
		int [] coords = {indexofCol[col] , col};
		indexofCol[col]--;
		return coords ;
	}
//the person picks the column
    public static int pickCol(Scanner s, String name, int[]indexofCol){
    	int col = -1;
    	boolean done = false;
    	while(!done){
    		System.out.print(name+" enter the coulmn to drop your checker: ");
    		if (s.hasNextInt()){
    			col = s.nextInt()-1;
    			s.nextLine();
    			if (col<0  || col>6){
        			System.out.println((col+1) + " is not a valid column.");
        		} else if (indexofCol[col]<=-1) {
        			System.out.println("Column "+(col+1)+" is full.");
        		} else done = true;
    		} else {
    			String wrong = s.nextLine();
    			System.out.println(wrong+" is not an integer.");
    		}
    	}
		return col;
    }
    //gets their names
	public static String[] getNames(Scanner s) {
		String[] names = new String[2];
    	System.out.print("Player 1 enter your name: ");
		names[0] = s.nextLine();
		System.out.print("Player 2 enter your name: ");
		names[1] = s.nextLine();
		return names;
	}
	//displays the board
	public static void displayBoard (char[][] board, Boolean done){
    	if (!done)System.out.println("Current Board");
    	else System.out.println("Final Board");
    	for (int i = 1; i <= 7; i++){
    		System.out.print(i+" ");
    	}
    	System.out.print("column numbers");
    	System.out.println();
    	for (int i = 0; i < board.length; i++){
    		for (int j=0; j < board[i].length-1; j++){
    			System.out.print(board[i][j]+" ");
    		}
    		System.out.println(board[i][board[i].length-1]);
    	}
    	if (!done)System.out.println();
    }
}

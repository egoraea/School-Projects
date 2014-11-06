/*  Student information for assignment:
 *
 *  On my honor, Eric Erickson, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: eje444
 *  email address: egoraea@gmail.com
 *  Grader name: Aaron
 *  Unique section number:53595
 *  Number of slip days I am using: 0
 */
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.UIManager;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class NameSurfer {

	// constants for menu choices
	public static final int SEARCH = 1;
	public static final int ONE_NAME = 2;
	public static final int APPEAR_ONCE = 3;
	public static final int APPEAR_ALWAYS = 4;
	public static final int INCREASING_POPULAR = 5;
	public static final int DECREASING_POPULAR = 6;
	public static final int ALWAYS_POPULAR = 7;
	public static final int QUIT = 8;

	// CS314 students, explain your menu option 7 here:
	/* 1:Searches for data for names containing a set of characters
	 * 2:Searches for data for one name
	 * 3: Names that only appear once in the top 1000
	 * 4: Names that are always in the top 1000
	 * 5: Names that get more popular over time
	 * 6: Names that get less popular over time
	 * 7: Names that have had multiple times in the top 10
	 * 8:Quits
	 * 
	 */
	// CS314 students, Explain your interesting search / trend here:
	/*
	 * Madison, ranks: 896 767 842 973 0 0 0 0 539 37 3
	 * 
	 * 	After being unranked for so long Madison started to come back
	 *  in the 80's which might have to do with the movie Splash coming 
	 *  out and the mermaid in the film picking the name Madison off of a 
	 *  street sign. After that the name became more and more popular 
	 *  even getting up to the 3 spot.
	 * 
	 */

	// CS314 students, add test code for NameRecord class here:
	public static void testNameRecord(){
		int test=1;
		boolean testing = false;
		ArrayList<Integer> test1 = new ArrayList<Integer>();
		test1.add(1);
		test1.add(2);
		NameRecord nR1 = new NameRecord("Sally",test1, 2020, 2);
		//test 1
		testing = nR1.getName().equals("Sally");
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 2
		ArrayList<Integer> test2 = new ArrayList<Integer>();
		test2.add(234);
		test2.add(13);
		NameRecord nR2 = new NameRecord("Frank",test2, 2020, 2);
		testing = nR2.getName().equals("Frank");
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 3
		testing = nR1.getRank(0)==1;
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 4
		testing = nR1.getRank(1)==2;
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 5
		testing = nR1.getMostPop()==2020;
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 6
		test2.remove(0);
		test2.remove(0);
		test2.add(1001);
		test2.add(1001);
		NameRecord nR3 = new NameRecord("Frank",test2, 2020, 2);
		testing = nR3.getMostPop()==2030;
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 7
		testing = nR3.rankDecs()==0;
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 8
		testing = nR1.rankDecs()==2;
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 9
		testing = nR2.topRankDecs() == 0;
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 10
		testing = nR1.topRankDecs() == 2;
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 11
		testing = nR1.everyDec();
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 12
		test2.add(1);
		NameRecord nR4 = new NameRecord("Frank",test2, 2020, 3);
		testing = !nR4.everyDec();
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 13
		testing = !nR1.oneDec();
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 14
		testing = nR4.oneDec();
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 15
		testing = !nR1.morePop();
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 16
		testing = nR2.morePop();
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 17
		testing = nR1.lessPop();
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 18
		testing = !nR2.lessPop();
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 19
		testing = nR3.toString().equals("Frank, ranks: 0 0\n2020: 0\n2030: 0\n");
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 20
		testing = nR4.toString().equals("Frank, ranks: 0 0 1\n2020: 0\n2030: 0\n2040: 1\n");
		if (testing){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
	}
	// main method. Driver for the whole program
	public static void main(String[] args) {
		try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		}
		catch(Exception e) {
		    System.out.println("Unable to set look at feel to local settings. " +
		    		"Continuing with default Java look and feel.");
		}
	    try {
		    //System.out.println("Opening GUI to choose file with names data...");
	        // next line for GUI
		    // Scanner fileScanner = new Scanner(getFile());

		    // next line to skip GUI
	    	//testNameRecord();
		    Scanner fileScanner = new Scanner(new File("names.txt"));
			Names n = new Names(fileScanner);
			fileScanner.close();
			int choice;
			Scanner keyboard = new Scanner(System.in);
			do {
				showMenu();
				choice = getChoice(keyboard);
				if( choice == SEARCH)
					search(n, keyboard);
				else if( choice == ONE_NAME )
					oneName(n, keyboard);
				else if( choice == APPEAR_ONCE )
					appearOnce(n);
				else if( choice == APPEAR_ALWAYS )
					appearAlways(n);
				else if( choice == INCREASING_POPULAR )
					morePop(n);
				else if( choice == DECREASING_POPULAR )
					lessPop(n);
				else if( choice == ALWAYS_POPULAR )
					alwaysPop(n);
				
				else 
					System.out.println("\n\nGoodbye.");

			} while( choice != QUIT);
		}
		catch(FileNotFoundException e) {
			System.out.println("Problem reading the data file. Exiting the program." + e);
		}
	}

	// method that shows names that have appeared in ever decade
	// pre: n != null
	// post: print out names that have appeared in ever decade
	private static void appearAlways(Names n) {
		if (n==null){
    		throw new IllegalArgumentException("Violation of precondition n can't be null" );
    	}
		ArrayList<String> list = n.rankedEveryDecade();
		System.out.println(list.size()+ " names appear in all decades. The names are: ");
		for (String s: list){
			System.out.println(s);
		}
	}

	// method that shows names that have appeared in only one decade
	// pre: n != null
	// post: print out names that have appeared in only one decade
	private static void appearOnce(Names n) {
		if (n==null){
    		throw new IllegalArgumentException("Violation of precondition n can't be null" );
    	}
		ArrayList<String> list = n.rankedOnlyOneDecade();
		System.out.println(list.size()+ " names appear in exactly one decade. The names are: ");
		for (String s: list){
			System.out.println(s);
		}
	}
	
	// method that shows names that have got more popular every decade
		// pre: n != null
		// post: print out names that have got more popular
		private static void morePop(Names n) {
			if (n==null){
	    		throw new IllegalArgumentException("Violation of precondition n can't be null" );
	    	}
			ArrayList<String> list = n.alwaysMorePopular();
			System.out.println(list.size()+ " are more popular in every decade. The names are: ");
			for (String s: list){
				System.out.println(s);
			}
		}
		
		// method that shows names that have got less popular 
		// pre: n != null
		// post: print out names that have got less popular
		private static void lessPop(Names n) {
			if (n==null){
	    		throw new IllegalArgumentException("Violation of precondition n can't be null" );
	    	}
			ArrayList<String> list = n.alwaysLessPopular();
			System.out.println(list.size()+ " names are less popular in every decade.. The names are: ");
			for (String s: list){
				System.out.println(s);
			}
		}
		// method that shows names that have always been pop
		// pre: n != null
		// post: print out names that have always been pop
		private static void alwaysPop(Names n) {
			if (n==null){
	    		throw new IllegalArgumentException("Violation of precondition n can't be null" );
	    	}
			ArrayList<String> list = n.alwaysPopular();
			System.out.println(list.size()+ " names appear multiple times in the top 10 of the rankings. The names are: ");
			for (String s: list){
				System.out.println(s);
			}
		}

	// method that shows data for one name, or states that name has never been ranked
	// pre: n != null, keyboard != null and is connected to System.in
	// post: print out the data for n or a message that n has never been in the top 1000 for any decade
	private static void oneName(Names n, Scanner keyboard) {
		if (n==null){
    		throw new IllegalArgumentException("Violation of precondition n can't be null" );
    	}
		System.out.print("Enter a name: ");
		String fullName =keyboard.nextLine();
		System.out.println();
		int i = n.getIndexOfName(fullName);
		if (i==-1){
			System.out.println(fullName+" does not appear in any decade.");
		}
		else {
			NameRecord nR = n.getName(i);
			System.out.print(nR.toString());
		}

		
	}

	// method that shows all names that contain a substring from the user
	// and the decade they were most popular in
	// pre: n != null, keyboard != null and is connected to System.in
	// post: show the correct data
	private static void search(Names n, Scanner keyboard) {
		if (n==null){
    		throw new IllegalArgumentException("Violation of precondition n can't be null" );
    	}
		System.out.print("Enter a partial name: ");
		String partialName = keyboard.nextLine();
		ArrayList<NameRecord> list=n.getMatches(partialName);
		System.out.println();
		System.out.println("There are "+list.size()+" matches for "+partialName +".");
		System.out.println();
		if (list.size()>0){
			System.out.println("The matches with their highest ranking decade are:");
			for (NameRecord nR : list){
				System.out.println(nR.getName()+" "+nR.getMostPop());
			}
		}
	}

	// get choice from the user
	// keyboard != null and is connected to System.in
	// return an int that is >= SEARCH and <= QUIT
	private static int getChoice(Scanner keyboard) {
		int choice = getInt(keyboard, "Enter choice: ");
		keyboard.nextLine();
		while( choice < SEARCH || choice > QUIT){
			System.out.println("\n" + choice + " is not a valid choice");
			choice = getInt(keyboard, "Enter choice: ");
			keyboard.nextLine();
		}
		return choice;
	}

	// ensure an int is entered from the keyboard
	// pre: s != null and is connected to System.in
    private static int getInt(Scanner s, String prompt) {
        System.out.print(prompt);
        while( !s.hasNextInt() ){
            s.next();
            System.out.println("That was not an int.");
            System.out.print(prompt);
        }
        return s.nextInt();
    }

    // show the user the menu
	private static void showMenu() {
		System.out.println("\nOptions:");
		System.out.println("Enter " + SEARCH + " to search for names.");
		System.out.println("Enter " + ONE_NAME + " to display data for one name.");
		System.out.println("Enter " + APPEAR_ONCE+ " to display all names that appear in only one decade.");
		System.out.println("Enter " + APPEAR_ALWAYS + " to display all names that appear in all decades.");
		// CS314 students fill in other options
		System.out.println("Enter " + INCREASING_POPULAR + " to display all names that are more popular in every decade.");
		System.out.println("Enter " + DECREASING_POPULAR + " to display all names that are less popular in every decade.");
		System.out.println("Enter " + ALWAYS_POPULAR + " to display all names with multiple times in the top 10 of the rankings");
		System.out.println("Enter " + QUIT + " to quit.\n");
	}

	/** Method to choose a file using a traditional window.
     * @return the file chosen by the user. Returns null if no file picked.
     */
    public static File getFile() {
        // create a GUI window to pick the text to evaluate
        JFileChooser chooser = new JFileChooser(".");
        chooser.setDialogTitle("Select File With Baby Names Data.");
        int retval = chooser.showOpenDialog(null);
        File f =null;
        chooser.grabFocus();
        if (retval == JFileChooser.APPROVE_OPTION)
           f = chooser.getSelectedFile();
        return f;
    }

}
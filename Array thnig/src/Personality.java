/**
 * @author: Student 1:Eric Erickson
 *           
 * CS312 Assignment 8.
 *
 *  On MY honor, Eric Erickson, this programming assignment is MY own work
 *  and I have not provided this code to any other student.
 *
 *
 * A program to process data from the Keirsey Temperament Sorter.
 *
 * Student 1: Eric Erickson
 * UTEID: eje444
 * email address: egoraea@gmail.com
 * Section 5 digit ID: 53700
 * Grader name: Megan Avery
 * Number of slip days used on this assignment:
 *

 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Personality {

    // The main method to process the data from the peronality tests
    public static void main(String[] args) throws FileNotFoundException {

		// The calls to construct scanners are suggestions.
		// You can do it your own way.
		Scanner keyboard = new Scanner (System.in);
		Scanner inFileReader = new Scanner(new File (getInFile(keyboard)));
		int subjects = inFileReader.nextInt();
		inFileReader.nextLine();
		for (int i = 1; i<=subjects; i++){
			Subject (inFileReader);
		}
        keyboard.close();
		inFileReader.close();
    }
    //gets data and prints out for each subject
    public static void Subject (Scanner inFileReader){
    	String name = inFileReader.nextLine();
    	String answers = inFileReader.nextLine();
    	char [] results = answers.toCharArray();
    	int [] exov = new int[3];
    	int [] sens = new int[3];
    	int [] thin = new int[3];
    	int [] judg = new int[3];
    	calcData(results, exov, sens, thin, judg);
    	int percOne = calcPerc(exov);
    	int percTwo = calcPerc(sens);
    	int percThree = calcPerc(thin);
    	int percFour = calcPerc(judg);
    	String percentOne ="";
    	String percentTwo="";
    	String percentThree="";
    	String percentFour="";
    	if (percOne >= 0) percentOne += percOne;
    	else percentOne = "NO ANSWERS";
    	if (percTwo >= 0) percentTwo += percTwo;
    	else percentTwo = "NO ANSWERS";
    	if (percThree >= 0) percentThree += percThree;
    	else percentThree = "NO ANSWERS";
    	if (percFour >= 0) percentFour += percFour;
    	else percentFour = "NO ANSWERS";
    	String personal = calcTypes(percOne,percTwo,percThree,percFour);
    	System.out.printf("%28s:%11s%11s%11s%11s = %s\n", name, percentOne, percentTwo, percentThree, percentFour, personal );
    }
    //calculates the number of answers for each type
    public static void calcData (char [] results, int[] exov, int [] sens, int[] thin, int[] judg){
    	char choice;
    	String answers = "AB-";
    	for (int i = 0; i < results.length; i++){
    		choice = results[i];	
    		if ((i+1) % 7 / 2 == 0 && (i+1)%7!=0){
    			exov[answers.indexOf(choice)]++;
    		} else if ((i+1) % 7 /2 == 1) {
    			sens[answers.indexOf(choice)]++;
    		} else if ((i+1) % 7 / 2== 2) {
    			thin[answers.indexOf(choice)]++;
    		} else {
    			judg[answers.indexOf(choice)]++;
    		}
    	}
    }
    //calculates the percentage of B's
    public static int calcPerc (int [] answ) { 
    	int perc = -1;
    	if (answ[1]+answ[0]>0) perc = (int) Math.round((double)(answ[1]*100)/(answ[0]+answ[1]));
    	return perc;
    }
    //figures out the personality types of the person
    public static String calcTypes(int percOne, int percTwo, int percThree, int percFour){
    	String Types = "";
    	if (percOne>50) Types += "I";
    	else if (percOne<50 && percOne >=0) Types += "E";
    	else if (percOne==50) Types += "X"; 
    	else Types += "-";
    	if (percTwo>50) Types += "N";
    	else if (percTwo<50 && percTwo >=0) Types += "S";
    	else if (percTwo==50) Types += "X"; 
    	else Types += "-";
    	if (percThree>50) Types += "F";
    	else if (percThree<50 && percThree >=0) Types += "T";
    	else if (percThree==50) Types += "X"; 
    	else Types += "-";
    	if (percFour>50) Types += "P";
    	else if (percFour<50 && percFour >=0) Types += "J";
    	else if (percFour==50) Types += "X"; 
    	else Types += "-";
    	return Types;
    }
	// Suggested method to get the name of the input file.
	public static String getInFile(Scanner keyboard) {
		System.out.print("Enter the name of the file with the personality data: ");
		String dataFile = keyboard.nextLine();
		System.out.println();
		// ...
		return dataFile;	
	}
	
}

/*
 * CS312 Assignment 7.
 * On my honor, Eric Erickspn, this programming assignment is my own work.
 * Section Number:53700
 *
 * A program to do simple word processing and a spell-check feature.
 *
 *  Name:Eric Erickson
 *  email address:egoraea@gmail.com
 *  UTEID:eje444
 *  Section 5 digit ID: 53700
 *  Grader name:Megan Avery
 *  Number of slip days used on this assignment:0
 */

// Add import statements here.
import java.util.*;
import java.io.*;
public class WordProcessor{
	public static void main (String[] args)throws FileNotFoundException{
		Scanner console = new Scanner(System.in);
		String file = fileInput(console);
		String output = file.replace(".txt", "_OUT.txt.");
		File f = new File (file);
		Scanner text = new Scanner(f);
		PrintStream process = new PrintStream(new File(output));
		int num = topNums(text,process);
		wordProc(text, num, process);
		Scanner test = new Scanner(new File(output));
		tester (test, num);
	}
	// gets the file name
	public static String fileInput (Scanner console) {
		System.out.print("Enter name of file to be processed, including the .txt extension: ");
		return console.next();
	}
	
	//prints the strings of numbers at the top
	public static int topNums (Scanner text,PrintStream process){
		int num = text.nextInt();
		text.nextLine();
		int tens = 0;
		for (int i = 1; i<=num/10; i++){
			for (int j = 1; j<=10;j++) {
			process.print(tens);
			}
		tens++;	
		}
		for (int i = 1; i<=num % 10; i++){
			process.print(tens);
		}
		process.println();
		for (int i = 1; i<=num/10; i++){
			for (int j = 1; j<10; j++) {
			process.print(j);
			}
			process.print("0");
		}
		for (int i = 1; i<=num % 10; i++){
			process.print(i);
		}		
		process.println();
		for (int i = 1; i<= num; i++ ){
			process.print("-");
		}
		process.println();
		return num;
	}
	//capitalizes the first letter
	public static String capit (String next){
		String first = next.substring(0, 1);
		first = first.toUpperCase();
		return first+next.substring(1);
		
	}
	//processes the file
	public static void wordProc(Scanner text, int num, PrintStream process) {
		boolean sentence = true;
		String next ="";
		int extra = 0;
		String line ="";
		while (text.hasNext()){
			line ="";
			

			
			while (line.length()+next.length() <= num){
				line += next+" ";
				if (text.hasNext()){
				next = text.next();
				if (sentence) next = capit(next);
				if (next.contains(".")) sentence = true;
				else sentence = false;		
				}
				else {
					extra = num - line.length()+1;
					for ( int i = 1; i<= extra; i++) {
						line += " ";
						next="";
					}
						
				}
			}
			line = line.substring(0, line.length()-extra-1);
			process.println(line);
			if (!text.hasNext() && !next.equals("")){
				process.println(next);
			}
		}
	}
	//tests if the output fits within the limits
	public static void tester (Scanner test, int num) {
		boolean lineLength = false;
		while (test.hasNextLine() && !lineLength){
			String line = test.nextLine();
			if (line.length() > num) lineLength = true;
		}
		if (lineLength) System.out.println("The maximum output file line length is INCORRECT!!!");
		else System.out.println("The maximum output file line length is CORRECT.");
	}
}




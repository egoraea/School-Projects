/**
 * @author  Eric Erickson
 * @version 10/9/13
 * CS312 Assignment 5.
 *
 * On my honor, Eric Erickson, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *
 * A program to encrypt and decrypt phrases using
 * columnar transposition cipher.
 *
 *  email address: egoraea@gmail.com
 *  UTEID: eje444
 *  Section 5 digit ID:53700	
 *  Grader name:Megan Avery
 *  Number of slip days used on this assignment:0
 */
import java.util.Scanner;

public class Ciphers {
 
    
    public static final int MAX_ROWS = 6;
    // main method to demonstrate various encrytpions and
    // decryptions using a columnar transposition cipher
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        showIntro();
        doEncryptions(keyboard);
        doDecryptions(keyboard);
        showTests();
        keyboard.close();
    }

    // show the introduction to the program
    public static void showIntro() {
        System.out.println("This program demonstrates a transposition cipher.");
        System.out.println("A cipher is an algorithm to encrypt or decrypt a message.");
        System.out.println();
        System.out.println("This program will demonstrate encrypting a message with");
        System.out.println("a columnar transposition cipher both with and without");
        System.out.println("padding characters. The program will then decrypt a message");
        System.out.println("assuming it was encrypted with a columnar transposition cipher");
        System.out.println("with padding.");
        System.out.println();
    }


    // do various encryptions both padded with Xs and
    // not padded
    public static void doEncryptions(Scanner keyboard) {
        // finish this method.
        // Break the problem up into methods
        System.out.println();
    	System.out.println("A demonstration of encrypting with a columnar transposition cipher:");
    	System.out.println();
    	System.out.print("Enter the message to encrypt: ");
    	String message= keyboard.nextLine();
    	System.out.println();
    	System.out.println();
    	System.out.println("Message encrypted with columnar transposition cipher and no padding.");
    	for (int i=2; i<=MAX_ROWS;i++){
        	String encrypted = encryptMessage(message,i);
        	System.out.printf("Encyrpted with %d rows: %s \n", i,encrypted);
        	}
    	System.out.println();
    	System.out.println("Message encrypted with columnar transposition cipher and padding.");
    	System.out.println();
    	for (int i=2; i<=MAX_ROWS;i++){
    	String padMessage = padding(message,i);
    	String encrypted = encryptMessage(padMessage,i);
    	System.out.printf("Clear text padded for %d rows: %s \n", i,padMessage);
    	System.out.printf("Encyrpted with %d rows: %s \n", i,encrypted);
    	System.out.println();
    	}
    }
    public static String padding(String message, int rows){
    	String padMessage=message;
    	while (padMessage.length()%rows!=0){
    		padMessage += "X";
    	}
    	return padMessage;
    }
    public static String encryptMessage (String message, int rows){
    	String encryption ="";
    	double mLength = message.length();
    	//int col = 0;     		
    	
    	while (encryption.length()< mLength){
			for (int j=0; j<rows;j++){
				for (int i=0;i<Math.ceil(mLength/rows);i++){
					int charSpot = i*rows+j;
					if (charSpot<=mLength-1)encryption += message.charAt(charSpot);
				}
			}
		}						
			
		return encryption;
    }
    public static String decryptMessage (String message, int rows){
    	String decrypted ="";
		int mLength= message.length();
		while (decrypted.length()< mLength){
			for (int j=0; j<mLength/rows;j++){
				for (int i=0;i<rows;i++){
					decrypted += message.charAt(i*(mLength/rows)+j);
				}
			}
			
		}
		return decrypted;
    }


    // do the decryptions with the of messages for
    // various values of the number of rows
    public static void doDecryptions(Scanner keyboard) {
        // finish this method.
        // Break the problem up into methods
        System.out.println();
    	System.out.println("A demonstration of decrypting with a columnar transposition cipher:");
    	System.out.println("If the length of the message is not a multiple of the number of rows");
        System.out.println("it will be padded which may throw off the decryption.");
        System.out.println();
    	System.out.print("Enter the message to decrypt: ");
    	String message= keyboard.nextLine();
    	System.out.println();
    	System.out.println();
    	System.out.println("Messages Decrypted with a Columnar Transposition Cipher");
    	System.out.println();
    	for (int i=2; i<=MAX_ROWS;i++){
    	String padMessage = padding(message,i);
    	String decrypted = decryptMessage(padMessage,i);
    	System.out.printf("Decrypted text padded for %d rows: %s \n", i,padMessage);
    	System.out.printf("Decyrpted with %d rows: %s \n", i,decrypted);
    	System.out.println();
    	}

    }


    // show tests of the methods
    public static void showTests() {
        System.out.println();
        System.out.println("This displays automatic tests of the program: ");

        // *** 2 tests for decrypting
        String encryptedMessage = "AEIBFJCGXDHX";
        String expected = "ABCDEFGHIJXX";
        // last 2 int parameters are rows, then test number
        decryptTest(encryptedMessage, expected, 4, 1);

        encryptedMessage = "CPEOURMT!";
        expected = "COMPUTER!";
        decryptTest(encryptedMessage, expected, 3, 2);
        //My decryption tests
        encryptedMessage = "FdxeE!";
        expected = "FedEx!";
        decryptTest(encryptedMessage, expected, 2, 3);
        
        encryptedMessage = "L geoeafng duLseeX";
        expected = "League of LegendsX";
        decryptTest(encryptedMessage, expected, 6, 4);




        // 2 tests for encrypting with padding
        String clearMessage = "Dell_CS_HallXXX";
        expected = "DCleSll_XlHX_aX";
        encryptTest(clearMessage, expected, 5, 1);

        clearMessage = "Texas_LonghornsX";
        expected = "Tsnre_gnxLhsaooX";
        encryptTest(clearMessage, expected, 4, 2);
        //My encryption tests
        clearMessage = "Potato";
        expected = "Paotto";
        encryptTest(clearMessage, expected, 3, 3);
        
        clearMessage = "Odysseus";
        expected = "Oysudses";
        encryptTest(clearMessage, expected, 2, 4);
    }

    public static void decryptTest(String encryptedMessage,
            String expected, int rows, int testNumber) {

        System.out.println();
        String actual = decryptMessage(encryptedMessage, rows);
        System.out.println("expected: " + expected + ", actual: " + actual);
        if(expected.equals(actual))
            System.out.println("passed decrypt test" + testNumber);
        else
            System.out.println("FAILED DECRYPT TEST " + testNumber);
    }

    public static void encryptTest(String clearMessage,
            String expected, int rows, int testNumber) {

        System.out.println();
        String actual = encryptMessage(clearMessage, rows);
        System.out.println("expected: " + expected + ", actual: " + actual);
        if(expected.equals(actual))
            System.out.println("passed encrypt test" + testNumber);
        else
            System.out.println("FAILED ENCRYPT TEST " + testNumber);
    }
}
/**
 * CS312 Assignment 8
 * On my honor, Eric Erickson, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 * Program to decrypt a message that has been
 * encrypted with a substitution cipher.
 * We assume only charcaters with ASCII codes
 * from 32 to 126 inclusive have been encrypted.
 *
 *  email address: egoraea@gmail.com
 *  UTEID:eje444
 *  Section 5 digit ID: 53700
 *  Grader name: Megan Avery
 *  Number of slip days used on this assignment:0
 *
 * Number of slip days I am using:0
 */

import java.util.*;

public class Decrypt {

    public static void main(String[] arg)
    {
    	Scanner scan = new Scanner(System.in);
        String encryptedText = DecryptUtilities.convertFileToString();
        // The other method from DecryptUtilities you will have to use is
        // DecryptUtilities.getDycryptionKey(int[]), but first you need to
        // do get an array with the frequency of all ASCII characters in the
        // encrypted text. Count ALL charcaters from ASCII code 0 to ASCII code 127
        System.out.println("The encrypted text is:");
        System.out.println();
        System.out.println(encryptedText);
        int [] frequency = getFrequency(encryptedText);
        printFrequencies(frequency);
        char[] key = DecryptUtilities.getDecryptionKey(frequency);
        printKey(key);
        String decryptedText = decrypt(encryptedText,key);
        boolean cont = true;
        printDecrypt(cont,decryptedText);
        while (cont){
        	System.out.println("Do you want to make a change to the key?");
        	System.out.print("Enter 'Y' or 'y' to make change: ");
        	char ans = scan.nextLine().charAt(0);
        	if (ans =='y' || ans =='Y'){
        		switchKey(key,scan);
        		decryptedText = decrypt(encryptedText,key);
        		printDecrypt(cont,decryptedText);
        		System.out.println();
        	} else cont = false;
        }
    	System.out.println();
    	printKey(key);
    	printDecrypt(cont,decryptedText);
        
        
    }
    public static void printDecrypt (boolean cont, String decrypted){
    	if (cont) System.out.println("The current version of the decrypted text is:");
    	else System.out.println("The final version of the decrypted text is:");
    	System.out.println();
    	System.out.println(decrypted);
    }
    public static String decrypt(String text, char[] key) {
		char[] enText = text.toCharArray();
		String decrypted ="";
		for (int i = 0; i<enText.length;i++){
			decrypted += key[enText[i]];
		}
		return decrypted;
	}

	public static int[] getFrequency(String text){
    	int[] freq = new int[128];
    	int ch;
    	for (int i =0; i<text.length();i++){
    		ch = text.charAt(i);
    		freq[ch]++;
    	}
    	return freq;
    }
    public static void printFrequencies(int[] frequency){
    	System.out.println("Frequencies of characters.");
    	System.out.println("Character - Frequency");
    	for (int i = ' '; i <= '~';i++){
    		System.out.println((char)i + " - " + frequency[i]);
    		
    	}
    	System.out.println();
    }
    public static void printKey(char[] key){
    	System.out.println("The current version of the key for ASCII characters 32 to 126 is: ");
    	for (int i = ' '; i <= '~'; i++){
    		System.out.println("Encrypt character: "+(char)i+", decrypt character: "+key[i]);
    	}
    	System.out.println();
    }
    public static void switchKey (char[] key, Scanner scan){
    	System.out.print("Enter the character in the decrypted text you want to change: ");
    	char ch1= scan.nextLine().charAt(0);
    	System.out.print("Enter the character you want to change '"+ch1+ "' to: ");
    	char ch2= scan.nextLine().charAt(0);
    	System.out.println("'"+ch1+"' will be swapped with '"+ch2+"' in the decrypted file.");
    	System.out.println();
    	int index1 = search(key,ch1);
    	int index2 = search(key,ch2);
    	key[index1]=ch2;
    	key[index2]=ch1;
    }
    public static int search (char[] key, char ch){
    	int index = -1;
    	for (int i = ' '; i < '~'; i++){
    		if (key[i]==ch) index=i;
    	}
    	return index;
    }
}
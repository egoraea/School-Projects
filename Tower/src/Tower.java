/**
 * @author  Eric Erickson
 * @version 9/11/2013
 * CS312 Assignment 2.
 * On my honor, Eric Erickson, this programming assignment is my own work and I have
 * not shared my solution wiht any other student in the class.
 *
 *
 * A program to print out the UT Tower via ASCII art.
 *
 *  email address: egoraea@gmail.com
 *  UTEID:eje444
 *  Section 5 digit ID:53700
 *  Grader name:Megan Avery
 *  Number of slip days used on this assignment:0
 */

public class Tower
{
    public static final int SIZE =3 ;
  //Prints the Roof/floors of the main part    
    public static void printFloor () {
    	System.out.println () ;
    	for (int i=1; i<=SIZE;i++ ){
    			System.out.print (" ");
    	}
    	for (int i=1;i<=SIZE*2+3;i++){ 
    			System.out.print ("~"); 
    	}

    }
  //Prints the Windows of The Middle  
    public static void printWindow () {
      	System.out.println();
      	for (int i=1; i<=SIZE;i++ ){
			System.out.print (" ");
	}
      	System.out.print("|");
    	for (int i=1; i<=SIZE; i++){
    		System.out.print ("-O");
    	}
    	System.out.print("-|");
    }
  //Prints the Top
    public static void printTop () {
    	System.out.println () ;
    	for (int i=1; i<=SIZE+2;i++ ){
    		System.out.print (" ");	
    	}
    	for (int i=1; i<=SIZE*2-1;i++ ){
    		System.out.print("#");
    	}
    }
  //Prints the Bars of Top part  
    public static void printBars (){
    	System.out.println () ;
    	for (int i=1; i<=SIZE+2;i++ ){
    		System.out.print (" ");	
    	}
    	for (int i=1; i<=SIZE*2-1;i++ ){
    		System.out.print("|");
    	}
    }
  //Prints the Bottom
    public static void printBot () {
    	System.out.println();
    	System.out.print("/");
    	for (int i=1; i<=SIZE*2; i++){
    		System.out.print ("\"O");
    	}
    	System.out.print("\"\\");
    }
  //Prints the Diagonals  
    public static void printDiagonal () {
  
    	for (int i=1;i<=SIZE/2+1; i++){
    	  	System.out.println () ;
    		for (int j=1;j<=SIZE-2*i+2;j++){
    			System.out.print(" ");
    		}
    		System.out.print("/");
    		for (int j=1;j<=SIZE+2*i-2;j++){
    			System.out.print("\"'");
    		}
    		System.out.print("\"\\");
    	}
    }
  //  
    public static void main(String[] args)
    {
       printTop();
       for (int i=1;i<=SIZE*2-2; i++){
     	  printBars();
       }
       printTop();
       for (int i=1;i<=SIZE*SIZE; i++){
    	   printFloor();
    	   printWindow();
       }
       printFloor();
       printDiagonal ();
      for (int i=1;i<=SIZE; i++){
    	  printBot();
      }
       
    	
    }
}

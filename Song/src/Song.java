/*
 * CS312 Assignment 1.
 * On my honor, Eric Erickson, this programming assignment is my own work.
 * Section Number:53700	
 *
 * A program to print out the lyrics to the
 * children's song, "There was an old woman".
 *
 *  Name: Eric Erickson
 *  email address: egoraea@gmail.com
 *  UTEID: eje444
 *  Section 5 digit ID:53700	
 *  Grader name:Megan Avery
 *  Number of slip days used on this assignment:0
 */


public class Song {
	public static void partOne() {
		System.out.println("I don't know why she swallowed that fly,");
		System.out.println("Perhaps she'll die.");
		System.out.println();
	}
	public static void partTwo() {
		System.out.println("She swallowed the spider to catch the fly,");
		partOne();
	}
	public static void partThree() {
		System.out.println("She swallowed the bird to catch the spider,");
		partTwo();
	}
	public static void partFour() {
		System.out.println("She swallowed the cat to catch the bird,");
		partThree();
	}
	public static void partFive() {
		System.out.println("She swallowed the dog to catch the cat,");
		partFour();
	}
	public static void partSix() {
		System.out.println("She swallowed the goat to catch the dog,");
		partFive();
	}
	public static void partSeven() {
		System.out.println("She swallowed the cow to catch the goat,");
		partSix();
	}
	public static void verse1() {
		System.out.println("There was an old woman who swallowed a fly.");
		partOne();
	}
	public static void verse2() {
		System.out.println("There was an old woman who swallowed a spider,");
		System.out.println("That wriggled and iggled and jiggled inside her.");
		partTwo();
	}
	public static void verse3() {
		System.out.println("There was an old woman who swallowed a bird,");
		System.out.println("How abusrd to swallow a bird.");
		partThree();
	}
	public static void verse4() {
		System.out.println("There was an old woman who swallowed a cat,");
		System.out.println("Imagine that to swallow a cat.");
		partFour();
	}
	public static void verse5() {
		System.out.println("There was an old woman who swallowed a dog,");
		System.out.println("What a hog to swallow a dog.");
		partFive();
	}
	public static void verse6() {
		System.out.println("There was an old woman who swallowed a goat,");
		System.out.println("She just opened her throat to swallow a goat.");
		partSix();
	}
	public static void verse7() {
		System.out.println("There was an old woman who swallowed a cow,");
		System.out.println("I don't know how she swallowed a cow.");
		partSeven();
	}
	public static void verse8() {
		System.out.println("There was an old woman who swallowed a horse,");
		System.out.println("She died of course.");
	}
	public static void main(String[] args) {
		verse1();
	
		verse2();		
	
		verse3();		
	
		verse4();		
		
		verse5();
	
		verse6();
	
		verse7();
	
		verse8();
		
		
	}
	
}


/* CS 314 STUDENTS: FILL IN THIS HEADER AND THEN COPY AND PASTE IT TO YOUR
 * LetterInventory.java AND AnagramSolver.java CLASSES.
 *
 * Student information for assignment:
 *
 *  On my honor, Eric Erickson, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID:eje444
 *  email address: egoraea@gmail.com
 *  Grader name:Aaron
 *  Number of slip days I am using:0
 */

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class AnagramFinderTester {

    private static final String testCaseFileName = "testCaseAnagrams.txt";
    private static final String dictionaryFileName = "d3.txt";

    public static void main(String[] args) {
        LetterInventory lets1 = new LetterInventory("");
        boolean success = false;
        int test = 1;
        // CS314 Students, delete the above tests when you turn in your assignment
        // CS314 Students add your LetterInventory tests here. 
       //test 1
        success = lets1.isEmpty();
        if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
        //test 2
        lets1 = new LetterInventory("abcdef");
        success = !lets1.isEmpty();
        if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
        //test 3
        success = lets1.get('a')==1;
        if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
        //test 4
        success = lets1.get('b')==1;
        if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
        //test 5
        success = lets1.equals(lets1);
        if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
        //test 6
        LetterInventory lets2 = new LetterInventory("abcdef");
        success = lets1.equals(lets2);
        if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
        //test 7
        success = lets1.equals(lets1.add(new LetterInventory("")));
        if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
        //test 8
        LetterInventory lets3 = new LetterInventory("abc");
        LetterInventory lets4 = new LetterInventory("def");
        success = lets1.equals(lets3.add(lets4));
        if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
        //test 9
        success = lets3.equals(lets1.subtract(lets4));
        if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
        //test 10
        success = lets1.equals(lets1.subtract(new LetterInventory("")));
        if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
        //test 11
        success = lets1.size()==6;
        if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
        //test 12
        success = lets3.size()==3;
        if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
        //test 13
        success = lets1.toString().equals("abcdef");
        if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
        //test 14
        success = lets3.toString().equals("abc");
        if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;


    }

    private static boolean getChoiceToDisplayAnagrams() {
        Scanner console = new Scanner(System.in);
        System.out.print("Enter y or Y to display anagrams during tests: ");
        String response = console.nextLine();
        return response.length() > 0 && response.toLowerCase().charAt(0) == 'y';
    }

    public static boolean showTestResults(Object expected, Object actual, int testNum, String featureTested) {
        System.out.println("Test Number " + testNum + " testing " + featureTested);
        System.out.println("Expected result: " + expected);
        System.out.println("Actual result: " + actual);
        boolean passed = (actual == null && expected == null) || actual.equals(expected);
        if(passed)
            System.out.println("Passed test " + testNum);
        else
            System.out.println("!!! FAILED TEST !!! " + testNum);
        System.out.println();
        return passed;
    }

    /**
     * Method to run tests on Anagram solver itself.
     * pre: the files d5.txt and testCaseAnagrams.txt are in the local directory
     * 
     * assumed format for file is
     * <NUM_TESTS>
     * <TEST_NUM>
     * <MAX_WORDS>
     * <PHRASE>
     * <NUMBER OF ANAGRAMS>
     * <ANAGRAMS>
     */
    private static void runAnagramTests(AnagramSolver solver, boolean displayAnagrams) {
        int solverTestCases = 0;
        int solverTestCasesPassed = 0;
        Stopwatch st = new Stopwatch();
        try {
            Scanner sc = new Scanner(new File(testCaseFileName));
            final int NUM_TEST_CASES = Integer.parseInt(sc.nextLine().trim());
            System.out.println(NUM_TEST_CASES);
            for(int i = 0; i < NUM_TEST_CASES; i++) {
                // expected results
                TestCase currentTest = new TestCase(sc);
                solverTestCases++;
                st.start();
                // actual results
                List<List<String>> actualAnagrams = solver.getAnagrams(currentTest.phrase, currentTest.maxWords);
                st.stop();
                if(displayAnagrams) {
                    displayAnagrams("actual anagrams", actualAnagrams);
                    displayAnagrams("expected anagrams", currentTest.anagrams);
                }


                if(checkPassOrFailTest(currentTest, actualAnagrams))
                    solverTestCasesPassed++;
                System.out.println("Time to find anagrams: " + st.time());
            }
        }
        catch(Exception e) {
            System.out.println("\nProblem while running test cases on AnagramSolver. Check" +
                    " that file testCaseAnagrams.txt is in the correct location.");
            System.out.println(e);
            System.out.println("AnagramSolver test cases run: " + solverTestCases);
            System.out.println("AnagramSolver test cases failed: " + (solverTestCases - solverTestCasesPassed));
        }
        System.out.println("\nAnagramSolver test cases run: " + solverTestCases);
        System.out.println("AnagramSolver test cases failed: " + (solverTestCases - solverTestCasesPassed));
    }


    // print out all of the anagrams in a list of anagram
    private static void displayAnagrams(String type,
            List<List<String>> anagrams) {

        System.out.println("Results for " + type);
        System.out.println("num anagrams: " + anagrams.size());
        System.out.println("anagrams: ");
        for(List<String> singleAnagram : anagrams)
            System.out.println(singleAnagram);
    }


    // determine if the test passed or failed
    private static boolean checkPassOrFailTest(TestCase currentTest,
            List<List<String>> actualAnagrams) {
        System.out.println();
        if(actualAnagrams.equals(currentTest.anagrams)) {
            System.out.println("Passed test " + currentTest.testCaseNumber);
            return true;
        }
        else{
            System.out.println("\nFailed test case " + currentTest.testCaseNumber);
            System.out.println("Phrase: " + currentTest.phrase + ", max words: " + currentTest.maxWords + ". Recall 0 means no limit.");
            System.out.println("Expected number of anagrams: " + currentTest.anagrams.size());
            System.out.println("Actual number of anagrams: " + actualAnagrams.size());
            if(currentTest.anagrams.size() == actualAnagrams.size()) {
                System.out.println("Sizes the same, but either a difference in anagrams or anagrams not in correct order.");
            }
            System.out.println();
            return false;
        }  
    }

    // class to handle the parameters for an anagram test 
    // and the expected reuslt
    private static class TestCase {

        private int testCaseNumber;
        private String phrase;
        private int maxWords;
        private List<List<String>> anagrams;

        // pre: sc is positioned at the start of a test case
        private TestCase(Scanner sc) {
            testCaseNumber = Integer.parseInt(sc.nextLine().trim());
            maxWords = Integer.parseInt(sc.nextLine().trim());
            phrase = sc.nextLine().trim();
            anagrams = new ArrayList<List<String>>();
            readAndStoreAnagrams(sc);
        }

        // pre: sc is positioned at the start of the resulting angrams
        // read in the number of angrams and then for each anagram:
        //  - read in the line
        //  - break the line up into words
        //  - create a new list of Strings for the anagram
        //  - add each word to the anagram
        //  - add the anagram to the list of anagrams
        private void readAndStoreAnagrams(Scanner sc) {
            int numAnagrams = Integer.parseInt(sc.nextLine().trim());
            for(int j = 0; j < numAnagrams; j++){
                String[] words = sc.nextLine().split("\\s+");
                ArrayList<String> anagram = new ArrayList<String>();
                for(String st : words)
                    anagram.add(st);
                anagrams.add(anagram);
            }
            assert anagrams.size() == numAnagrams : "Wrong number of angrams read or expected";
        }
    }
}



/*  Student information for assignment:
 *
 *  On my honor, <NAME>, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name: Eric Erickson
 *  email address: egoraea@gmail.com
 *  UTEID: eje444
 *  Section 5 digit ID: 53595 
 *  Grader name: Aaron
 *  Number of slip days used on this assignment:
 */

// add imports as necessary

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.TreeMap;


public class HangmanManager {

    // instance vars
	private ArrayList<String> wordList;
	private boolean debug;
	private ArrayList<String> currentList;
	private int guesses;
	private ArrayList<Character> guessed;
    private int diffic;
    private int turn;
    private String pattern;
    
    public HangmanManager(List<String> words, boolean debugOn) {
    	wordList = new ArrayList<String>(words);
    	debug = debugOn;
    }
    public HangmanManager(List<String> words){
    	this(words,false);
    }
    
    // pre: none
    // post: return the number of words in the original Dictionary with the given length
    public int numWords(int length) {
        int total = 0;
    	for (String s: wordList){
        	if (s.length()==length)
        		total++;    		
        }
    	return total;
    }


    // pre: numWords(wordLen) > 0, numGuesses >= 1, diff = HangmanMain.EASY, HangmanMain.MEDIUM, or HangmanMain.HARD
    public void prepForRound(int wordLen, int numGuesses, int diff) {
    	if(numWords(wordLen)<=0 && numGuesses<1 && 
    			(diff!=HangmanMain.HARD||diff!=HangmanMain.MEDIUM||diff!=HangmanMain.HARD) ) 
            throw new IllegalArgumentException("Violation of precondition: " +
            		"There must be words of that length, guesses must be at least 1 "
            		+ "and the diffculty must be one of the options");
    	StringBuffer sb = new StringBuffer();
    	turn = 1;
    	guesses = numGuesses;
    	diffic = diff;
    	currentList = new ArrayList<String>();
    	guessed = new ArrayList<Character>();
    	for (String s : wordList){
    		if (s.length()==wordLen){
    			currentList.add(s);
    		}
    	}
    	for (int i = 0; i<wordLen; i++){
    		sb.append("-");
    	}
    	pattern=sb.toString();
    }
    
    
    // pre: none
    // return the number of words that are still posibilities
    public int numWordsCurrent() {
        return currentList.size();
    }
    
    
    // pre: none
    // return number of wrong guesses left in this game
    public int getGuessesLeft() {
        return guesses;
    }
    
    
    // pre: none
    // post: return a String version of the guesses made so far
    public String getGuessesMade() {
        return guessed.toString();
    }
    
    
    // pre: none
    // post: return true if guess has already been used, false otherwise
    public boolean alreadyGuessed(char guess) {
        return guessed.contains(guess);
    }
    
    
    // get the current pattern. (In other words the revealed characters and '-'s
    // for characters not yet revealed.
    public String getPattern() {
        return pattern;
    }
    
    
    // pre: !alreadyGuessed(ch)
    // post: return a tree map with the resulting patterns and the number of
    // words in each of the new patterns.
    // the return value is for testing and debugging purposes
    public TreeMap<String, Integer> makeGuess(char guess) {
    	if(alreadyGuessed(guess) ) 
            throw new IllegalArgumentException("Violation of precondition: " +
            		"Char can't already be guessed");
    	TreeMap<String,Integer> result = new TreeMap<String,Integer>();
    	 TreeMap<String, ArrayList<String>> words = new  TreeMap<String, ArrayList<String>>();
    	String currPatt = pattern;
    	addGuess(guess);
    	//finds all patterns and puts them in the treemaps
    	for (String s : currentList){
    		String patt = wordPattern(s,guess);
    		if (result.containsKey(patt)){
    			int i = result.get(patt);
    			result.put(patt, i+1);
    		} else{
    			result.put(patt, 1);
    			words.put(patt,new ArrayList<String>());
    		}
			words.get(patt).add(s);
    	}
    	pattern = newPattern(result);
    	//updates currentList
    	currentList = words.get(pattern);
    	//if nothing new was revealed they lose a guess
     	if (currPatt.equals(pattern)){
    		guesses--;
    	}
    	turn++;
        return result;
    }
    
    //puts guess in list of guesses
    private void addGuess(char guess){
    	boolean added = false;
    	int position = 0;
    	//adds guess into correct position
    	while(!added){
    		if (position>guessed.size()-1){
    			guessed.add(guess);
    			added=true;
    		}else if (guess<guessed.get(position)){
    			guessed.add(position, guess);
      			added=true;
    		} else {
    			position++;
    		}
    	}
    	
    }
    //finds the pattern for one word
    private String wordPattern(String s, char guess){
    	StringBuffer sb = new StringBuffer();
    	for (int i = 0; i<s.length();i++){
    		if (s.charAt(i)==guess){
    			sb.append(guess);
    		} else {
    			sb.append(pattern.charAt(i));
    		}
    	}
    	return sb.toString();
    }
    //finds the new pattern from all the patterns
    private String newPattern(TreeMap<String, Integer> round){
    	if (round.size()==1){
    		return round.firstKey();
    	}
    	boolean secHard = false;
    	if ((diffic==HangmanMain.EASY&&turn%2==0)||(diffic==HangmanMain.MEDIUM&&turn%4==0)){
    		secHard = true;
    	}
    	int max = 0;
    	String pattMax = "";
    	int second = 0;
    	String pattSec = "";
    	//goes through every key to find the max
    	for(String s: round.keySet()){
    		int num = round.get(s);
    		if (num>max){
    			second = max;
    			max = num;
    			pattSec = pattMax;
    			pattMax = s;
    		} else if (num == max){
    			if (solveTie(pattMax,s)>0){
    				pattMax = s;
    			}
    		} else if (num>second){
    			second = num;
    			pattSec = s;
    		} else if (num==second){
			if (solveTie(pattSec,s)>0){
    				pattSec = s;
    			}
    		}
    	}
    	if (secHard){
    		return pattSec;
    	}
    	return pattMax;
    }
    //solves a tie between two patterns
    private int solveTie(String s1, String s2) {
    	int dashes1 = 0;
    	int dashes2 = 0;
    	for (int i = 0; i<s1.length();i++){
    		if (s1.charAt(i)=='-'){
    			dashes1++;
    		}
    		if (s2.charAt(i)=='-'){
    			dashes2++;
    		}
    	}
    	if (dashes1 - dashes2 != 0){
    		return dashes2 - dashes1;
    	}
		return s1.compareTo(s2);
	}
	// pre: numWordsCurrent() > 0
    // return the secret word the manager picked 
    // if there is more than one word left, pick one at random
    public String getSecretWord() {
    	if(numWordsCurrent()<=0 ) 
            throw new IllegalArgumentException("Violation of precondition: " +
            		"There must be at least one word in the list");
    	if (currentList.size()==1)
    		return currentList.get(0);
    	else {
    	    Random r = new Random();
    		return currentList.get(r.nextInt(currentList.size()));
    	}
    }
}
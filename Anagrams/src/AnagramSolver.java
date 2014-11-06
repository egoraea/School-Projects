/* 
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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.HashMap;


public class AnagramSolver {
	//for comparing
	private static class AnagramComparator implements Comparator<List<String>> {
		public int compare(List<String> a1, List<String> a2) {
			if (a1.size()!=a2.size()){
				return a1.size()-a2.size();
			} else {
				for (int i = 0;i<a1.size();i++){
					if (!a1.get(i).equals(a2.get(i))){
						return a1.get(i).compareTo(a2.get(i));
					}
				}
			}
			return 0;
        }
    }
	private HashMap<String, LetterInventory> dict;
	
	public AnagramSolver(List<String> dictionary){
		dict = new HashMap<String, LetterInventory>();
		for (String s: dictionary){
			dict.put(s, new LetterInventory(s));
		}
	}
	//gets anagrams for a word
	public List<List<String>> getAnagrams(String word,int max){
		if(word == null || max<0 || new LetterInventory(word).size()==0){
			throw new IllegalArgumentException();
		}
		LetterInventory letter = new LetterInventory(word);
		ArrayList<String> validWords = new ArrayList<String>();
		//check for which words are valid at all for this word 
		for (String s: dict.keySet()){
			if(letter.subtract(new LetterInventory(s))!=null){
				validWords.add(s);
			}
		}
		//creating variables for recursion
		ArrayList<List<String>> result = new ArrayList<List<String>>();
		ArrayList<String> words = new ArrayList<String>();
		//calling recursion method
		recAnagram(0,max,letter,words,result,validWords,0);
		//sorting result
		Collections.sort(result, new AnagramComparator());
		return result;
	}
	//makes deep copy of arraylist
	private ArrayList<String> copy(ArrayList<String> words){
		ArrayList<String> result = new ArrayList<String>();
		for(String s : words){
			result.add(s);
		}
		return result;
	}
	//recursive method to get anagrams
	private void recAnagram(int index,int maxWords,LetterInventory letters,ArrayList<String> words,ArrayList<List<String>> anagrams,
			ArrayList<String> validWords,int indexOfList){	
		//if no more letters done
		if (letters.isEmpty()){
			if(words.size()<=maxWords || maxWords==0){
				ArrayList<String> temp = copy(words);
				Collections.sort(temp);
				anagrams.add(temp);
			return;
			}
		} 
		//if too many words stop
		if (words.size()>=maxWords&&maxWords!=0){
			return;
		}
		
		//for everyword from this one on check if it works
		for (int i = indexOfList; i<validWords.size();i++){
			String s = validWords.get(i);
			LetterInventory temp = letters.subtract(dict.get(s));
			if (temp!=null) {
				words.add(s);
				recAnagram(index+1,maxWords, temp,words,anagrams,validWords,i);
				words.remove(index);
			}	
		}
	}
}
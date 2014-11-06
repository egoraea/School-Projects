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
public class LetterInventory {
	private int[] letters;
	private int size;
	public LetterInventory(String word){
		letters = new int[26];
		size = 0;
		word = word.toLowerCase();
		for (int i = 0; i<word.length();i++){
			char ch = word.charAt(i);
			if( 'a' <= ch && ch <= 'z'){
				letters[ch-'a']++;
				size++;
			}
		}
	}
	//returns size
	public int size(){
		return size;
	}
	//returns if inventory is empty
	public boolean isEmpty(){
		return size==0;
	}
	//gets a characters frequency
	public int get(char ch){
		String temp = ""+ch;
		temp = temp.toLowerCase();
		ch = temp.charAt(0);
		return letters[ch-'a'];
	}
	//adds two letter inventories
	public LetterInventory add(LetterInventory other){
		LetterInventory temp = new LetterInventory("");
		for (int i = 0;i<letters.length;i++){
			temp.letters[i]=letters[i]+other.letters[i];
		}
		temp.size=other.size+size;
		return temp;
	}
	//subracts two Letter Inventories
	public LetterInventory subtract(LetterInventory other){
		LetterInventory temp = new LetterInventory("");
		for (int i = 0;i<this.letters.length;i++){
			if (this.letters[i]-other.letters[i]<0)
				return null;
			else
				temp.letters[i]=this.letters[i]-other.letters[i];
		}
		temp.size=size-other.size;
		return temp;
	}
	//converts to String
	public String toString(){
		StringBuilder sb = new StringBuilder();
		for (int i = 0;i<letters.length;i++){
			for(int j = 0; j<letters[i];j++){
				sb.append((char)(i+'a'));
			}
		}
		return sb.toString();
	}
	//checks if an Object is equal to this inventory
	public boolean equals(Object other){
		if(other == null)
            return false; 
		else if(this.getClass() != other.getClass())
            return false;
        else if(this == other)
	        return true; 
        else {
        	LetterInventory otherInventory = (LetterInventory)other;
        	for (int i = 0;i<letters.length;i++){
			if(letters[i]!=otherInventory.letters[i])
					return false;
        	}
		}
		return true;
	}
}




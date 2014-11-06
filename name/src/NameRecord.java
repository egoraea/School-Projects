/*  Student information for assignment:
 *
 *  On my honor, Eric Erickson, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: eje444
 *  email address: egoraea@gmail.com
 *  Grader name: Aaron
 *  Unique section number:53595
 *  Number of slip days I am using: 0
 */
import java.util.ArrayList;
public class NameRecord {
	private String name;
	private ArrayList<Integer> freq = new ArrayList<Integer>();
	private int start;
	private int numDecs;
	
	public NameRecord(String Name, ArrayList<Integer> ranks, int Start, int decs){
		name = Name;
		freq.addAll(ranks);
		start = Start;	
		numDecs = decs;
	}
	//gets the name
	public String getName(){
		return name;
	}
	//gets rank for a certain decade
	public int getRank(int decade){
		if (decade>=numDecs){
    		throw new IllegalArgumentException("Violation of precondition must be within range of decades" );
    	}
		int rank = freq.get(decade);
		if (rank == 1001){
			rank=0;
		}
		return rank;
	}
	//finds most popular decade
	public int getMostPop(){
		int pop = 1002;
		int popYear=0;
		for(int i = 0; i<freq.size();i++){
			if (freq.get(i)<=pop){
				popYear=i;
				pop=freq.get(i);
			}
		}
		return start+(popYear*10);
	}
	//number of ranked decades
	public int rankDecs(){
		int total = 0;
		for (int i = 0;i<freq.size(); i++){
			if (freq.get(i)<1001){
				total++;
			}
		}
		return total;
	}
	//years in top 10
	public int topRankDecs(){
		int total = 0;
		for (int i = 0;i<freq.size(); i++){
			if (freq.get(i)<=10){
				total++;
			}
		}
		return total;
	}
	//if every decade was ranked
	public boolean everyDec(){
		return !freq.contains(1001);
	}
	//if only one decade was ranked
	public boolean oneDec(){
		return rankDecs()==1;
	}
	//if it gets more popular every decade
	public boolean morePop(){
		for (int i = 0; i<freq.size()-1;i++){
			if (freq.get(i)<=freq.get(i+1)){
				return false;
			}
		}
		return true;
	}
	//if it gets less popular with every decade
	public boolean lessPop(){
		for (int i = 0; i<freq.size()-1;i++){
			if (freq.get(i)>=freq.get(i+1)){
				return false;
			}
		}
		return true;
	}
	//to string method
	public String toString(){
		String result = "";
		result+=getName()+", ranks:";
		for (int i : freq){
			if (i==1001){
				i = 0;
			}
			result+=" "+i;
		}
		result+="\n";
		for (int i = 0; i < freq.size(); i++){
			int j = freq.get(i);
			if (j==1001){
				j=0;
			}
			result+=(start+i*10)+": "+j+"\n";
		}
		return result;
	}
}

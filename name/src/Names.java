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
import java.util.Scanner;
public class Names {
	private int start;
	private int decs;
	private ArrayList<NameRecord> list = new ArrayList<NameRecord>();
	private ArrayList<String> names = new ArrayList<String>();
	
	public Names(Scanner fileScanner) {
		start = fileScanner.nextInt();
		decs = fileScanner.nextInt();
		String line;
		while( fileScanner.hasNextLine() ){
		    line = fileScanner.nextLine();
		    Scanner s = new Scanner(line);
		    String name = "";
		    if (s.hasNext()){
		    name = s.next();
		    }
		    ArrayList<Integer> ranks = new ArrayList<Integer>();
		    while (s.hasNextInt()){
		    	int i = s.nextInt();
		    	if (i==0){
		    		i=1001;
		    	}
		    	ranks.add(i);
		    }
		    //checks if right amount of ranks
		    if (ranks.size()==decs){
		    	NameRecord n = new NameRecord(name, ranks, start,decs);
		    	list.add(n);
		    	names.add(name);
		    }
		    s.close();
		}
	}
	//returns a names NameRecord for an index
	public NameRecord getName(int index){
		return list.get(index);
	}
	//gets index of a given name
	public int getIndexOfName(String fullName){
		fullName = fullName.substring(0,1).toUpperCase()+fullName.substring(1).toLowerCase();
		return names.indexOf(fullName);
	}
	//checks for partial parts of a name
	public ArrayList<NameRecord> getMatches(String partialName){
		partialName=partialName.toLowerCase();
		ArrayList<NameRecord> result = new ArrayList<NameRecord>();
		for (int i = 0;i<names.size();i++){
			String s = names.get(i).toLowerCase();
			if (s.contains(partialName)){
				result.add(list.get(i));
			}
		}	
		return result;
	}
	//returns all name ranked in every decade
	public ArrayList<String> rankedEveryDecade(){
		ArrayList<String> result = new ArrayList<String>();
		for (NameRecord n : list){
			if (n.everyDec()){
				result.add(n.getName());
			}
		}	
		return result;
	}
	//returns all names ranked in only one decade
	public ArrayList<String> rankedOnlyOneDecade(){
		ArrayList<String> result = new ArrayList<String>();
		for (NameRecord n : list){
			if (n.oneDec()){
				result.add(n.getName());
			}
		}	
		return result;
	}
	//returns names increasing in popularity
	public ArrayList<String> alwaysMorePopular(){
		ArrayList<String> result = new ArrayList<String>();
		for (NameRecord n : list){
			if (n.morePop()){
				result.add(n.getName());
			}
		}	
		return result;
	}
	//returns all names decreasing in popularity
	public ArrayList<String> alwaysLessPopular(){
		ArrayList<String> result = new ArrayList<String>();
		for (NameRecord n : list){
			if (n.lessPop()){
				result.add(n.getName());
			}
		}	
		return result;
	}
	//returns all names of multiple top 10s
	public ArrayList<String> alwaysPopular(){
		ArrayList<String> result = new ArrayList<String>();
		for (NameRecord n : list){
			if (n.topRankDecs()>=2){
				result.add(n.getName());
			}
		}	
		return result;
	}
}

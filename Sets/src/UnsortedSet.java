/*  Student information for assignment:
 *
 *  On MY honor, Eric Erickson, this programming assignment is MY own work
 *  and I have not provided this code to any other student.
 *
 *  Number of slip days used: 1
 *
 *  Student 1 (Student whose turnin account is being used)
 *  UTEID: eje444
 *  email address: egoraea@gmail.com
 *  Grader name: Aaron
 *  Section number: 53595

 */

import java.util.Iterator;
import java.util.ArrayList;

/**
 * A simple implementation of an ISet. 
 * Elements are not in any particular order.
 * Students are to implement methods that 
 * were not implemented in AbstractSet and override
 * methods that can be done more efficiently. 
 * An ArrayList must be used as the internal storage container.
 *
 */
public class UnsortedSet<E> extends AbstractSet<E> {
	private ArrayList<E> myCon;
	
	public UnsortedSet(){
		myCon = new ArrayList<E>();
	}
	//Big O(N)
	public boolean add(E item) {
		if( item == null)
            throw new IllegalArgumentException();
		if (!myCon.contains(item)){
			myCon.add(item);
			return true;
		}
		return false;
	}
	//Big O(N)
	public void clear(){
		myCon.clear();
	}
	//Big O(N^2)
    public ISet<E> difference(ISet<E> otherSet){
    	if( otherSet == null)
            throw new IllegalArgumentException();
    	UnsortedSet<E> result = new UnsortedSet<E>();
    	for (E item: this){
    		if (!otherSet.contains(item)){
    			result.myCon.add(item);
    		}
    	}
    	return result;
    }
  //Big O(N^2)
	public ISet<E> intersection(ISet<E> otherSet) {
		if( otherSet == null)
            throw new IllegalArgumentException();
		UnsortedSet<E> result = new UnsortedSet<E>();
    	for (E item: this){
    		if (otherSet.contains(item)){
    			result.myCon.add(item);
    		}
    	}
    	return result;
	}

	//Big O(1)
	public Iterator<E> iterator() {
		return myCon.iterator();
	}
	//Big O(1)
	public int size(){
		return myCon.size();
	}
	//Big O(N^2)
	public ISet<E> union(ISet<E> otherSet){
		if( otherSet == null)
            throw new IllegalArgumentException();
		UnsortedSet<E> result = new UnsortedSet<E>();
		result.addAll(this);
    	result.addAll(otherSet);
    	return result;
    }
}
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
 * In this implementation of the ISet interface the elements in the Set are 
 * maintained in ascending order.
 * 
 * The data type for E must be a type that implements Comparable.
 * 
 * Students are to implement methods that were not implemented in AbstractSet 
 * and override methods that can be done more efficiently. An ArrayList must 
 * be used as the internal storage container. For methods involving two set, 
 * if that method can be done more efficiently if the other set is also a 
 * SortedSet do so.
 */
public class SortedSet<E extends Comparable<? super E>> extends AbstractSet<E> {

    private ArrayList<E> myCon;
    /**
     * create an empty SortedSet
     */
  //Big O(1)
    public SortedSet() {
    	myCon = new ArrayList<E>();
    }

    /**
     * create a SortedSet out of an unsorted set. <br>
     * @param other != null
     */
  //Big O(NlogN)
    public SortedSet(ISet<E> other) {
    	if( other == null)
            throw new IllegalArgumentException();
    	myCon = new ArrayList<E>();
    	for (E item : other){
			myCon.add(item);
		}
    	if(!other.getClass().equals(this.getClass())){
    		mergeSort(myCon,0,size()-1);
    	}
    }
  //Big O(N)
    private void merge(ArrayList<E> list, int leftPos, int rightEnd,int center){
    	ArrayList<E> temp = new ArrayList<E>();
    	int tempLeft = leftPos;
    	int tempRight = center+1;
    	while (tempLeft<=center && tempRight<=rightEnd){
    		if (list.get(tempLeft).compareTo(list.get(tempRight))<0){
    			temp.add(list.get(tempLeft));
    			tempLeft++;
    		} else {
    			temp.add(list.get(tempRight));
    			tempRight++;
    		}
    	}
    	while (tempLeft<=center){
    			temp.add(list.get(tempLeft));
    			tempLeft++;	
    	}
    	
    	while (tempRight<=rightEnd){
    			temp.add(list.get(tempRight));
    			tempRight++;
    	}
          	for (int i = leftPos; i<=rightEnd; i++){
    		list.set(i, temp.get(i-leftPos));
    	}
    }
  //Big O(NlogN)
    private void mergeSort(ArrayList<E> list, int leftPos, int rightEnd){
    	if(leftPos<rightEnd){
    		int center = (rightEnd+leftPos)/2;
    		mergeSort(list,leftPos,center);
    		mergeSort(list,center+1,rightEnd);
    		merge(list,leftPos,rightEnd,center);
    	}
    }
    /**
     * Big O(1)
     * Return the smallest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the smallest element in this SortedSet.
     */
    public E min() {
    	if( size() != 0 )
            throw new IllegalArgumentException();
    	return myCon.get(0);
    }

    /**
     * Big O(1)
     * Return the largest element in this SortedSet.
     * <br> pre: size() != 0
     * @return the largest element in this SortedSet.
     */
    public E max() {
    	if( size() != 0 )
            throw new IllegalArgumentException();
    	return myCon.get(size()-1);
    }
    //Big O(logN)
	public boolean add(E item) {
		if( item == null)
            throw new IllegalArgumentException();
		int high = size()-1;
    	int low = 0;
    	int mid = (high+low)/2;
    	while (low<=high){
    		mid = low+(high-low)/2;
    		if (item.compareTo(myCon.get(mid))<0){
    			high = mid-1;
    		}
    		else if (item.compareTo(myCon.get(mid))>0){
    			low = mid+1;
    			mid++;
    		}
    		else return false;
    	}
    	myCon.add(mid,item);
		return true;
	}
	//Big O(N)
	private ArrayList<E> mergeSets(ISet<E> otherSet){
		if( otherSet == null)
            throw new IllegalArgumentException();
		ArrayList<E> temp = new ArrayList<E>();
    	int thisPos = 0;
    	int otherPos = 0;
    	SortedSet<E> otherSort;
    	if(otherSet instanceof SortedSet){
    		otherSort = (SortedSet<E>)otherSet;
    	} else {
    		otherSort = new SortedSet<E>(otherSet);
    	}
    	while (thisPos<size() && otherPos<otherSort.size()){
    		if (myCon.get(thisPos).compareTo(otherSort.myCon.get(otherPos))<0){
    			if (!temp.contains(myCon.get(thisPos))){
    			temp.add(myCon.get(thisPos));
    			}
    			thisPos++;
    		} else{
    			if (!temp.contains(otherSort.myCon.get(otherPos))){
        			temp.add(otherSort.myCon.get(otherPos));
        			}
    			if (myCon.get(thisPos).compareTo(otherSort.myCon.get(otherPos))==0)
    				thisPos++;
    			otherPos++;
    			
    		}
    	}
    	
    	while (thisPos<size()){
    		if (!temp.contains(myCon.get(thisPos))){
    			temp.add(myCon.get(thisPos));
    			}
    			thisPos++;	
    	}
    	
    	while (otherPos<otherSort.size()){
    		if (!temp.contains(otherSort.myCon.get(otherPos))){
    			temp.add(otherSort.myCon.get(otherPos));
    			}
    			otherPos++;
    	}
    	return temp;
	}
	//Big O(N)
	public boolean addAll(ISet<E> otherSet){
		if( otherSet == null)
            throw new IllegalArgumentException();
		ArrayList<E> temp = mergeSets(otherSet);
		if (myCon.equals(temp)){
    		return false;
    	}
    	myCon = temp;
    	return true;
	}
	//Big O(N)
	public void clear(){
		myCon.clear();
	}
	//Big O(logN)
	public boolean contains(E item){
		if( item == null)
            throw new IllegalArgumentException();
    	int high = size()-1;
    	int low = 0;
    	while (low<=high){
    		int mid = low+(high-low)/2;
    		if (item.compareTo(myCon.get(mid))<0)
    			high = mid-1;
    		else if (item.compareTo(myCon.get(mid))>0)
    			low = mid+1;
    		else return true;
    	}
		return false;
    }
	//Big O(N)
	public boolean containsAll(ISet<E> otherSet){
		if( otherSet == null)
            throw new IllegalArgumentException();
		int index = 0;
		int otherIndex = 0;
		SortedSet<E> otherSort;
    	if(otherSet instanceof SortedSet){
    		otherSort = (SortedSet<E>)otherSet;
    	} else {
    		otherSort = new SortedSet<E>(otherSet);
    	}
		while (otherIndex < otherSort.size()){
			if (index>=size()){
				return false;
			}
			int temp = otherSort.myCon.get(otherIndex).compareTo(myCon.get(index));
			if(temp<0){
				return false;
			} else if (temp>0) {
				index++;
			} else {
				otherIndex++;
			}
		}
		return true;
	}
	//Big O(N)
	public ISet<E> difference(ISet<E> otherSet){
		if( otherSet == null)
            throw new IllegalArgumentException();
		SortedSet<E> result = new SortedSet<E>();
		int index = 0;
		int otherIndex = 0;
		SortedSet<E> otherSort;
    	if(otherSet instanceof SortedSet){
    		otherSort = (SortedSet<E>)otherSet;
    	} else {
    		otherSort = new SortedSet<E>(otherSet);
    	}
		while (otherIndex < otherSort.size()&&index<size()){
			int temp = otherSort.myCon.get(otherIndex).compareTo(myCon.get(index));
			if(temp<0){
				otherIndex++;
			} else if (temp>0) {
				result.add(myCon.get(index));
				index++;
			} else {
				index++;
				otherIndex++;
			}
		}
		while (index<size()){
    			result.myCon.add(myCon.get(index));
    			index++;	
    	}
		return result;
	}
	//Big O(N)
	public boolean equals (Object other){
		if(other == null)
            return false;
        else if(!(other instanceof ISet))
            return false;
        else if(this == other){
            return true;
        } else {
        	SortedSet<?> otherSet;
        	if(other instanceof SortedSet){
        		otherSet = (SortedSet<?>)other;
        		if(otherSet.size()!=this.size())
            		return false;
        		Iterator<E> it = this.iterator();
                Iterator<?> otherIt = otherSet.iterator();
                while (it.hasNext()){
                	if (!it.next().equals(otherIt.next())){
                		return false;
                	}
                }
                return true;
        	} else {
        		return super.equals(other);
        	}
        }
	}
	//Big O(N)
	public ISet<E> intersection(ISet<E> otherSet) {
		if( otherSet == null)
            throw new IllegalArgumentException();
		SortedSet<E> result = new SortedSet<E>();
		int index = 0;
		int otherIndex = 0;
		SortedSet<E> otherSort;
    	if(otherSet instanceof SortedSet){
    		otherSort = (SortedSet<E>)otherSet;
    	} else {
    		otherSort = new SortedSet<E>(otherSet);
    	}
		while (otherIndex < otherSort.size()&&index<size()){
			int temp = otherSort.myCon.get(otherIndex).compareTo(myCon.get(index));
			if(temp<0){
				otherIndex++;
			} else if (temp>0) {
				index++;
			} else {
				result.myCon.add(myCon.get(index));
				index++;
				otherIndex++;
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
	//Big O(N)
	public ISet<E> union(ISet<E> otherSet){
		if( otherSet == null)
            throw new IllegalArgumentException();
		SortedSet<E> result = new SortedSet<E>(otherSet);
		result.addAll(this);
		return result;
	}
}
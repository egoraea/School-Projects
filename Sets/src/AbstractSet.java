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

/**
 * Students are to complete this class. 
 * Students should implement as many methods
 * as they can using the Iterator from the iterator 
 * method and the other methods. 
 *
 */
public abstract class AbstractSet<E> implements ISet<E> {

    /* NO INSTANCE VARIABLES ALLOWED.
     * NO DIRECT REFERENCE TO UnsortedSet OR SortedSet ALLOWED.
     * (In other words the data types UnsortedSet and SortedSet
     * will not appear any where in this class.)
     * Also no direct references to ArrayList or other Java Collections.
     */  
    
 	/**
 	 * Big O(N^2)
      * A union operation. Add all items of otherSet that are not already present in this set
      * to this set.
      * @param otherSet != null
      * @return true if this set changed as a result of this operation, false otherwise.
      */
    public boolean addAll(ISet<E> otherSet){
    	if( otherSet == null)
            throw new IllegalArgumentException();
    	boolean result = false;
    	for(E item: otherSet){
    		boolean temp = false;
    		temp = add(item);
    		if (temp){
    			result = true;
    		}
    	}
    	return result;
    }
    

	/**
	 * Big O(N)
     * Make this set empty.
     * <br>pre: none
     * <br>post: size() = 0
     */
    public void clear(){
    	for (E item : this){
    		remove(item);
    	}
    };
    

	/**
	 * Big O(N)
     * Determine if item is in this set. 
     * <br>pre: item != null
     * @param item element whose presence is being tested. Item may not equal null.
     * @return true if this set contains the specified item, false otherwise.
     */
    public boolean contains(E item){
    	if( item == null)
            throw new IllegalArgumentException();
    	for (E e : this){
    		if (e.equals(item))
    			return true;
    	}
    	return false;
    }

    
	/**
	 * Big O(N^2)
     * Determine if all of the elements of otherSet are in this set.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return true if this set contains all of the elements in otherSet, 
     * false otherwise.
     */
    public boolean containsAll(ISet<E> otherSet){
    	if( otherSet == null)
            throw new IllegalArgumentException();
    	for (E e : otherSet){
    		if (!this.contains(e))
    			return false;
    	}
    	return true;
    }
    
    /**
     * Big O(N^2)
     * Create a new set that is the difference of this set and otherSet. Return an ISet of 
     * elements that are in this Set but not in otherSet. Also called
     * the relative complement. 
     * <br>Example: If ISet A contains [X, Y, Z] and ISet B contains [W, Z] then
     * A.difference(B) would return an ISet with elements [X, Y] while
     * B.difference(A) would return an ISet with elements [W]. 
     * <br>pre: otherSet != null
     * <br>post: returns a set that is the difference of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the difference of this set and otherSet
     */
    public ISet<E> difference(ISet<E> otherSet){
    	if( otherSet == null)
            throw new IllegalArgumentException();
    	ISet<E> result = this.intersection(this);
    	for (E item : otherSet){
    		if (result.contains(item)){
    			result.remove(item);
    		}
    	}
    	return result;
    }
    
    

	    
   
    /**
     * Big O(N^2)
     * Determine if this set is equal to other.
     * Two sets are equal if they have exactly the same elements.
     * The order of the elements does not matter.
     * <br>pre: none
     * @param other the object to compare to this set 
     * @return true if other is a Set and has the same elements as this set
     */
    public boolean equals(Object other){
    	if(other == null)
            return false;
        else if(!(other instanceof ISet))
            return false;
        else if(this == other){
            return true;
        } else {
        	ISet<?> otherSet = (ISet<?>)other;
        	if(otherSet.size()!=this.size()){
        		return false;
        	}
        	Iterator<?> it = otherSet.iterator();
        	int total = 0;
        	while (it.hasNext()){
        		Object temp = it.next();
        		for (E item : this){
        			if (temp.equals(item)){
        				total++;
        			}
        		}
        	}
        	return total==size();
        }
    }
    
    
	
    
	/**
	 * Big O(N)
     * Remove the specified item from this set if it is present.
     * pre: item != null
     * @param item the item to remove from the set. item may not equal null.
     * @return true if this set changed as a result of this operation, false otherwise
     */
    public boolean remove(E item){
    	if( item == null)
            throw new IllegalArgumentException();
    	Iterator<E> it = iterator();
    	while (it.hasNext()){
    		if(it.next().equals(item)){
    			it.remove();
    			return true;
    		}
    	}
    	return false;
    }
    
    
    
	/**
	 * Big O(N)
     * Return the number of elements of this set.
     * pre: none
     * @return the number of items in this set
     */
    public int size(){
    	int size = 0;
    	Iterator<E> it = iterator();
    	while(it.hasNext()){
    		it.next();
    		size++;
    	}
    	return size;
    }; 
    
    
	/**
	 * Big O(N^2)
     * Create a new set that is the union of this set and otherSet.
     * <br>pre: otherSet != null
     * <br>post: returns a set that is the union of this set and otherSet.
     * Neither this set or otherSet are altered as a result of this operation.
     * <br> pre: otherSet != null
     * @param otherSet != null
     * @return a set that is the union of this set and otherSet
     */
    public ISet<E> union(ISet<E> otherSet){
    	if( otherSet == null)
            throw new IllegalArgumentException();
    	ISet<E> result = this.intersection(this);
    	result.addAll(otherSet);
    	return result;
    }
     
      
    //BigO(N)
    public String toString() {
        StringBuilder result = new StringBuilder();
        String seperator = ", ";
        result.append("(");

        Iterator<E> it = this.iterator();
        while (it.hasNext()) {
            result.append(it.next());
            result.append(seperator);
        }
        // get rid of extra separator
        if (this.size() > 0)
            result.setLength(result.length() - seperator.length());

        result.append(")");
        return result.toString();
    }
}
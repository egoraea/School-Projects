/*  Student information for assignment:
 *
 *  On my honor, Eric Erickson, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name:Eric Erickson
 *  email address:egoraea@gmail.com
 *  UTEID:eje444
 *  Section 5 digit ID: 53595 
 *  Grader name: Aaron
 *  Number of slip days used on this assignment:0
 */
import java.lang.IllegalArgumentException;
import java.util.Iterator;
import java.lang.IllegalStateException;

public class LinkedList<E> implements IList<E> {
    // CS314 student. Add you instance variables here.
    // You decide what instance variables to use. 
    // Must adhere to assignment requirements. No ArrayLists or Java LinkedLists.
    private int size;
    private DoubleListNode<E> first;
    private DoubleListNode<E> last;
    ///iterator class
    private class LLIterator implements Iterator<E>{
       private DoubleListNode<E> temp;
       private boolean removeAllow; 
       public LLIterator(){
    	   temp=first;
    	   removeAllow = false;
       }
       //O(1)
       public boolean hasNext(){
        	return temp!=null; 
        }
        //O(1)
        public E next(){ 
        	E result = temp.getData();
        	temp = temp.getNext();
        	removeAllow = true;
        	return result;
        }
        //O(1)
        public void remove(){
        	if (!removeAllow){
        		throw new IllegalStateException();
        	}
        	if (temp==null){
        		removeLast();
        	} else if (temp.getPrev().equals(first)){
        		removeFirst();
        	}else{
        		temp.setPrev(temp.getPrev().getPrev());
        		temp.getPrev().getPrev().setNext(temp);
        		size--;
        	}
        }
    }
    //O(1)
    public LinkedList(){
    	first = null;
    	last = null;
    	size = 0;
    }
    //O(1)
    /**
     * Add an item to the end of this list.
     * <br>pre: item != null
     * <br>post: size() = old size() + 1, get(size() - 1) = item
     * @param item the data to be added to the end of this list
     */
	public void add(E item){
		// TODO Auto-generated method stub
		if(item == null){
			throw new IllegalArgumentException();
		}
		if (size==0){
			DoubleListNode<E> newNode = new DoubleListNode<E>(null,item,null);
			first = newNode;
			last = newNode;
		}
		else{
			DoubleListNode<E> newNode = new DoubleListNode<E>(last,item,null);
			last.setNext(newNode);
			last = newNode;
		}
		size++;
	}
	//O(N)
	/**
     * Insert an item at a specified position in the list.
     * <br>pre: 0 <= pos <= size(), item != null
     * <br>post: size() = old size() + 1, get(pos) = item, all elements in
     * the list with a positon >= pos have a position = old position + 1
     * @param pos the position to insert the data at in the list
     * @param item the data to add to the list
    */
	public void insert(int pos, E item){
		// TODO Auto-generated method stub
		if (pos>=size || pos<0 || item==null) {
			throw new IllegalArgumentException();
		}
		if (pos==0){
			addFirst(item);
		}  else if (pos==size){
			add(item);
		} else {
			DoubleListNode<E> after = getNode(pos);
			DoubleListNode<E> before = after.getPrev();
			DoubleListNode<E> newNode = new DoubleListNode<E>(before,item,after);
			after.setPrev(newNode);
			before.setNext(newNode);
			size++;
		}
	}
	//O(N)
	 /**
     * Change the data at the specified position in the list.
     * the old data at that position is returned.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: get(pos) = item, return the
     * old get(pos)
     * @param pos the position in the list to overwrite  
     * @param item the new item that will overwrite the old item
     * @return the old data at the specified position
     */
	public E set(int pos, E item){
		// TODO Auto-generated method stub
		if (pos>=size || pos<0 || item==null) {
			throw new IllegalArgumentException();
		}
		DoubleListNode<E> temp = getNode(pos);
		E result = temp.getData();
		temp.setData(item);
		return result;
	}
	//O(N)
	/**
     * Gets a node from the list.
     * <br>pre: 0 <= pos < size()
     * <br>post: return the item at pos
     * @param pos specifies which node to get
     * @return the node at the specified position in the list
     */
	private DoubleListNode<E> getNode(int pos){
		if (pos>=size || pos<0) {
			throw new IllegalArgumentException();
		}
		DoubleListNode<E> result = first;
		for (int i = 0; i<pos;i++){
			result= result.getNext();
		}
		return result;
	}
	//O(N)
	/**
     * Get an element from the list.
     * <br>pre: 0 <= pos < size()
     * <br>post: return the item at pos
     * @param pos specifies which element to get
     * @return the element at the specified position in the list
     */
	public E get(int pos){
		// TODO Auto-generated method stub
		if (pos>=size || pos<0) {
			throw new IllegalArgumentException();
		}
		return getNode(pos).getData();
	}
	//O(N)
	/**
     * Remove an element in the list based on position.
     * <br>pre: 0 <= pos < size()
     * <br>post: size() = old size() - 1, all elements of
     * list with a positon > pos have a position = old position - 1
     * @param pos the position of the element to remove from the list
     * @return the data at position pos
     */
	public E remove(int pos){
		// TODO Auto-generated method stub
		if (pos>=size || pos<0) {
			throw new IllegalArgumentException();
		}
		if (pos == 0){
			return removeFirst();
		} else if (pos == size-1){
			return removeLast();
		}
		DoubleListNode<E> result = getNode(pos);
		size--;
		result.getPrev().setNext(result.getNext());
		result.getNext().setPrev(result.getPrev());
		return result.getData();
	}
	//O(N)
	 /**
     * Remove the first occurrence of obj in this list.
     * Return <tt>true</tt> if this list changed as a result of this call, <tt>false</tt> otherwise.
     * <br>pre: obj != null
     * <br>post: if obj is in this list the first occurence has been removed and size() = old size() - 1. 
     * If obj is not present the list is not altered in any way.
     * @param obj The item to remove from this list.
     * @return Return <tt>true</tt> if this list changed as a result of this call, <tt>false</tt> otherwise.
     */
	public boolean remove(E obj){
		if (obj==null) {
			throw new IllegalArgumentException();
		}
		if (last.getData().equals(obj)){
			removeLast();
			return true;
		}
		DoubleListNode<E> temp = first;
		if (temp.getData().equals(obj)){
			removeFirst();
			return true;
		}else{
			temp=temp.getNext();
		}
		for (int i = 1; i<size-1;i++){
			if(temp.getData().equals(obj)){
				temp.getPrev().setNext(temp.getNext());
				temp.getNext().setPrev(temp.getPrev());
				size--;
				return true;
			}
			temp=temp.getNext();
		}
		return false;
	}
	//O(N)
	/**
     * Return a sublist of elements in this list from <tt>start</tt> inclusive to <tt>stop</tt> exclusive.
     * This list is not changed as a result of this call.
     * <br>pre: <tt>0 <= start < size(), start <= stop <= size()</tt>
     * <br>post: return a list whose size is stop - start and contains the elements at positions start through stop - 1 in this list.
     * @param start index of the first element of the sublist.
     * @param stop stop - 1 is the index of the last element of the sublist.
     * @return a list with <tt>stop - start</tt> elements, The elements are from positions <tt>start</tt> inclusive to
     * <tt>stop</tt> exclusive in this list.
     */
	public IList<E> getSubList(int start, int stop){
		// TODO Auto-generated method stub
		if (start>=size || start<0 ||start>size || stop<start) {
			throw new IllegalArgumentException();
		}
		DoubleListNode<E> temp = getNode(start);
		LinkedList<E> result = new LinkedList<E>();
		for (int i = start;i<stop;i++){
			result.add(temp.getData());
			temp = temp.getNext();
		}
		return result;
	}
	//O(1)
	/**
     * Return the size of this list. In other words the number of elements in this list.
     * <br>pre: none
     * <br>post: return the number of items in this list
     * @return the number of items in this list
     */
	public int size(){
		// TODO Auto-generated method stub
		return size;
	}
	//O(N)
	/**
     * Find the position of an element in the list.
     * <br>pre: item != null
     * <br>post: return the index of the first element equal to item
     * or -1 if item is not present
     * @param item the element to search for in the list
     * @return return the index of the first element equal to item or a -1 if item is not present
     */
	public int indexOf(E item){
		// TODO Auto-generated method stub
		if (item==null) {
			throw new IllegalArgumentException();
		}
		DoubleListNode<E> temp = first;
		for (int i = 0; i<size;i++){
			if (temp.getData().equals(item)){
				return i;
			}
			temp = temp.getNext();
		}
		return -1;
	}
	//O(N)
	/**
     * find the position of an element in the list starting at a specified position.
     * <br>pre: 0 <= pos < size(), item != null
     * <br>post: return the index of the first element equal to item starting at pos
     * or -1 if item is not present from position pos onward
     * @param item the element to search for in the list
     * @param pos the position in the list to start searching from
     * @return starting from the specified position return the index of the first element equal to item or a -1 if item is not present between pos and the end of the list
     */
	public int indexOf(E item, int pos){
		if (pos>=size || pos<0 || item==null) {
			throw new IllegalArgumentException();
		}
		DoubleListNode<E> temp = getNode(pos);
		for (int i = pos; i<size;i++){
			if (temp.getData().equals(item)){
				return i;
			}
			temp = temp.getNext();
		}
		return -1;
	}
	//O(1)
	/**
     * return the list to an empty state.
     * <br>pre: none
     * <br>post: size() = 0
     */
	public void makeEmpty(){
		// TODO Auto-generated method stub
		first = null;
		last = null;
		size = 0;
	}
	//O(1)
	/**
	    * return an Iterator for this list.
	    * <br>pre: none
	    * <br>post: return an Iterator object for this List
	    */
	public Iterator<E> iterator(){
		// TODO Auto-generated method stub
		return new LLIterator();
	}
	//O(N)
	/**
     * Remove all elements in this list from <tt>start</tt> inclusive to <tt>stop</tt> exclusive.
     * <br>pre: <tt>0 <= start < size(), start <= stop <= size()</tt>
     * <br>post: <tt>size() = old size() - (stop - start)</tt>
     * @param start position at beginning of range of elements to be removed
     * @param stop stop - 1 is the position at the end of the range of elements to be removed
     */
    public void removeRange(int start, int stop){
    	if (start>=size || start<0 ||start>size || stop<start) {
			throw new IllegalArgumentException();
		}
    	DoubleListNode<E> startNode = getNode(start);
    	DoubleListNode<E> stopNode = getNode (stop);
    	if (start==0 && stop==size){
    		makeEmpty();
    	} else if (stop==size){
    		last = startNode.getPrev();
    		last.setNext(null);
    		size += -(stop-start);
    	} else if (start==0){
    		first = stopNode;
    		first.setPrev(null);
    		size += -(stop-start);
    	} else {
    		startNode.getPrev().setNext(stopNode);
    		stopNode.setPrev(startNode.getPrev());
    		size += -(stop-start);
    	}
    }
	//O(1)
	/**
	 * add item to the front of the list.
	 * <br>pre: item != null
	 * <br>post: size() = old size() + 1, get(0) = item
	 * @param item the data to add to the front of this list
	 */
	public void addFirst(E item){
		if (item==null) {
			throw new IllegalArgumentException();
		}
		if (size==0){
			first = new DoubleListNode<E>(null,item,null);
			last =first;
		} else {
			DoubleListNode<E> newNode = new DoubleListNode<E>(null,item,first);
			first.setPrev(newNode);
			first = newNode;
		}
		size++;
	}

	//O(1)
	/**
	 * add item to the end of the list.
	 * <br>pre: item != null
	 * <br>post: size() = old size() + 1, get(size() -1) = item
	 * @param item the data to add to the end of this list
	 */
	public void addLast(E item){
		if (item==null) {
			throw new IllegalArgumentException();
		}
		add(item);
	}

	//O(1)
	/**
	 * remove and return the first element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old first element of this list
	 */
	public E removeFirst(){	
	    E result = first.getData();
	    if (size>1){
	    first = first.getNext();
	    first.setPrev(null);
	    } else {
	    	first = null;
	    	last = null;
	    }
	    size--;
		return result;
	}

	//O(1)
	/**
	 * remove and return the last element of this list.
	 * <br>pre: size() > 0
	 * <br>post: size() = old size() - 1
	 * @return the old last element of this list
	 */
	public E removeLast(){	
		E result = last.getData();
	    if (size>1){
	    last = last.getPrev();
	    last.setNext(null);
	    } else {
	    	first = null;
	    	last = null;
	    }
	    size--;
		return result;
	}
	//O(N)
	/**
     * Return a String version of this list enclosed in
     * square brackets, []. Elements are in
     * are in order based on position in the 
     * list with the first element
     * first. Adjacent elements are seperated by comma's
     * @return a String representation of this IList
     */
	public String toString(){	
	    StringBuffer sb = new StringBuffer();
	    DoubleListNode<E> temp = first;
	    sb.append("[");
	    for (int i = 0; i<size-1;i++){
	    	sb.append(temp.getData()+", ");
	    	temp=temp.getNext();
	    }
	    if (size>0){
	    	sb.append(temp.getData());
	    }
	        sb.append("]");
		return sb.toString();
	}

	///O(N)
	/**
	 * check if this list is equal to another Object.
	 * <br>pre: none
	 * @return true if other is a non null LinkedList object
	 * with the same elements as this LinkedList in the same
	 * order.
	 */
	public boolean equals(Object other){	
		if(other == null)
            return false;
        else if(!(other instanceof IList))
            return false;
        else if(this == other){
            return true;
        } else {
        	 IList<?> otherList = (IList<?>) other;
             if (this.size != otherList.size()){
            	return false;
             }
             if (this.size()==0){
            	 return true;
             }
             Iterator<E> thisIt = this.iterator();
             Iterator<?> otherIt = otherList.iterator();
             while(thisIt.hasNext()) {
                 if (!(thisIt.next().equals(otherIt.next()))){
                	 return false;
                 }
             }
	    return true;
        }
	}
}
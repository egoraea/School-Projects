/*
 * CS312 Assignment 12.
 * On my honor, Eric Erickson, this programming assignment is my own work.
 * Section Number:
 *
 * A program to play 37 notes mimicking guitar string plucking.
 *
 *  Name:Eric Erickson
 *  email address: egoraea@gmail.com
 *  UTEID:eje444
 *  Section 5 digit ID: 53700
 *  Grader name: Megan Avery
 *  No slip days are allowed on this assignment:
 */

public class RingBuffer {
	private double [] ring;
	private int first = 0;
	private int last = 0;
	boolean full = false;
	boolean empty = true ;
	//constructs
	public RingBuffer(int capacity){
		ring = new double[capacity];
	}
	//checks the size
	public int size(){
	int result = 0;
	if (first>last) result=last-first+ring.length;
	else result=last-first;	
	if (first==last && full) result = ring.length;
	return result;
	}
	//checks if arrays is empty;
	public boolean isEmpty(){
		return empty;
	}
	//checks if array is full
	public boolean isFull(){
		return full;
	}
	//adds thing to end
	public void enqueue(double x){
		empty = false;
		if (isFull()) throw new RuntimeException() ;
		ring[last] = x;
		last++;	
		if (last==ring.length) last=0;
		if (last==first) full=true;
	}
	//deletes and increments first thing and returns it
	public double dequeue(){
		full = false;
		if (isEmpty()) throw new RuntimeException() ;
		double result = ring[first];
		ring[first] = 0;
		first++;
		if (first==ring.length) first=0;
		if (first==last) empty = true;
		return result;
	}
	//peeks at first thing
	public double peek(){
		return ring[first];
	}
	//converts to string
	public String toString(){
		String result = "[";
		for (int i = 0; i<=size()-2; i++){
			if (first+i>=ring.length) result += ring[first+i-ring.length];
			else result += ring[first + i];
			result += ", ";
		}
		if (!empty && last != 0)result += ring[last-1];
		else if (!empty) result += ring[ring.length-1];
		result += "]";
		return result;
	}
}
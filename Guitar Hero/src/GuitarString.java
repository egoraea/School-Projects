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
public class GuitarString {

	private int time = 0;
	RingBuffer rb;
	public GuitarString(double frequency){
		int length = (int)Math.round(44100/frequency);
		rb = new RingBuffer(length);
		while (!rb.isFull()){
			rb.enqueue(0.0);
		}
	}
	public GuitarString(double[] init){
		rb = new RingBuffer(init.length);
		for (int i=0; i<= init.length; i++){
			rb.enqueue(init[i]);
		}
	}
	// set the buffer to white noise (random values between -0.5 and +0.5)
	public void pluck(){
		while (!rb.isEmpty()) rb.dequeue();
		while (!rb.isFull()) rb.enqueue(Math.random()-.5);
	}
	  // advance the simulation one time step
	public void tic(){
		time++;
		double first = rb.dequeue();
		double second = rb.peek();
		rb.enqueue((first+second)/2*.994);
	}
	  // return the current sample
	public double sample(){
		return rb.peek();
	}
	 // return number of tics
	public int time(){
		  return time; 
	}
}

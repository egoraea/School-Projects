import java.awt.Color;
import java.awt.Graphics;
/**
 * @author  Eric Erickson
 * @version 9/23/2013
 * CS312 Assignment 3.
 * On my honor, Eric Erickson, this programming assignment is my own work and I have
 * not shared my solution with any other student in the class.
 *
 *
 * A program to create a drawing. Part 1 of the assignment, worth 4 points.
 *
 *  email address: egoraea@gmail.com
 *  UTEID:eje444
 *  Section 5 digit ID:53700
 *  Grader name:Megan Avery
 *  Number of slip days used on this assignment:0
 */


public class Drawing1 {

	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(400, 200);
		Graphics g = panel.getGraphics();
		panel.setBackground(Color.GREEN);
		g.setColor(Color.RED);
		g.fillOval(0, 0, 200, 100);
		g.fillOval(200, 100, 200, 100);
		g.setColor(Color.BLACK);
		g.drawLine(100,0,100,100);
		g.drawLine(0,50,200,50);
		g.drawLine(0,100,400,100);
		g.drawLine(200,0,200,200);
		g.drawLine(300,100,300,200);
		g.drawLine(200,150,400,150);
	
	}
}
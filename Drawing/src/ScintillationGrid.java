import java.awt.Color;
import java.awt.Graphics;

/**
 * @author  Eric Erickson
 * @version 9/23/2013
 * CS312 Assignment 3.
 * On my honor, Eric Erickson, this programming assignment is my own work and I have
 * not shared my solution wiht any other student in the class.
 *
 *
 * A program to print out various ScintillationGrids. Part 2 of assignment 3.
 * Worth 16 points.
 *
 *  email address: egoraea@gmail.com
 *  UTEID:eje444
 *  Section 5 digit ID:53700
 *  Grader name:Megan Avery
 *  Number of slip days used on this assignment:0
 */

public class ScintillationGrid {
	public static void drawGrid (int x, int y, int size, int lines, int thickness,Graphics g) {
		drawBox(x,y,size,g);
		drawLines(x,y,size,lines,thickness,g);
		drawCircles(x,y,size,lines,thickness,g);
	}
	public static void drawBox(int x, int y, int size, Graphics g) {
		g.setColor(Color.BLACK);
		g.fillRect(x, y, size, size);
	}
	public static void drawLines(int x, int y, int size, int lines, int thickness, Graphics g){
		g.setColor(Color.GRAY);
		int ypos=0;
		int xpos=0;
		for (int i=1; i<=lines; i++ ){
			ypos =ypos + ((size-thickness*lines)/(lines+1))  ;
			g.fillRect(x, y+ypos,size,thickness);
			ypos += thickness;
		}
		for (int i=1; i<=lines; i++ ){
			xpos =xpos + ((size-thickness*lines)/(lines+1))  ;
			g.fillRect(x+xpos, y,thickness,size);
			xpos += thickness;}
	}
	public static void drawCircles (int x, int y, int size, int lines, int thickness, Graphics g){
		g.setColor(Color.WHITE);
		int ypos=0;
		
		for (int i=1; i<=lines; i++ ){
			ypos =ypos + ((size-thickness*lines)/(lines+1));
			int xpos=0;
			int circleSize=Math.max(thickness+2,thickness*140/100);
			for (int j=1; j<=lines; j++ ){
				xpos =xpos + ((size-thickness*lines)/(lines+1))  ;
				g.fillOval(x+xpos-(circleSize-thickness)/2, y+ypos-(circleSize-thickness)/2, circleSize, circleSize);
				xpos += thickness;
			}
			ypos += thickness;
		}
	}
	public static void main(String[] args) {
		DrawingPanel panel = new DrawingPanel(900, 650);
		Graphics g = panel.getGraphics();
		panel.setBackground(Color.CYAN);
		drawGrid(0,0,300,3,6,g);
		drawGrid(50,400,200,1,20,g);
		drawGrid(400,50,420,6,10,g);
		drawGrid(500,500,100,7,4,g);
		
	}
}

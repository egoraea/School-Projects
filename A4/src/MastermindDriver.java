/*  Student information for assignment:
 *
 *  On MY honor, Eric Erickson, this programming assignment is MY own work
 *  and I have not provided this code to any other student.
 *
 *  Number of slip days used:
 *
 *  Student 1 (Student whose turnin account is being used)
 *  UTEID: eje444
 *  email address: egoraea@gmail.com
 *  Grader name: Aaron
 *  Section number: 53595
 *  

 */

public class MastermindDriver {

    public static void main(String[] args){
    	Game g = new Game(true);
        g.runGames();
        g = new Game(false);
        g.runGames();
    }

}
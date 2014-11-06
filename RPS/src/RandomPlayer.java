
/**
 * RandomPlayer can be called with a long seed, or with no seed.  In the former case, 
 * the play() method generates a random integer between 1 and 3 inclusive.  In the latter, a
 * fixed sequence is generated that depends on the seed.
 * (The play_2 method, if present, will generate a cyclic sequence of integers specified 
 * in the int array plays.
 * 
 * @author (Vallath Nandakumar) 
 * @version (v 1.0, Sept. 23, 2013)
 */
import java.util.Random;
public class RandomPlayer
{
    private Random rand;
    //private static int roundNumber;
    //private int [] plays = {1, 2, 3, 2, 3, 1, 1}; // fixed rotating sequence of plays
    
/*
    RandomPlayer (long seed)
    {
        rand = new Random(seed);
    }
*/
    
    RandomPlayer () 
    {
        rand = new Random();
    }
    
    /*
     * Generates a random sequence of integers among 1, 2, and 3.
     */
    public int play ()
    {
        int play = 1 + rand.nextInt(5);
        return play;
    }
    
    /*
     * play_2 generates a cyclic sequence of integers from int[] play.
     */
/*
    public int play_2 ()
    {        
        int play = plays [ roundNumber%( plays.length)];
        roundNumber ++;
        return play;
    }
*/
 
}
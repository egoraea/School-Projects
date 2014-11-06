import java.util.Arrays;
import java.util.Random;


public class ShuffleArray {
	public static final boolean DEBUG = true;

	public static void main(String[] args) {

		int [] a = {0, 1, 2, 3, 4, 5};
		shuffle(a,10);

	}

	// Exchange cards at two random locations to shuffle.
	public static void shuffle(int [] array, int noOfTimes) {
		Random rand = new Random();
		int temp = 0;

		// Swap cards at two selected places
		for (int i = 0; i < noOfTimes; i ++ ) {
			int src = rand.nextInt(array.length); // Select random index
			int dest = rand.nextInt(array.length);
			temp = array[src];
			array[src] = array[dest];
			array[dest] = temp;		
			if (DEBUG) System.out.println(Arrays.toString(array));
		}
	}
}

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
public class GuitarHero {

	public static void main(String[] args) {
		String keyboard = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";
		GuitarString[] strings = createStrings();
		while (true) {
            if (StdDraw.hasNextKeyTyped()) {
            	char key = StdDraw.nextKeyTyped();
            	if (keyboard.indexOf(key) != -1)strings[keyboard.indexOf(key)].pluck();
            }
            double sample = sampleStrings(strings);
            StdAudio.play(sample);
            ticStrings(strings);
        }
       
	}
	//creates array of guitar Strings
	public static GuitarString[] createStrings(){
		GuitarString[] strings = new GuitarString[37];
		for (int i = 0; i<strings.length; i++){
			strings[i] = new GuitarString(440*Math.pow(1.05956, i-24));
		}
		return strings;
	}
	//tics every string
	public static void ticStrings(GuitarString[] strings){
		for (int i = 0; i<strings.length; i++){
			strings[i].tic();;
		}
	}
	//adds all the samples togethor
	public static double sampleStrings(GuitarString[] strings){
		double sample = 0;
		for (int i = 0; i<strings.length; i++){
			sample += strings[i].sample();
		}
		return sample;
	}
}

/*  Student information for assignment:
 *
 *  On my honor, Eric Erickson, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: eje444
 *  email address: egoraea@gmail.com
 *  Grader name: Aaron
 *  Number of slip days I am using: 0
 */

/*
 * Place results of experiments here:
Binary Random n:1000 Size:1000 Height:21.6 Time:2.6409200000000028E-5
Binary Random n:2000 Size:2000 Height:24.1 Time:4.19846E-5
Binary Random n:4000 Size:4000 Height:27.2 Time:8.307970000000266E-5
Binary Random n:8000 Size:8000 Height:31.1 Time:2.0031139999999417E-4
Binary Random n:16000 Size:16000 Height:31.7 Time:4.690107000000218E-4
Binary Random n:32000 Size:31999.7 Height:35.1 Time:0.001093599500000035
Binary Random n:64000 Size:63999.6 Height:38.6 Time:0.0035118580000000586
Binary Random n:128000 Size:127998 Height:39.6 Time:0.006474356499991495
Binary Random n:256000 Size:255992.4 Height:43.5 Time:0.014918357599960162
Binary Random n:512000 Size:511969.6 Height:47.0 Time:0.05049358960014063
Binary Random n:1024000 Size:1023883.7 Height:49.0 Time:0.11824802150084086

Java Random n:1000 Time: 1.802960000000003E-5
Java Random n:2000 Time: 4.239939999999999E-5
Java Random n:4000 Time: 9.2318200000003E-5
Java Random n:8000  Time: 1.9396939999999442E-4
Java Random n:16000 Time: 4.745859000000248E-4
Java Random n:32000 Time: 0.0010914991000000392
Java Random n:64000 Time: 0.0030941683000005687
Java Random n:128000 Time: 0.007119978399990815
Java Random n:256000 Time: 0.023340251899942217
Java Random n:512000 Time: 0.049637799700071435
Java Random n:1024000 Time: 0.10390153460131737

Binary Sorted n:1000 Size:1000 Height:999 Time: 1.7545999999999933E-4
Binary Sorted n:2000 Size:2000 Height:1999 Time: 5.819696000000033E-4
Binary Sorted n:4000 Size:4000 Height:3999 Time: 0.0037637666
Binary Sorted n:8000 Size:8000 Height:7999 Time: 0.01982065849999997
Binary Sorted n:16000 Size:16000 Height:15999 Time: 0.06686004939999957
Binary Sorted n:32000 Size:32000 Height:31999 Time: 0.3991722394999994
Binary Sorted n:64000 Size:64000 Height:63999 Time: 1.364029584600007
Binary Sorted n:12800 Size:128000 Height:12799 Estimated Time:5.2
Binary Sorted n:25600 Size:25600 Height:25599 Estimated Time: 20
Binary Sorted n:51200 Size:51200 Height:51199 Estimated Time:80
Binary Sorted n:1024000 Size:1024000 Height:1023999 Estimated Time:320

Java Sorted n:1000 Time: 1.3443400000000018E-5
Java Sorted n:2000 Time: 2.7014400000000027E-5
Java Sorted n:4000 Time: 6.100340000000094E-5
Java Sorted n:8000  Time: 1.2048050000000201E-4
Java Sorted n:16000 Time: 2.5659689999998875E-4
Java Sorted n:32000 Time: 5.684572000000867E-4
Java Sorted n:64000 Time: 0.0013760029999999404
Java Sorted n:128000 Estimated Time: .002
Java Sorted n:256000 Estimated Time: .004
Java Sorted n:512000 Estimated Time: 0.008
Java Sorted n:1024000 Estimated Time: 0.016

The minimum possible tree height is log(N)-1
The TreeSet is very slightly faster than the Binary Search Tree for random order
The TreeSet is much faster when entering sorted values
This is probably because it will balance it's not a naieve tree and it balances it self
*/

/**
 * Test class for binary search tree
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.TreeSet;


public class BSTTester {

    public static void main(String[] args) {
//    	//experiment code
//    	double[][] timing = new double[4][11];
//    	int [] height = new int[11];
//    	int [] size = new int[11];
//    	for (int p = 1; p<=10; p++){
//    	int times = -1;
//    	Stopwatch s = new Stopwatch();
//    		for (int i = 1; i<= 64; i*=2){
//    			int n = 1000*i;
//    			times ++;
//    			Random r = new Random();
//    			BinarySearchTree<Integer> b1 = new BinarySearchTree<Integer>();
//    			double total = 0;
//    			for(int j = 0; j < n; j++) {
//    				s.start();
//    				b1.add( new Integer( r.nextInt() ) );
//    				s.stop();
//    				total += s.time();
//    			}
//    			height[times] += b1.height();
//    			size[times] += b1.size();
//    			timing[0][times] = total/10;
//    			TreeSet<Integer> t1 = new TreeSet<Integer>();
//    			total = 0;
//    			for(int j = 0; j < n; j++) {
//    				s.start();
//    				t1.add( new Integer( r.nextInt() ) );
//    				s.stop();
//    				total += s.time(); 
//    			}
//    			timing[1][times] = total/10;
//    			BinarySearchTree<Integer> b2 = new BinarySearchTree<Integer>();
//    			total = 0;
//    			for(int j = 0; j < n; j++) {
//    				s.start();
//    				b2.iterativeAdd(j);
//    				s.stop();
//    				total += s.time();
//    			}
//    			timing[2][times] = total/10;
//    			TreeSet<Integer> t2 = new TreeSet<Integer>();
//    			total = 0;
//    			for(int j = 0; j < n; j++) {
//    				s.start();
//    				t2.add(j);
//    				s.stop();
//    				total += s.time();
//    			}
//    			timing[3][times] = total/10;
//    		}	
//    		for (int i = 128; i<= 1024; i*=2){
//    			int n = 1000*i;
//    			times++;
//    			Random r = new Random();
//    			BinarySearchTree<Integer> b1 = new BinarySearchTree<Integer>();
//    			double total = 0;
//    			for(int j = 0; j < n; j++) {
//    				s.start();
//    				b1.add( new Integer( r.nextInt() ) );
//    				s.stop();
//    				total += s.time();
//    			}	
//    			height[times] += b1.height();
//    			size[times] += b1.size();
//    			timing[0][times] = total/10;
//    			TreeSet<Integer> t1 = new TreeSet<Integer>();
//    			total = 0;
//    			for(int j = 0; j < n; j++) {
//    				s.start();
//    				t1.add( new Integer( r.nextInt() ) );
//    				s.stop();
//    				total += s.time();
//    			}	
//    			timing[1][times] = total/10;
//    		}	
//    	}
//    	int n = 1000;
//    	for (int i = 0; i <11; i++){
//    		System.out.println("Binary Random n:"+n+" Size:"+size[i]+" Height:"+height[i]+" Time:" + timing[0][i] );
//    		n *= 2;
//    	}
//    	for (int i = 1; i<4; i++){
//    		System.out.println("Timings"+Arrays.toString(timing[i]));
//    	}
    	boolean success = false;
		int test = 1;
		BinarySearchTree<String> BST1 = new BinarySearchTree<String>();
		//test 1
		success = BST1.add("M");
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 2
		success = BST1.add("K");
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 3
		success = !BST1.iterativeAdd("K");
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 4
		success = BST1.iterativeAdd("I");
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 5
		success = BST1.isPresent("I");
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 6
		success = BST1.isPresent("M");
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 7
		success = BST1.size() == 3;
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 8
		success = BST1.height()== 2;
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 9
		ArrayList<String> expec = new ArrayList<String>();
		expec .add("I");
		expec .add("K");
		expec .add("M");
		success = expec.equals(BST1.getAll());
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 10
		success = expec.equals(BST1.getAllLessThan("Z"));
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 11
		success = expec.equals(BST1.getAllGreaterThan("A"));
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 12
		expec.remove(2);
		success = expec.equals(BST1.getAllLessThan("M"));
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 13
		success = BST1.remove("M");
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 14
		success = expec.equals(BST1.getAll());
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 15
		success = expec.equals(BST1.getAllGreaterThan("A"));
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 16
		success = BST1.size() == 2;
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 17
		success = BST1.height() == 1;
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 18 
		BST1.add("A");
		success = BST1.min().equals("A");
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 19
		success = BST1.remove("A");
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 20
		success = BST1.min().equals("I");
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 21
		success = BST1.max().equals("K");
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 22
		BST1.add("N");
		success = BST1.max().equals("N");
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 23
		success = BST1.numNodesAtDepth(0) == 1;
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 24
		success = BST1.numNodesAtDepth(1) == 2;
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 25
		success = BST1.get(0).equals("I");
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
		//test 26
		success = BST1.get(1).equals("K");
		if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    }

}
/*  Student information for assignment:
 *
 *  On MY honor, Eric Erickson, this programming assignment is MY own work
 *  and I have not provided this code to any other student.
 *
 *  Number of slip days used: 1
 *
 *  Student 1 (Student whose turnin account is being used)
 *  UTEID: eje444
 *  email address: egoraea@gmail.com
 *  Grader name: Aaron
 *  Section number: 53595

 */


import java.util.Iterator;


/*
CS 314 Students, put your results to the experiments and answers to
questions here:
 File Size    | total words | unique words | SortedSet | UnsortedSet | HashSet   | TreeSet   |
==============================================================================================
     55 KB    |    9673     |     2920     | 0.015901s | 0.123011s   | 0.029304s | 0.033755s |
    110 KB    |    19671    |     5065     | 0.033780s | 0.359857s   | 0.042012s | 0.081074s |
    162 KB    |    29482    |     5347     | 0.107171s | 0.496725s   | 0.069023s | 0.069838s |
    419 KB    |    74199    |     13748    | 0.104741s | 2.294405s   | 0.059233s | 0.083510s |

 Percent increases from previous:

 File Size    | total words | unique words | SortedSet | UnsortedSet | HashSet |  TreeSet |
===========================================================================================
    2.00x    |   2.03x      |    1.73x     |  2.12x    |  2.93x      | 1.43x   |  2.40x   |
    1.47x    |   1.50x      |    1.06x     |  3.17x    |  1.38x      | 1.64x   |  0.86x   |
    2.59x    |   2.52x      |    2.57x     |  0.98x    |  4.62x      | 0.86x   |  1.20x   |

1. It looks like for Sorted set it is O(NlogN) Unsorted is (N), HashSet is O(N) and TreeSet is O(N).
2.My add methods are O(N) for Unsorted and O(logN) for Sorted. HashSet is probably O(N)and TreeSet is probably O(logN)
3. TreeSet is sorted while HashSet is not.
CS314 Students, why is it unwise to implement all three of the
intersection, union, and difference methods in the AbstractSet class:
	In abstract set to get a new Iset you have to call one of the other three so if you implement all three then they 
	will be all calling each other and nothing will ever be accomplished

*/


public class SetTester {

    public static void main(String[] args){
    	boolean success = false;
    	int test = 1;
    	//test 1
    	UnsortedSet<String> un1 = new UnsortedSet<String>();
    	UnsortedSet<String> un2 = new UnsortedSet<String>();
    	success = un1.equals(un2);
    	if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		//test 2
  		success = un1.add("a");
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		//test 3
  		un1.clear();
  		success=un1.equals(un2);
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		//test 4
  		UnsortedSet<String> un3 = new UnsortedSet<String>();
  		un3.add("a");
  		un1.add("a");
  		un1.add("hi");
  		un2.add("hi");
  		success = un3.equals(un1.difference(un2));
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		//test 5
  		success = un1.equals(un3.union(un2));
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		//test 6
  		un3.clear();
  		un3.add("hi");
  		success = un3.equals(un1.intersection(un2));
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		//test 7
  		Iterator<String> it = un1.iterator();
  		success = it.next().equals("a");
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		//test 8
  		success = un1.size()==2;
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		//test 9
  		un3.clear();
  		un3.addAll(un1);
  		success = un3.equals(un1);
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		//test 10
  		success = un3.contains("hi");
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		
  		//test 11
  		success = un3.containsAll(un1);
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		
  		//test 12
  		un3.remove("a");
  		success = un3.equals(un2);
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		
  		//test 13
  		SortedSet<String> s1 = new SortedSet<String>();
  		SortedSet<String> s2 = new SortedSet<String>(un1);
  		SortedSet<String> s3 = new SortedSet<String>();
  		success = s2.equals(un1);
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;

  		//test 14
  		s1.add("hi");
  		success = s1.equals(un3);
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		
  		//test 15
  		s3.addAll(un1);
  		success = s3.equals(un1);
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		
  		//test 16
  		s3.clear();
  		un1.clear();
  		success = s3.equals(un1);
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		
  		//test 17
  		success = !s3.contains("3");
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		
  		//test 18
  		success = s1.containsAll(un3);
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		
  		//test 19
  		s3.add("a");
  		success = s1.equals(s2.difference(s3));
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
  		
  		//test 20
  		success = s1.equals(s2.intersection(un2));
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
		//test 21
  		success = s2.equals(s3.union(s1));
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
		//test 22
  		success = s1.size()==1;
  		if (success){
  			System.out.println("Test "+test+" passed");
  		}
  		else {
  			System.out.println("Test "+test+" failed");
  		}
  		test++;
    }
}
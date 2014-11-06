/*  Student information for assignment:
 *
 *  On my honor, Eric Erickson, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  Name:Eric Erickson
 *  email address:egoraea@gmail.com
 *  UTEID:eje444
 *  Section 5 digit ID: 53595 
 *  Grader name: Aaron
 *  Number of slip days used on this assignment:0
 */

// Experiment results. CS314 students, place your experiment
// results here:
/*Adding at end: ArrayList
N = 50000, time: 0.08303888900000002
N = 100000, time: 0.13444982899999994
N = 200000, time: 0.27796437900000004
N = 400000, time: 0.541636612
N = 800000, time: 1.0303393279999995


Adding at end: LinkedList
N = 50000, time: 0.066490516
N = 100000, time: 0.12069134999999996
N = 200000, time: 0.22443066000000012
N = 400000, time: 0.5363715499999998
N = 800000, time: 1.1918727589999998


Adding at front: ArrayList
N = 10000, time: 0.8979318940000001
N = 20000, time: 3.594993013999999
N = 40000, time: 14.366238673999991
N = 80000, time: 59.50046897099996
N = 160000, time: 292.639520729


Adding at front: LinkedList
N = 10000, time: 0.013635871999999997
N = 20000, time: 0.028330014000000004
N = 40000, time: 0.049582373
N = 80000, time: 0.09495452800000001
N = 160000, time: 0.18425171499999995


Removing from front: ArrayList
N = 10000, time: 0.8174936110000003
N = 20000, time: 3.455174358
N = 40000, time: 14.111806221000004
N = 80000, time: 59.247215096000005
N = 160000, time: 288.217499542


removing from front: LinkedList
N = 10000, time: 0.021993023999999996
N = 20000, time: 0.05187221199999999
N = 40000, time: 0.11367927899999998
N = 80000, time: 0.22535207700000004
N = 160000, time: 0.45475813200000004


Getting random: ArrayList
N = 10000, time: 0.024212739000000004
N = 20000, time: 0.05081566499999999
N = 40000, time: 0.11416962600000002
N = 80000, time: 0.26017017300000006
N = 160000, time: 0.7258250399999999

m
Getting random: LinkedList
N = 10000, time: 9.390514127999998
N = 20000, time: 38.36780837499999
N = 40000, time: 156.68894230600011
N = 80000, time: 712.2741441680001
N = 160000, time: 3778.8751434690002


Getting all using iterator: ArrayList
N = 10000, time: 0.007477355000000012
N = 20000, time: 0.011468619000000013
N = 40000, time: 0.02468085700000002
N = 80000, time: 0.023928783000000002
N = 160000, time: 0.04847793500000001


Getting all using iterator: LinkedList
N = 10000, time: 0.009381754
N = 20000, time: 0.01664928900000002
N = 40000, time: 0.027542028999999975
N = 80000, time: 0.03224487299999999
N = 160000, time: 0.06727680299999998


Getting all using get method: ArrayList
N = 10000, time: 0.0030755600000000063
N = 20000, time: 0.006316460999999991
N = 40000, time: 0.012631209000000018
N = 80000, time: 0.012130030999999996
N = 160000, time: 0.031098243000000022

Getting all using get method: LinkedList
N = 10000, time: 9.157576365000002
N = 20000, time: 38.05087212299999
N = 40000, time: 154.21233884
N = 80000, time: 715.1229395730002
N = 160000, time: 3578.995432279


for adding at the end both are constant time because every time N is double time is doubled
for adding at the front LinkedLists is constant time but Array list are O(N)
for removing from the from Arraylist are O(N) and Linked Lists are constant
for getting randomly Array Lists are constant time and Linked Lists are O(N)
for for using iterator both are constant time
for getting all Array list is constant time Linked Lists are O(N)


*
*/

import java.util.Iterator;
import java.util.ArrayList;
import java.util.Random;
import java.util.Arrays;

public class LinkedListTester {

    public static void main(String[] args) {
    	LinkedList<String> list1 = new LinkedList<String>();
    	boolean success = false;
    	int test = 1;
    	//test 1
        list1.add("A");
        success = list1.toString().equals("[A]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 2
        list1.add("C");
        success = list1.toString().equals("[A, C]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 3
        list1.add("B");
        success = list1.toString().equals("[A, C, B]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 4
		list1.makeEmpty();
    	success = list1.toString().equals("[]");
    	if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 5
        list1.add("A");
        success = list1.toString().equals("[A]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 6
        list1.add("B");
        list1.add("C");
        success=list1.toString().equals("[A, B, C]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test7
        list1.makeEmpty();
        success = list1.toString().equals("[]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test8
        list1.makeEmpty();
        success = list1.toString().equals("[]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 9
        list1.add("item");
        list1.makeEmpty();
        success = list1.toString().equals("[]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 10
        list1.addFirst("A");
        success = list1.toString().equals("[A]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test11
        list1.addFirst("B");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 12
        list1.addFirst("C");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 13
        list1.addLast("3");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 14
        list1.addLast("2");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 15
        list1.addLast("1");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 16
        Iterator<String> it = list1.iterator();
        success = it.hasNext();
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 17
        success=it.next().equals("C");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 18
        it.remove();
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 19
        success=it.next().equals("B");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 20
        it.remove();
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 21
        success = it.next().equals("A");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 22
        it.remove();
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 23
        while(it.hasNext()){
        	it.next();
        	it.remove();
        }
        success = true;
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //tests 24
        success = !it.hasNext();
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 25
        list1.insert(0, "A");
        success = list1.toString().equals("[A]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 26
        list1.insert(0, "B");
        success = list1.toString().equals("[B, A]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 27
        list1.insert(2, "C");
        success = list1.toString().equals("[B, A, C]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 28
        list1.set(0, "A");
        success = list1.toString().equals("[A, A, C]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 29
        list1.set(2,"A");
        success = list1.toString().equals("[A, A, A]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 30
        list1.set(1, "C");
        success = list1.toString().equals("[A, C, A]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 31
        success = list1.get(0).equals("A");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 32
        success = list1.get(1).equals("C");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 33
        success = list1.get(2).equals("A");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 34
        list1.remove(1);
        success = list1.toString().equals("[A, A]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 35
        list1.remove(1);
        success = list1.toString().equals("[A]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 36
        list1.remove(0);
        success = list1.toString().equals("[]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 37
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.remove("A");
        success = list1.toString().equals("[B, C]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 38
        list1.remove("C");
        success = list1.toString().equals("[B]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 39
        list1.remove("B");
        success = list1.toString().equals("[]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 40
        list1.add("A");
        list1.add("B");
        list1.add("C");
        success = list1.getSubList(0, 0).toString().equals("[]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 41
        success = list1.getSubList(0, 1).toString().equals("[A]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 42
        success = list1.getSubList(1, 2).toString().equals("[B]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 43
        success = list1.size()==3;
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 44
        success = list1.getSubList(0, 2).size()==2;
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 45
        success = list1.getSubList(0,1).size()==1;
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 46
        success = list1.indexOf("A")==0;
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 47
        success = list1.indexOf("B")==1;
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 48
        success = list1.indexOf("C")==2;
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 49
        success = list1.indexOf("A", 1)==-1;
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 50
        success = list1.indexOf("C",1)==2;
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 51
        success = list1.indexOf("B",0)==1;
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 52
        list1.removeRange(0,0);
        success = list1.toString().equals("[A, B, C]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 53
        list1.removeRange(0,2);
        success = list1.toString().equals("[C]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 54
        list1.removeRange(0,1);
        success = list1.toString().equals("[]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 55
        success = list1.equals(list1);
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 56
        success = !list1.equals("A");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 57
        success = !list1.equals(it);
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 58
        list1.add("A");
        list1.add("B");
        list1.add("C");  
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.removeFirst();
        success = list1.toString().equals("[B, C, A, B, C, A, B, C]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 59
        list1.removeFirst();
        success = list1.toString().equals("[C, A, B, C, A, B, C]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 60
        list1.removeFirst();
        success = list1.toString().equals("[A, B, C, A, B, C]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 61
        list1.removeLast();
        success = list1.toString().equals("[A, B, C, A, B]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 62
        list1.removeLast();
        success = list1.toString().equals("[A, B, C, A]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
        //test 63
        list1.removeLast();
        success = list1.toString().equals("[A, B, C]");
        if (success){
			System.out.println("Test "+test+" passed");
		}
		else {
			System.out.println("Test "+test+" failed");
		}
		test++;
    }

    private static Object[] toArray(LinkedList<String> list) {
        Object[] result = new Object[list.size()];
        Iterator<String> it = list.iterator();
        int index = 0;
        while( it.hasNext() ){
            result[index] = it.next();
            index++;
        }
        return result;
    }

    //pre: none
    private static boolean arraysSame(Object[] one, Object[] two)  {
        boolean same;
        if( one == null || two == null ) {
            same = (one == two);
        }
        else {
            //neither one or two are null
            assert one != null && two != null;
            same = one.length == two.length;
            if( same ) {
                int index = 0;
                while( index < one.length && same ) {
                    same = ( one[index].equals(two[index]) );
                    index++;
                }
            }
        }
        return same;
    }

}
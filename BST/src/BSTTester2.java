/*
 * Place results of experiments here:
Q1: n=1000 Avg. time: 3.6380070000000003E-4 height: 11.9 size: 1000.0
Q1: n=2000 Avg. time: 7.595160999999999E-4 height: 13.0 size: 2000.0
Q1: n=4000 Avg. time: 0.0014351433000000002 height: 14.1 size: 4000.0
Q1: n=8000 Avg. time: 0.0030291025999999994 height: 15.3 size: 8000.0
Q1: n=16000 Avg. time: 0.0096491679 height: 16.7 size: 16000.0
Q1: n=32000 Avg. time: 0.015115969000000002 height: 18.0 size: 31999.7
Q1: n=64000 Avg. time: 0.034012859 height: 19.0 size: 63999.5
Q1: n=128000 Avg. time: 0.0761874424 height: 20.1 size: 127998.2
Q1: n=256000 Avg. time: 0.18078243549999995 height: 21.3 size: 255990.8
Q1: n=512000 Avg. time: 0.43518045539999994 height: 22.8 size: 511971.1
Q1: n=1024000 Avg. time: 1.0311676937 height: 24.0 size: 1023882.3

Q2: n=1000 Avg. time: 0.0011001994 height: 0.0 size: 1000.0
Q2: n=2000 Avg. time: 4.154649E-4 height: 0.0 size: 2000.0
Q2: n=4000 Avg. time: 7.279796E-4 height: 0.0 size: 4000.0
Q2: n=8000 Avg. time: 0.0011808632 height: 0.0 size: 8000.0
Q2: n=16000 Avg. time: 0.0021661095 height: 0.0 size: 16000.0
Q2: n=32000 Avg. time: 0.0055643045 height: 0.0 size: 31999.9
Q2: n=64000 Avg. time: 0.0116139058 height: 0.0 size: 63999.6
Q2: n=128000 Avg. time: 0.027917240200000006 height: 0.0 size: 127998.3
Q2: n=256000 Avg. time: 0.0779104582 height: 0.0 size: 255991.2
Q2: n=512000 Avg. time: 0.1953172961 height: 0.0 size: 511970.1
Q2: n=1024000 Avg. time: 0.5178900413 height: 0.0 size: 1023881.3

Q3: n=1000 Avg. time: 2.4580579999999993E-4 height: 10.0 size: 1000.0
Q3: n=2000 Avg. time: 5.670657E-4 height: 11.0 size: 2000.0
Q3: n=4000 Avg. time: 0.0012756628000000002 height: 12.0 size: 4000.0
Q3: n=8000 Avg. time: 0.0028254044 height: 13.0 size: 8000.0
Q3: n=16000 Avg. time: 0.0062081392 height: 14.0 size: 16000.0
Q3: n=32000 Avg. time: 0.0135913261 height: 15.0 size: 32000.0
Q3: n=64000 Avg. time: 0.029966029300000002 height: 16.0 size: 64000.0
Q3: n=128000 Avg. time: 0.0669515084 height: 17.0 size: 128000.0
Q3: n=256000 Avg. time: 0.15152870870000001 height: 18.0 size: 256000.0
Q3: n=512000 Avg. time: 0.3795089017 height: 19.0 size: 512000.0
Q3: n=1024000 Avg. time: 0.7885509491999999 height: 20.0 size: 1024000.0

Q4: n=1000 Avg. time: 6.018800000000001E-5 height: 0.0 size: 1000.0
Q4: n=2000 Avg. time: 1.246104E-4 height: 0.0 size: 2000.0
Q4: n=4000 Avg. time: 2.7588199999999997E-4 height: 0.0 size: 4000.0
Q4: n=8000 Avg. time: 5.943249E-4 height: 0.0 size: 8000.0
Q4: n=16000 Avg. time: 0.0014170561000000001 height: 0.0 size: 16000.0
Q4: n=32000 Avg. time: 0.0033529409999999995 height: 0.0 size: 32000.0
Q4: n=64000 Avg. time: 0.0076447053000000004 height: 0.0 size: 64000.0
Q4: n=128000 Avg. time: 0.020358398000000003 height: 0.0 size: 128000.0
Q4: n=256000 Avg. time: 0.037532771300000004 height: 0.0 size: 256000.0
Q4: n=512000 Avg. time: 0.08610546100000001 height: 0.0 size: 512000.0
Q4: n=1024000 Avg. time: 0.1934803639 height: 0.0 size: 1024000.0

Q1 is BinaryTreeSet with random data.
Q2 is Java's TreeSet with random data.
Q3 is BinaryTreeSet with sorted data.
Q4 is Java's TreeSet with sorted data.

Data collected from dots.cs.utexas.edu on 04/05/2014.
 */

/**
 * Test class for binary search tree
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.TreeSet;

public class BSTTester2 {

    private static int testNo = 0;
    private static boolean succeeded = true;

    public static void main(String[] args) {
	studentTests();
        if (!succeeded) System.exit(1);
        providedTests();
        //if (!succeeded) System.exit(1);

	perfTests();
    }

    public static void studentTests() {
        BinarySearchTree<String> t = new BinarySearchTree<String>();

	ArrayList<String> originalContents = new ArrayList<String>();
	originalContents.add("5555");
	originalContents.add("0123");
	originalContents.add("6666");
	originalContents.add("4444");
	originalContents.add("1111");
	originalContents.add("0000");
	originalContents.add("1100");
	originalContents.add("0120");
	ArrayList<String> expectedContents = new ArrayList<String>(originalContents);
	Collections.sort(expectedContents);

	for (String s : originalContents) {
	    runTest(true, t.add(s), "add('"+s+"')");
	    t.printTree(); System.out.println();
	}

	//t.rotateRootLeft();
        //t.printTree(); System.out.println();

        runTest("6666", t.max(), "max()");
        runTest("0000", t.min(), "min()");
	runTest(expectedContents, t.getAll(), "getAll");

	//System.out.println("Removing 0000...");
        runTest(true, t.remove("0000"), "remove existing");
	runTest(7, t.size(), "size after remove");
	t.printTree();

	runTest(true, t.remove("0120"), "remove existing");
	runTest(6, t.size(), "size after remove");
	t.printTree();

	runTest(true, t.remove("1111"), "remove existing");
	runTest(5, t.size(), "size after remove");
	t.printTree();

	//runTest("1100", t.get(0), "get(0)");
	List<String> contents = t.getAll();
	expectedContents.remove("0000");
	expectedContents.remove("0120");
	expectedContents.remove("1111");
	runTest(expectedContents, contents, "getAll");

	System.out.println(contents);
	for (int i=0; i<contents.size(); i++) {
	    runTest(contents.get(i), t.get(i), "get("+i+")");
	    runTest(contents.subList(0, i), t.getAllLessThan(contents.get(i)), "getAllLessThan("+contents.get(i)+")");
	    runTest(contents.subList(i+1, contents.size()), t.getAllGreaterThan(contents.get(i)), "getAllGreaterThan("+contents.get(i)+")");
	}

	runTest(1, t.numNodesAtDepth(0), "numNodesAtDepth(0)");
	runTest(2, t.numNodesAtDepth(1), "numNodesAtDepth(1)");
	runTest(2, t.numNodesAtDepth(2), "numNodesAtDepth(2)");
	runTest(0, t.numNodesAtDepth(3), "numNodesAtDepth(3)");

	runTest(false, t.add("5555"), "add() already existing");

	//
	t.printTree();
	t.remove("4444");
	t.printTree();
	runTest(4, t.size(), "remove root node");

	runTest(2, t.height(), "height");
	runTest(false, t.isPresent("0000"), "isPresent(0000)");
	runTest(true, t.isPresent("6666"), "isPresent(6666)");
	runTest(false, t.isPresent("0505"), "isPresent(0505)");

	runTest(false, t.iterativeAdd("5555"), "iterativeAdd(5555)");
	runTest(true, t.iterativeAdd("0505"), "iterativeAdd(0505)");
	runTest(true, t.isPresent("0505"), "isPresent(0505)");

	runTest("0123", t.min(), "min");
	runTest("6666", t.max(), "max");
	t.printTree();
	runTest(5, t.size(), "size");
	runTest(2, t.height(), "height");

	runTest(1, t.numNodesAtDepth(0), "numNodesAtDepth(0)");
	runTest(2, t.numNodesAtDepth(1), "numNodesAtDepth(1)");
	runTest(2, t.numNodesAtDepth(2), "numNodesAtDepth(2)");
	runTest(0, t.numNodesAtDepth(3), "numNodesAtDepth(3)");

	// Empty the tree
	for (String s : t.getAll()) {
	    runTest(true, t.remove(s), "remove("+s+")");
	}
	runTest(0, t.size(), "size of empty tree");
	runTest(-1, t.height(), "height of empty tree");
	expectedContents = new ArrayList<String>();
	runTest(expectedContents, t.getAll(), "Contents of empty tree");
	runTest(expectedContents, t.getAllGreaterThan("0000"), "Values greater than in empty tree");
	runTest(expectedContents, t.getAllLessThan("7777"), "Values less than in empty tree");
	runTest(false, t.isPresent("5555"), "isPresent on empty tree");
	runTest(0, t.numNodesAtDepth(0), "numNodes at depth 0");
	runTest(0, t.numNodesAtDepth(1), "numNodes at depth 1");
	runTest(0, t.numNodesAtDepth(2), "numNodes at depth 2");
	runTest(false, t.remove("5555"), "Remove from empty tree");

	/*ArrayList<String> expected = new ArrayList<String>();
	expected.add("0123");
	expected.add("1100");
	runTest(expected, t.getAllLessThan("4441"));
	expected.add("4444");
	runTest(expected, t.getAllLessThan("4445"));
	expected.add("5555");
	runTest(expected, t.getAllLessThan());*/
    }

    public static void runTest(Object expected, Object actual, String test) {
        testNo++;
        boolean passed = false;
        if (expected == null && actual == null)
            passed = true;
        else if (expected == null || actual == null)
            passed = false;
        else
            passed = expected.equals(actual);
        if (passed) {
            System.out.println("Passed test "+testNo+": "+test);
        } else {
            System.out.println("FAILED test "+testNo+": "+test);
            System.out.println("Expected: "+expected);
            System.out.println("Actual: "+actual);
        }
	System.out.println();
        succeeded &= passed;
    }

    public static void perfTests() {
	// Q1: Record time, height, size for tree w/ 1000 random ints
	int n = 1000;
	for (n=1000; n<1500000; n*=2) {
	    double time = 0.0;
	    double avgHeight = 0.0;
	    double avgSize = 0.0;
	    Stopwatch s = new Stopwatch();
	    for (int cnt = 0; cnt<10; cnt++) {
		Random r = new Random();
		BinarySearchTree b = new BinarySearchTree();
		s.start();
		for(int i = 0; i < n; i++) {
		    b.add( new Integer( r.nextInt() ) ); 
		}
		s.stop();
		time += s.time();
		avgHeight += (double)b.height();
		avgSize += (double)b.size();
	    }
	    System.out.println("Q1: n="+n+" Avg. time: "+time/10+" height: "+avgHeight/10+" size: "+avgSize/10);
	}
	System.out.println();

	// Q2: Same experiment, but with java's TreeSet
	for (n=1000; n<1500000; n*=2) {
	    double time = 0.0;
	    double avgHeight = 0.0;
	    double avgSize = 0.0;
	    Stopwatch s = new Stopwatch();
	    for (int cnt = 0; cnt<10; cnt++) {
		Random r = new Random();
		TreeSet b = new TreeSet();
		s.start();
		for(int i = 0; i < n; i++) {
		    b.add( new Integer( r.nextInt() ) ); 
		}
		s.stop();
		time += s.time();
		avgHeight += 0;
		avgSize += (double)b.size();
	    }
	    System.out.println("Q2: n="+n+" Avg. time: "+time/10+" height: "+avgHeight/10+" size: "+avgSize/10);
	}
	System.out.println();

	// Q3: Same experiment, but with sorted ints
	for (n=1000; n<1500000; n*=2) {
	    double time = 0.0;
	    double avgHeight = 0.0;
	    double avgSize = 0.0;
	    Stopwatch s = new Stopwatch();
	    for (int cnt = 0; cnt<10; cnt++) {
		BinarySearchTree b = new BinarySearchTree();
		s.start();
		for(int i = 0; i < n; i++) {
		    b.add( new Integer( i ) ); 
		}
		s.stop();
		time += s.time();
		avgHeight += (double)b.height();
		avgSize += (double)b.size();
	    }
	    System.out.println("Q3: n="+n+" Avg. time: "+time/10+" height: "+avgHeight/10+" size: "+avgSize/10);
	}
	System.out.println();

	// Q4: Same experiment, but with java's TreeSet
	for (n=1000; n<1500000; n*=2) {
	    double time = 0.0;
	    double avgHeight = 0.0;
	    double avgSize = 0.0;
	    Stopwatch s = new Stopwatch();
	    for (int cnt = 0; cnt<10; cnt++) {
		TreeSet b = new TreeSet();
		s.start();
		for(int i = 0; i < n; i++) {
		    b.add( new Integer( i ) ); 
		}
		s.stop();
		time += s.time();
		avgHeight += 0;
		avgSize += (double)b.size();
	    }
	    System.out.println("Q4: n="+n+" Avg. time: "+time/10+" height: "+avgHeight/10+" size: "+avgSize/10);
	}
    }

    public static void providedTests() {
        BinarySearchTree<String> t = new BinarySearchTree<String>();

        //test 1
        System.out.println("Test 1: empty tree created.");
        showTestResults( t.size() == 0, 1 );

        //test 2
        System.out.println("Test 2: height of empty tree must be -1.");
        showTestResults( t.height() == -1, 2 );

        //test 3
        System.out.println("Test 3: empty tree must " +
        "not contain the String \"abyss\".");
        showTestResults( t.isPresent("abyss") == false, 3 );

        t.add("abyss");
        //test 4
        System.out.println("Test 4: added \"abyss\" to the" +
        "tree. Size must be 1.");		
        showTestResults( t.size() == 1, 4 );

        //test 5
        System.out.println("Test 5: height of tree with 1" +
        "element must be 0.");
        showTestResults( t.height() == 0, 5 );

        //test 6
        System.out.println("Test 6: \"abyss\" must be in the tree.");
        showTestResults( t.isPresent("abyss") == true, 6 );

        //test 7
        System.out.println("Test 7: tree must " +
        "not contain the String \"beep\".");		
        showTestResults( t.isPresent("beep") == false, 7);

        //test 8
        System.out.println("Test 8: min value must be" +
        "\"abyss\" at this point.");		
        showTestResults( t.min().equals("abyss"), 8);

        //test 9
        System.out.println("Test 9: max value must be" +
        "\"abyss\" at this point.");    
        showTestResults( t.max().equals("abyss"), 9);

        t.add("abyss");
        //test 10
        System.out.println("Test 10: attempt to add \"abyss\"" +
        "again. size must remain 1.");    
        showTestResults( t.size() == 1, 10 );

        //test 11
        System.out.println("Test 11: attempt to add \"abyss\"" +
        "again. height must remain 0.");  
        showTestResults( t.height() == 0, 11 );

        //test 12
        System.out.println("Test 12: \"abyss\" must still be" +
        "present.");  
        showTestResults( t.isPresent("abyss") == true, 12 );

        t.add("beep");
        //test 13
        System.out.println("Test 13: added \"beep\" to the" +
        "tree. Size must be 2.");   		
        showTestResults( t.size() == 2, 13 );

        //test 14
        System.out.println("Test 14: height of tree with 2" +
        "elements must be 1."); 
        showTestResults( t.height() == 1, 14 );

        //test 15
        System.out.println("Test 15: Removing \"abyss\" from the tree.");
        showTestResults( t.remove("abyss") == true, 15 );

        //test 16
        System.out.println("Test 16: Removing \"beep\" from the tree.");
        showTestResults( t.remove("beep") == true, 16 );

        //test 17
        System.out.println("Test 17: Tree must be empty at this point.");
        showTestResults( t.size() == 0, 17 );

        t.add("beep");
        t.add("abyss");
        t.add("calls");
        ArrayList<String> expected = new ArrayList<String>();
        expected.add("abyss");
        expected.add("beep");
        expected.add("calls");

        //test 18
        System.out.println("Test 18: Added \"beep\", \"abyss\", and" +
                "\"calls\" to the tree in that order.\n" +
        "Testing getAll method.");

        showTestResults( expected.equals( t.getAll() ) == true, 18 );

        //test 19
        t.add("bit");
        t.add("dish");
        System.out.println("Test 19: Added \"bit\" and \"dish\" to" +
        "tree. Checking that \"yes\" is not present.");		
        showTestResults( t.remove("yes") == false, 19);

        //test 20
        t.add("a");
        System.out.println("Test 20: Added \"a\" and then " +
        "removed it.");
        showTestResults(t.remove("a") == true, 20);

        //test 21
        System.out.println("Test 21: Checking that \"calls\" is still present.");
        showTestResults(t.remove("calls") == true, 21);

        //test 22
        t.remove("abyss");
        System.out.println("Test 22: Removing \"abyss\". " +
        "Checking that \"beep\" is still present.");
        showTestResults(t.remove("beep") == true, 22);

        // Test 23 - Adding unbalanced
        BinarySearchTree<Integer>  iTree = new BinarySearchTree<Integer>();
        ArrayList<Integer> iExpected = new ArrayList<Integer>();
        iTree.add(1);
        iTree.iterativeAdd(2);
        iTree.iterativeAdd(3);
        iTree.add(-1);
        iExpected.add(-1);
        iExpected.add(1);
        iExpected.add(2);
        iExpected.add(3);
        System.out.println("Test 23: Adding unbalanced");
        showTestResults( iExpected.equals( iTree.getAll() ) == true, 23 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 24 - Adding unbalanced
        iTree.iterativeAdd(-2);
        iExpected.add(0, -2);
        System.out.println("Test 24: Adding unbalanced");
        showTestResults( iExpected.equals( iTree.getAll() ) == true, 24 );
        System.out.println(iTree.getAll());
        iTree.printTree();

        // Test 25 - Removing root [-2, -1, 2, 3]
        iTree.remove(1);
        iExpected.remove(new Integer(1));
        System.out.println("Test 25: Removing root");
        showTestResults( iExpected.equals( iTree.getAll() ) == true, 25 );
        System.out.println(iTree.getAll());
        iTree.printTree();

        // Test 26 - Removing new root [-2, 2, 3]
        iTree.remove(-1);
        iExpected.remove(new Integer(-1));
        System.out.println("Test 26: Removing new root");
        showTestResults( iExpected.equals( iTree.getAll() ) == true, 26 );
        System.out.println(iTree.getAll());
        iTree.printTree();

        // Test 27 - IsPresent new root
        System.out.println("Test 27: IsPresent new root");
        showTestResults( iTree.isPresent(-2) == true, 27 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 28 - IsPresent rightmost minimum
        System.out.println("Test 28: IsPresent rightmost minimum");
        showTestResults( iTree.isPresent(2) == true, 28 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 29 - Size
        System.out.println("Test 29: Size of defunct tree");
        showTestResults( iTree.size() == 3, 29 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 30 - Size removing rightmost minimum [-2, 3]
        iTree.remove(2);
        iExpected.remove(new Integer(2));
        System.out.println("Test 30: Size of defunct tree");
        showTestResults( iTree.size() == 2, 30 );
        System.out.println(iTree.getAll());
        iTree.printTree();

        // Test 31 - Height
        System.out.println("Test 31: Height of defunct tree");
        showTestResults( iTree.height() == 1, 31 );
        System.out.println(iTree.getAll());
        iTree.printTree();

        // Test 32 - Height removing root [3]
        iTree.remove(-2);
        iExpected.remove(new Integer(-2));
        System.out.println("Test 32: Height of defunct tree");
        showTestResults( iTree.height() == 0, 32 );
        System.out.println(iTree.getAll());
        iTree.printTree();

        // Test 33 - Max of tree
        System.out.println("Test 33: Max of defunct tree");
        showTestResults( iTree.max().equals(new Integer(3)), 33 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 34 - Max of tree [-1, 3]
        iTree.add(-1);
        System.out.println("Test 34: Max of defunct tree");
        showTestResults( iTree.max().equals(new Integer(3)), 34 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 35 - Min of tree
        System.out.println("Test 35: Min of defunct tree");
        showTestResults( iTree.min().equals(new Integer(-1)), 35 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 36 - Min of tree
        iTree.add(4);
        System.out.println("Test 36: Min of defunct tree");
        showTestResults( iTree.min().equals(new Integer(-1)), 36 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 37 - Number of Nodes at Depth
        System.out.println("Test 37: Number of Nodes at depth of defunct tree");
        showTestResults( iTree.numNodesAtDepth(0) == 1, 37 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 38 - Number of Nodes at Depth
        System.out.println("Test 38: Number of Nodes at depth of defunct tree");
        showTestResults( iTree.numNodesAtDepth(1) == 2, 38 );
        //System.out.println(iTree.getAll());
        //iTree.printTree();

        // Test 39 - height
        int[] values = {50, 25, -10, 10, 5, 0, 23, 30, 35, 40, 100, 75, 200};
        BinarySearchTree<Integer> t2 = new BinarySearchTree<Integer>();
        for(int i : values)
            t2.add(i);
	// This is not an important value.
        /*System.out.println("Height again for non trivial tree");
        showTestResults(t2.height() == 5, 39);*/
        //System.out.println(t2.getAll());
        //t2.printTree();

        // Test 40 - 52: get kth
        System.out.println("getKth");
        Arrays.sort(values);
	System.out.println(Arrays.toString(values));
	t2.printTree();
        for(int i = 0; i < values.length; i++) {
            showTestResults(t2.get(i).equals(new Integer(values[i])), 40 + i);
        }

        // Test 53: getAllLessThan
        System.out.println("get all less than -50");
        showTestResults(t2.getAllLessThan(-50).equals(new ArrayList<Integer>()), 53);
        //System.out.println(t2.getAll());
        //t2.printTree();


        // Test 54: getAllLessThan
        System.out.println("get all less than 25");
        ArrayList<Integer> expectedList = new ArrayList<Integer>();
        int cutoff = 25;
        int index = 0;
        while(index < values.length && values[index] < cutoff) {
            expectedList.add(values[index]);
            index++;
        }
        List<Integer> actual = t2.getAllLessThan(cutoff);    
        showTestResults(actual.equals(expectedList), 54);
        //System.out.println(expectedList);
        //System.out.println(t2.getAll());
        //t2.printTree();

        // Test 55: getAllLessThan
        System.out.println("get all less than 1000");
        expectedList.clear();
        cutoff = 1000;
        index = 0;
        while(index < values.length && values[index] < cutoff) {
            expectedList.add(values[index]);
            index++;
        }
        actual = t2.getAllLessThan(cutoff);    
        showTestResults(actual.equals(expectedList), 55);
        //System.out.println(expectedList);
        //System.out.println(t2.getAll());
        //t2.printTree();


        // Test 57: getAllGreaterThan
        System.out.println("get all greater than 1000");
        expectedList.clear();
        cutoff = 1000;
        index = values.length - 1;
        while(index >= 0 && values[index] > cutoff) {
            expectedList.add(values[index]);
            index--;
        }
        Collections.reverse(expectedList);
        actual = t2.getAllGreaterThan(cutoff);    
        showTestResults(actual.equals(expectedList), 57);
        //System.out.println(expectedList);
        //System.out.println(t2.getAll());
        //t2.printTree();

        // Test 58: getAllGreaterThan
        System.out.println("get all greater than 25");
        expectedList.clear();
        cutoff = 25;
        index = values.length - 1;
        while(index >= 0 && values[index] > cutoff) {
            expectedList.add(values[index]);
            index--;
        }
        Collections.reverse(expectedList);
        actual = t2.getAllGreaterThan(cutoff);    
        showTestResults(actual.equals(expectedList), 58);
        //System.out.println(expectedList);
        //System.out.println(t2.getAll());
        //t2.printTree();


        // Test 59: getAllGreaterThan
        System.out.println("get all greater than -1000");
        expectedList.clear();
        cutoff = -1000;
        index = values.length - 1;
        while(index >= 0 && values[index] > cutoff) {
            expectedList.add(values[index]);
            index--;
        }
        Collections.reverse(expectedList);
        actual = t2.getAllGreaterThan(cutoff);    
        showTestResults(actual.equals(expectedList), 59);
        //System.out.println(expectedList);
        //System.out.println(t2.getAll());
        //t2.printTree();
          
        
        // Test 60, stress test
        System.out.println("Stress test, comparing size to HashSet");
        BinarySearchTree<Integer> bst1 = new BinarySearchTree<Integer>();
        HashSet<Integer> hs = new HashSet<Integer>();
        Random r = new Random();
        int numValues = 500000;
        for(int i = 0; i < numValues; i++) {
            int temp = r.nextInt();
            bst1.add(temp);
            hs.add(temp);
        }
	/*bst1.printTree();
	System.out.println(hs);
	System.out.println(hs.size()+" "+bst1.size());*/
        showTestResults(hs.size() == bst1.size(), 60);

        // Test 61, stress test
        System.out.println("Stress test, comparing size to HashSet");
        bst1 = new BinarySearchTree<Integer>();
        hs = new HashSet<Integer>();
        numValues = 1000000;
        for(int i = 0; i < numValues; i++) {
            int temp = r.nextInt();
            bst1.add(temp);
            hs.add(temp);
        }
        showTestResults(hs.size() == bst1.size(), 61);
    }

    private static void showTestResults(boolean passed, int testNum) {
        if( passed )
            System.out.println( "test " + testNum + " passed.");
        else
            System.out.println( "test " + testNum + " failed.");
	succeeded &= passed;
    }
}
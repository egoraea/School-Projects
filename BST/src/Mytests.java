import java.util.ArrayList;


public class Mytests {
	public void main(){
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

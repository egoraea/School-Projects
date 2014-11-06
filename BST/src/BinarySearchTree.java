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

import java.util.ArrayList;
import java.util.List;
/**
 * Shell for a bianry search tree class.
 * @author scottm
 *
 */

public class BinarySearchTree<E extends Comparable<E>> {

    private BSTNode<E> root;
    // CS314 students. Add any other instance variables you want here
    private int size;
    // CS314 students. Add a default contructor here.
    public BinarySearchTree(){
    	root = null;
    	size = 0;
    }
    /**
     *  Add the specified item to this Binary Search Tree if it is not already present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Add value to this tree if not already present. Return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to add to the tree
     *  @return false if an item equivalent to value is already present
     *  in the tree, return true if value is added to the tree and size() = old size() + 1
     */
    public boolean add(E value) {
    	if( value == null)
            throw new IllegalArgumentException();
    	if (size == 0){
    		size++;
    		root = new BSTNode<E>(null,value,null);
    		return true;
    	}
        return addHelper(root, value);
    }
    private boolean addHelper(BSTNode<E> node, E val){
    	if (node == null){
    		return true;
    	}
    	int temp = val.compareTo(node.getData());
    	if (temp == 0)
			return false;
		else if (temp<0){
			if (addHelper(node.getLeft(),val)){
				if(node.getLeft()==null){
					node.setLeft(new BSTNode<E>(null,val,null));
					size++;
				}
				return true;
			}
		}
		else{
			if (addHelper(node.getRight(),val)){
				if(node.getRight()==null){
					node.setRight(new BSTNode<E>(null,val,null));
					size++;
				}
				return true;
			}	
		}
    	return false;
    }
    /**
     *  Remove a specified item from this Binaray Search Tree if it is present.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: Remove value from the tree if present, return true if this tree
     *  changed as a result of this method call, false otherwise.
     *  @param value the value to remove from the tree if present
     *  @return false if value was not present
     *  returns true if value was present and size() = old size() - 1
     */
    public boolean remove(E value) {
    	if( value == null)
            throw new IllegalArgumentException();
        if (size==0){
        	return false;
        }
    	int old = size;
    	root = removeHelper(root, value);
    	return old != size;
    }
    private BSTNode<E> removeHelper(BSTNode<E> node, E val){
    	BSTNode<E> curr = node;
    	int temp = node.getData().compareTo(val);
    	if (temp>0){
    		if (curr.getLeft()!=null){
    			curr.setLeft(removeHelper(node.getLeft(),val)); 
    		} else {
    			return curr;
    		}
    	} else if (temp<0){
    		if (curr.getRight()!=null){
    			curr.setRight(removeHelper(node.getRight(),val));
    		} else {
    			return curr;
    		}
    	} else {
    		boolean left = curr.getLeft()!=null;
    		boolean right = curr.getRight()!=null;
    		if (!left && !right){
    			curr = null;
    			size--;
    		} else if (!right){
    			curr = curr.getLeft();
    			size--;
    		} else if (!left){
    			curr = curr.getRight();
    			size--;
    		} else {
    			if (Math.random()>.5){
    				E max = findMax(curr.getLeft());
    				curr.setData(max);
    				curr.setLeft(removeHelper(curr.getLeft(),max));  
    			} else {
    				E min = findMin(curr.getRight());
    				curr.setData(min);
    				curr.setRight(removeHelper(curr.getRight(),min));
    			}
    		}
    	}
    	return curr;
    }
    private E findMax(BSTNode<E> node){
    	BSTNode<E> temp = node;
        while (temp.getRight()!=null){
        	temp = temp.getRight();
        }
    	return temp.getData();
    }
    
    private E findMin(BSTNode<E> node){
    	BSTNode<E> temp = node;
        while (temp.getLeft()!=null){
        	temp = temp.getLeft();
        }
    	return temp.getData();
    }
    /**
     *  Check to see if the specified element is in this Binary Search Tree.
     *  <br>
     *  pre: <tt>value</tt> != null<br>
     *  post: return true if value is present in tree, false otherwise
     *  @param value the value to look for in the tree
     *  @returns true if value is present in this tree, false otherwise
     */
    public boolean isPresent(E value) {
    	if( value == null)
            throw new IllegalArgumentException();
    	BSTNode<E> curr = root;
    	while(curr!=null){
    		int temp = value.compareTo(curr.getData());
    		if (temp == 0)
    			return true;
    		else if (temp<0)
    			curr = curr.getLeft();
    		else 
    			curr = curr.getRight();
    	}
        return false;
    }


    /**
     *  Return how many elements are in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the number of items in this tree
     *  @returns the number of items in this Binary Search Tree
     */
    public int size() {
        return size;
    }

    /**
     *  return the height of this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return the height of this tree.
     *  If the tree is empty return -1, otherwise return the
     *  height of the tree
     *  @returns the height of this tree or -1 if the tree is empty
     */
    public int height() {
    	if (root == null){
    		return -1;
    	}
        return heightHelper(0,root);
    }
    private int heightHelper(int height, BSTNode<E> node){
    	int result = height;
    	if (node.getLeft()!=null){
    		result = heightHelper(height+1,node.getLeft());
    	}
    	if (node.getRight()!=null){
    		int temp = heightHelper(height+1,node.getRight());
    		if (temp>result)
    			result = temp;
    	}
    	return result;
    }
    /**
     *  Return a list of all the elements in this Binary Search Tree.
     *  <br>
     *  pre: none<br>
     *  post: return a List object with all data from the tree in ascending order. 
     *  If the tree is empty return an empty List
     *  @returns a List object with all data from the tree in sorted order
     *  if the tree is empty return an empty List
     */
    public List<E> getAll() {
       ArrayList<E> result = new ArrayList<E>();
       if (size==0){
    	   return result;
       }
       getAllHelper(result, root);
    	return result;
    }
    private void getAllHelper(List<E> list, BSTNode<E> node){
    	if (node.getLeft()!=null){
    		getAllHelper(list,node.getLeft());
    	}
    	list.add(node.getData());
    	if (node.getRight()!=null){
    		getAllHelper(list,node.getRight());
    	}
    }


    /**
     * return the maximum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the largest value in this Binary Search Tree
     * @return the maximum value in this tree
     */
    public E max() {
    	if( size <= 0)
            throw new IllegalArgumentException();
        BSTNode<E> temp = root;
        while (temp.getRight()!=null){
        	temp = temp.getRight();
        }
    	return temp.getData();
    }

    /**
     * return the minimum value in this binary search tree.
     * <br>
     * pre: <tt>size()</tt> > 0<br>
     * post: return the smallest value in this Binary Search Tree
     * @return the minimum value in this tree
     */
    public E min() {
    	if( size <= 0)
            throw new IllegalArgumentException();
    	BSTNode<E> temp = root;
        while (temp.getLeft()!=null){
        	temp = temp.getLeft();
        }
    	return temp.getData();
    }

    /**
     * An add method that implements the add algorithm iteratively instead of recursively.
     * <br>pre: data != null
     * <br>post: if data is not present add it to the tree, otherwise do nothing.
     * @param data the item to be added to this tree
     * @return true if data was not present before this call to add, false otherwise.
     */
    public boolean iterativeAdd(E data) {
    	if( data == null)
            throw new IllegalArgumentException();
    	if (size == 0){
    		root = new BSTNode<E>(null,data,null);
    		size++;
    		return true;
    	}
    	BSTNode<E> curr = root;
    	BSTNode<E> prev = null;
    	int temp = data.compareTo(curr.getData());
    	while(curr!=null){
    		temp = data.compareTo(curr.getData());
    		if (temp == 0)
    			return false;
    		else if (temp<0){
    			prev = curr;
    			curr = curr.getLeft();
    		}
    		else {
    			prev = curr;
    			curr = curr.getRight();
    		}
    	}	
    	if (temp<0)
    		prev.setLeft(new BSTNode<E>(null,data,null));
    	else 
    		prev.setRight(new BSTNode<E>(null,data,null));
    	size++;
        return true;
    }


    /**
     * Return the "kth" element in this Binary Search Tree. If kth = 0 the 
     * smalles value (minimum) is returned. If kth = 1 the second smallest value is
     * returned, and so forth.
     * <br>pre: 0 <= kth < size()
     * @param kth indicates the rank of the element to get
     * @return the kth value in this Bianry Search Tree
     */
    public E get(int kth) {
    	if( !(0<=kth && kth<size))
            throw new IllegalArgumentException();
        return getHelper(kth,new int[]{0},root);
    }
    private E getHelper(int kth,int[] k, BSTNode<E> node){
    	if (node.getLeft()!=null){
    		E temp = getHelper(kth,k,node.getLeft());
    		if(temp!=null)
    			return temp;
    	}
    	if (k[0]==kth)
    		return node.getData();
    	k[0]++;
    	if (node.getRight()!=null){
    		E temp = getHelper(kth,k,node.getRight());
    		if(temp!=null)
    			return temp;
    	}
    	return null;
    }


    /**
     * Return a List with all values in this Binary Search Tree that are less than
     * the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are less than the parameter value. If there are
     * no values in this tree less than value return an empty list. The elements of the list are in ascending order.
     */
    public List<E> getAllLessThan(E value) {
    	if( value == null)
            throw new IllegalArgumentException();
        ArrayList<E> list = new ArrayList<E>();
        if (size==0){
        	return list;
        }
    	lessThanHelper(list,root,value);
    	return list;
    }
    private void lessThanHelper(List<E> list, BSTNode<E> node, E val){
    	int temp = node.getData().compareTo(val);
    	if (temp<0){
    		if (node.getLeft()!=null){
    			getAllHelper(list,node.getLeft());
    		}
    		list.add(node.getData());
    		if (node.getRight()!=null){
    			lessThanHelper(list,node.getRight(),val);
    		}
    	} else {
    		if (node.getLeft()!=null){
    			lessThanHelper(list,node.getLeft(),val);
    		}
    	}
    }

    /**
     * Return a List with all values in this Binary Search Tree that are greater than
     * the parameter <tt>value</tt>.
     * <tt>value</tt> != null<br>
     * @param value the cutoff value
     * @return a List with all values in this tree that are greater than the parameter value. If there are
     * no values in this tree greater than value return an empty list. The elements of the list are in ascending order.
     */
    public List<E> getAllGreaterThan(E value) {
    	if( value == null)
            throw new IllegalArgumentException();
        ArrayList<E> list = new ArrayList<E>();
        if (size==0){
        	return list;
        }
      	greaterThanHelper(list,root,value);
      	return list;
      }
      private void greaterThanHelper(List<E> list, BSTNode<E> node, E val){
    	  int temp = node.getData().compareTo(val);
      	if (temp>0){
      		if (node.getLeft()!=null){
      			greaterThanHelper(list,node.getLeft(),val);
      		}
      		list.add(node.getData());
      		if (node.getRight()!=null){
      			getAllHelper(list,node.getRight());
      		}
      	} else {
      		if (node.getRight()!=null){
      			greaterThanHelper(list,node.getRight(),val);
      		}
      	}
      }

    /**
     * Find the number of nodes in this tree at the specified depth.
     * <br>pre: none
     * @param d The target depth.
     * @return The number of nodes in this tree at a depth equal to
     * the parameter d.
     */
    public int numNodesAtDepth(int d) {
        if(size==0){
        	return 0;
        }
    	return depthHelper(d,0,root);
    }
    private int depthHelper(int d, int currD, BSTNode<E> node){
    	int total = 0;
    	if(d==currD)
    		return 1;
    	if(node.getLeft()!=null)
    		total+= depthHelper(d,currD+1,node.getLeft());
    	if(node.getRight()!=null)
    		total+= depthHelper(d,currD+1,node.getRight());
    	return total;
    }
    /**
     * Prints a vertical representation of this tree.
     * The tree has been rotated counter clockwise 90
     * degrees. The root is on the left. Each node is printed
     * out on its own row. A node's children wil not necessarily
     * be at the rows directly above and below a row. They will
     * be indented three spaces from the parent. Nodes indented the
     * same amount are at the same depth.
     * pre: none
     */
    public void printTree() {
        printTree(root, "");
    }

    private void printTree(BSTNode<E> n, String spaces) {
        if(n != null){
            printTree(n.getRight(), spaces + "  ");
            System.out.println(spaces + n.getData());
            printTree(n.getLeft(), spaces + "  ");
        }
    }

    private static class BSTNode<E extends Comparable<E>> {
        private E data;
        private BSTNode<E> left;
        private BSTNode<E> right;

        public BSTNode() {
            this(null);
        }

        public BSTNode(E initValue) {
            this(null, initValue, null); 
        }

        public BSTNode(BSTNode<E> initLeft,
                E initValue,        
                BSTNode<E> initRight) {
            data = initValue; 
            left = initLeft; 
            right = initRight; 
        }

        public E getData() { 
            return data; 
        }

        public BSTNode<E> getLeft() { 
            return left;
        }

        public BSTNode<E> getRight() { 
            return right; 
        }

        public void setData(E theNewValue) { 
            data = theNewValue; 
        }

        public void setLeft(BSTNode<E> theNewLeft) { 
            left = theNewLeft; 
        }

        public void setRight(BSTNode<E> theNewRight) { 
            right = theNewRight; 
        }    
    }
}



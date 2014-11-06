//  MathMatrix.java - CS314 Assignment 2

/*  Student information for assignment:
 *
 *  On my honor, Eric Erickson, this programming assignment is my own work
 *  and I have not provided this code to any other student.
 *
 *  UTEID: eje444
 *  email address: egoraea@gmail.com
 *  Grader name: Aaron
 *  Unique section number:53595
 *  Number of slip days I am using: 0
 */


/**
 * A class that models systems of linear equations (Math Matrices)
 * as used in linear algebra.
 *
 * @version Skeleton file for students
 */
public class MathMatrix
{
    // instance variables
    /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    private int[][] values;

    
    /**
     * create a MathMatrix with cells equal to the values in mat.
     * A "deep" copy of mat is made.
     * Changes to mat after this constructor do not affect this
     * Matrix and changes to this MathMatrix do not affect mat
     * @param  mat  mat !=null, mat.length > 0, mat[0].length > 0,
     * mat is a rectangular matrix
     */
    public MathMatrix(int[][] mat) {
        // check the precondition. rectangularMatrix is a private method at end of Matrix class
        if((mat == null) || (mat.length == 0) || (mat[0].length == 0)
                || !rectangularMatrix(mat)) 
            throw new IllegalArgumentException("Violation of precondition: " +
            		"int[][] Matrix constructor");
                
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
        values = new int[mat.length][mat[0].length];
        for (int i = 0; i<values.length;i++){
        	for (int j = 0; j<values[0].length;j++){
        		values[i][j] = mat [i][j];
        	}
        }
    }


    /**
     * create a MathMatrix of the specified size with all cells set to the intialValue.
     * <br>pre: numRows > 0, numCols > 0
     * <br>post: create a matrix with numRows rows and numCols columns. 
     * All elements of this matrix equal initialVal.
     * In other words after this method has been called getVal(r,c) = initialVal 
     * for all valid r and c.
     * @param numRows numRows > 0
     * @param numCols numCols > 0
     * @param initialVal all cells of this Matrix are set to initialVal
     */
    public MathMatrix(int numRows, int numCols, int initialVal) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	if (numRows<=0||numCols<=0){
    		throw new IllegalArgumentException("Violation of precondition must be at least 1x1" );
    	}
    	values = new int[numRows][numCols];
        for (int i = 0; i<values.length;i++){
        	for (int j = 0; j<values[0].length;j++){
        		values[i][j] = initialVal;
        	}
        }
    }


    /**
     * change the value of one of the cells in this MathMatrix.
     * <br>pre: 0 <= row < numRows(), 0 <= col < numCols()
     * <br>post: getVal(row, col) = newValue
     * @param row 0 <= row < numRows()
     * @param col 0 <= col < numCols()
     */
    public void changeElement(int row, int col, int newValue) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	if (row>=values.length||col>=values[0].length){
    		throw new IllegalArgumentException("Violation of precondition must be within matrix" );
    	}
    	values[row][col] = newValue;
    }


    /**
     * Get the number of rows.
     * @return the number of rows in this MathMatrix
     */
    public int numRows() {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
        return values.length; // alter as necessary
    }


    /**
     * Get the number of columns.
     * @return the number of columns in this MathMatrix
     */
    public int numCols() {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
        return values[0].length; // alter as necessary
    }


    /**
     * get the value of a cell in this MathMatrix.
     * <br>pre: row  0 <= row < numRows(), col  0 <= col < numCols()
     * @param  row  0 <= row < numRows()
     * @param  col  0 <= col < numCols()
     * @return the value at the specified position
     */
    public int getVal(int row, int col) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	if (row>=values.length||col>=values[0].length){
    		throw new IllegalArgumentException("Violation of precondition must be within matrix" );
    	}
        return values[row][col]; // alter as necessary
    }


   /**
    * implements MathMatrix addition, (this MathMatrix) + rightHandSide.
    * pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * post: This method does not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * @return a new MathMatrix that is the result of adding this Matrix to rightHandSide.
    * The number of rows in the returned Matrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned Matrix is equal to the number of columns in this MathMatrix.
    */
    public MathMatrix add(MathMatrix rightHandSide) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	if (values.length!=rightHandSide.values.length||values[0].length!=rightHandSide.values[0].length){
    		throw new IllegalArgumentException("Violation of precondition both matrices must be same size" );
    	}
    	int[][] result = new int[values.length][values[0].length];
    	for (int i = 0; i<values.length;i++){
         	for (int j = 0; j<values[0].length;j++){
         		result[i][j] = values[i][j]+rightHandSide.values[i][j];
         	}
         }
    	MathMatrix answer = new MathMatrix(result);
        return answer; // alter as necessary
    }


   /**
    * implements MathMatrix subtraction, (this MathMatrix) - rightHandSide.
    * <br>pre: rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * <br>post: This method does not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numRows(), rightHandSide.numCols() = numCols()
    * @return a new MathMatrix that is the result of subtracting rightHandSide from this MathMatrix.
    * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned MathMatrix is equal to the number of columns in this MathMatrix.
    */
    public MathMatrix subtract(MathMatrix rightHandSide) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	if (values.length!=rightHandSide.values.length||values[0].length!=rightHandSide.values[0].length){
    		throw new IllegalArgumentException("Violation of precondition both matrices must be same size" );
    	}
    	int[][] result = new int[values.length][values[0].length];
    	for (int i = 0; i<values.length;i++){
         	for (int j = 0; j<values[0].length;j++){
         		result[i][j] = values[i][j]-rightHandSide.values[i][j];
         	}
         }
    	MathMatrix answer = new MathMatrix(result);
        return answer; // alter as necessary
    }


   /**
    * implements matrix multiplication, (this MathMatrix) * rightHandSide.
    * <br>pre: rightHandSide.numRows() = numCols()
    * <br>post: This method should not alter the calling object or rightHandSide
    * @param rightHandSide rightHandSide.numRows() = numCols()
    * @return a new MathMatrix that is the result of multiplying this MathMatrix and rightHandSide.
    * The number of rows in the returned MathMatrix is equal to the number of rows in this MathMatrix.
    * The number of columns in the returned MathMatrix is equal to the number of columns in rightHandSide.
    */
    public MathMatrix multiply(MathMatrix rightHandSide) {
    	if (rightHandSide.values.length!=values[0].length){
    		throw new IllegalArgumentException("Violation of precondition must be have as many rows as first matrix's columns" );
    	}
    	int[][] result = new int[values.length][rightHandSide.values[0].length];
    	for (int i = 0; i<values.length;i++){
         	for (int j = 0; j<rightHandSide.values[0].length;j++){
         		int spot = 0;
         		for (int g = 0; g<values[i].length;g++){
         			spot+=values[i][g]*rightHandSide.values[g][j];
         		}
         		result[i][j]=spot;
         	}
         }
    	MathMatrix answer = new MathMatrix(result);
        return answer; // alter as necessary
    } 


   /**
    * Multiply all elements of this MathMatrix by factor.
    * <br>pre: none
    * <br>post: all elements in this matrix have been multiplied by factor. 
    * In other words after this method has been called getVal(r,c) = old getVal(r, c) * factor
    * for all valid r and c.
    * @param factor the value to multipy every cell in this Matrix by.
    */
    public void scale(int factor) {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	   for (int i = 0; i<values.length;i++){
    		   for (int j = 0; j<values[0].length;j++){
    			   values[i][j] *= factor;
    		   }
    	   }
    }


    /**
     * accessor: get a transpose of this MathMatrix. 
     * This Matrix is not changed.
     * <br>pre: none
     * @return a transpose of this MathMatrix
     */
    public MathMatrix getTranspose() {
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	int[][] result = new int[values.length][values[0].length];
    	for (int i = 0; i<values.length;i++){
         	for (int j = 0; j<values[0].length;j++){
         		result[i][j] = values[j][i];
         	}
         }
    	MathMatrix answer = new MathMatrix(result);
        return answer; // alter as necessary
    }


    /**
     * override equals.
     * @return true if rightHandSide is the same size as this MathMatrix and all values in the
     * two MathMatrix objects are the same, false otherwise
     */
    public boolean equals(Object rightHandSide) {
        /* CS314 Students. The following is standard equals
         * method code. We will learn about it in a few weeks.
         */
        boolean result = false;
        if( rightHandSide != null && this.getClass() == rightHandSide.getClass()){
            // rightHandSide is a non null MathMatrix
            MathMatrix otherMatrix = (MathMatrix)rightHandSide;
            
            // cs314 students: determine if otherMatrix is equal
            // to this MathMatrix and set result to true if they are.
            
            /*CS314 STUDENTS: ADD YOUR CODE HERE*/
            if (values.length!=otherMatrix.values.length||values[0].length!=otherMatrix.values[0].length){
        		return false;
        	}
            for (int i = 0; i<values.length;i++){
             	for (int j = 0; j<values[0].length;j++){
             		result = values[i][j]==otherMatrix.values[i][j];
             	}
             }
        }
        return result;
    }


    /**
     * override toString.
     * @return a String with all elements of this MathMatrix. 
     * Each row is on a seperate line.
     * Spacing based on longest element in this Matrix.
     * Each row stats and ends with a vertical bar: '|'
     */
    public String toString(){
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	StringBuffer sb = new StringBuffer();
    	for (int i = 0; i<values.length;i++){
    		sb.append("|");
    		for (int j=0;j<values[0].length;j++){
    			int x = values[i][j];
    			sb.append(String.format("%1$6d",x));
    		}
    		sb.append("|\n");
    	}
        return sb.toString(); // alter as necessary
    }
    
    /**
     * Return true if this MathMatrix is upper triangular. To
     * be upper triangular all elements below the main 
     * diagonal must be 0.<br>
     * pre: this is a square matrix. numRows() == numCols()  
     * @return <tt>true</tt> if this MathMatrix is upper triangular,
     * <tt>false</tt> otherwise. 
     */
    public boolean isUpperTriangular() {
    	if (values.length!=values[0].length){
    		throw new IllegalArgumentException("Violation of precondition must be square" );
    	}
        /*CS314 STUDENTS: ADD YOUR CODE HERE*/
    	for (int i = 0; i<values[0].length;i++){
    		for (int j=i+1;j<values.length;j++){
    			if (values[j][i]!=0)return false;
    		}
    	}
    		
        return true; // alter as necessary
    }
    
    // method to ensure mat is rectangular
    // pre: mat != null
    public static boolean rectangularMatrix(int[][] mat) {
        if(mat == null)
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null");
        boolean isRectangular = true;
        int row = 1;
        final int COLUMNS = mat[0].length;

        while( isRectangular && row < mat.length ) {
            isRectangular = ( mat[row].length == COLUMNS );
            row++;
        }

        return isRectangular;
    }
}
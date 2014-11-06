import java.util.Random;

/*  Student information for assignment:
 *
 *  UTEID: eje444
 *  email address: egoraea@gmail.com
 *  Grader name: Aaron
 *  Number of slip days I am using: 0
 */



/* CS314 Students. Put your experiment results and
* answers to questions here.
* 0.021449411003999982 seconds average for first addition
* 0.09527630004499997 seconds average for second addition
* 0.20762626786799998 seconds average for third addition
* 0.013176799199000007 seconds average for first multiply
* 0.16211675608100018 seconds average for second multiply
* 1.0116810490510015 seconds average for third multiply
* 
* Questions
* 1. I expect the if it was doubled again to take about .8 seconds
* 2. I think the Big O is N^2. The timing data supports it from the 
*    first to second but not second to third
* 3. I expect it to be about 8 seconds.
* 4. I think the Big O is N^3 because the timing data goe's about 8 time more each time.
* 5. I can create up to a 21250 x 21250 matrix before i run out of memory which is about 1.8 GB of memory.
*/

/**
 * A class to run tests on the MathMatrix class
 */
public class MathMatrixTester {

    /**
     * main method that runs simple test on the MathMatrix class
     *
     * @param args not used
     */
    public static void main(String[] args) {
    	//Stopwatch s = new Stopwatch();
        // CS314 Students. When ready delete the above tests 
        // and add your 24 tests here.
    	Random r = new Random();
        MathMatrix mat1 = new MathMatrix(4,4,0);
        int[][] test1 = {{1,1,1,1},{1,1,1,1},{1,1,1,1},{1,1,1,1}};
        MathMatrix mat2 = new MathMatrix(test1);
        //test 1
        int test = 1;
        mat2.changeElement(2, 2, 0);
        boolean actualBoo = get2DArray(mat2)[2][2]==0;
        boolean expectedBoo = true;
        if (actualBoo==expectedBoo)System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 2
        mat2.changeElement(2, 2, 5);
        int actualInt = get2DArray(mat2)[2][2];
        int expectedInt = 5;
        if(actualInt==expectedInt)System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test3
        actualInt=mat1.numRows();
        expectedInt=4;
        if(actualInt==expectedInt)System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test4
        MathMatrix mat3 = new MathMatrix(1,1,4);
        actualInt=mat3.numRows();
        expectedInt=1;
        if(actualInt==expectedInt)System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test5
        actualInt=mat3.numCols();
        if(actualInt==expectedInt)System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test6
        actualInt=mat1.numCols();
        expectedInt=4;
        if(actualInt==expectedInt)System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 7
        actualInt=mat3.getVal(0, 0);
        if(actualInt==expectedInt)System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 8
        actualInt=mat1.getVal(0, 0);
        expectedInt=0;
        if (actualInt==expectedInt)System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 9
        MathMatrix mat4 = new MathMatrix (5,5,5);
        MathMatrix mat5= new MathMatrix (5,5,4);
        int[][] expectedarr1 = {{9,9,9,9,9},{9,9,9,9,9},{9,9,9,9,9},{9,9,9,9,9},{9,9,9,9,9}};
        if (equals(get2DArray(mat4.add(mat5)),expectedarr1))System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 10
        MathMatrix mat6 = new MathMatrix (1,1,1);
        int[][]expectedarr2={{2}};
        if (equals(get2DArray(mat6.add(mat6)),expectedarr2))System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 11
        expectedarr2[0][0]=0;
        if (equals(get2DArray(mat6.subtract(mat6)),expectedarr2))System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 12
        int[][] expectedarr3 = {{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1},{1,1,1,1,1}};
        if (equals(get2DArray(mat4.subtract(mat5)),expectedarr3))System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 13
        MathMatrix mat7 = new MathMatrix (80,1,1);
        MathMatrix mat8 = new MathMatrix (1,80,1);
        int[][]expectedarr4 = new int[80][80];
        for (int i = 0; i<expectedarr4.length;i++){
        	for (int j = 0; j<expectedarr4[0].length;j++){
        		expectedarr4[i][j] = 1;
        	}
        }
        if (equals(get2DArray(mat7.multiply(mat8)),expectedarr4))System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 14
        int[][] identity = {{1,0,0},{0,1,0},{0,0,1}};
        MathMatrix ideMat = new MathMatrix(identity);
        MathMatrix mat9 = createMat(r,3,3,1);
        if (equals(get2DArray(ideMat.multiply(mat9)),get2DArray(mat9)))System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 15
        MathMatrix mat10 = new MathMatrix (3,2,2);
        int[][] expectedarr5 = {{8,8},{8,8},{8,8}};
        mat10.scale(4);
        if (equals(get2DArray(mat10),expectedarr5))System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 16
        MathMatrix mat11 = new MathMatrix(3,2,-8);
        mat11.scale(-1);
        if (equals(get2DArray(mat11),expectedarr5))System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 17
        if (equals(get2DArray(mat6.getTranspose()),get2DArray(mat6)))System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 18
        if (equals(get2DArray(ideMat.getTranspose()),get2DArray(ideMat)))System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test  19
        MathMatrix mat1copy = new MathMatrix(4,4,0);
        if (mat1.equals(mat1copy))System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 20
        if (mat1.equals(mat1))System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 21
        String expectedStr = "|     1     0     0|\n|     0     1     0|\n|     0     0     1|\n";
        if (ideMat.toString().equals(expectedStr))System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 22
        int[][] test2 = {{123456}};
        MathMatrix mat12 = new MathMatrix(test2);
        expectedStr = "|123456|\n";
        if (mat12.toString().equals(expectedStr))System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 23
        actualBoo = mat1.isUpperTriangular();
        expectedBoo = true;
        if (actualBoo==expectedBoo)System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        //test 24
        actualBoo = ideMat.isUpperTriangular();
        if (actualBoo==expectedBoo)System.out.println("Test "+test+" passed");
        else System.out.println("Test "+test+" failed");
        test++;
        /*experiments
        Random r = new Random();

        double average = 0;
        for (int j = 1; j<=3;j++){
        	average=0;
        	for (int i = 1; i<=1000; i++){
        		s.start();
        		MathMatrix emat1 = createMat(r,800*j,800*j,1);
        		MathMatrix emat2 = createMat(r,800*j,800*j,1);
        		emat1.add(emat2);
        		s.stop();
        		average += s.time();
        	}
        System.out.println(average/1000);
        }
        for (int j = 1; j<=3;j++){
        	average=0;
        	for (int i = 1; i<=1000; i++){
        		s.start();
        		MathMatrix emat1 = createMat(r,200*j,200*j,1);
        		MathMatrix emat2 = createMat(r,200*j,200*j,1);
        		emat1.multiply(emat2);
        		s.stop();
        		average += s.time();
        	}
        System.out.println(average/1000);
        }
        */
    }
    
    // method that sums elements of mat, may overflow int!
    // pre: mat != null
    private static int sumVals(MathMatrix mat) {
        if(mat == null)
            throw new IllegalArgumentException("mat may not be null");
        
        int result = 0;
        final int ROWS =  mat.numRows();
        final int COLS = mat.numCols();
        for(int r = 0; r < ROWS; r++)
            for(int c = 0; c < COLS; c++) 
                result += mat.getVal(r, c); // likely to overflow, but can still do simple check
        return result;
    }
    
    // create a matrix with random values
    // pre: rows > 0, cols > 0, randNumGen != null
    private static MathMatrix createMat(Random randNumGen, int rows,
            int cols, final int LIMIT) {
        
        if(randNumGen == null)
            throw new IllegalArgumentException("randomNumGen variable may no be null");
        else if(rows <= 0 || cols <= 0)
            throw new IllegalArgumentException("rows and columns must be greater than 0. " +
            		"rows: " + rows + ", cols: " + cols);
        
        int[][] temp = new int[rows][cols];
        final int SUB = LIMIT / 4;
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++)
                temp[r][c] = randNumGen.nextInt(LIMIT) - SUB;
        
        return new MathMatrix(temp);
    }

    private static void printTestResult(int[][] data1, int[][] data2, int testNum, String testingWhat) {
        System.out.print( "Test number " + testNum + " tests the " + testingWhat +". The test ");
        String result = equals(data1, data2) ? "passed" : "failed";
        System.out.println( result );
    }

    // pre: m != null, m is at least 1 by 1 in size
    private static int[][] get2DArray(MathMatrix m) {
        //check precondition
        assert ( m != null ) && ( m.numRows() > 0 ) && ( m.numCols()> 0 )
                : "Violation of precondition: get2DArray";

        int[][] result = new int[m.numRows()][m.numCols()];
        for(int r = 0; r < result.length; r++)
        {   for(int c = 0; c < result[0].length; c++)
            {   result[r][c] = m.getVal(r,c);
            }
        }
        return result;
    }

    // pre: data1 != null, data2 != null, data1 and data2 are at least 1 by 1 matrices
    //      data1 and data2 are rectangular matrices
    // post: return true if data1 and data2 are the same size and all elements are
    //      the same
    private static boolean equals(int[][] data1, int[][] data2) {
       //check precondition
        if( ( data1 == null ) || ( data1.length == 0 )
               || ( data1[0].length == 0 ) || !rectangularMatrix(data1)
               ||  ( data2 == null ) || ( data2.length == 0 )
               || ( data2[0].length == 0 ) || !rectangularMatrix(data2))
                throw new IllegalArgumentException( "Violation of precondition: equals check on 2d arrays of ints");

        boolean result = (data1.length == data2.length) && (data1[0].length == data2[0].length);
        int row = 0;
        while( result && row < data1.length ) {
            int col = 0;
            while( result && col < data1[0].length ) {
               result = (data1[row][col] == data2[row][col]);
                col++;
            }
            row++;
        }

        return result;
    }


    // method to ensure mat is rectangular
    // pre: mat != null, mat is at least 1 by 1
    private static boolean rectangularMatrix( int[][] mat ) {
        if(mat == null || mat.length == 0 || mat[0].length == 0)
            throw new IllegalArgumentException("Violation of precondition: "
                    + " Parameter mat may not be null" 
                    + " and must be at least 1 by 1");
        return MathMatrix.rectangularMatrix(mat);
    }
}

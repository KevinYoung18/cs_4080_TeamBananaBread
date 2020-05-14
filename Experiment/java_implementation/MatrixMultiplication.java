// Marlon Aquino, Allison Inciong, Michael Nguyen, Kevin Young
// CS 4080
// Professor Talari
// May 7, 2020

import java.util.Random;

public class MatrixMultiplication 
{
	// declare variables
	static final int NUM_TRIALS = 10;
	
	// main method
	public static void main(String[] args)
	{
		// print statements
		System.out.println(timeManySizes("int", "int", 32, 6));
		System.out.println(timeManySizes("float", "float", 32, 6));
		System.out.println(timeManySizes("float", "int", 32, 6));
	}
	
	// create matrix for int
	public static int[][] createIntMatrix(int size)
	{
		// create random object
		Random rand = new Random();
		
		// create array for int matrix
		int[][] array = new int[size][size];
		
		// fill array with random ints
		for (int i = 0; i < size; i++) 
		{
           		for (int j = 0; j < size; j++)
                		array[i][j] = rand.nextInt(10);
       		}
		return array;
	}
	
	// create matrix for float
	public static float[][] createFloatMatrix(int size)
	{
		// create random object
		Random rand = new Random();
		
		// create array for float matrix
		float[][] array = new float[size][size];
		
		// fill array with random floats
		for (int i = 0; i < size; i++) 
		{
            		for (int j = 0; j < size; j++)
                		array[i][j] = rand.nextFloat();
        	}
		return array;
	}
	
	// time the matrix multiplication for float-int
	public static long timeMatMul(float[][] array1, int[][] array2, int size)
	{
		// start clock
		long startTime = System.nanoTime();
		
	    	// multiplying both arrays via the classic way
		float finalArray[][] =  new float[size][size];
	    	for (int i = 0; i < size; i++) 
		{
	        	for (int j = 0; j < size; j++) 
			{
	            		for (int k = 0; k < size; k++) 
				{
	                		finalArray[i][j] += array1[i][k] * (array2[k][j]);
	            		}
	        	}
	    	}

		// stop clock
	    	long timeElapsed = System.nanoTime() - startTime;
	    	return timeElapsed/1000;
	}
	
	// time matrix multiplication for float-float
	public static long timeMatMul(float[][] array1, float[][] array2, int size)
	{
		// start clock
		long startTime = System.nanoTime();
		
	    	// multiplying both arrays via the classic way
		float finalArray[][] =  new float[size][size];
	    	for (int i = 0; i < size; i++) 
		{
	        	for (int j = 0; j < size; j++) 
			{
	            		for (int k = 0; k < size; k++) 
				{
	               			finalArray[i][j] += array1[i][k] * (array2[k][j]);
	            		}
	        	}
	    	}

		// stop clock
	    	long timeElapsed = System.nanoTime() - startTime;
	    	return timeElapsed/1000;
	}
	
	// time matrix multiplication for int-int
	public static long timeMatMul(int[][] array1, int[][] array2, int size)
	{
		// start clock
		long startTime = System.nanoTime();
	    
		// multiplying both arrays via the classic way
		int finalArray[][] =  new int[size][size];
	    	for (int i = 0; i < size; i++) 
		{
	        	for (int j = 0; j < size; j++) 
			{
	            		for (int k = 0; k < size; k++) 
				{
	                		finalArray[i][j] += array1[i][k] * (array2[k][j]);
	            		}
	        	}
	    	}

		// stop clock
	    	long timeElapsed = System.nanoTime() - startTime;
	    	return timeElapsed/1000;
	}
	
	// get average matrix multiplication time
	public static long getAvgTime(String datatype1, String datatype2, int size)
	{
		// if statement for int
		if(datatype1.equalsIgnoreCase("int"))
		{
			// initialize variables
			long avgTime = 0;
			
			// for loop through trials
			for(int trial = 0; trial < NUM_TRIALS; trial++)
			{
				// declare int matrices
				int[][] array1 = createIntMatrix(size);
				int[][] array2 = createIntMatrix(size);
				
				// calculate average time
			    	avgTime += timeMatMul(array1, array2, size);
			}
			
			// calculate average time
			return avgTime / NUM_TRIALS;
		}
		
		// else if statement for float
		else if(datatype2.equalsIgnoreCase("float")) 
		{
			// initialize variables
			long avgTime = 0;
			
			// for loop through trials
			for(int trial = 0; trial < NUM_TRIALS; trial++)
			{
				// declare float matrices
				float[][] array1= createFloatMatrix(size);
				float[][] array2= createFloatMatrix(size);
				
				// calculate average time
			    	avgTime += timeMatMul(array1, array2, size);
			}
			
			// calculate average time
			return avgTime / NUM_TRIALS;
		}
		
		// else statement for int-float
		else 
		{
			// initialize variables
			long avgTime = 0;
			
			// for loop through trials
			for(int trial = 0; trial < NUM_TRIALS; trial++)
			{
				// declare int and float matrices
				float[][] array1 = createFloatMatrix(size);
				int[][] array2 = createIntMatrix(size);
				
				// calculate average time
			    	avgTime += timeMatMul(array1, array2, size);
			}
			
			// calculate average time
			return avgTime / NUM_TRIALS;
		}
	}
	
	// print results
	public static String timeManySizes(String datatype1, String datatype2, int base, int numIterations)
	{
		// declare string for print
		String result = datatype1 + "_" + datatype2 + ",";
		
		// for loop
		for(int i = 0; i < numIterations; i++)
		{
			// calculate result
			result += getAvgTime(datatype1, datatype2, (int)(base * Math.pow(2, i )));
			
			// if statement
			if(i < numIterations-1)
				result += ",";
		}
		
		// return statement
		return result;
	}
	
}

// Marlon Aquino, Allison Inciong, Michael Nguyen, Kevin Young
// CS 4080
// Professor Talari
// May 7, 2020

import java.util.*;

public class MatrixMult 
{
    // main method
    public static void main(String[] args) throws Exception 
    {
        // declare variables
        long startTime = 0;
        long endTime = 0;
        double tempTimeElapsed = 0;
        double timeElapsed = 0;

        // create a random object to generate random numbers
        Random rand = new Random();
        int nxtRandom = 10;                                                             // Numbers will be between 0 and 10
        Scanner sc = new Scanner(System.in);
        int n = 4;                                                                      // n represents matrix rows + columns
        
        // prompt the user for matrix size
        System.out.print("Enter a number (higher than 0) for the size your matrix: ");
        do 
        {
            try 
            {
                n = sc.nextInt();
            } 
            catch (InputMismatchException e) 
            {
                System.out.println("Enter a number (higher than 0) for your matrix: ");
            }
            sc.nextLine();
        } while (n <= 0);

        // if statement
        if (n == 1) 
        {
            int firstNum, secondNum;
            System.out.println("Enter a number for the first matrix: ");
            firstNum = sc.nextInt();
            System.out.println("Enter a number for the second matrix: ");
            secondNum = sc.nextInt();
            System.out.println(firstNum * secondNum);
            System.exit(0);
        }

        // create arrays for matrix multiplication, operands and product arrays
        int[][] array1 = new int[n][n];
        int[][] array2 = new int[n][n];
        int[][] finalArray = new int[n][n];

        // instantiate counter
        int counter = 0;

        // while loop
        while (counter < 5) 
        {
            // print what value counter holds
            System.out.println(counter);
            
            // filling the first array
            for (int i = 0; i < n; i++) 
            {
                for (int j = 0; j < n; j++)
                    array1[i][j] = rand.nextInt(nxtRandom);
            }

            // filling the second array
            for (int i = 0; i < n; i++) 
            {
                for (int j = 0; j < n; j++)
                    array2[i][j] = rand.nextInt(nxtRandom);
            }

            // start clock
            startTime = System.currentTimeMillis();
            
            // multiplying both arrays via the classic way
            for (int i = 0; i < n; i++) 
            {
                for (int j = 0; j < n; j++) 
                {
                    for (int k = 0; k < n; k++) 
                    {
                        finalArray[i][j] += array1[i][k] * (array2[k][j]);
                    }
                }
            }

            // stop clock and increment counter
            endTime = System.currentTimeMillis();
            tempTimeElapsed = endTime - startTime;
            timeElapsed = timeElapsed + tempTimeElapsed;
            counter++;
        }

        /**
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    finalArray[i][j] += array1[i][k] * array2[k][j];
                }
                //System.out.print(finalArray[i][j] + " ");
            }
            //System.out.println();
        }
         **/

        // close scanner
        sc.close();
        
        // calculate time in seconds
        timeElapsed = ((timeElapsed) / 1000) / 5;
        System.out.println("Runtime: " + timeElapsed + " s");
    }
}

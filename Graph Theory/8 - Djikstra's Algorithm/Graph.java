import java.util.*;
import java.io.*;
public class Graph {
	private int[] cost, prev;
	private int size, min, currentNode;
	private boolean[] done;

    public void 
    solve (final int[][] matrix)
    {
    	size = matrix.length;
		cost = new int[size];
		prev = new int[size]; // from 0 to 6 (A to G)
		done = new boolean[size];
		min  = Integer.MAX_VALUE;
		currentNode = 0;

		/*
		 * ALGORITHM
		*/

        char letter = 'A';
        for (int i = 0; i < size; ++i)
        {
        	System.out.printf("Path from %c is: %c", 
        		(char)(letter++), (char)(i+65));

        	int spot = i;
        	do {
        		spot = prev[spot];
        		System.out.print(" -> "+(char)(spot+65));
        	} while (spot != 0);

        	System.out.println("");
        }
	}

    public static void 
    main (final String[] args) 
    {
		Graph test = new Graph();

        final int[][] matrix = new int[][]
        //   A    B    C    D    E    F    G
        {{   0,   7,   0,   5,   0,   0,   0 },
         {   7,   0,   8,   9,   7,   0,   0 },
         {   0,   8,   0,   0,   5,   0,   0 },
         {   5,   9,   0,   0,  15,   6,   0 },
         {   0,   7,   5,  15,   0,   8,   9 },
         {   0,   0,   0,   6,   8,   0,  11 },
         {   0,   0,   0,   0,   9,  11,   0 }
        };

        System.out.println("Graph one:\n");
		test.solve(matrix);

        final int[][] matrixTwo = new int[][]
        //   A    B    C    D    E    F    G    H
        {{   0,   6,   1,   3,   0,   0,   5,   0 },
         {   6,   0,   0,   0,   3,   0,   6,   3 },
         {   1,   0,   0,   1,   0,   0,   0,   0 },
         {   3,   0,   1,   0,   2,   8,   0,   0 },
         {   0,   3,   0,   2,   0,   0,   0,   4 },
         {   0,   0,   0,   8,   0,   0,   0,   5 },
         {   5,   6,   0,   0,   0,   0,   0,   0 },
		 {   0,   3,   0,   0,   4,   5,   0,   0 }
        };

		System.out.println("\nGraph two:\n");
		test.solve(matrixTwo);
    }
}

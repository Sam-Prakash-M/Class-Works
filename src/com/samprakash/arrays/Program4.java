package com.samprakash.arrays;

import java.util.Scanner;

public class Program4 {

	public static void main(String[] args) {
          System.out.println("Enter a row and column of first Matrix : ");
          Scanner scanner = new Scanner(System.in);
          System.out.println("Row is : ");
          int row1 = scanner.nextInt();
          System.out.println("Column is : ");
          int col1 = scanner.nextInt();
          System.out.println("Enter a row and column of Second Matrix : ");
          System.out.println("Row is : ");
          int row2 = scanner.nextInt();
          System.out.println("Column is : ");
          int col2 = scanner.nextInt();
          if(col1 != row2) {
         	 System.out.println("Cant Mulptiply this Type of Arrays : ");
         	 return;
          }
          int[][] matrix1 = new int[row1][col1] , matrix2 = new int [row2][col2];
           System.out.println("Enter the elements of Matrix 1 --- > ");
           for(int row = 0 ; row < row1 ; row++) {
        	   for(int col = 0 ; col < col1 ; col++) {
        		   matrix1[row][col] = scanner.nextInt();
        	   }
           }
           System.out.println("Enter the elements of Matrix 2 --- > ");
           for(int row = 0 ; row < row2 ; row++) {
        	   for(int col = 0 ; col < col2 ; col++) {
        		   matrix2[row][col] = scanner.nextInt();
        	   }
           }
           int [][] resultantMatrix = new int [row1][col2];
          scanner.close();
         
         
         mulptilicationOfMatrix(matrix1 , matrix2 , resultantMatrix,row1,col1,row2,col2);
         
	}

	private static void mulptilicationOfMatrix(int[][] matrix1, int[][] matrix2, int[][] resultantMatrix,int row1,int col1,int row2,int col2) {
	  
		for(int row = 0 ; row < row1;row++) {
			for(int col = 0 ; col < col2; col++) {
			for(int value = 0 ; value < row2 ; value++) {
				resultantMatrix[row][col] += (matrix1[row][value] * matrix2[value][col]);
			}
			
			}
		}
		System.out.println("resultant Array is : ");
		 for(int row = 0 ; row < resultantMatrix.length ; row++) {
      	   for(int col = 0 ; col < resultantMatrix[row].length ; col++) {
      		  System.out.print(resultantMatrix[row][col]+" ");
      	   }
      	   System.out.println();
         }
	}

}

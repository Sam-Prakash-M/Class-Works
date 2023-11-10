package com.samprakash.evaluation;

import java.util.Arrays;
import java.util.Scanner;

public class Question4 {
//PatternPrinting
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str = sc.next();
		System.out.println("Enter the number of rows : ");
		int rows = sc.nextInt();
		PrintThePattern(rows, str);
	}

	
	  private static void PrintThePattern(int rows, String str) {
	      char[][] array = new char[rows][str.length()/2];
	      for(int i = 0 ; i < rows ; i++) {
	        	for(int j = 0 ; j < str.length()/2 ; j++) {
	        		 array[i][j] =' ';
	        	}
	        }
	        int letter = 0, minCol = 0;
	        while(letter < str.length()) {
	        	
	        	for(int i = 0 ; i < rows && letter < str.length(); i++) {
	        		array[i][minCol] = str.charAt(letter++);
	        	}
	  
	        	 int currCol = minCol+1;
	        	minCol += (rows-1);
	        	  int currRow = rows-2;
	        	for(int j = currRow; j >= 1 && letter < str.length(); j--) {
	        		array[j][currCol++] = str.charAt(letter++);
	        	}
	        }
	        for(int i = 0 ; i < rows ; i++) {
	        	for(int j = 0 ; j < str.length()/2 ; j++) {
	        		System.out.print(array[i][j]+" ");
	        	}
	        	System.out.println();
	        }
	  
	  }
	 

	

}

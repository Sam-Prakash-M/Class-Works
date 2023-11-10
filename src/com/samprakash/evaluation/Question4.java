package com.samprakash.evaluation;

import java.util.Scanner;

public class Question4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner sc = new Scanner(System.in);
			System.out.println("Enter the String : ");
			String str = sc.next();
			System.out.println("Enter the number of rows : ");
			int rows = sc.nextInt();
			PrintThePattern(rows,str);
	}

	private static void PrintThePattern(int rows, String str) {
		   int middle = rows+rows/2;
		for(int i = 0 ; i < rows ; i++) {
			   char val = str.charAt(i);
			   int minIndex = 0;
			for(int j = 0 ; j <= str.length()/2 ; j++) {
				
				if(i == 0 || i == rows-1) {
					if(j == 0) {
						minIndex = i + middle;
						System.out.print(val);
						val = str.charAt(minIndex);
					}
					else if(minIndex >= str.length()) {
							break;
					}
					else if(j % (rows-1) == 0) {
						System.out.print(str.charAt(minIndex)+" ");
						minIndex += middle;
					}
					else {
						System.out.print("  ");
					}
				}
				else {
					if(j == 0) {
						minIndex = i + middle;
						System.out.print(val);
						val = str.charAt(minIndex);
					}
					else if(minIndex >= str.length() && j <= str.length()/2) {
						if((j+i) % (rows-1) == 0) {
							  int ans = rows%2 == 0 ? 2:1;
							System.out.print(str.charAt(minIndex-i-ans)+" ");
							break;
						}
						
					}
					else if(j % (rows-1) == 0) {
						System.out.print(str.charAt(minIndex)+" ");
						minIndex += middle;
					}
					else if((j+i) % (rows-1) == 0) {
						System.out.print(str.charAt(minIndex-i-1)+" ");
					}
					else {
						System.out.print("  ");
					}
					
				}
				
				
		}
			System.out.println();
	}
	}
}



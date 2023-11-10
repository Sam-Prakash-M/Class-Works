package com.samprakash.pattern;

import java.util.Scanner;

public class pyramidProblems {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	      	System.out.println("Enter a size of Number : ");
	      	int size = scanner.nextInt();
	      	
	}
	private static void pyramid7(int size) {
		for(int i = 1 ; i < 2*size ;i++) {
			for(int space = 1 ; space < 2*size-i; space++) {
				System.out.print(" ");
			}
			for(int j = 1 ; j <= i ; j++) {
				System.out.print(j+" ");
			}
			 
			System.out.println();
		}
		System.out.println("------------------------------------------------");
		
	}

	private static void pyramid6(int size) {
		for(int i = 1 ; i < 2*size ;i++) {
			for(int space = 1 ; space < 2*size-i; space++) {
				System.out.print(" ");
			}
			for(int j = 1 ; j <= i ; j++) {
				System.out.print("* ");
			}
			 
			System.out.println();
		}
		System.out.println("------------------------------------------------");
		
	}

	private static void pyramid5(int size) {
		for(int i = 1 ; i < 2*size ;i++) {
			for(int space = 1 ; space < 2*size-i; space++) {
				System.out.print(" ");
			}
			for(int j = 1 ; j <= i ; j++) {
				System.out.print(j);
			}
			
			  for(int k = i-1 ; k >= 1; k--) { 
				  System.out.print(k); 
				  }
			 
			System.out.println();
		}
		System.out.println("------------------------------------------------");
	}

	private static void pyramid4(int size) {
		for(int i = 2*size-1 ; i >= 1 ;i--) {
			for(int space = i ; space > 1; space--) {
				System.out.print(" ");
			}
			for(int j = 1 ; j <= (2*size-i) ; j++) {
				System.out.print(i+j-1);
			}
			for(int k = 8 ; k >= i; k--) {
				System.out.print(k);
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");
	}

	private static void pyramid3(int size) {
		for(int i = 2*size-1 ; i >= 1 ;i--) {
			for(int space = i ; space <= 2*size-1; space++) {
				System.out.print(" ");
			}
			for(int j = 1 ; j <= i ; j++) {
				System.out.print("* ");
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");

		
	}

	private static void pyramid2(int size) {
		for(int i = 2*size-1 ; i >= 1 ;i--) {
			for(int space = i ; space <= 2*size-1; space++) {
				System.out.print(" ");
			}
			for(int j = 1 ; j <= i ; j++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");

	}

	private static void pyramid1(int size) {
		for(int i = 1 ; i < 2*size ;i++) {
			for(int space = 0 ; space < 2*size - i ; space++) {
				System.out.print(" ");
			}
			for(int j = 1 ; j <= i ; j++) {
				System.out.print(i+" ");
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");
	}
}

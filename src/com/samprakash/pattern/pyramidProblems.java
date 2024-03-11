package com.samprakash.pattern;

import java.util.InputMismatchException;
import java.util.Scanner;

public class pyramidProblems {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		pyramidProblems pp = new pyramidProblems();
		int choice = 0 ,size = 0;
		do {   
			try {
				System.out.println("which pyramid  you are looking for\n"
						+ "there are 7 pyramid program  here enter 1... 7\n8 for exit");
				choice = sc.nextInt();
				 System.out.println("Enter a Pyramid Size : ");
				  size = sc.nextInt();
			}
			catch(InputMismatchException ime) {
				ime.printStackTrace();
				System.out.println("Enter a Valid Input : ");
				main(new String[] {});
			}
			
			switch(choice) {
			    
			case 1 : {
				pp.pyramid1(size);
				break;
			}
			case 2 : {
				pp.pyramid2(size);
				break;
			}
			case 3 : {
				pp.pyramid3(size);
				break;
			}
			case 4 : {
				pp.pyramid4(size);
				break;
			}
			case 5 : {
				pp.pyramid5(size);
				break;
			}
			case 6 : {
				pp.pyramid6(size);
				break;
			}
			case 7 : {
				pp.pyramid7(size);
				break;
			}
			
			case 8 : {
				break;
			}
			default : {
				System.out.println("please enter the number betWeen 1 - 8");
			}
			
			}
		}
		while(choice != 8);
	      	
	}
	private  void pyramid7(int size) {
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

	private  void pyramid6(int size) {
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

	private  void pyramid5(int size) {
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

	private  void pyramid4(int size) {
		for(int i = 2*size-1 ; i >= 1 ;i--) {
			for(int space = i ; space > 1; space--) {
				System.out.print(" ");
			}
			for(int j = 1 ; j <= (2*size-i) ; j++) {
				System.out.print(i+j-1);
			}
			for(int k = 2*size-2 ; k >= i; k--) {
				System.out.print(k);
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");
	}

	private  void pyramid3(int size) {
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

	private  void pyramid2(int size) {
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

	private  void pyramid1(int size) {
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

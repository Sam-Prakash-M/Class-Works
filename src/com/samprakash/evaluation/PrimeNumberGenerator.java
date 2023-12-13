package com.samprakash.evaluation;

import java.util.Scanner;

public class PrimeNumberGenerator {

	public static void main(String[] args) {
		PrimeNumberGenerator pg = new PrimeNumberGenerator();
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the range to find the prime number : ");
		int range = sc.nextInt();
		pg.findPrimeRange(range);
	}

	private void findPrimeRange(int no) {
		if(no == 0) {
			System.out.println("Enter a valid number : start from 1 ");
		}
		
		for(int i = 1 ; i <= no; i++) {
			  if(isPrimeNumber(i)) {
				  System.out.print(i+" ");
			  }
		}
		
	}

	private boolean isPrimeNumber(int number) {
		int count = 0;
		  for(int i = 1 ; i <= (int)Math.sqrt(number); i++) {
			    
			  if(number % i == 0) {
				  count++;
			  }
			  if(count >= 2) {
				  return false;
			  }
		  }
		return true;
	}

}

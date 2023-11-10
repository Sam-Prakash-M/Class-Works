package com.samprakash;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeChecker {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//System.out.println("Enter a Number : ");
	       List <Integer> list = new ArrayList<>();
		for(int i = 0 ; i < 5; i++) {
			list.add(sc.nextInt());
		}
		Prime.checkPrime(list);	
	}
	private static final class Prime {
		public static void checkPrime(List<Integer> list) {
			System.out.println(list.toString());
			for(int i = 0 ; i < list.size(); i++) {
				if(i == 3) {
					continue;
				}
				List <Integer> subList = list.subList(0,i+1);
				//System.out.println(subList.toString());
				for(int j = 0 ; j < subList.size() ; j++) {
					
					int count = 0; 
					for(int k = 2 ; k <= subList.get(j)/2 ; k++) {
						if(subList.get(j)%k == 0) {
							count++;
							
							break;
						}
					}
					if(count == 0 && subList.get(j) != 1) {
						System.out.print(list.get(j)+" ");
					}
					
				}
			
	         	System.out.println();
				
			}
		}
	}
}


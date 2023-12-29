package com.samprakash.spinWheel;

import java.util.Scanner;

public class FindMiniumPath {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Size of an Array : ");
		int size = sc.nextInt();
		System.out.println("Enter a element in an Array : ");
		int [] array = new int[size];
		for(int i = 0 ; i < size ; i++) {
			array[i] = sc.nextInt();
		}
		new FindMiniumPath().findMinimumPossibleHealth(array);

	}

	private void findMinimumPossibleHealth(int[] array) {
		
		int min = array[0];
	            
		for(int i = 1 ; i < array.length ; i++) {
			for(int j = 0 ; j < array.length ; j++) {
				if(j == i) {
					continue;
				}
				else if(array[j] > min) {
					 array[j] = array[j] % min;
					 if(array[j] < min && array [j] != 0) {
						 
						 min =   array[j];
					 }
				 }
			}
			 
		}
		System.out.println(min);
		
	}

}

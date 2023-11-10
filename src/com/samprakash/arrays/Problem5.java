package com.samprakash.arrays;

import java.util.Arrays;
import java.util.Scanner;

public class Problem5 {

	public static void main(String[] args) {
	   
		System.out.println("Enter the size of the Array : ");
		Scanner scanner = new Scanner(System.in);
		    int size = scanner.nextInt();
		    System.out.println("Enter the Elements in the Array : ");
		    int [] array = new int[size];
		    for(int index = 0 ; index < array.length ; index++) {
		    	array[index] = scanner.nextInt();
		    }
		    scanner.close();
		    swapTheArray(array);
	}

	private static void swapTheArray(int[] array) {
		 Arrays.sort(array);
		int len = array.length;
		if(array.length%2 == 0) {
			len--;
		}  
		  int mid = len/2;
		for(int i = 0 ; i < array.length ; i += 2) { 
			int swap1 = 0,swap2 = 0;
			if(mid + 1 < array.length) {
				swap1 = array[mid];
				swap2 = array[mid+1];
			}
			for(int j = mid-1 ; j >= i; j--) {
				array[j+2] = array[j];
			}
			if(i+1 < array.length) {
				array[i] = swap1;
				array[i+1] = swap2;
			}
			mid++;
		}
		System.out.println("Resultant Array is : ");
		 for(int index = 0 ; index < array.length ; index++) {
		    System.out.print(array[index]+" ");
		    }
			
	}

}

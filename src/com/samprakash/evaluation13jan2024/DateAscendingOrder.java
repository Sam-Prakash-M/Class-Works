package com.samprakash.evaluation13jan2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class DateAscendingOrder {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number of dates : ");
		int noOfDates = scanner.nextInt();
		  
		int [][] date = new int[noOfDates][3];
		System.out.println("Enter a each Date : ");
		for(int i = 0 ; i < date.length ; i++) {
			date[i][0] = scanner.nextInt();
			date[i][1] = scanner.nextInt();
			date[i][2] = scanner.nextInt();
		}
		
		new DateAscendingOrder().findDifference(date);

	}

	private void findDifference(int[][] date) {
		
		Arrays.sort(date,new Comparator<>() {

			@Override
			public int compare(int[] array1, int[] array2) {
				
				if(array1[2] > array2[2]) {
					return 1;
				}
				else if(array1[2] < array2[2]) {
					return -1;
				}
				else {
					if(array1[1] > array2[1]) {
						return 1;
					}
					else if(array1[1] < array2[1]) {
						return -1;
					}
					else {
						if(array1[0] > array2[0]) {
							return 1;
						}
						else if(array1[0] < array2[0]) {
							return -1;
						}
						else {
							return 0;
						}
					}
				}
			}
			/*
			 * public int compare(int[] array1, int[] array2) { if (array1[2] != array2[2])
			 * { return Integer.compare(array1[2], array2[2]); } else if (array1[1] !=
			 * array2[1]) { return Integer.compare(array1[1], array2[1]); } else { return
			 * Integer.compare(array1[0], array2[0]); } }
			 */

			
		});
		
		
			System.out.println(Arrays.deepToString(date));
		
		
	}

}

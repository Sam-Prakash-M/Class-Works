package com.samprakash.evaluation13jan2024;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class FindPairs {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter a size of an 2D Array : ");
		int row = scanner.nextInt();
		int [][] array = new int[row][2];
		for(int i = 0 ; i < array.length ; i++) {
			array[i][0] = scanner.nextInt();
			array[i][1] = scanner.nextInt();
		}
		new FindPairs().findPairs(array);

	}

	private void findPairs(int[][] array) {
	    
		Arrays.sort(array,new Comparator<>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				
				return Integer.compare(o1[0], o2[1]) ;
			}
			
		});
		System.out.println(Arrays.deepToString(array));
		
	}

}

package com.samprakash.evaluation;

import java.util.Scanner;

public class NinetyDegreeRotation {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an array : ");
		int size = sc.nextInt();

		int[][] array = new int[size][size];
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				array[i][j] = sc.nextInt();
			}
		}
		NinetyDegreeRotation transPoseMatrix = new NinetyDegreeRotation();
		transPoseMatrix.getOutput(array);

	}

	private void getOutput(int[][] matrix) {
		for (int i = 0; i < matrix.length; i++) {
			 // first transpose the array .. don't Consider diagonal Array
            for(int j = i + 1; j < matrix.length; j++) {
                 int temp = matrix[i][j];
                 matrix[i][j] = matrix[j][i];
                 matrix[j][i] = temp; 
            }
			// Just reverse the Each Row
			this.swapCurrentRow(matrix[i]);
			
		}
		for (int[] i : matrix) {
			for (int j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
	}

	private void swapCurrentRow(int[] array) {
		for(int i = 0 ; i <= array.length/2 ; i++) {
			int temp = array[i];
			array[i] = array[array.length-1-i];
			array[array.length-1-i] = temp;
		}
		
	}
}

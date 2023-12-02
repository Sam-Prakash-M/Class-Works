package zohoevaluation;

import java.util.Scanner;

public class TransPoseMatrix {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Rows and Columns of the array : ");
		int row = sc.nextInt() , col = sc.nextInt();
		
		int [][] array = new int[row][col];
		for(int i = 0 ; i < row ; i++) {
			for(int j = 0 ; j < col ; j++) {
				array[i][j] = sc.nextInt();
			}
			System.out.println();
		}
		TransPoseMatrix transPoseMatrix = new TransPoseMatrix();
		transPoseMatrix.getOutput(array);

	}

	private void getOutput(int[][] matrix) {
		 for(int i =0 ; i < matrix.length;i++) {
        	 // first transpose the array .. don't Consider diagonal Array
            for(int j = i + 1; j < matrix.length; j++) {
                 int temp = matrix[i][j];
                 matrix[i][j] = matrix[j][i];
                 matrix[j][i] = temp; 
            }
		 }
		 for(int [] i : matrix) {
			 for(int j : i) {
				 System.out.print(j+" ");
			 }
			 System.out.println();
		 }
		
		
	}

}

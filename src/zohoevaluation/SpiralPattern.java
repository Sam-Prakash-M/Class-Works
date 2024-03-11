package zohoevaluation;

import java.util.Scanner;

public class SpiralPattern {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the number of Rows : ");
		int number = sc.nextInt();
		String[][] matrix = new String[number][number];
		/*
		 * for(int i = 0 ; i < matrix.length ; i++) { Arrays.fill(matrix[i]," "); }
		 */
		spiralMatix(matrix);

	}

	private static void spiralMatix(String[][] matrix) {
		int minRow = 0, minCol = 0, maxRow = matrix.length - 1, maxCol = matrix.length - 1;
		int currCol = 0;
		int time = matrix.length;
		int val = 1;
		while (time > 0) {
			for (int i = minRow, j = currCol; i <= maxRow; i++, j++) {
				matrix[i][j] = String.valueOf(val++);
			}
			currCol += 2;
			if (time == matrix.length) {
				minCol++;
			} else {
				minCol += 2;
			}

			maxRow--;
			for (int i = maxRow; i >= minRow; i--) {
				matrix[i][maxCol] = String.valueOf(val++);
			}
			maxCol--;
			maxRow--;
			for (int i = maxCol; i >= minCol; i--) {
				matrix[minRow][i] = String.valueOf(val++);
			}
			minRow++;
			time--;

		}
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix.length; j++) {
				if (matrix[i][j] != null) {
					if (i == 0) {
						System.out.print(matrix[i][j] + " ");
					} else {
						System.out.print(" " + matrix[i][j]);
					}
				} else {
					System.out.print("  ");
				}

			}
			System.out.println();
		}

	}

}

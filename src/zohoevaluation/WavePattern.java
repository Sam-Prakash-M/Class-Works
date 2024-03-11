package zohoevaluation;

import java.util.Arrays;
import java.util.Scanner;

public class WavePattern {

//PatternPrinting
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str = sc.next();
		System.out.println("Enter the number of rows : ");
		int rows = sc.nextInt();
		// printThePatternByUsingNestedLoops(rows, str);
		 System.out.println(printZigZag(str, rows));
	}

	private static String printZigZag(String str, int numRows) {

		if (numRows == 1) {
			return str;
		}

		int size = str.length();
		final char[] chars = new char[size];
		final int step = numRows * 2 - 2;
		int subStep = step;
		int row = 0;
		int index = row;
		for (int i = 0; i < size; i++) {
			chars[i] = str.charAt(index);

			if (subStep > 0 && subStep < step && index + subStep < size) {
				chars[++i] = str.charAt(index + subStep);
			}

			index += step;
			if (index >= size) {
				index = ++row;
				subStep -= 2;
			}
		}

		return new String(chars);
	}

	private static void printThePatternByUsingNestedLoops(int rows, String str) {
		if (rows == 1) {
			System.out.println(str);
			return;
		}
		char[][] array = new char[rows][str.length() / 2 + 1];
		for (int i = 0; i < rows; i++) {
			Arrays.fill(array[i], ' ');
		}
		int letter = 0, minCol = 0;
		while (letter < str.length()) {

			for (int i = 0; i < rows && letter < str.length(); i++) {
				array[i][minCol] = str.charAt(letter++);
			}

			int currCol = minCol + 1;
			minCol += (rows - 1);
			for (int j = rows - 2; j >= 1 && letter < str.length(); j--) {
				array[j][currCol++] = str.charAt(letter++);
			}
		}
		/*
		 * for(int i = 0 ; i < rows ; i++) { for(int j = 0 ; j < str.length()/2 ; j++) {
		 * System.out.print(array[i][j]+" "); } System.out.println(); }
		 */
		for (char[] i : array) {
			for (char j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}

	}

}

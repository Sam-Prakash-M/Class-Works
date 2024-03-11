package com.samprakash.day2jan2024;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class WordFinder {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter a Row Of an Array ");
		int row = scanner.nextInt();
		System.out.print("Enter a Col Of an Array ");
		int col = scanner.nextInt();
		scanner.nextLine();
		char[][] array = new char[row][col];
		array[0] = new char[] { 'a', 'z', 'o', 'l' };
		array[1] = new char[] { 'n', 'x', 'h', 'o' };
		array[2] = new char[] { 'v', 'y', 'i', 'v' };
		array[3] = new char[] { 'o', 'r', 's', 'e' };
		System.out.println("Enter a Element in an Array ");
		for (char[] i : array) {
			for (char j : i) {
				System.out.print(j + " ");
			}
			System.out.println();
		}
		/*
		 * for(int i = 0 ; i < row ; i++) { for(int j = 0 ; j < col ; j++) { array[i][j]
		 * = scanner.next().charAt(0); }
		 * 
		 * }
		 */
		System.out.print("Enter a String Array  length to check whether it is present ");
		int size = scanner.nextInt();
		scanner.nextLine();
		String[] element = new String[size];
		System.out.println("Enter a Element in a String");
		for (int i = 0; i < size; i++) {
			element[i] = scanner.nextLine();
		}
		new WordFinder().findtheWord(array, element);

	}

	private void findtheWord(char[][] array, String[] element) {
		for (int i = 0; i < element.length; i++) {
			checkWhetherThisWordOccurs(array, element[i]);
		}

	}

	private void checkWhetherThisWordOccurs(char[][] array, String str) {

		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				if (str.charAt(0) == array[i][j]) {
					if (isThisWordPresentInTheArray(i, j, 0, str, array)) {
						System.out.println("Presents : " + str);
					}
				}
			}
		}

	}

	private boolean isThisWordPresentInTheArray(int row, int col, int index, String str, char[][] array) {

		Queue<int[]> queue = new LinkedList<>();
		queue.offer(new int[] { row, col });
		while (!queue.isEmpty() && index < str.length()) {
			int[] currPlace = queue.poll();
			int currRow = currPlace[0], currCol = currPlace[1];
			boolean isHas = false;
			index++;

			if (currRow + 1 < array.length && currCol < array[currRow].length && index < str.length()) {

				if (array[currRow + 1][currCol] == str.charAt(index)) {
					//System.out.println("isVan Comes in row " + str.charAt(index));
					isHas = true;
					queue.offer(new int[] { currRow + 1, currCol });
				}
			}
			if (currRow < array.length && currCol + 1 < array[currRow].length && index < str.length()) {

				if (array[currRow][currCol + 1] == str.charAt(index)) {
					//System.out.println("isVan Comes in Col " + str.charAt(index));
					isHas = true;
					queue.offer(new int[] { currRow, currCol + 1 });
				}

			}

			if (!isHas) { {
				if(index < str.length()) {
					return false;
				}
			}
				
			}

		}
		return true;

	}

}

package com.samprakash.evaluation;

import java.util.Arrays;
import java.util.Scanner;

/*Maximum Gap in Array:
Given an unsorted array, find the maximum difference between the successive elements in its sorted form.*/
public class SuccessiveElements {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a size of an array : ");
		int size = sc.nextInt();
		System.out.println("Enter a elements in the array : ");
		int[] array = new int[size];
		for (int i = 0; i < size; i++) {
			array[i] = sc.nextInt();
		}
		new SuccessiveElements().findTheMaximumDifference(array);

	}
				//it is used to find the difference 
	private void findTheMaximumDifference(int[] array) {

		// this is going to sort the array
		this.sortTheGivenArray(array);
		int maxDiffer = Integer.MIN_VALUE , currDiffer;
		for(int i= 0 ; i < array.length - 1; i++) {
			currDiffer = array[i+1] - array[i];
			if(currDiffer > maxDiffer) {
				maxDiffer = currDiffer;
			}
		}
		System.out.println(Arrays.toString(array));
		System.out.println("Maximum differ is : "+maxDiffer);

	}

	private void sortTheGivenArray(int[] array) {
		for (int outer = 0; outer < array.length - 1; outer++) {
			boolean isEntered = false;
			for (int inner = 0; inner < array.length - 1 - outer; inner++) {
				if (array[inner] > array[inner + 1]) {
					isEntered = true;
					int temp = array[inner];
					array[inner] = array[inner + 1];
					array[inner + 1] = temp;
				}
			}
			if (!isEntered) {
				break;
			}

		}

	}

}

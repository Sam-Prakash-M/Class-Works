package com.samprakash.evaluation;

import java.util.Scanner;

public class KthSmallestElement {
	/*
	 * Given an unsorted array, write a Java function to find the kth smallest
	 * element in the array.
	 */
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a size of an Array : ");
		int size = sc.nextInt();
		System.out.println("Enter each element in the array : ");
		int [] small = new int [size];
		for(int i = 0 ; i < size ; i++) {
			small[i] = sc.nextInt();
		}
		System.out.println("Enter which Smallest element in the array : ");
		int element = sc.nextInt();
		int kthSmallestElement = new KthSmallestElement().findKthSmallestElement(small, element);
		System.out.println("K th Smallest element is --> : "+kthSmallestElement);

	}
	// here selction sort is used so that k th smallest find by iterate k time
	private int findKthSmallestElement(int[] small, int element) {
		 for(int i = 0 ; i <= element - 1; i++) {
			 int minPos = i;
			 for(int j = i+1 ; j < small.length ; j++) {
				 if(small[j] < small[minPos]) {
					 minPos = j;
				 }
			 }
			 if(minPos != i) {
				 int swap = small[i];
				 small[i] = small[minPos];
				 small[minPos] = swap;
			 }
		 }
		return small[element-1];
	}

}

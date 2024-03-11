package com.samprakash.leetcode;

import java.util.InputMismatchException;
import java.util.Scanner;

public class RotateArray {
	public static void main(String[] args) {
		  
		Scanner sc = new Scanner(System.in);
		RotateArray ra = new RotateArray();
		int choice;
		   while(true) {
				System.out.println("Enter\n1)Rotate Array in Right\n2)Rotate Array in Left\n3)Exit");
				choice = sc.nextInt();
				if(choice == 3) {
					break;
				}
				System.out.println("Enter a size of an Array : ");
				int size  = sc.nextInt();
				System.out.println("Enter a element in array : ");
				int[] array = new int[size];
				for(int i = 0 ; i < size ;i++) {
					array[i] = sc.nextInt();
				}
				System.out.println("Enter How my many times to array rotate : ");
				int rotation = sc.nextInt();
				switch(choice) {
				case 1 : {
					ra.rotateRight(array,rotation);
					break;
				}
				case 2 : {
					ra.rotateLeft(array,rotation);
					break;

				}
				default : {
					System.out.println("Enter a number between 1-3 : ");
				}
				}
		}
		
		
		 
		
	}

	private void rotateLeft(int[] nums, int k) {
		
		int remainingRotation = k % nums.length;
		
		int start = nums.length - 1 - remainingRotation, index = nums.length - 1
				
				, previous = nums.length - 1, temp = nums[nums.length - 1 -  remainingRotation];
		
		nums[nums.length - 1 - remainingRotation] = nums[nums.length - 1];

		for (int i = 1; i < nums.length && remainingRotation != 0; i++) {

			if (start == previous) {
				previous = --start;
				temp = nums[start];
			}
			if (start - remainingRotation < 0) {
				start += nums.length;
			}
			index = nums[start - remainingRotation];

			nums[start - remainingRotation] = temp;
			temp = index;
			start -= remainingRotation;
		
		}
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.print("\n-------------------------------------------------------\n");

	}

	private void rotateRight(int[] nums, int k) {
		int remainingRotation = k % nums.length;
		int start = remainingRotation, index = 0, previous = 0, temp = nums[remainingRotation];
		nums[remainingRotation] = nums[0];
		for (int i = 1; i < nums.length && remainingRotation != 0; i++) {
			if (start == previous) {
				previous = ++start;
				temp = nums[start];
			}

			if (start + remainingRotation >= nums.length) {
				start -= nums.length;
			}

			index = nums[remainingRotation + start];

			nums[remainingRotation + start] = temp;
			temp = index;
			start += remainingRotation;

		}
		for (int i : nums) {
			System.out.print(i + " ");
		}
		System.out.print("\n-------------------------------------------------------\n");
	}
}

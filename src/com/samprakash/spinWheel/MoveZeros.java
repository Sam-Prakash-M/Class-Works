package com.samprakash.spinWheel;

import java.util.Scanner;

public class MoveZeros {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a size of an Array : ");
		int size = sc.nextInt();
		int [] array = new int [size];
		System.out.println("Enter a Element in Array : ");
		for(int i =  0 ; i < array.length ; i++) {
			array[i] = sc.nextInt();
		}
		new MoveZeros().moveZeros(array);

	}

	private void moveZeros(int[] array) {
		
		int end = -1 , start = -1;
		for(int i = 0 ; i < array.length - 1;) {
			if(array[i] == 0) {
				
				if(i + 1 < array.length) {
					start = i;
					end = i + 1;
				}
			}
			else {
				if(end != -1) {
					if(array[end] != 0) {
						int temp = array[start];
						array[start] = array[end];
						array[end] = temp;
						end = -1;
						start = -1;
					}
					end--;
				}
				else {
					i++;
				}
				
			}
		}
		
	}

}

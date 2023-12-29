package com.samprakash.spinWheel;

import java.util.Scanner;

public class LeadersInArray {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a size of an Array : ");
		int size = sc.nextInt();
		System.out.println("Enter a elements in an Array : ");
		int [] array =  new int[size];
		for(int i = 0 ; i < size ; i++) {
			array[i] = sc.nextInt();
		}
		LeadersInArray leader = new LeadersInArray();
		  leader.printAllLeadersInAnArray(array);
		//leader.printAllLeadersInAnArray(array,array.length-1,array[array.length-1]);
	}

	private void printAllLeadersInAnArray(int[] array) {
		  
		int max = array[array.length-1], start = array.length-1;
		System.out.print(array[start]+" ");
		for(int i = start - 1; i >= 0 ; i--) {
			if(array[i] > max) {
				System.out.print(array[i]+" ");
				max = array[i];
			}
		}
		
	}
	/*
	 * private void printAllLeadersInAnArray(int[] array , int start , int max) {
	 * 
	 * if(array.length == start || array[i] > max) {
	 * 
	 * } }
	 */

}

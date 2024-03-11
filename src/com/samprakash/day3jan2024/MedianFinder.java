package com.samprakash.day3jan2024;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MedianFinder {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a size of an first array : ");
		int size1 = sc.nextInt();
		System.out.println("Enter a elements in an array like sorted form ");
		int[] array1 = new int[size1];
		for(int i = 0 ; i < size1 ; i++) {
			array1[i] = sc.nextInt();
		}
		System.out.println("Enter a size of an Second array : ");
		int size2 = sc.nextInt();
		System.out.println("Enter a elements in an array like sorted form ");
		int[] array2 = new int[size2];
		for(int i = 0 ; i < size2 ; i++) {
			array2[i] = sc.nextInt();
		}
		int maxLen = array1.length + array2.length;
		new MedianFinder().findOutTheMedian(array1,array2,maxLen);

	}

	private void findOutTheMedian(int[] array1, int[] array2, int maxLen) {
		
		List <Integer> list = new ArrayList <>();
		
		for(int i = 0 ; i < array1.length || i < array2.length ; i++) {
			if(list.isEmpty()) {
				System.out.println("is true : "+list.isEmpty());
				if(array1.length == 0 && array2.length == 0) {
					return;
				}
				else if(array1.length == 0) {
					list.add(array2[i]);
				}
				else if(array2.length == 0){ 
					list.add(array1[i]);
				}
				else {
					list.add(array1[i]);
					if(array1[i] <= array2[i]) {
						list.add(array2[i]);
					}
					else {
						list.add(0,array2[i]);
					}
				}
				
				
				
				System.out.println("First time : "+list);
				continue;
				
			}
			
			
			  if(i > maxLen/2 + 1) {
			  System.out.println("Size is : "+list.size()); break; }
			 
			if(i < array1.length && i < array2.length) {
				if(array1[i] <= array2[i]) {
					
					if(array1[i] <= list.get(i)) {
						list.add(i, array1[i]);
						if(array2[i] <= list.get(i)) {
							list.add(i, array2[i]);
						}
						else {
							list.add(array2[i]);
						}
					}
					else {
						list.add(array1[i]);
						list.add(array2[i]);
					}
				}
				else {
					if(array2[i] <= list.get(i)) {
						list.add(i , array2[i]);
						if(array1[i] <= list.get(i)) {
							list.add(i, array1[i]);
						}
						else {
							list.add(array1[i]);
						}
					}
					else {
						list.add(array2[i]);
						list.add(array1[i]);
					}
				}
				System.out.println("Double side : "+list);
				continue;
			}
			if(i < array1.length) {
				if(i - 1 < list.size() && array1[i] <= list.get(i-1)) {
					list.add(i-1 , array1[i]);
				}
				else if(i< list.size() && array1[i] <= list.get(i)) {
					list.add(i,array1[i]);
				}
				else if(i+1 < list.size() && array1[i] <= list.get(i+1)){
					list.add(i+1,array1[i]);
				}
				else {
					list.add(array1[i]);
				}
				/*
				 * if(array1[i] <= list.get(list.size()-1)) { list.add(list.size() - 1 ,
				 * array1[i]); } else { list.add(array1[i]); }
				 */
				System.out.println("Second Time : "+list);
			}
			if(i < array2.length) {
				if(i - 1 < list.size() && array2[i] <= list.get(i-1)) {
					list.add(i-1 , array2[i]);
				}
			else if(i < list.size() && array2[i] <= list.get(i)) {
					list.add(i,array2[i]);
				}
				else if(i+1 < list.size() && array2[i] <= list.get(i+1)){
					list.add(i+1,array2[i]);
				}
				else {
					list.add(array2[i]);
				}
				/*
				 * if(array2[i] <= list.get(list.size()-1)) { list.add(list.size() - 1 ,
				 * array2[i]); } else { list.add(array2[i]); }
				 */
				System.out.println("Third Time : "+list);
			}
			
		}
		System.out.println("List is : "+list+"\nMax len is "+maxLen);
		if(maxLen % 2 == 0) {
			double medianFirst = list.get(maxLen/2) , medianSecond = list.get(maxLen/2 - 1);
			System.out.println("Median is : "+((medianFirst + medianSecond)/2));
		}
		else {
		System.out.println("Median is : "+(double)(list.get(maxLen/2)));
			
		}
		
	}

}

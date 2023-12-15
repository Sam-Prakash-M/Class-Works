package com.samprakash.evaluation;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class RemoveDuplicates {
	/*
	 * Remove Duplicates: Write a Java function to remove duplicates from an
	 * ArrayList of integers. The output should be an ArrayList containing unique
	 * elements in the order they first
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the size of an arraylist : ");
		int size = sc.nextInt();
		List<Integer> list = new ArrayList<>(size);

		for (int i = 0; i < size; i++) {
			list.add(sc.nextInt());
		}
		System.out.println("before removing : \n" + list);
		List<Integer> result = new RemoveDuplicates().removeTheDuplicates(list);
		System.out.println("After removing : \n" + result);
	

	}

	private List<Integer> removeTheDuplicates(List<Integer> list) {
                               
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < list.size(); i++) {//it finds the frequency of each elements
			map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
		}
		System.out.println(map);

		for (int i = 0; i < list.size(); i++) {//it finds the counts of elements which has more than one
			
			if (map.get(list.get(i)) > 1) {//if more than 2 it calls the remove methods
				this.removeTheExtraElements(list, map, list.get(i));
			}
		}
		return list;
	}
		// it finds the last index of the elements and removing the until the count becomes 1.
	private void removeTheExtraElements(List<Integer> list, Map<Integer, Integer> map, int element) {
		          
			int count = map.get(element);
		   while(count-- > 1) { 
			   
			   int index = list.lastIndexOf(element);
			   list.remove(index);
			   
		   }
	}

}

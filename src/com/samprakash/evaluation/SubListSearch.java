package com.samprakash.evaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SubListSearch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a size of original list : ");
		int sizeOriginal = sc.nextInt();
		System.out.println("Enter a element of original list : ");
		List <Integer> listOriginal = new ArrayList <>();
		for(int i = 0 ; i < sizeOriginal ; i++) {
			listOriginal.add(sc.nextInt());
		}
		System.out.println("Enter a size of Sub list : ");
		int sizeSub = sc.nextInt();
		System.out.println("Enter a element of Sub list : ");
		List <Integer> subList = new ArrayList <>();
		for(int i = 0 ; i < sizeSub ; i++) {
			subList.add(sc.nextInt());
		}
		boolean isfounded = new SubListSearch().isFoundedInList(listOriginal,subList);
		System.out.println("is presented in the list : "+isfounded);

	}
	//Used to find out sublist present or not
	private boolean isFoundedInList(List<Integer> listOriginal, List<Integer> subList) {
	          
		    for(int i = 0 ; i <= listOriginal.size() - subList.size() ; i++) {
		    	   if(listOriginal.subList(i, listOriginal.size()).equals(subList)) {
		    		   return true;
		    	   }
		    }
		return false;
	}

}

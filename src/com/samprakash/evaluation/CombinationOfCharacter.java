package com.samprakash.evaluation;

import java.util.ArrayList;
import java.util.Scanner;

public class CombinationOfCharacter {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String : ");
		String word = sc.next();
		 new CombinationOfCharacter().printCombination(0,word,new ArrayList <>());

	}

	private void printCombination(int i, String word, ArrayList <Character> list) {
		  
		if(i == word.length()) {
			if(!list.isEmpty()) {
				System.out.println(list);
			}
			return;
		}
		list.add(word.charAt(i));
		printCombination(i+1, word, list);
		list.remove((Character)word.charAt(i));
		printCombination(i+1, word, list);
	}

}

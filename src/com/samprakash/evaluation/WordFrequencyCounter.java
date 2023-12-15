package com.samprakash.evaluation;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class WordFrequencyCounter {

	public static void main(String[] args) {

		WordFrequencyCounter wc = new WordFrequencyCounter();
		System.out.println("Enter a word : ");
		Scanner sc = new Scanner(System.in);
		String word = sc.nextLine();
		wc.findFrequencyCounter(word);
	}

	private void findFrequencyCounter(String word) {
		String[] eachWord = word.split(" ");
		this.puntuationRemover(eachWord);
		Map <String, Integer> map = new LinkedHashMap<>();
		  
		/*
		 * for (int i = 0; i < eachWord.length; i++) {
		 * 
		 * map.put(eachWord[i], map.getOrDefault(eachWord[i], 0) + 1); }
		 */
		this.eachWordFrquency(eachWord,map);
		Set<Map.Entry<String, Integer>> entryset = map.entrySet();

		for (Map.Entry<String, Integer> entry : entryset) {
			System.out.println(entry.getKey() + " frequency is : " + entry.getValue());
		}

	}

	private void eachWordFrquency(String[] eachWord, Map<String, Integer> map) {
		
		for(int i = 0 ; i < eachWord.length; i++) {
			int count = 0;
			if(!eachWord[i].equals("")) {
				for(int j = i; j < eachWord.length; j++) {
					if(eachWord[i].equalsIgnoreCase(eachWord[j])) {
						   if(i != j) {
							   eachWord[j] ="";
						   }
						count++;
					}
				}
				map.put(eachWord[i],count);
			}
			
		}
		
	}

	private void puntuationRemover(String[] eachWord) {
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < eachWord.length; i++) {
			for (int j = 0; j < eachWord[i].length(); j++) {
				if (Character.isAlphabetic(eachWord[i].charAt(j)) || Character.isDigit(eachWord[i].charAt(j))) {
					sb.append(eachWord[i].charAt(j));
				}
			}
			eachWord[i] = sb.toString();
			sb.delete(0, sb.length());
		}

	}

}

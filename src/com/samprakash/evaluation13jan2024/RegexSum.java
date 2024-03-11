package com.samprakash.evaluation13jan2024;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
  
/*
 * Print the given lines as one by one whenever
a) Space Comes
b) Special Character comes
c) In the word in the middle in which has upper case
*/

public class RegexSum {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a String : ");
		String word = scanner.nextLine();
		new RegexSum().printWordByRegex(word);

	}

	private void printWordByRegex(String text) {
		 String[] patternCombined = text.split("\\s| [A-Z]|[~`@#$%^&*-.,]");

	       for(int i = 0 ; i < patternCombined.length ; i++) {
	    	   System.out.println(patternCombined[i]);
	       }
	      
	}

}

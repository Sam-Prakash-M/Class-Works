package zohoevaluation;

import java.util.Arrays;
import java.util.Scanner;

public class Palindrom {

	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
      System.out.println("Enter a String 1 : ");
      String str1 = sc.next();
      System.out.println("Enter a String 2 : ");
      String str2 = sc.next();
      Palindrom p = new Palindrom();
      int [] frequencyArray1 = new int[26];
      int [] frequencyArray2 = new int[26];
      p.countEachWordFrequency(str1,frequencyArray1);
      p.countEachWordFrequency(str2,frequencyArray2);
		/*
		 * System.out.println(Arrays.toString(frequencyArray1));
		 * System.out.println(Arrays.toString(frequencyArray2));
		 */
       boolean isValid = p.isPalindrom(frequencyArray1,frequencyArray2);
       System.out.println("Is it possible to make words : "+isValid);
      
	}

	private boolean isPalindrom(int[] frequencyArray1, int[] frequencyArray2) {
		for(int i = 0 ; i < frequencyArray1.length ; i++) {
			if(frequencyArray2[i] > frequencyArray1[i]) {
				return false;
			}
		}
		return true;
	}

	private void countEachWordFrequency(String str , int []frequencyArray) {
		
		for(int i = 0 ; i < str.length() ; i++) {
			   
			char ch = str.charAt(i);
			if(ch >= 'A' && ch <= 'Z') {
				frequencyArray[ch - 'A']++;
			}
			else if(ch >= 'a' && ch <= 'z'){
				frequencyArray[ch - 'a']++;
			}
		}
		
	}


}

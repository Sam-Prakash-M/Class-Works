package zohoevaluation;

import java.util.Arrays;
import java.util.Scanner;

public class StringOrder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the no of String : ");
		int no = sc.nextInt();
		String [] str = new String[no];
		System.out.println("Enter the Each String : ");
		for(int i = 0 ; i < no ; i++) {
			str[i] = sc.next();
		}
		largestLexicographically(str);
		

	}

	private static void largestLexicographically(String[] str) {
		for(int i = 0 ; i < str.length ; i++) {
			char [] result = str[i].toCharArray();
			Arrays.sort(result);
			 String output = "";
			 for(int j = result.length - 1 ; j >= 0 ; j--) {
				 output += result[j];
			 }
			 str[i] = output;
		}
		for(String i : str) {
			System.out.println(i);
		}
		
	}

}

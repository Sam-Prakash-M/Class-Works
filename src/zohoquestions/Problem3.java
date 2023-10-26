package zohoquestions;

import java.util.Scanner;

public class Problem3 {
  public static void main(String[] args) {
	 System.out.println("Enter the pattern (without Space) Design to Print : ");
	 Scanner scanner = new Scanner(System.in);
	   String pattern = scanner.next();
	   scanner.close();
	   patternPrinting(pattern);
	   
}

private static void patternPrinting(String pattern) {
	   for(int start = 0 ; start < pattern.length();start++) {
		  
		   for(int word = 0 ; word < pattern.length() ; word++) {
			   if(word == start) {
				   System.out.print(pattern.charAt(start));
			   }
			   else if(word == pattern.length() - 1 - start) {
				   System.out.print(pattern.charAt(pattern.length() - 1 - start));
			   }
			   else {
				   System.out.print(" ");
			   }
		   }
		   System.out.println();
	   }
	
}
}

package zohoevaluation;

import java.util.Scanner;

public class JumbledNumber {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a Number to check : ");
		int number = sc.nextInt();
		boolean result = isJumbledNumber(number);
		System.out.println(result);

	}

	private static boolean isJumbledNumber(int number) {
		 String str = String.valueOf(number);
		 for(int i = 0 ; i < str.length() ; i++) {
			 int count = 0;
			 if(i-1 >= 0) {
				 int diff = Math.abs(Integer.parseInt(""+str.charAt(i-1)) - Integer.parseInt(""+str.charAt(i)));
				 if(diff <= 1) {
					 count++;
					 continue;
				 }
			 }
			 else if(i+1 < str.length()) {
				 int diff = Math.abs(Integer.parseInt(""+str.charAt(i+1)) - Integer.parseInt(""+str.charAt(i)));
				 if(diff <= 1) {
					 count++;
					 continue;
				 }
			 }
			 if(count == 0) {
				 return false;
			 }
		 }
		return true;
	}

}

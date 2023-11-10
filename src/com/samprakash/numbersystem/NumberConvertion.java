package com.samprakash.numbersystem;

import java.util.Scanner;

public class NumberConvertion {

	public static void main(String[] args) {
		   Scanner sc = new Scanner(System.in);
	  System.out.println("Enter a Number : ");
	  int number = sc.nextInt();
	  Sam : while(true) {
		   System.out.println("1 for binary to decimal\n2 for decimal to binary");
		   System.out.println("3 for octal to binary\n4 for binary to octal");
		   System.out.println("5 for hexadecimal to binary\6 for binary hexadecimal");
		   System.out.println("7 for Exit the loop");
		   int choice = sc.nextInt();
		   switch(choice) {
		   case 1 :
			   binaryToDecimal(number);
			   break;
		   case 2 :
			   decimalToBinary(number);
			   break;
		   case 3 :
			   octalToBinary(number);
			   break;
		   case 4 :
			   binaryToOctal(number);
			   break;
		   case 5 :
			   hexaDecimalToBinary(number);
			   break;
		   case 6 :
			   binaryToHexaDecimal(number);
		   case 7 :
			   break Sam;
			default :
				continue Sam;
			   
		   }
			

	   }
	  
	}

	private static void binaryToHexaDecimal(int number) {
		// TODO Auto-generated method stub
		
	}

	private static void hexaDecimalToBinary(int number) {
		// TODO Auto-generated method stub
		
	}

	private static void binaryToOctal(int number) {
		// TODO Auto-generated method stub
		
	}

	private static void octalToBinary(int number) {
		int copyVal = number;
		String binaryVal = "";
		while(copyVal > 0) {
			int rem = copyVal%10;
			 while(rem > 0) {
				 binaryVal = rem%2 + binaryVal;
				 rem /= 2;
			 }
			 copyVal /= 10;
		}
		
         System.out.println("Equilant Binary Value For "+number+" is : "+binaryVal);
		
	}

	private static void decimalToBinary(int number) {
		int copyVal = number;
		String binaryVal = "";
		 while(copyVal > 0) {
			 binaryVal = copyVal%2 + binaryVal;
			 copyVal /= 2;
		 }
         System.out.println("Equilant Binary Value For "+number+" is : "+binaryVal);

		
	}

	private static void binaryToDecimal(int number) {
		
		int copyVal = number , decimalResult = 0 , base = 1;
		  while(copyVal > 0) {
			  decimalResult += copyVal%10 * base;
			  base *= 2;
			  copyVal /= 10;
		  }
		  System.out.println("Equilant Decimal Value For "+number+" is : "+decimalResult);
		
	}

}

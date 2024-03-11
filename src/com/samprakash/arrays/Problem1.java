package com.samprakash.arrays;

import java.util.Scanner;

public class Problem1 {
      
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter the Total Number Of Persons : ");
		int countOfMembers = scanner.nextInt();
		String [][] familyDetails = new String[countOfMembers][2];
		System.out.println("Enter the Each Family Members Details : ");
		scanner.nextLine();
		for(int outer = 0 ; outer < countOfMembers;outer++) {
			for(int inner = 0; inner < 2 ; inner++) { 
				if(inner == 0) {
					System.out.println("Child Name : "+(outer+1));
				}
				else {
					System.out.println("Father Name : "+(outer+1));
					
				}
				familyDetails[outer][inner] = scanner.nextLine();
			}
				
		}
		System.out.println("Find A Person who has how many Grand Childrens : ");
		String match = scanner.next();
		int noOfChildrens = findNoOfFathers(familyDetails,match);
		System.out.println(match+" has "+noOfChildrens+" Grand Childrens");
	}

	private static int findNoOfFathers(String[][] familyDetails,String find) {
	       
		   int result = 0;
		for(int outer = 0 ; outer < familyDetails.length ; outer++) {
			int inner = 1;
			while(inner > 0) {// need only one time to run so here this loop used
				if(familyDetails[outer][inner].equals(find)) {
					result += findNoOfChildrens(familyDetails,familyDetails[outer][inner-1]);
				}
				inner--;
			}
		}
		
		return result;
		
	}

	private static int findNoOfChildrens(String[][] familyDetails, String matcher) {
		int countOfChildrens = 0;
		for(int outer = 0 ; outer < familyDetails.length ; outer++) {
			int inner = 1;
			while(inner > 0) {// need only one time to run so here this loop used
				if(familyDetails[outer][inner--].equals(matcher)) {
					countOfChildrens++;				
					}
			}
		}
		return countOfChildrens;
	}
}

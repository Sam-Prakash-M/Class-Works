package com.samprakash.spinWheel;

import java.util.Scanner;

public class DateDifference {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a date , month and year 1 : ");
		int date1 = sc.nextInt() , month1 = sc.nextInt() , year1 = sc.nextInt();
		System.out.println("Enter a date , month and year 2: ");
		int date2 = sc.nextInt() , month2 = sc.nextInt() , year2 = sc.nextInt();
	//	15, 2, 2000, 28, 2, 2000)
		DateDifference dateDifference = new DateDifference();
		dateDifference.findDifferenceOfdate(date1,date2 , month1 , month2 , year1 , year2);

	}

	private void findDifferenceOfdate(int date1, int date2, int month1, int month2, int year1, int year2) {
		
		int totalDateOfYear1 = 0 , totalDateOfYear2 = 0 
				, monthday1 = date1 , monthday2 = date2;
		int [] months = {31,28,31,30,31,30,31,31,30,31,30,31};
		
		for(int i = 0 ; i < month1 - 1; i++) {
			monthday1 += months[i];
		}
		for(int i = 0 ; i < month2 - 1; i++) {
			monthday2 += months[i];
		}
		
		totalDateOfYear1 =  addLeapDays(year1 , month1) + monthday1 + (year1 * 365);
		totalDateOfYear2 =  addLeapDays(year2 , month2) + monthday2 +(year2 * 365);
		System.out.println("Date Differnce between them is "+Math.abs(totalDateOfYear2 - totalDateOfYear1 ));
		
	}

	private int addLeapDays(int year , int month) {
		
		if(month < 3) {
			 year--;
		}
		
		return year / 400 + year/4 - year/100;
	}

}

package com.samprakash.spinWheel;

import java.util.Scanner;

public class DividedByThree {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String no = sc.next();
		String ans = new DividedByThree().isDividiedByThree(no);
		System.out.println(ans);

	}

	private  String isDividiedByThree(String no) {
		  
		int rem = 0;
		for(int i = 0 ; i < no.length() ; i++) {
			int CurrNo = no.charAt(i) -'0'; 
			if(rem != 0) {
				CurrNo += rem;
				rem = 0;
			}
			int CurrRem = CurrNo % 3;
			if(CurrRem != 0) {
				rem = CurrRem * 10;
			}
			//System.out.println("Rem is : "+rem);
		}
		//System.out.println("Rem is : "+rem);
		return rem != 0 ? "NO" : "YES";
	}

}

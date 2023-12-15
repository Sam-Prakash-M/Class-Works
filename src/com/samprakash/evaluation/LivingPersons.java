package com.samprakash.evaluation;

import java.util.Scanner;

public class LivingPersons {
		private int birthAge , deathAge;
		private String name;
	public LivingPersons(String name, int birthAge, int deathAge) {
			this.name = name;
			this.birthAge = birthAge;
			this.deathAge = deathAge;
		}
	public LivingPersons() {
		
	}
	public static void main(String[] args) {
		 LivingPersons [] livingPersons = new LivingPersons[10];
		 livingPersons [0] = new LivingPersons("was",1911,1921);
		 livingPersons [1] = new LivingPersons("das",1917,1933);
		 livingPersons [2] = new LivingPersons("fas",1924,1932);
		 livingPersons [3] = new LivingPersons("kas",1934,1947);
		 livingPersons [4] = new LivingPersons("qas",1938,1950);
		 livingPersons [5] = new LivingPersons("las",1900,1911);
		 livingPersons [6] = new LivingPersons("sas",1905,1918);
		 livingPersons [7] = new LivingPersons("tas",1912,1931);
		 livingPersons [8] = new LivingPersons("ras",1960,1981);
		 livingPersons [9] = new LivingPersons("bas",1975,1995);
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the 2 different years  to find the perons  ");
		int year1 = sc.nextInt() , year2 = sc.nextInt();
		
		 LivingPersons lp = new LivingPersons();
		   lp.findTheLivingPersons(livingPersons , year1 , year2);
		
	}
	private void findTheLivingPersons(LivingPersons[] livingPersons, int year1, int year2) {
		
		for(int i = 0 ; i < livingPersons.length ; i++) {
			
			if( (livingPersons[i].birthAge >= year1 && livingPersons[i].birthAge <=  year2)
				&& !(livingPersons[i].deathAge >= year1 && livingPersons[i].deathAge <=  year2)) {
				System.out.println(livingPersons[i].name);
			}
		}
		
	}

}

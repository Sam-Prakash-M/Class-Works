package com.samprakash.evaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTraingle {

	public static void main(String[] args) {

		PascalsTraingle pt = new PascalsTraingle();
		  Scanner sc = new Scanner(System.in);
		  System.out.println("Enter a Row's of Traingle : ");
		    int row = sc.nextInt();
		    pt.printPascalsTriangle(row);

	}

	private void printPascalsTriangle(int row) {
	     
		List <List <Integer>> outer = new ArrayList<>();
		for(int i = 0 ; i < row ; i++) {
			List <Integer> inner = new ArrayList<>();
			for(int j = 0 ; j <= i ; j++) {
				if(j == 0 || j == i) {
					inner.add(1);
				}
				else {
					inner.add( outer.get(i-1).get(j-1) + outer.get(i-1).get(j) );
				}
				
			}
			outer.add(inner);
		}
		for(List <Integer> o : outer) {
			for(int space = 0 ; space < row - 1 ; space++) {
				System.out.print("  ");
			}
			for(int i : o) {
				System.out.printf("%4d",i);
			}
			System.out.println();
			row--;
		}
		
	}

}

package com.samprakash.evaluation;

import java.util.Scanner;

public class ValidParenthesisCombination {
	/*
	 * Valid Parentheses Combination: Given an integer 'n', generate all
	 * combinations of well-formed parentheses. For example, if n=3, the output
	 * should be ["((()))", "(()())", "(())()", "()(())", "()()()"]. Implement this
	 * using a stack and backtracking.
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number of Combination needed : ");
		int no = sc.nextInt();
		ValidParenthesisCombination vc = new ValidParenthesisCombination();
		vc.findAllParenthesis(0,0, 0, no, new char [no*2]);
	}

	private void findAllParenthesis(int index ,int noOfOpen, int noOfClose, int size,char [] array) {
			 
		if(size == noOfClose) {
			System.out.println(new String(array));
			return;
		}
		if(noOfOpen < size) {
			array[index] = '(';
			findAllParenthesis(index+1 , noOfOpen+1, noOfClose, size,array);
		}
		if(noOfClose < noOfOpen) {
			array[index] = ')';
			findAllParenthesis(index+1, noOfOpen, noOfClose+1, size, array);
		}
	}

}

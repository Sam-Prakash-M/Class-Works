package com.samprakash.evaluation;

import java.util.Scanner;

public class Question3 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a mathamatical Equation : ");
		String str = sc.next();
		System.out.println("Is valid or not : "+IsvalidMathematicalExpression(str));

	}
	private static boolean IsvalidMathematicalExpression(String string) {

		int count = 0, index;
		for (index = 0; index < string.length(); index++) {
			if (string.charAt(index) == '(') {
				count++;
			} else if (string.charAt(index) == ')') {
				count--;
			}

			else if (string.charAt(index) == '+' || string.charAt(index) == '-' || string.charAt(index) == '*'
					|| string.charAt(index) == '/') {

				if (((string.charAt(index - 1) >= 65 && string.charAt(index - 1) <= 90)
						|| (string.charAt(index - 1) >= 97 && string.charAt(index - 1) <= 122)
						|| (string.charAt(index - 1) == ')'))
						&& ((string.charAt(index + 1) >= 65 && string.charAt(index + 1) <= 90)
								|| (string.charAt(index + 1) >= 97 && string.charAt(index + 1) <= 122)
								|| (string.charAt(index + 1) == '('))) {

					continue;
				} else {
					return false;
				}
			} else {
				continue;
			}
		}
		if (count == 0 && index == string.length()) {
			return true;
		} else {
			return false;
		}
	}

}

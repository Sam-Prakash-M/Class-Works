package zohoevaluation;

import java.util.Scanner;
import java.util.Stack;

public class MathematicalExpression {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a mathamatical Equation : ");
		String str = sc.next();
		System.out.println("Is valid or not : "+IsvalidMathematicalExpression(str));

	}
	private static boolean IsvalidMathematicalExpression(String string) {
		
		Stack <Character> stack = new Stack<>();
		for (int index = 0; index < string.length(); index++) {
			if (string.charAt(index) == '(') {
				stack.push(string.charAt(index));
			} else if (string.charAt(index) == ')') {
				if(stack.isEmpty()) {
					return false;
				}
			     char ch = stack.pop();
			     if(ch !='(') {
			    	 return false;
			     }
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
			} 
		}
		if (stack.isEmpty()) {
			return true;
		} else {
			return false;
		}
	}

}

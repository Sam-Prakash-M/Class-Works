package com.samprakash.evaluation;

import java.util.Scanner;
import java.util.Stack;

public class EvaluatePostFixExpression {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String : ");
		String expression = sc.next();
		System.out.println(new EvaluatePostFixExpression().postFix(expression));

	}
	public int postFix(String expression) {
        Stack <Integer> stack = new Stack <>();
        String operator = "+-%/*";
        for(int i = 0 ; i < expression.length() ; i++){
            if(operator.contains(""+expression.charAt(i))) {
                int first = stack.pop() , second = stack.pop();
                if(expression.charAt(i) == '+') {
                    stack.push(second + first);
                }
               else if(expression.charAt(i) == '-') {
                    stack.push(second - first);
                }
               else if(expression.charAt(i) == '*') {
                    stack.push(second * first);
                }
                else if(expression.charAt(i) == '%') {
                    stack.push(second % first);
                }
                else {
                    stack.push(second / first);
                }
            }
            else {
                stack.push(expression.charAt(i)-'0');
            }
        }
        return stack.pop();
    }

}

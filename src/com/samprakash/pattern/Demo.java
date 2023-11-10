package com.samprakash.pattern;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Demo {
	static Scanner sc = new Scanner(System.in);

	public static void myMain()
			throws IllegalAccessException, IllegalArgumentException, InvocationTargetException, InterruptedException {
		Method method1[] = PatternProblems.class.getDeclaredMethods();
		Method method2[] = pyramidProblems.class.getDeclaredMethods();
		sort(method1);
		sort(method2);
//		System.out.println("Welcome to Java Pattern Application");
		boolean b = true;
		do {
			Thread.sleep(1000);
			System.out.println("*******************");
			System.out.println("\tP A T T E R N S  &  P Y R A M I D S");
			System.out.println("*******************");
			int j=1;
			for (int i = 0; i < method1.length; i++) {

				System.out.println(j++  + " - " + method1[i].getName());
			}
			for (int i = 0; i < method2.length; i++) {

				System.out.println(j++  + " - " + method2[i].getName());
			}
			System.out.println("0 - Exit");
			System.out.println("*******************");
			System.out.println("Enter Your Choice");
			int input = sc.nextInt();
			Thread.sleep(400);
			if (input == 0) {
				b = false;
			} else {
				System.out.println("*******************");
				System.out.println("Enter the matrix size");
				int n = sc.nextInt();
				Thread.sleep(500);
				if(input<=method1.length) {
					method1[input - 1].invoke(new PatternProblems(), n);
				}else {
					method2[input- 1-method1.length].invoke(new PatternProblems(), n);
				}
				Thread.sleep(200);
			}
		} while (b);
		System.out.println("*******************");
		System.out.println("Thank You");
		System.out.println("*******************");
	}
	public static void sort(Method[] m1) {
		Comparator<Method> c=new Comparator<Method>() {

			@Override
			public int compare(Method o1, Method o2) {
				// TODO Auto-generated method stub
				if (o1.getName().equals(o2.getName())) {
					return 0;
				} else {
					int i = o1.getName().length() - 1;
					while (Character.isDigit(o1.getName().charAt(i))) {
						i--;
					}
					int num1 = Integer.parseInt(o1.getName().substring(++i));
					i = o2.getName().length() - 1;
					while (Character.isDigit(o2.getName().charAt(i))) {
						i--;
					}
					int num2 = Integer.parseInt(o2.getName().substring(++i));
					return num1 > num2 ? 1 : -1;
				}
			}
		};
		Arrays.sort(m1, c);
	}
}

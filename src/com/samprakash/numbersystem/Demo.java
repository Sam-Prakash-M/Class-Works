package com.samprakash.numbersystem;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Demo { 
	static Scanner sc = new Scanner(System.in);
	public static void myMain() throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		Method method[]=NumberConvertion.class.getDeclaredMethods();
		boolean b=true;
		do {
			System.out.println("*************");
			System.out.println("\tB I N A R Y <-> D E C I M A L");
			System.out.println("*************");
			int i=1;
			for (Method method2 : method) {
					System.out.println(i+++method2.getName());
				
			}
			System.out.println("0 - Exit\nEnter your choice");
			int input=sc.nextInt();
			if(input ==0) {
				b=false;
			}else {
				int res=(Integer)method[input-1].invoke(new NumberConvertion(), null);
				System.out.println(res);
			}
			System.out.println("*************");
		} while (b);
		System.out.println("Thank You");
	}
}

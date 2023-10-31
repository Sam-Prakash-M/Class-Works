package com.samprakash;
import java.lang.reflect.Method;
import java.util.Scanner;

import com.samprakash.pattern.PatternPrintingZoho;

public class Demo {

	public static void main(String[] args) {
	      		//Class <PatternPrintingZoho> classObject = ;
	      		Method [] allMethods = PatternPrintingZoho.class.getDeclaredMethods();
	      		for(Method m : allMethods) {
	      			String name = m.getName();
	      			System.out.println("Methods : "+m.getName());
	      		}
	     
		
	}
	void sam() {
		
	}
}

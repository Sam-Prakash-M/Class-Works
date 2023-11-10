package com.samprakash.numbersystem;

import java.util.Scanner;

public class Areas {

	public static void main(String[] args) {
	   Scanner sc = new Scanner(System.in);
	   
	  Sam : while(true) {
		  System.out.println("\n");
		  System.out.println("----------------------Here You can Find a Area of Following Shapes-----------------------");
		  System.out.println();
		   System.out.println("Enter 1 for Rectangle : ");
		   System.out.println("Enter 2 for Square : ");
		   System.out.println("Enter 3 for Triangle : ");
		   System.out.println("Enter 4 for Exit : ");
		   int choice = sc.nextInt();
		   switch(choice) {
		   case 1 : {
			   System.out.println("Enter a length of the Rectangle in cm : ");
			   double length = sc.nextDouble();
			   System.out.println("Enter a Width of the Rectangle in cm : ");
			   double width = sc.nextDouble();
			   shapeOfArea(length,width);
			   break;
		   }
		   case 2 : {
			   System.out.println("Enter a side of the Square in cm : ");
			   double side = sc.nextDouble();
			   shapeOfArea(side);
			   break;
		   }
		   case 3 : {
			   System.out.println("Enter a base of the Triangle in cm : ");
			   double base = sc.nextDouble();
			   System.out.println("Enter a Height of the Triangle in cm : ");
			   double height = sc.nextDouble();
			   shapeOfArea(0.5,base,height);
			   break;
		   }
		   case 4 : {
			   break Sam;
		   }
		   default : {
			   System.out.println("Please Given a Valid input : ");
		   }
			   
			   
		   }
	   }

	}

	private static void shapeOfArea(double pointFive, double base, double height) {

		System.out.println("Area of Traingle is : "+(pointFive*base*height)+" cm");
		
	}

	private static void shapeOfArea(double side) {
		
		System.out.println("Area of Square is : "+(side*side)+" cm");
		
	}

	private static void shapeOfArea(double length, double width) {
		
		System.out.println("Area of Rectangle is : "+(length*width)+" cm");
		
	}

}

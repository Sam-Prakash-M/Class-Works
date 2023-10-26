package zohoquestions;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem2 {
          int weight,position;
	public Problem2(int index ,int countWeight) {
		position = index;
		weight = countWeight;
	}

	public static void main(String[] args) {
        
		System.out.println("Enter the numbers Count to given as Input : ");
		Scanner scanner = new Scanner(System.in);
		int size = scanner.nextInt();
		int[] numbers = new int[size];
		System.out.println("Enter the all the numbers : ");
		for(int index = 0 ; index < numbers.length ; index++) {
			numbers[index] = scanner.nextInt();
		}
		scanner.close();
		Problem2[] weightage = new Problem2[size];
		weightageOfEachNumber(numbers,weightage);
	}

	private static void weightageOfEachNumber(int[] numbers, Problem2[] weightage) {
		   for(int index = 0 ; index < numbers.length ; index++) {
				int countWeight = 0;
			    int squareRoot = (int)Math.sqrt(numbers[index]);
			    if(squareRoot * squareRoot == numbers[index]) {
			    	countWeight += 5;
			    }
			    if(numbers[index]%4 == 0 && numbers[index]%6 == 0) {
			    	countWeight += 4;
			    }
			    if(numbers[index]%2 == 0) {
			    	countWeight += 3;
			    }
			    Problem2 p = new Problem2(index,countWeight);
			    weightage[index] = p;
		   }
		   System.out.println("Before Sorting //");
		   for(Problem2 element : weightage) {
			   System.out.print("<"+numbers[element.position]+","+element.weight+"> ");
		   }
		   System.out.println();
		   Arrays.sort(weightage, new Comparator<Problem2>() {

			@Override
			public int compare(Problem2 o1, Problem2 o2) {
				
				return o1.weight < o2.weight ? 1 : -1;
			}
			   
		   });
		   for(Problem2 element : weightage) {
			   System.out.print("<"+numbers[element.position]+","+element.weight+"> ");
		   }
		   
	}

}

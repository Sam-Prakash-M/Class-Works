package com.samprakash.pattern;

import java.util.InputMismatchException;
import java.util.Scanner;

public class PatternProblems {

	// There is no state for this Class
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		 PatternProblems pp = new PatternProblems();
		int choice = 0 ,size = 0;
		do {   
			try {
				System.out.println("which pattern  you are looking for\n"
						+ "there are 14 pattern program  here enter 1... 14\n15 for exit");
				choice = sc.nextInt();
				 System.out.println("Enter a Pattern Size : ");
				  size = sc.nextInt();
			}
			catch(InputMismatchException ime) {
				ime.printStackTrace();
				System.out.println("Enter a Valid Input : ");
			
				main(new String[] {});
			}
			
			switch(choice) {
			    
			case 1 : {
				pp.pattern1(size);
				break;
			}
			case 2 : {
				pp.pattern2(size);
				break;
			}
			case 3 : {
				pp.pattern3(size);
				break;
			}
			case 4 : {
				pp.pattern4(size);
				break;
			}
			case 5 : {
				pp.pattern5(size);
				break;
			}
			case 6 : {
				pp.pattern6(size);
				break;
			}
			case 7 : {
				pp.pattern7(size);
				break;
			}
			case 8 : {
				pp.pattern8(size);
				break;
			}
			case 9 : {
				pp.pattern9(size);
				break;
			}
			case 10 : {
				pp.pattern10(size);
				break;
			}
			case 11 : {
				pp.pattern11(size);
				break;
			}
			case 12 : {
				pp.pattern12(size);
				break;
			}
			case 13 : {
				pp.pattern13(size);
				break;
			}
			case 14 : {
				pp.pattern14(size);
				break;
			}
			case 15 : {
				break;
			}
			default : {
				System.out.println("please enter the number betWeen 1 - 15");
			}
			
			}
		}
		while(choice != 15);
	}

	public  void pattern14(int size) {
		for (int i = 1; i <= 2 * size - 1; i++) {
			if (i < size + 1) {

				for (int star = 1; star <= (2 * size); star++) {
					if (star >= 1 && star <= i || star >= (2 * size) + 1 - i) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			} else {

				for (int star = 1; star <= (2 * size); star++) {
					if (star > (2 * size) - i && star <= (2 * size) - ((2 * size) - i)) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
				System.out.println();
			}
		}
		System.out.println("------------------------------------------------");

	}

	public  void pattern13(int size) {
		for (int i = 1; i <= 2 * size - 1; i++) {
			if (i < size + 1) {
				for (int space = 1; space < i; space++) {
					System.out.print(" ");
				}
				for (int star = 1; star < (2 * size) - (i - 1) * 2; star++) {
					if (i == 1 || star == 1 || star == (2 * size) - (i - 1) * 2 - 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			} else {
				for (int space = 1; space < 2 * size - i; space++) {
					System.out.print(" ");
				}
				for (int star = 1; star <= (i - size) * 2 + 1; star++) {
					if (i == 2 * size - 1 || star == 1 || star == (i - size) * 2 + 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		System.out.println("------------------------------------------------");
	}

	public  void pattern12(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (i == 0 || i == size - 1 || j == 0 || j == size - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}

			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");

	}

	public  void pattern11(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");

	}

	public  void pattern10(int size) {

		for (int i = 1; i <= 2 * size; i++) {
			if (i < size + 1) {

				for (int star = 1; star <= 2 * size; star++) {
					if (i > 1 && star > size - i + 1 && star <= (size - i + 1) + (i - 1) * 2) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
				System.out.println();
			} else {
				for (int star = 1; star <= 2 * size; star++) {
					if (i < 2 * size && star > (i - size) && star < (2 * size + 1) - (i - size)) {
						System.out.print(" ");
					} else {
						System.out.print("*");
					}
				}
				System.out.println();
			}

		}

		System.out.println("------------------------------------------------");

	}

	public  void pattern9(int size) {

		for (int i = 1; i <= (2 * size) - 1; i++) {

			if (i < size + 1) {
				for (int space = 1; space <= size - i; space++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= i * 2 - 1; j++) {
					if (j == 1 || j == i * 2 - 1) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			} else {
				for (int space = 1; space <= i - size; space++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= (2 * size) - (2 * (i - size) + 1); j++) {
					if (j == 1 || j == ((2 * size) - (2 * (i - size) + 1))) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}

			System.out.println();
		}

		System.out.println("------------------------------------------------");

	}

	public  void pattern8(int size) {

		for (int i = 1; i <= (2 * size) - 1; i++) {

			if (i < size + 1) {
				for (int space = 1; space <= size - i; space++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= i; j++) {
					if (j == 1 || j == i) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			} else {
				for (int space = 1; space <= i - size; space++) {
					System.out.print(" ");
				}
				for (int j = 1; j <= (2 * size) - i; j++) {
					if (j == 1 || j == (2 * size) - i) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}

			System.out.println();
		}

		System.out.println("------------------------------------------------");

	}

	public  void pattern7(int size) {
		for (int i = 1; i <= (2 * size) - 1; i++) {

			if (i < size + 1) {
				for (int j = 1; j <= i; j++) {
					if (j == 1 || j == i) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			} else {
				for (int j = 1; j <= (2 * size) - i; j++) {
					if (j == 1 || j == (2 * size) - i) {
						System.out.print("*");
					} else {
						System.out.print(" ");
					}
				}
			}

			System.out.println();
		}

		System.out.println("------------------------------------------------");

	}

	public  void pattern6(int size) {
		for (int i = 1; i <= size; i++) {
			for (int space = 1; space <= size - i; space++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= size; j++) {
				if (i == 1 || i == size || j == 1 || j == size) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		System.out.println("------------------------------------------------");

	}

	public  void pattern5(int size) {
		for (int i = 1; i <= size; i++) {
			for (int space = 1; space < i; space++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= size; j++) {
				if (i == 1 || i == size || j == 1 || j == size) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		System.out.println("------------------------------------------------");

	}

	public  void pattern4(int size) {
		for (int i = 1; i <= size; i++) {
			for (int space = 1; space <= size - i; space++) {
				System.out.print(" ");
			}
			for (int j = 1; j <= (2 * i) - 1; j++) {
				if (i == size || j == 1 || j == (2 * i) - 1) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		System.out.println("------------------------------------------------");

	}

	public  void pattern3(int size) {
		for (int i = size; i > 0; i--) {
			for (int space = size; space > i; space--) {
				System.out.print(" ");
			}
			for (int j = 0; j < (2 * i) - 1; j++) {
				if (i == size || j == 0 || j == (2 * i) - 2) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		System.out.println("------------------------------------------------");

	}

	public  void pattern2(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size - i; j++) {
				if (i == 0 || j == 0 || j == size - 1 - i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");

	}

	public  void pattern1(int size) {

		for (int i = 0; i < size; i++) {
			for (int space = 0; space < i; space++) {
				System.out.print(" ");
			}
			for (int j = 0; j < size - i; j++) {
				if (i == 0 || j == 0 || j == size - 1 - i) {
					System.out.print("*");
				} else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}

		System.out.println("------------------------------------------------");
	}

}

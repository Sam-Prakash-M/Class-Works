package com.samprakash.pattern;

public class PatternPrintingZoho {
	
	//There is no state for this Class
	public static void pattern14(int size) {
		for(int i = 1 ; i <= 2*size-1; i++) {
			if(i < size + 1) {
				
				for(int star = 1 ; star <= (2*size); star++) {
					if(star >= 1 && star  <= i  || star >= (2*size)+ 1-i) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			else {
				
				for(int star = 1 ; star <= (2*size) ; star++) {
					if(star > (2*size) - i && star <= (2*size)-((2*size) - i)) {
						System.out.print(" ");
					}
					else {
						System.out.print("*");
					}
				}
				System.out.println();
			}
		}
		System.out.println("------------------------------------------------");
		
	}

	public static void pattern13(int size) {
		for(int i = 1 ; i <= 2*size-1; i++) {
			if(i < size + 1) {
				for(int space = 1 ; space < i ; space++) {
					System.out.print(" ");
				}
				for(int star = 1 ; star < (2*size) -(i-1)*2 ; star++) {
					if(i == 1 || star == 1 || star == (2*size) -(i-1)*2-1) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
			else {
				for(int space = 1 ; space < 2*size - i;space++) {
					System.out.print(" ");
				}
				for(int star = 1 ; star <= (i-size)*2+1 ; star++) {
					if(i == 2*size -1 || star == 1 || star == (i-size)*2 + 1) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
				System.out.println();
			}
		}
		System.out.println("------------------------------------------------");
	}

	public static void pattern12(int size) {
		for(int i = 0 ; i < size ; i++) {
			for(int j = 0 ; j < size; j++) {
				if(i == 0 || i == size -1 || j == 0|| j == size-1) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
					
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");
	 
		
		
	}

	public static void pattern11(int size) {
		for(int i = 0 ; i < size ; i++) {
			for(int j = 0 ; j < size; j++) {
					System.out.print("*");
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");
	 
		
	}

	public static void pattern10(int size) {
      
		for(int i = 1 ; i <= 2*size; i++) {
			if(i < size + 1) {
				
				for(int star = 1 ; star <= 2*size ; star++) {
					if(i > 1 && star > size-i + 1 && star <= (size-i+1) + (i-1)*2) {
						System.out.print(" ");
					}
					else {
						System.out.print("*");
					}
				}
				System.out.println();
			}
			else {
				for(int star = 1 ; star <= 2*size ; star++) {
					if( i < 2*size && star > (i-size) && star < (2*size+1) -(i-size)) {
						System.out.print(" ");
					}
					else {
						System.out.print("*");
					}
				}
				System.out.println();
			}
			
			
			
		}
			 
		System.out.println("------------------------------------------------");
	
		
	}

	public static void pattern9(int size) {
          
		for(int i = 1 ; i <= (2* size) - 1 ; i++) {
		    
			if(i < size + 1) {
				for(int space = 1 ; space <= size - i ; space++) {
					System.out.print(" ");
				}
				for(int j = 1 ; j <= i*2-1; j++) {
					if(j == 1 || j == i*2-1) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			}
			else {
				for(int space = 1 ; space <= i - size  ; space++) {
					System.out.print(" ");
				}
				for(int j = 1 ; j <= (2*size) - (2*(i-size) + 1); j++) {
					if(j == 1 || j == ((2*size) - (2*(i-size) + 1)) ){
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			}
			
			System.out.println();
		}
			 
		System.out.println("------------------------------------------------");
	
		
	}

	public static void pattern8(int size) {
		
	for(int i = 1 ; i <= (2* size) - 1 ; i++) {
		    
			if(i < size + 1) {
				for(int space = 1 ; space <= size - i ; space++) {
					System.out.print(" ");
				}
				for(int j = 1 ; j <= i; j++) {
					if(j == 1 || j == i) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			}
			else {
				for(int space = 1 ; space <= i - size  ; space++) {
					System.out.print(" ");
				}
				for(int j = 1 ; j <= (2*size) - i; j++) {
					if(j == 1 || j == (2*size) - i) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			}
			
			System.out.println();
		}
			 
		System.out.println("------------------------------------------------");
	
		
		
	}

	public static void pattern7(int size) {
		for(int i = 1 ; i <= (2* size) - 1 ; i++) {
		    
			if(i < size+1 ) {
				for(int j = 1 ; j <= i; j++) {
					if(j == 1 || j == i) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			}
			else {
				for(int j = 1 ; j <= (2*size) - i; j++) {
					if(j == 1 || j == (2*size) - i) {
						System.out.print("*");
					}
					else {
						System.out.print(" ");
					}
				}
			}
			
			System.out.println();
		}
			 
		System.out.println("------------------------------------------------");
	
		
		
	}

	public static void pattern6(int size) {
		for(int i = 1 ; i <= size ; i++) {
			for(int space = 1 ; space <= size - i; space++) {
				System.out.print(" ");
			}
			for(int j = 1 ; j <= size; j++) {
				if(i == 1 ||  i == size || j == 1 || j == size) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
			 
		System.out.println("------------------------------------------------");
	
		
		
	}

	public static void pattern5(int size) {
		for(int i = 1 ; i <= size ; i++) {
			for(int space = 1 ; space <  i; space++) {
				System.out.print(" ");
			}
			for(int j = 1 ; j <= size; j++) {
				if(i == 1 ||  i == size || j == 1 || j == size) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
			 
		System.out.println("------------------------------------------------");
	
		
	}

	public static void pattern4(int size) {
		for(int i = 1 ; i <= size ; i++) {
			for(int space = 1 ; space <= size - i; space++) {
				System.out.print(" ");
			}
			for(int j = 1 ; j <= (2*i) - 1; j++) {
				if(i == size ||  j == 1 || j == (2*i) - 1) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
			 
		System.out.println("------------------------------------------------");
	
		
		
	}

	public static void pattern3(int size) {
		for(int i = size ; i > 0 ; i--) {
			for(int space = size ; space > i ; space--) {
				System.out.print(" ");
			}
			for(int j = 0 ; j < (2*i) - 1; j++) {
				if(i == size ||  j == 0 || j == (2*i) - 2) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
			 
		System.out.println("------------------------------------------------");
	
		
	}

	public static void pattern2(int size) {
		for(int i = 0 ; i < size ; i++) {
			for(int j = 0 ; j < size - i; j++) {
				if(i == 0 ||  j == 0 || j == size -1-i) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
		System.out.println("------------------------------------------------");
	 
		
	}

	public static void pattern1(int size) {
	   
		for(int i = 0 ; i < size ; i++) {
			for(int space = 0 ; space <  i ; space++) {
				System.out.print(" ");
			}
			for(int j = 0 ; j < size - i; j++) {
				if(i == 0 ||  j == 0 || j == size -1-i) {
					System.out.print("*");
				}
				else {
					System.out.print(" ");
				}
			}
			System.out.println();
		}
			 
		System.out.println("------------------------------------------------");
	}

}

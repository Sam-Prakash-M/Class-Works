package zohoevaluation;

import java.util.Scanner;

public class PatternString {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a String : ");
		String str = sc.next();
		System.out.println("Enter a word to search : ");
		String word = sc.next();
		System.out.println("Enter a column Size : ");
		int column = sc.nextInt();
		int row = column % str.length() != 0 ? str.length() / column + 1 : str.length() / column;
		System.out.println(row);
		char[][] result = new char[row][column];
		int index = 0;
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				if (index < str.length()) {
					result[i][j] = str.charAt(index++);
				} else {
					break;
				}

			}
			System.out.println();
		}
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < column; j++) {
				System.out.print(result[i][j] + " ");
			}
			System.out.println();
		}
		PatternString ps = new PatternString();
		ps.findTheWords(result, word);
	}

	private void findTheWords(char[][] result, String word) {
		Sam: for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[i].length; j++) {
				if (result[i][j] == word.charAt(0)) {
					boolean answer;
					if (j + word.length() <= result[i].length) {
						answer = new PatternString().isPresentInTheStringRightSide(i, j, result,word);
						if (answer) {
							break Sam;
						}

					}
					if (i + word.length() <= result.length) {
						answer = new PatternString().isPresentInTheStringBottomSide(i, j, result,word);
						if (answer) {
							break Sam;
						}
					}

				}
			}
			System.out.println();
		}

	}

	private boolean isPresentInTheStringBottomSide(int row, int col, char[][] result,String word) {
		    int currRow;
		    int index = 1;
		    for(currRow = row+1;currRow  < result.length ; currRow++,index++) {
		    	if(index < word.length() && result[currRow][col] != word.charAt(index)) {
		    		return false;
		    	}
		    	else if(index == word.length()-1) {
		    		System.out.println("Start Index : <"+row+","+col+">\n"
		    	+"End Index : <"+currRow+","+col+">");
		    		return true;
		    		
		    	}
		    }
		return false;
	}

	private boolean isPresentInTheStringRightSide(int row, int col, char[][] result , String word) {
		 int currCol;
		    int index = 1;
		    for(currCol = col+1; currCol < result[row].length ; currCol++,index++) {
		    	if(index < word.length() && result[row][currCol] != word.charAt(index)) {
		    		return false;
		    	}
		    	else if(index == word.length()-1) {
		    	System.out.println("Start Index : <"+row+","+col+">\n"
		    	+"End Index : <"+row+","+currCol+">");
		    		return true;
		    		
		    	}
		    }
		return false;
	}

}

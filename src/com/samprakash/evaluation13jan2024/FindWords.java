package com.samprakash.evaluation13jan2024;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class FindWords {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a row of an Array : ");
		int row = scanner.nextInt();
		System.out.println("Enter a Col of an Array : ");
		int col = scanner.nextInt();
		char[][] array = new char[row][col];
		for(int i = 0 ; i < array.length ; i++) {
			for(int j = 0 ; j < array[i].length ; j++) {
				array[i][j] = scanner.next().charAt(0);
			}
		}
		System.out.println("Enter a String to Search");
		String find = scanner.next();
			int count = new FindWords().findWordsInArray(array,find.toCharArray());
			System.out.println(find+" Ocuures : "+count+" times");
		
	}

	private int findWordsInArray(char[][] array, char[] word) {
		
		
		List<List<int[]>> totalPaths = new ArrayList<>();
		boolean[][] visited = new boolean[array.length][array[0].length];
		for(int i = 0 ; i < array.length ; i++) {
			for(int j = 0 ; j < array[i].length ; j++) {
				
				if(array[i][j] == word[0]) {
					findThewordPresentOrNot(i,j,new ArrayList<>(),visited,array,word,0,totalPaths);
				}
			}
		
		}
		totalPaths.forEach(iList -> {
			  
			System.out.println("Total size : "+iList.size());
			for(int i = 0 ; i < iList.size();i++) {
				System.out.print(Arrays.toString(iList.get(i)));
			}
			System.out.println();
		});
		return totalPaths.size();
		
	}

	private void findThewordPresentOrNot(int i, int j,List<int[]> paths,boolean[][] visited, char[][] array, char[] word, int index,List<List<int[]>> totalPaths) {
		
		
		if(i >= array.length || i < 0 || j >= array[i].length || j < 0 || visited[i][j]||array[i][j] != word[index]) {
			return;
		}
		visited[i][j] = true;
		paths.add(new int[] {i,j});
		if(array[i][j] == word[index]) {
			totalPaths.add(new ArrayList<>(paths));
			
		}
		else {
			 findThewordPresentOrNot(i,j+1,paths,visited,array,word,index+1,totalPaths);
			 findThewordPresentOrNot(i+1,j,paths,visited,array,word,index+1,totalPaths);
			 findThewordPresentOrNot(i-1,j,paths,visited,array,word,index+1,totalPaths);
			 findThewordPresentOrNot(i,j-1,paths,visited,array,word,index+1,totalPaths);
		}
		
		visited[i][j] = false;
		paths.remove(paths.size()-1);
		
	}

}

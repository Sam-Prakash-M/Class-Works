package com.samprakash.dungeongame.view;

import java.util.Scanner;

import com.samprakash.dungeongame.viewmodel.DungeonGameViewModel;

public class DungeonGameView {
   
	private static DungeonGameViewModel dungeonGameViewModel = new DungeonGameViewModel();
	private static Scanner scanner = new Scanner(System.in);
	public void startTheGame() {
		
		System.out.println("-------------------------------------------"
		+"\nEnter a size of dungeon Row and col : ");
		
		int row = scanner.nextInt() , col = scanner.nextInt();
		char [][] dungeonGame = new char[row][col];
		
		System.out.println("Enter a adventurer place : ");
		  int adventurerPlaceRow = scanner.nextInt(), adventurerPlaceCol = scanner.nextInt();
		  System.out.println("Enter a Gold Place : ");
		  int GoldPlaceRow = scanner.nextInt() , GoldPlaceCol = scanner.nextInt();
		  System.out.println("Enter a Monstor Place : ");
		  int monsterRow = scanner.nextInt() , monsterCol = scanner.nextInt();
		  dungeonGameViewModel.setTheGame(dungeonGame,adventurerPlaceRow
				  ,adventurerPlaceCol,GoldPlaceRow,GoldPlaceCol , monsterRow , monsterCol);
		  
		  int minCount = dungeonGameViewModel.findMinimumPath();
		  if(minCount != -1) {
			  System.out.println("MinimumCount is : "+minCount);
		  }
		  else {
			  System.out.println("No Possible Solution :");
		  }
		 
		
	}

}

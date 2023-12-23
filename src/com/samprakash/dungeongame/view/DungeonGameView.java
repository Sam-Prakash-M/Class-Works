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
		  int adventurerRow = scanner.nextInt(), adventurerCol = scanner.nextInt();
		  System.out.println("Enter a Gold Place : ");
		  int GoldRow = scanner.nextInt() , GoldCol = scanner.nextInt();
		  System.out.println("Enter a Monstor Place : ");
		  int monsterRow = scanner.nextInt() , monsterCol = scanner.nextInt();
		  dungeonGameViewModel.setTheGame(dungeonGame,adventurerRow
				  ,adventurerCol,GoldRow,GoldCol , monsterRow , monsterCol);
		  
		  int minCount = dungeonGameViewModel.findMinimumPath();
		  if(minCount != -1) {
			  dungeonGameViewModel.findThePathsOfAdventurer(adventurerRow
					  ,adventurerCol,GoldRow
					  ,GoldCol);
			  dungeonGameViewModel.findThePathsOfMonster(monsterRow
					  ,monsterCol,GoldRow
					  ,GoldCol);
			  dungeonGameViewModel.showThePath();
			  System.out.println("MinimumCount is : "+minCount);
		  }
		  else {
			  System.out.println("No Possible Solution :");
		  }
		 
		
	}
	public void printThePath(String path) {
		
		System.out.println(path);
		
	}

}

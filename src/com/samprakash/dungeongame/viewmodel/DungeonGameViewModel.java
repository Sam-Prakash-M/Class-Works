package com.samprakash.dungeongame.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.samprakash.dungeongame.dto.Gamer;

public class DungeonGameViewModel {

   public static  List<Gamer> allGamers = new ArrayList <>(); 

	public void setTheGame(char[][] dungeonGame, int adventurerPlaceRow, int adventurerPlaceCol, int goldPlaceRow,
			int goldPlaceCol , int monsterRow , int monsterCol) {
		
		  Gamer firstGamer =  new Gamer(dungeonGame,adventurerPlaceRow
				  ,adventurerPlaceCol,goldPlaceRow,goldPlaceCol , monsterRow , monsterCol);
		  allGamers.add(firstGamer);
		  
		
	}

	public int findMinimumPath() {
		int adventurerRow = allGamers.get(0).getAdventurerRow();
		int adventurerCol = allGamers.get(0).getAdventurerCol();
		int goldRow = allGamers.get(0).getGoldRow();
		int goldCol = allGamers.get(0).getGoldCol();
		int monsterRow = allGamers.get(0).getMonsterRow();
		int monsterCol = allGamers.get(0).getMonsterCol();
		   int adventurerCount = 0;
		
		if(adventurerRow > goldRow) {
			  
			while(adventurerRow != goldRow) {
				adventurerCount++;
				adventurerRow--;
			}
			adventurerCount += (Math.abs(adventurerCol - goldCol));
			
		}
		else if(adventurerRow < goldRow) {
			while(adventurerRow != goldRow) {
				adventurerCount++;
				adventurerRow++;
			}
			adventurerCount += (Math.abs(adventurerCol - goldCol));
			
		}
		else {
			adventurerCount += (Math.abs(adventurerCol - goldCol));
		}
		int monsterMinCount = this.findMonsterCount(goldRow,goldCol,monsterRow,monsterCol);
		return adventurerCount <= monsterMinCount ? adventurerCount : -1  ;
	}

	private int findMonsterCount(int goldRow, int goldCol,int monsterRow, int monsterCol) {
		int minCount = 0;
		if(monsterRow > goldRow) {
			  
			while(monsterRow != goldRow) {
				minCount++;
				monsterRow--;
			}
			minCount += (Math.abs(monsterCol - goldCol));
			
		}
		else if(monsterRow < goldRow) {
			while(monsterRow != goldRow) {
				minCount++;
				monsterRow++;
			}
			minCount += (Math.abs(monsterCol - goldCol));
			
		}
		else {
			minCount += (Math.abs(monsterCol - goldCol));
		}
		return minCount;
		
	}

}

package com.samprakash.dungeongame.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.samprakash.dungeongame.dto.Gamer;

public class DungeonGameViewModel {

   public static  List<Gamer> allGamers = new ArrayList <>(); 

	public void setTheGame(char[][] dungeonGame, int adventurerPlaceRow, int adventurerPlaceCol, int goldPlaceRow,
			int goldPlaceCol) {
		
		  Gamer firstGamer =  new Gamer(dungeonGame,adventurerPlaceRow
				  ,adventurerPlaceCol,goldPlaceRow,goldPlaceCol);
		  allGamers.add(firstGamer);
		  
		
	}

	public int findMinimumPath() {
		int adventurerRow = allGamers.get(0).getAdventurerRow();
		int adventurerCol = allGamers.get(0).getAdventurerCol();
		int goldRow = allGamers.get(0).getGoldRow();
		int goldCol = allGamers.get(0).getGoldCol();
		char[][]gungeonGame = allGamers.get(0).getDungeonGame();
		
		   int minCount = 0;
		
		if(adventurerRow > goldRow) {
			  
			while(adventurerRow != goldRow) {
				minCount++;
				adventurerRow--;
			}
			minCount += (Math.abs(adventurerCol - goldCol));
			
		}
		else if(adventurerRow < goldRow) {
			while(adventurerRow != goldRow) {
				minCount++;
				adventurerRow++;
			}
			minCount += (Math.abs(adventurerCol - goldCol));
			
		}
		else {
			minCount += (Math.abs(adventurerCol - goldCol));
		}
		return minCount;
	}

}

package com.samprakash.dungeongame.viewmodel;

import java.util.ArrayList;
import java.util.List;

import com.samprakash.dungeongame.dto.Gamer;
import com.samprakash.dungeongame.repository.DungeonGameRepository;
import com.samprakash.dungeongame.view.DungeonGameView;

public class DungeonGameViewModel {
   public static DungeonGameView dungeonGameView = new DungeonGameView();
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


	public void findThePathsOfAdventurer(int adventurerRow, int adventurerCol, int goldRow,
			int goldCol) {
		if(adventurerRow >= goldRow && adventurerCol >= goldCol) {
			  
			this.findAllThePathsOfAdventurerDownToLeft
			("( "+adventurerRow+""+adventurerCol+" )",adventurerRow
					,adventurerCol ,goldRow , goldCol );
			System.out.println(DungeonGameRepository.adventurerWays);
				
			
		}
		else if(adventurerRow >= goldRow && adventurerCol <= goldCol) {
			this.findAllThePathsOfAdventurerDownToRight
			("( "+adventurerRow+""+adventurerCol+" )",
					adventurerRow, adventurerCol, goldRow, goldCol);
		}
		else if(adventurerRow <= goldRow && adventurerCol >= goldCol){ 
			this.findAllThePathsOfAdventurerLeftToUp
			("( "+adventurerRow+""+adventurerCol+" )",
					adventurerRow, adventurerCol, goldRow, goldCol);
			
		}
		else {
			this.findAllThePathsOfAdventurerRightToUp
			("( "+adventurerRow+""+adventurerCol+" )",
					adventurerRow, adventurerCol, goldRow, goldCol);
		}
		System.out.println(DungeonGameRepository.adventurerWays);
		
	}

	private void findAllThePathsOfAdventurerRightToUp(String res, int adventurerRow, int adventurerCol, int goldRow,
			int goldCol) {
		if( (adventurerRow == goldRow) &&  (adventurerCol == goldCol) ) {
			DungeonGameRepository.adventurerWays.add(res);
			return;
			
		}
		else if(adventurerRow == goldRow) {
			findAllThePathsOfAdventurerRightToUp
			(res+"( "+adventurerRow+""+(adventurerCol+ 1)+" )" 
					,adventurerRow,adventurerCol +  1, goldRow , goldCol);
			return;
		}
		else if(adventurerCol == goldCol) {
			findAllThePathsOfAdventurerRightToUp
			(res+"( "+(adventurerRow+1)+""+adventurerCol+" )" 
					,adventurerRow + 1,adventurerCol, goldRow , goldCol);
			return;
		}
		findAllThePathsOfAdventurerRightToUp
		(res+"( "+(adventurerRow + 1)+""+adventurerCol+" )" 
				,adventurerRow + 1,adventurerCol, goldRow , goldCol);
		findAllThePathsOfAdventurerRightToUp
		(res+"( "+adventurerRow+""+(adventurerCol+ 1)+" )" 
				,adventurerRow ,adventurerCol + 1, goldRow , goldCol);
		
		
		
		
	}

	private void findAllThePathsOfAdventurerLeftToUp(String res, int adventurerRow, int adventurerCol, int goldRow,
			int goldCol) {
		if( (adventurerRow == goldRow) &&  (adventurerCol == goldCol) ) {
			DungeonGameRepository.adventurerWays.add(res);
			return;
			
		}
		else if(adventurerRow == goldRow) {
			findAllThePathsOfAdventurerLeftToUp
			(res+"( "+adventurerRow+""+(adventurerCol-1)+" )" 
					,adventurerRow,adventurerCol - 1, goldRow , goldCol);
			return;
		}
		else if(adventurerCol == goldCol) {
			findAllThePathsOfAdventurerLeftToUp
			(res+"( "+(adventurerRow+1)+""+adventurerCol+" )" 
					,adventurerRow + 1,adventurerCol, goldRow , goldCol);
			return;
		}
		findAllThePathsOfAdventurerLeftToUp
		(res+"( "+(adventurerRow + 1)+""+adventurerCol+" )" 
				,adventurerRow + 1,adventurerCol, goldRow , goldCol);
		findAllThePathsOfAdventurerLeftToUp
		(res+"( "+adventurerRow+""+(adventurerCol- 1)+" )" 
				,adventurerRow ,adventurerCol - 1, goldRow , goldCol);
		
		
	}

	private void findAllThePathsOfAdventurerDownToRight(String res, int adventurerRow, int adventurerCol,
			int goldRow, int goldCol) {
		if( (adventurerRow == goldRow) &&  (adventurerCol == goldCol) ) {
			DungeonGameRepository.adventurerWays.add(res);
			return;
			
		}
		else if(adventurerRow == goldRow) {
			findAllThePathsOfAdventurerDownToRight
			(res+"( "+adventurerRow+""+(adventurerCol+1)+" )" 
					,adventurerRow,adventurerCol+1, goldRow , goldCol);
			return;
		}
		else if(adventurerCol == goldCol) {
			findAllThePathsOfAdventurerDownToRight
			(res+"( "+(adventurerRow-1)+""+adventurerCol+" )" 
					,adventurerRow-1,adventurerCol, goldRow , goldCol);
			return;
		}
		findAllThePathsOfAdventurerDownToRight
		(res+"( "+(adventurerRow-1)+""+adventurerCol+" )" 
				,adventurerRow - 1,adventurerCol, goldRow , goldCol);
		findAllThePathsOfAdventurerDownToRight
		(res+"( "+adventurerRow+""+(adventurerCol+1)+" )" 
				,adventurerRow ,adventurerCol+1, goldRow , goldCol);
		
		
	}

	private void findAllThePathsOfAdventurerDownToLeft(String res ,int adventurerRow, int adventurerCol, int goldRow, int goldCol) {
		
		if( (adventurerRow == goldRow) &&  (adventurerCol == goldCol) ) {
			DungeonGameRepository.adventurerWays.add(res);
			return;
			
		}
		else if(adventurerRow == goldRow) {
			findAllThePathsOfAdventurerDownToLeft
			(res+"( "+adventurerRow+""+(adventurerCol-1)+" )" 
					,adventurerRow,adventurerCol-1, goldRow , goldCol);
			return;
		}
		else if(adventurerCol == goldCol) {
			findAllThePathsOfAdventurerDownToLeft
			(res+"( "+(adventurerRow-1)+""+adventurerCol+" )" 
					,adventurerRow-1,adventurerCol, goldRow , goldCol);
			return;
		}
		findAllThePathsOfAdventurerDownToLeft
		(res+"( "+(adventurerRow-1)+""+adventurerCol+" )" 
				,adventurerRow - 1,adventurerCol, goldRow , goldCol);
		findAllThePathsOfAdventurerDownToLeft
		(res+"( "+adventurerRow+""+(adventurerCol-1)+" )" 
				,adventurerRow ,adventurerCol-1, goldRow , goldCol);
		
		
		
	}

	public void findThePathsOfMonster(int monsterRow, int monsterCol, int goldRow, int goldCol) {
		if(monsterRow >= goldRow && monsterCol >= goldCol) {
			  
			this.findAllThePathsOfMonsterDownToLeft
			("( "+monsterRow+""+monsterCol+" )",monsterRow
					,monsterCol ,goldRow , goldCol );
			System.out.println(DungeonGameRepository.adventurerWays);
				
			
		}
		else if(monsterRow >= goldRow && monsterCol <= goldCol) {
			this.findAllThePathsOfMonsterDownToRight
			("( "+monsterRow+""+monsterCol+" )",
					monsterRow, monsterCol, goldRow, goldCol);
		}
		else if(monsterRow <= goldRow && monsterCol >= goldCol){ 
			this.findAllThePathsOfMonsterLeftToUp
			("( "+monsterRow+""+monsterCol+" )",
					monsterRow, monsterCol, goldRow, goldCol);
			
		}
		else {
			this.findAllThePathsOfMonsterRightToUp
			("( "+monsterRow+""+monsterCol+" )",
					monsterRow, monsterCol, goldRow, goldCol);
		}
		System.out.println(DungeonGameRepository.monsterWays);
		
	}

	private void findAllThePathsOfMonsterRightToUp(String res, int monsterRow, int monsterCol, int goldRow,
			int goldCol) {
		if( (monsterRow == goldRow) &&  (monsterCol == goldCol) ) {
			DungeonGameRepository.monsterWays.add(res);
			return;
			
		}
		else if(monsterRow == goldRow) {
			findAllThePathsOfMonsterRightToUp
			(res+"( "+monsterRow+""+(monsterCol+ 1)+" )" 
					,monsterRow,monsterCol +  1, goldRow , goldCol);
			return;
		}
		else if(monsterCol == goldCol) {
			findAllThePathsOfMonsterRightToUp
			(res+"( "+(monsterRow+1)+""+monsterCol+" )" 
					,monsterRow + 1,monsterCol, goldRow , goldCol);
			return;
		}
		findAllThePathsOfMonsterRightToUp
		(res+"( "+(monsterRow + 1)+""+monsterCol+" )" 
				,monsterRow + 1,monsterCol, goldRow , goldCol);
		findAllThePathsOfMonsterRightToUp
		(res+"( "+monsterRow+""+(monsterCol+ 1)+" )" 
				,monsterRow ,monsterCol + 1, goldRow , goldCol);
		
		
		
	}

	private void findAllThePathsOfMonsterLeftToUp(String res, int monsterRow, int monsterCol, int goldRow,
			int goldCol) {
		if( (monsterRow == goldRow) &&  (monsterCol == goldCol) ) {
			DungeonGameRepository.monsterWays.add(res);
			return;
			
		}
		else if(monsterRow == goldRow) {
			findAllThePathsOfMonsterLeftToUp
			(res+"( "+monsterRow+""+(monsterCol-1)+" )" 
					,monsterRow,monsterCol - 1, goldRow , goldCol);
			return;
		}
		else if(monsterCol == goldCol) {
			findAllThePathsOfMonsterLeftToUp
			(res+"( "+(monsterRow+1)+""+monsterCol+" )" 
					,monsterRow + 1,monsterCol, goldRow , goldCol);
			return;
		}
		findAllThePathsOfMonsterLeftToUp
		(res+"( "+(monsterRow + 1)+""+monsterCol+" )" 
				,monsterRow + 1,monsterCol, goldRow , goldCol);
		findAllThePathsOfMonsterLeftToUp
		(res+"( "+monsterRow+""+(monsterCol- 1)+" )" 
				,monsterRow ,monsterCol - 1, goldRow , goldCol);
		
		
	}

	private void findAllThePathsOfMonsterDownToRight(String res, int monsterRow, int monsterCol, int goldRow,
			int goldCol) {
		if( (monsterRow == goldRow) &&  (monsterCol == goldCol) ) {
			DungeonGameRepository.monsterWays.add(res);
			return;
			
		}
		else if(monsterRow == goldRow) {
			findAllThePathsOfMonsterDownToRight
			(res+"( "+monsterRow+""+(monsterCol+1)+" )" 
					,monsterRow,monsterCol+1, goldRow , goldCol);
			return;
		}
		else if(monsterCol == goldCol) {
			findAllThePathsOfMonsterDownToRight
			(res+"( "+(monsterRow-1)+""+monsterCol+" )" 
					,monsterRow-1,monsterCol, goldRow , goldCol);
			return;
		}
		findAllThePathsOfMonsterDownToRight
		(res+"( "+(monsterRow-1)+""+monsterCol+" )" 
				,monsterRow - 1,monsterCol, goldRow , goldCol);
		findAllThePathsOfMonsterDownToRight
		(res+"( "+monsterRow+""+(monsterCol+1)+" )" 
				,monsterRow ,monsterCol+1, goldRow , goldCol);
		
		
	}

	private void findAllThePathsOfMonsterDownToLeft(String res, int monsterRow, int monsterCol, int goldRow,
			int goldCol) {
		if( (monsterRow == goldRow) &&  (monsterCol == goldCol) ) {
			DungeonGameRepository.monsterWays.add(res);
			return;
			
		}
		else if(monsterRow == goldRow) {
			findAllThePathsOfMonsterDownToLeft
			(res+"( "+monsterRow+""+(monsterCol-1)+" )" 
					,monsterRow,monsterCol-1, goldRow , goldCol);
			return;
		}
		else if(monsterCol == goldCol) {
			findAllThePathsOfMonsterDownToLeft
			(res+"( "+(monsterRow-1)+""+monsterCol+" )" 
					,monsterRow-1,monsterCol, goldRow , goldCol);
			return;
		}
		findAllThePathsOfMonsterDownToLeft
		(res+"( "+(monsterRow-1)+""+monsterCol+" )" 
				,monsterRow - 1,monsterCol, goldRow , goldCol);
		findAllThePathsOfMonsterDownToLeft
		(res+"( "+monsterRow+""+(monsterCol-1)+" )" 
				,monsterRow ,monsterCol-1, goldRow , goldCol);
		
		
		
	}

	public void showThePath() {
		
		for(String path : DungeonGameRepository.adventurerWays) {
			
			if(!DungeonGameRepository.monsterWays.contains(path)) {
				dungeonGameView.printThePath(path);
				return;
			}
		}
		
		
	}

}

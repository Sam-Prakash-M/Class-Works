package com.samprakash.dungeongame.dto;

public class Gamer {
   
	 private int  adventurerCol , adventurerRow 
	 , goldRow, GoldCol,monsterRow,monsterCol , triggerRow , triggerCol;
	 public int getMonsterCol() {
		return monsterCol;
	}

	public void setMansterCol(int monsterCol) {
		this.monsterCol = monsterCol;
	}

	public int getMonsterRow() {
		return monsterRow;
	}

	public void setMonsterRow(int monsterRow) {
		this.monsterRow = monsterRow;
	}

	private  char dungeonGame[][];

		public Gamer(char[][] dungeonGame, int adventurerPlaceRow,
				int adventurerPlaceCol, int goldRow,
			int goldCol , int monsterRow 
			, int monsterCol, int triggerRow , int triggerCol ) {
		this.dungeonGame = dungeonGame;
		this.adventurerRow = adventurerPlaceRow;
		this.adventurerCol = adventurerPlaceCol;
		this.goldRow = goldRow;
		this.GoldCol = goldCol;
		this.monsterRow = monsterRow;
		this.monsterCol = monsterCol;
		this.triggerRow = triggerRow;
		this.triggerCol = triggerCol;
	}

		public int getTriggerRow() {
			return triggerRow;
		}

		public void setTriggerRow(int triggerRow) {
			this.triggerRow = triggerRow;
		}

		public int getTriggerCol() {
			return triggerCol;
		}

		public void setTriggerCol(int triggerCol) {
			this.triggerCol = triggerCol;
		}

		public void setMonsterCol(int monsterCol) {
			this.monsterCol = monsterCol;
		}

		public  char[][] getDungeonGame() {
			return dungeonGame;
		}

		public  void setDungeonGame(char[][] dungeonGame) {
			 this.dungeonGame = dungeonGame;
		}
	public int getAdventurerCol() {
		return adventurerCol;
	}

	public void setAdventurerCol(int adventurerCol) {
		this.adventurerCol = adventurerCol;
	}

	public int getAdventurerRow() {
		return adventurerRow;
	}

	public void setAdventurerRow(int adventurerRow) {
		this.adventurerRow = adventurerRow;
	}

	public int getGoldRow() {
		return goldRow;
	}

	public void setGoldRow(int goldRow) {
		this.goldRow = goldRow;
	}

	public int getGoldCol() {
		return GoldCol;
	}

	public void setGoldCol(int goldCol) {
		GoldCol = goldCol;
	}
}

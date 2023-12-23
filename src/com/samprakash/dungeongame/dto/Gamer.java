package com.samprakash.dungeongame.dto;

public class Gamer {
   
	 private int  adventurerCol , adventurerRow , goldRow, GoldCol;
	 private  char dungeonGame[][];

		public Gamer(char[][] dungeonGame, int adventurerPlaceRow, int adventurerPlaceCol, int goldRow,
			int goldCol) {
		this.dungeonGame = dungeonGame;
		this.adventurerRow = adventurerPlaceRow;
		this.adventurerCol = adventurerPlaceCol;
		this.goldRow = goldRow;
		this.GoldCol = goldCol;
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

package com.samprakash.dungeongame.main;

import com.samprakash.dungeongame.view.DungeonGameView;

public class DungeonGameApplication {
	
		private static DungeonGameView dungeonGame = new DungeonGameView();
		
	public static void main(String[] args) {
		dungeonGame.startTheGame();
	}

}

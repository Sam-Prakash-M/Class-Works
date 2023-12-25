package com.samprakash.dungeongame.repository;

import java.util.ArrayList;
import java.util.List;

public class DungeonGameRepository {
      
	public static List <String[]> monsterWays , adventurerWays;
	public static List < List <int[]> > adventurerAllWays;
	public static List <List <int[]> > adventurerBestWay;
	static {
		monsterWays = new ArrayList<>();
		adventurerWays = new ArrayList<>();
		adventurerAllWays = new ArrayList<>();
		adventurerBestWay = new ArrayList<>();
	}
	
}

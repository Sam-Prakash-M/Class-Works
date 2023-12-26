package com.samprakash.dungeongame.repository;

import java.util.ArrayList;
import java.util.List;

public class DungeonGameRepository {
      
	public static List <String[]> monsterWays , adventurerWays;
	public static List < List <int[]> > adventurerAllWays;
	public static List < List <int[]> > monsterAllWays;
	public static List <List <int[]> > adventurerBestWay;
	public static List <List <int[]> > adventurerToTriggerWay;
	static {
		monsterWays = new ArrayList<>();
		adventurerWays = new ArrayList<>();
		adventurerAllWays = new ArrayList<>();
		adventurerBestWay = new ArrayList<>();
		adventurerToTriggerWay = new ArrayList <>();
		monsterAllWays = new ArrayList <>();
	}
	
}

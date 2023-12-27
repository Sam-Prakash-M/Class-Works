package com.samprakash.dungeongame.repository;

import java.util.ArrayList;
import java.util.List;

public class DungeonGameRepository {
      
	public static List <String[]> monsterWays , adventurerWays;
	public static List < List <int[]> > adventurerAllWays;
	public static List < List <int[]> > monsterAllWays;
	public static List <List <int[]> > adventurerBestWay;
	public static List <List <int[]> > adventurerToTriggerWay;
	public static List <List <int[]> > triggerToGoldWay;
	public static List <List <int[]> > adventurerToTriggerBestWay;
	public static List <List <int[]> > triggerToGoldBestWay;
	static {
		monsterWays = new ArrayList<>();
		adventurerWays = new ArrayList<>();
		adventurerAllWays = new ArrayList<>();
		adventurerBestWay = new ArrayList<>();
		adventurerToTriggerWay = new ArrayList <>();
		monsterAllWays = new ArrayList <>();
		 triggerToGoldWay = new ArrayList <>();
		 adventurerToTriggerBestWay = new ArrayList <>();
		 triggerToGoldBestWay = new ArrayList <>(); 
	}
	
}

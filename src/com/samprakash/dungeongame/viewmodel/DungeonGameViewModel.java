package com.samprakash.dungeongame.viewmodel;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.samprakash.dungeongame.dto.Gamer;
import com.samprakash.dungeongame.repository.DungeonGameRepository;
import com.samprakash.dungeongame.view.DungeonGameView;

public class DungeonGameViewModel {
	public static DungeonGameView dungeonGameView = new DungeonGameView();
	public static List<Gamer> allGamers = new ArrayList<>();

	public void setTheGame(char[][] dungeonGame, int adventurerPlaceRow, int adventurerPlaceCol, int goldPlaceRow,
			int goldPlaceCol, int monsterRow, int monsterCol, int triggerRow, int triggerCol) {

		Gamer firstGamer = new Gamer(dungeonGame, adventurerPlaceRow, adventurerPlaceCol, goldPlaceRow, goldPlaceCol,
				monsterRow, monsterCol, triggerRow, triggerCol);
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

		if (adventurerRow > goldRow) {

			adventurerCount += (adventurerRow - goldRow);

			adventurerCount += (Math.abs(adventurerCol - goldCol));

		} else if (adventurerRow < goldRow) {

			adventurerCount += (goldRow - adventurerRow);
			adventurerCount += (Math.abs(adventurerCol - goldCol));

		} else {
			adventurerCount += (Math.abs(adventurerCol - goldCol));
		}
		System.out.println("Adventurer Count : " + adventurerCount);
		int monsterCount = this.findMonsterCount(goldRow, goldCol, monsterRow, monsterCol);
		allGamers.get(0).setAdventurerCount(adventurerCount);
		allGamers.get(0).setMonsterCount(monsterCount);
		//return adventurerCount <= monsterCount ? adventurerCount : -1;
		
		  return adventurerCount <= monsterCount ? adventurerCount :
		  this.possibleUsingTrigger(goldRow, goldCol, adventurerRow, adventurerCol,
		  monsterCount, adventurerCount);
		 
	}

	private int possibleUsingTrigger(int goldRow, int goldCol, int adventurerRow, int adventurerCol, int monsterCount,
			int adventurerCount) {
		int triggerRow = allGamers.get(0).getTriggerRow();
		int triggerCol = allGamers.get(0).getTriggerCol();

		int adventurerToTriggerCount = 0;
		if (adventurerRow > triggerRow) {

			adventurerToTriggerCount += (adventurerRow - triggerRow);
			adventurerToTriggerCount += (Math.abs(adventurerCol - triggerCol));
		} else if (adventurerRow < triggerRow) {

			adventurerToTriggerCount += (triggerRow - adventurerRow);

			adventurerToTriggerCount += (Math.abs(adventurerCol - triggerCol));
		} else {
			adventurerToTriggerCount += (Math.abs(adventurerCol - triggerCol));
		}
		allGamers.get(0).setAdventurerToTriggerCount(adventurerToTriggerCount);
		System.out.println("Adventurer to Trigger  Count : " + adventurerToTriggerCount);
		return adventurerToTriggerCount > monsterCount ? -1
				: adventurerToTriggerCount + this.triggerToGold(goldRow, goldCol, triggerRow, triggerCol);
	}

	private int triggerToGold(int goldRow, int goldCol, int triggerRow, int triggerCol) {

		int triggerToGoldCount = 0;
		if (triggerRow > goldRow) {

			triggerToGoldCount += (triggerRow - goldRow);

			triggerToGoldCount += (Math.abs(triggerCol - goldCol));
		} else if (triggerRow < goldRow) {
			triggerToGoldCount += (goldRow - triggerRow);
			triggerToGoldCount += (Math.abs(triggerCol - goldCol));
		} else {
			triggerToGoldCount += (Math.abs(triggerCol - goldCol));
		}
		allGamers.get(0).setTriggerToGoldCount(triggerToGoldCount);
		System.out.println("Trigger to Gold Count : " + triggerToGoldCount);
		return triggerToGoldCount;
	}

	public int findMonsterCount(int goldRow, int goldCol, int monsterRow, int monsterCol) {
		int monsterCount = 0;
		if (monsterRow > goldRow) {

			monsterCount += (monsterRow - goldRow);
			monsterCount += (Math.abs(monsterCol - goldCol));

		} else if (monsterRow < goldRow) {
			monsterCount += (goldRow - monsterRow);

			monsterCount += (Math.abs(monsterCol - goldCol));

		} else {
			monsterCount += (Math.abs(monsterCol - goldCol));
		}
		System.out.println("monster Count : " + monsterCount);
		return monsterCount;

	}

	public void findThePathsOfAdventurer(int adventurerRow, int adventurerCol, int goldRow, int goldCol) {
		String[] res = new String[allGamers.get(0).getAdventurerCount() + 1];
		res[0] = "( " + adventurerRow + " , " + adventurerCol + " )";

		if (adventurerRow >= goldRow && adventurerCol >= goldCol) {

			findAllThePathsOfAdventurerDownToLeft(1, res, adventurerRow, adventurerCol, goldRow, goldCol);
			System.out.println(DungeonGameRepository.adventurerWays);

		} else if (adventurerRow >= goldRow && adventurerCol <= goldCol) {
			findAllThePathsOfAdventurerDownToRight(1, res, adventurerRow, adventurerCol, goldRow, goldCol);
		} else if (adventurerRow <= goldRow && adventurerCol >= goldCol) {
			findAllThePathsOfAdventurerLeftToUp(1, res, adventurerRow, adventurerCol, goldRow, goldCol);

		} else {
			findAllThePathsOfAdventurerRightToUp(1, res, adventurerRow, adventurerCol, goldRow, goldCol);
		}

	}

	private void findAllThePathsOfAdventurerRightToUp(int index, String[] res, int adventurerRow, int adventurerCol,
			int goldRow, int goldCol) {
		if ((adventurerRow == goldRow) && (adventurerCol == goldCol)) {

			DungeonGameRepository.adventurerWays.add(Arrays.copyOf(res, res.length));

			return;

		} else if (adventurerRow == goldRow) {
			res[index] = "( " + adventurerRow + " , " + (adventurerCol + 1) + " )";
			findAllThePathsOfAdventurerRightToUp(index + 1, res, adventurerRow, adventurerCol + 1, goldRow, goldCol);
			return;
		} else if (adventurerCol == goldCol) {
			res[index] = "( " + (adventurerRow + 1) + " , " + adventurerCol + " )";
			findAllThePathsOfAdventurerRightToUp(index + 1, res, adventurerRow + 1, adventurerCol, goldRow, goldCol);
			return;
		}
		res[index] = "( " + (adventurerRow + 1) + " , " + adventurerCol + " )";

		findAllThePathsOfAdventurerRightToUp(index + 1, res, adventurerRow + 1, adventurerCol, goldRow, goldCol);

		res[index] = "( " + adventurerRow + " , " + (adventurerCol + 1) + " )";

		findAllThePathsOfAdventurerRightToUp(index + 1, res, adventurerRow, adventurerCol + 1, goldRow, goldCol);

	}

	private void findAllThePathsOfAdventurerLeftToUp(int index, String[] res, int adventurerRow, int adventurerCol,
			int goldRow, int goldCol) {
		if ((adventurerRow == goldRow) && (adventurerCol == goldCol)) {

			DungeonGameRepository.adventurerWays.add(Arrays.copyOf(res, res.length));

			return;

		} else if (adventurerRow == goldRow) {
			res[index] = "( " + adventurerRow + " , " + (adventurerCol - 1) + " )";
			findAllThePathsOfAdventurerLeftToUp(index + 1, res, adventurerRow, adventurerCol - 1, goldRow, goldCol);
			return;
		} else if (adventurerCol == goldCol) {
			res[index] = "( " + (adventurerRow + 1) + " , " + adventurerCol + " )";
			findAllThePathsOfAdventurerLeftToUp(index + 1, res, adventurerRow + 1, adventurerCol, goldRow, goldCol);
			return;
		}
		res[index] = "( " + (adventurerRow + 1) + " , " + adventurerCol + " )";

		findAllThePathsOfAdventurerLeftToUp(index + 1, res, adventurerRow + 1, adventurerCol, goldRow, goldCol);

		res[index] = "( " + adventurerRow + " , " + (adventurerCol - 1) + " )";

		findAllThePathsOfAdventurerLeftToUp(index + 1, res, adventurerRow, adventurerCol - 1, goldRow, goldCol);

	}

	private void findAllThePathsOfAdventurerDownToRight(int index, String[] res, int adventurerRow, int adventurerCol,
			int goldRow, int goldCol) {
		if ((adventurerRow == goldRow) && (adventurerCol == goldCol)) {

			DungeonGameRepository.adventurerWays.add(Arrays.copyOf(res, res.length));
			return;

		} else if (adventurerRow == goldRow) {
			res[index] = "( " + adventurerRow + " , " + (adventurerCol + 1) + " )";
			findAllThePathsOfAdventurerDownToRight(index + 1, res, adventurerRow, adventurerCol + 1, goldRow, goldCol);
			return;
		} else if (adventurerCol == goldCol) {
			res[index] = "( " + (adventurerRow - 1) + " , " + adventurerCol + " )";

			findAllThePathsOfAdventurerDownToRight(index + 1, res, adventurerRow - 1, adventurerCol, goldRow, goldCol);
			return;
		}
		res[index] = "( " + (adventurerRow - 1) + " , " + adventurerCol + " )";

		findAllThePathsOfAdventurerDownToRight(index + 1, res, adventurerRow - 1, adventurerCol, goldRow, goldCol);

		res[index] = "( " + adventurerRow + " , " + (adventurerCol + 1) + " )";

		findAllThePathsOfAdventurerDownToRight(index + 1, res, adventurerRow, adventurerCol + 1, goldRow, goldCol);

	}

	private void findAllThePathsOfAdventurerDownToLeft(int index, String[] res, int adventurerRow, int adventurerCol,
			int goldRow, int goldCol) {

		if ((adventurerRow == goldRow) && (adventurerCol == goldCol)) {

			DungeonGameRepository.adventurerWays.add(Arrays.copyOf(res, res.length));
			return;

		} else if (adventurerRow == goldRow) {
			res[index] = "( " + adventurerRow + " , " + (adventurerCol - 1) + " )";
			findAllThePathsOfAdventurerDownToLeft(index + 1, res, adventurerRow, adventurerCol - 1, goldRow, goldCol);
			return;
		} else if (adventurerCol == goldCol) {
			res[index] = "( " + (adventurerRow - 1) + " , " + adventurerCol + " )";
			findAllThePathsOfAdventurerDownToLeft(index + 1, res, adventurerRow - 1, adventurerCol, goldRow, goldCol);
			return;
		}
		res[index] = res + "( " + (adventurerRow - 1) + " , " + adventurerCol + " )";

		findAllThePathsOfAdventurerDownToLeft(index + 1, res, adventurerRow - 1, adventurerCol, goldRow, goldCol);

		res[index] = res + "( " + adventurerRow + " , " + (adventurerCol - 1) + " )";

		findAllThePathsOfAdventurerDownToLeft(index + 1, res, adventurerRow, adventurerCol - 1, goldRow, goldCol);

	}

	public void findThePathsOfMonster(int monsterRow, int monsterCol, int goldRow, int goldCol) {
		String[] res = new String[allGamers.get(0).getMonsterCount() + 1];
		res[0] = "( " + monsterRow + " , " + monsterCol + " )";
		if (monsterRow >= goldRow && monsterCol >= goldCol) {

			findAllThePathsOfMonsterDownToLeft(1, res, monsterRow, monsterCol, goldRow, goldCol);
			System.out.println(DungeonGameRepository.adventurerWays);

		} else if (monsterRow >= goldRow && monsterCol <= goldCol) {
			findAllThePathsOfMonsterDownToRight(1, res, monsterRow, monsterCol, goldRow, goldCol);
		} else if (monsterRow <= goldRow && monsterCol >= goldCol) {
			findAllThePathsOfMonsterLeftToUp(1, res, monsterRow, monsterCol, goldRow, goldCol);

		} else {
			findAllThePathsOfMonsterRightToUp(1, res, monsterRow, monsterCol, goldRow, goldCol);
		}

	}

	private void findAllThePathsOfMonsterRightToUp(int index, String[] res, int monsterRow, int monsterCol, int goldRow,
			int goldCol) {
		if ((monsterRow == goldRow) && (monsterCol == goldCol)) {

			DungeonGameRepository.monsterWays.add(Arrays.copyOf(res, res.length));
			return;

		} else if (monsterRow == goldRow) {
			res[index] = "( " + monsterRow + " , " + (monsterCol + 1) + " )";
			findAllThePathsOfMonsterRightToUp(index + 1, res, monsterRow, monsterCol + 1, goldRow, goldCol);
			return;
		} else if (monsterCol == goldCol) {
			res[index] = "( " + (monsterRow + 1) + " , " + monsterCol + " )";
			findAllThePathsOfMonsterRightToUp(index + 1, res, monsterRow + 1, monsterCol, goldRow, goldCol);
			return;
		}
		res[index] = "( " + (monsterRow + 1) + " , " + monsterCol + " )";

		findAllThePathsOfMonsterRightToUp(index + 1, res, monsterRow + 1, monsterCol, goldRow, goldCol);

		res[index] = "( " + monsterRow + " , " + (monsterCol + 1) + " )";

		findAllThePathsOfMonsterRightToUp(index + 1, res, monsterRow, monsterCol + 1, goldRow, goldCol);

	}

	private void findAllThePathsOfMonsterLeftToUp(int index, String[] res, int monsterRow, int monsterCol, int goldRow,
			int goldCol) {
		if ((monsterRow == goldRow) && (monsterCol == goldCol)) {

			DungeonGameRepository.monsterWays.add(Arrays.copyOf(res, res.length));
			return;

		} else if (monsterRow == goldRow) {

			res[index] = "( " + monsterRow + " , " + (monsterCol - 1) + " )";

			findAllThePathsOfMonsterLeftToUp(index + 1, res, monsterRow, monsterCol - 1, goldRow, goldCol);
			return;
		} else if (monsterCol == goldCol) {
			res[index] = "( " + (monsterRow + 1) + " , " + monsterCol + " )";
			findAllThePathsOfMonsterLeftToUp(index + 1, res, monsterRow + 1, monsterCol, goldRow, goldCol);
			return;
		}
		res[index] = "( " + (monsterRow + 1) + " , " + monsterCol + " )";

		findAllThePathsOfMonsterLeftToUp(index + 1, res, monsterRow + 1, monsterCol, goldRow, goldCol);

		res[index] = "( " + monsterRow + " , " + (monsterCol - 1) + " )";

		findAllThePathsOfMonsterLeftToUp(index + 1, res, monsterRow, monsterCol - 1, goldRow, goldCol);

	}

	private void findAllThePathsOfMonsterDownToRight(int index, String[] res, int monsterRow, int monsterCol,
			int goldRow, int goldCol) {
		if ((monsterRow == goldRow) && (monsterCol == goldCol)) {

			DungeonGameRepository.monsterWays.add(Arrays.copyOf(res, res.length));

			return;

		} else if (monsterRow == goldRow) {
			res[index] = "( " + monsterRow + " , " + (monsterCol + 1) + " )";
			findAllThePathsOfMonsterDownToRight(index + 1, res, monsterRow, monsterCol + 1, goldRow, goldCol);
			return;
		} else if (monsterCol == goldCol) {
			res[index] = "( " + (monsterRow - 1) + " , " + monsterCol + " )";
			findAllThePathsOfMonsterDownToRight(index + 1, res, monsterRow - 1, monsterCol, goldRow, goldCol);
			return;
		}
		res[index] = "( " + (monsterRow - 1) + " , " + monsterCol + " )";

		findAllThePathsOfMonsterDownToRight(index + 1, res, monsterRow - 1, monsterCol, goldRow, goldCol);

		res[index] = "( " + monsterRow + " , " + (monsterCol + 1) + " )";

		findAllThePathsOfMonsterDownToRight(index + 1, res, monsterRow, monsterCol + 1, goldRow, goldCol);

	}

	private void findAllThePathsOfMonsterDownToLeft(int index, String[] res, int monsterRow, int monsterCol,
			int goldRow, int goldCol) {
		if ((monsterRow == goldRow) && (monsterCol == goldCol)) {

			DungeonGameRepository.monsterWays.add(Arrays.copyOf(res, res.length));

			return;

		} else if (monsterRow == goldRow) {
			res[index] = "( " + monsterRow + " , " + (monsterCol - 1) + " )";
			findAllThePathsOfMonsterDownToLeft(index + 1, res, monsterRow, monsterCol - 1, goldRow, goldCol);
			return;
		} else if (monsterCol == goldCol) {
			res[index] = "( " + (monsterRow - 1) + " , " + monsterCol + " )";
			findAllThePathsOfMonsterDownToLeft(index + 1, res, monsterRow - 1, monsterCol, goldRow, goldCol);
			return;
		}
		res[index] = "( " + (monsterRow - 1) + " , " + monsterCol + " )";

		findAllThePathsOfMonsterDownToLeft(index + 1, res, monsterRow - 1, monsterCol, goldRow, goldCol);
		res[index] = "( " + monsterRow + " , " + (monsterCol - 1) + " )";

		findAllThePathsOfMonsterDownToLeft(index + 1, res, monsterRow, monsterCol - 1, goldRow, goldCol);

	}

	public void showThePath() {

		for (String[] path : DungeonGameRepository.adventurerWays) {

			dungeonGameView.printThePath(Arrays.toString(path));

		}
		dungeonGameView.printThePath("\nMonster Path is Arriving : -- >\n");
		for (String[] path : DungeonGameRepository.monsterWays) {

			dungeonGameView.printThePath(Arrays.toString(path));

		}
		for (String[] adventurerPath : DungeonGameRepository.adventurerWays) {

			boolean isCorrectpath = true;
			monster: for (String[] monsterPath : DungeonGameRepository.monsterWays) {

				for (int i = 0; i < adventurerPath.length - 1; i++) {

					for (int j = i - 1; j < i; j++) {

						if (j == -1) {
							if (adventurerPath[i].equals(monsterPath[j + 1])) {
								isCorrectpath = false;
								break monster;
							}
							continue;
						}
						if (adventurerPath[i].equals(monsterPath[j]) || adventurerPath[i].equals(monsterPath[j + 1])) {
							isCorrectpath = false;
							break monster;
						}

					}

				}
			}

			if (isCorrectpath) {
				dungeonGameView.printThePath("\nCorrect path is : \n");
				dungeonGameView.printThePath(Arrays.toString(adventurerPath));
				return;
			}

		}

	}

	public void assignPitsLocation(int i) {

	}

	public void setTheGame(char[][] dungeonGame, int adventurerRow, int adventurerCol, int goldRow, int goldCol,
			int[][] pits) {
		Gamer gamer = new Gamer(dungeonGame, adventurerRow, adventurerCol, goldRow, goldCol, pits);
		allGamers.add(gamer);

	}

	public void findAllPossiblePathsOfAdventurerToGold(List<int[]> result, int row, int col, int adventurerRow,
			int adventurerCol, int goldRow, int goldCol, boolean[][] previouslyVisited) {
		
		if (adventurerRow < 0 || adventurerRow >= row || adventurerCol < 0 
					|| adventurerCol >= col
				|| previouslyVisited[adventurerRow][adventurerCol]) {
			return;
		}

		previouslyVisited[adventurerRow][adventurerCol] = true;
		result.add(new int[] {adventurerRow , adventurerCol});

		if ((adventurerRow == goldRow && adventurerCol == goldCol)) {	
            
			DungeonGameRepository.adventurerAllWays.add(new ArrayList<>(result));
			

		} else {
			findAllPossiblePathsOfAdventurerToGold(result, row, col, adventurerRow - 1, adventurerCol, goldRow, goldCol,
					previouslyVisited);

			findAllPossiblePathsOfAdventurerToGold(result, row, col, adventurerRow + 1, adventurerCol, goldRow, goldCol,
					previouslyVisited);

			findAllPossiblePathsOfAdventurerToGold(result, row, col, adventurerRow, adventurerCol - 1, goldRow, goldCol,
					previouslyVisited);
			findAllPossiblePathsOfAdventurerToGold(result, row, col, adventurerRow, adventurerCol + 1, goldRow, goldCol,
					previouslyVisited);
	     }
		// back track
				previouslyVisited[adventurerRow][adventurerCol] = false;
				result.remove(result.size() - 1);

		
	}

	public void printAllAdventurerPossiblePaths() {
   
		  System.out.println("is adventurer ways empty : "+DungeonGameRepository.adventurerAllWays.isEmpty());
		for (List<int[]> list : DungeonGameRepository.adventurerAllWays) {
			for(int[] array : list) {
				System.out.print(Arrays.toString(array)+" ");
			}
			System.out.println();
			
		}

	}

	public int printMinimumPathWithoutCollidingPits(int[][] pits) {
		   int currCount = 0 , minCount = Integer.MAX_VALUE;
		  for (List<int[]> list : DungeonGameRepository.adventurerAllWays) {
			     boolean isCorrectWay = true;
			     //collidingWith Monster
			     if(isColidingWithMonster(list, DungeonGameRepository.monsterAllWays)) {
			    	 isCorrectWay = false;
			     }
			     else {
			    	 intArray :	for(int[] array : list) {
			              
							for(int i = 0 ; i < pits.length ; i++) {
								  if(array[0] == pits[i][0] && array[1] == pits[i][1]) {
									  isCorrectWay = false;
									  break intArray;
								  } 
								}
							}
				       	
			     }
			     if(isCorrectWay) {
	            	  currCount = list.size() - 1 ;
	            	  if(currCount <= minCount) {
	            		  minCount = currCount;
	            		 
	            		  DungeonGameRepository.adventurerBestWay.add(list);
	            	  }
	              }
	
			
		}
		   System.out.println("The correct Minimim Path  is : ");
		  for(List <int[]> list : DungeonGameRepository.adventurerBestWay) {
			  boolean isShortestPath = false;
			  for(int [] arr : list) {
				  if(list.size() == minCount + 1) {
					  isShortestPath = true;
					  System.out.print(Arrays.toString(arr)+" ");
				  }  
			  }
			  if(isShortestPath) {
				  System.out.println();
			  }
			   
		  }
		  return DungeonGameRepository.adventurerBestWay.isEmpty() ?  -1 : minCount;
		
	}

	private boolean isColidingWithMonster(List <int[]> adventurer , List <List <int[]>> monster) {
		  
		
	for(int i = 0 ; i < adventurer.size() - 1; i++) {
			            
			 for(List <int[]> eachMonster : monster) {
				 
				if(eachMonster.size() - 1 == allGamers.get(0).getMonsterCount() && i < eachMonster.size() ) {
					System.out.println("Curr Monster count is : "+allGamers.get(0).getMonsterCount());
						int [] adventurerArray = adventurer.get(i);
						int [] monsterArray1 = eachMonster.get(i);
						if(i == 0) {
			
							if(adventurerArray[0] == monsterArray1[0] 
									&& adventurerArray[1] == monsterArray1[1]) {
								//System.out.println("Adventurer Colliding with monster : ");
								return true;
								
							}
						}
						else {
							int [] monsterArray2 = eachMonster.get(i - 1);
							if( (adventurerArray[0] == monsterArray1[0] 
									&& adventurerArray[1] == monsterArray1[1]) ||
									(adventurerArray[0] == monsterArray2[0] 
											&& adventurerArray[1] == monsterArray2[1])) {
								//System.out.println("Adventurer Colliding with monster : ");
								return true;
							}
							
						}
					
				}
			}
		}
		
	//System.out.println("Adventurer Not Colliding with monster : ");
		return false;
	}

	public void setTheGame(char[][] dungeonGame, int adventurerRow, int adventurerCol,int monsterRow, int monsterCol, int goldRow,
			int goldCol, int[][] pits) {
		
		Gamer gamer = new Gamer(dungeonGame,adventurerRow,adventurerCol,monsterRow,monsterCol,goldRow,goldCol,pits);
		allGamers.add(gamer);
		
	}

	public void findAllPossibleMonsterToGold(List<int[]> result, int row, int col, int monsterRow, int monsterCol,
			int goldRow, int goldCol, boolean[][] previouslyVisited) {
		if (monsterRow < 0 || monsterRow >= row || monsterCol < 0 
				|| monsterCol >= col
			|| previouslyVisited[monsterRow][monsterCol]) {
		return;
	}

	previouslyVisited[monsterRow][monsterCol] = true;
	result.add(new int[] {monsterRow , monsterCol});

	if ((monsterRow == goldRow && monsterCol == goldCol)) {	
        
		DungeonGameRepository.monsterAllWays.add(new ArrayList<>(result));
		

	} else {
		findAllPossibleMonsterToGold(result, row, col, monsterRow - 1, monsterCol, goldRow, goldCol,
				previouslyVisited);

		findAllPossibleMonsterToGold(result, row, col, monsterRow + 1, monsterCol, goldRow, goldCol,
				previouslyVisited);

		findAllPossibleMonsterToGold(result, row, col, monsterRow, monsterCol - 1, goldRow, goldCol,
				previouslyVisited);
		findAllPossibleMonsterToGold(result, row, col, monsterRow, monsterCol + 1, goldRow, goldCol,
				previouslyVisited);
     }
	// back track
			previouslyVisited[monsterRow][monsterCol] = false;
			result.remove(result.size() - 1);

		
	}

	public void printAllMonsterPossiblePaths() {
		System.out.println("Is Empty monster : "+DungeonGameRepository.monsterAllWays.isEmpty());
		for (List<int[]> list : DungeonGameRepository.monsterAllWays) {
			for(int[] array : list) {
				System.out.print(Arrays.toString(array)+" ");
			}
			System.out.println();
			
		}
		
	}

	public void setTheGame(char[][] dungeonGame, int adventurerRow, int adventurerCol, int monsterRow, int monsterCol,
			int goldRow, int goldCol, int triggerRow, int triggerCol, int[][] pits) {
		Gamer gamer = new Gamer(dungeonGame,adventurerRow,
				adventurerCol,monsterRow,monsterCol,goldRow,goldCol,triggerRow , triggerCol ,pits);
		allGamers.add(gamer);
		
	}

	public void findAllPossiblePathsOfAdventurerToTrigger(List<int[]> result, int row, int col, int adventurerRow,
			int adventurerCol, int triggerRow, int triggerCol, boolean[][] previouslyVisited) {
		if (adventurerRow < 0 || adventurerRow >= row || adventurerCol < 0 
				|| adventurerCol >= col
			|| previouslyVisited[adventurerRow][adventurerCol]) {
		return;
	}

	previouslyVisited[adventurerRow][adventurerCol] = true;
	result.add(new int[] {adventurerRow , adventurerCol});

	if ((adventurerRow == triggerRow && adventurerCol == triggerCol)) {	
        
		DungeonGameRepository.adventurerToTriggerWay.add(new ArrayList<>(result));
		

	} else {
		findAllPossiblePathsOfAdventurerToTrigger(result, row, col, adventurerRow - 1, adventurerCol, triggerRow, triggerCol,
				previouslyVisited);

		findAllPossiblePathsOfAdventurerToTrigger(result, row, col, adventurerRow + 1, adventurerCol, triggerRow, triggerCol,
				previouslyVisited);

		findAllPossiblePathsOfAdventurerToTrigger(result, row, col, adventurerRow, adventurerCol - 1, triggerRow, triggerCol,
				previouslyVisited);
		findAllPossiblePathsOfAdventurerToTrigger(result, row, col, adventurerRow, adventurerCol + 1, triggerRow, triggerCol,
				previouslyVisited);
     }
	// back track
			previouslyVisited[adventurerRow][adventurerCol] = false;
			result.remove(result.size() - 1);

		
		
	}

	public void findAllPossiblePathsOfTriggerToGold(List <int[]> result, int row, int col, int triggerRow,
			int triggerCol, int goldRow, int goldCol, boolean[][] previouslyVisited) {
		if (triggerRow < 0 || triggerRow >= row || triggerCol < 0 
				|| triggerCol >= col
			|| previouslyVisited[triggerRow][triggerCol]) {
		return;
	}

	previouslyVisited[triggerRow][triggerCol] = true;
	result.add(new int[] {triggerRow , triggerCol});

	if ((goldRow == triggerRow && goldCol == triggerCol)) {	
        
		DungeonGameRepository.triggerToGoldWay.add(new ArrayList<>(result));
		

	} else {
		findAllPossiblePathsOfTriggerToGold(result, row, col, triggerRow - 1, triggerCol, goldRow, goldCol,
				previouslyVisited);

		findAllPossiblePathsOfTriggerToGold(result, row, col, triggerRow + 1, triggerCol, goldRow, goldCol,
				previouslyVisited);

		findAllPossiblePathsOfTriggerToGold(result, row, col, triggerRow, triggerCol - 1, goldRow, goldCol,
				previouslyVisited);
		findAllPossiblePathsOfTriggerToGold(result, row, col, triggerRow, triggerCol + 1, goldRow, goldCol,
				previouslyVisited);
     }
	// back track
			previouslyVisited[triggerRow][triggerCol] = false;
			result.remove(result.size() - 1);

		
		
	}

	public int printMinimumPathAdventurerToTriggerWithoutCollidingPits(int[][] pits) {
		int currCount = 0 , minCount = Integer.MAX_VALUE;
		  for (List<int[]> list : DungeonGameRepository.adventurerToTriggerWay) {
			     boolean isCorrectWay = true;
			     //collidingWith Monster
			     if(isColidingWithMonster(list, DungeonGameRepository.monsterAllWays)) {
			    	 isCorrectWay = false;
			     }
			     else {
			    	 intArray :	for(int[] array : list) {
			              
							for(int i = 0 ; i < pits.length ; i++) {
								  if(array[0] == pits[i][0] && array[1] == pits[i][1]) {
									  isCorrectWay = false;
									  break intArray;
								  } 
								}
							}
				       	
			     }
			     if(isCorrectWay) {
	            	  currCount = list.size() - 1 ;
	            	  if(currCount <= minCount) {
	            		  minCount = currCount;
	            		 
	            		  DungeonGameRepository.adventurerToTriggerBestWay.add(list);
	            	  }
	              }
	
			
		}
		   System.out.println("The correct Minimim Path  is : ");
		  for(List <int[]> list : DungeonGameRepository.adventurerToTriggerBestWay) {
			  boolean isShortestPath = false;
			  for(int [] arr : list) {
				  if(list.size() == minCount + 1) {
					  isShortestPath = true;
					  System.out.print(Arrays.toString(arr)+" ");
				  }  
			  }
			  if(isShortestPath) {
				  System.out.println();
			  }
			   
		  }
		  return DungeonGameRepository.adventurerToTriggerBestWay.isEmpty() ?  -1 : minCount;
		
	}

	public int printMinimumPathTriggerToGoldWithoutCollidingPits(int[][] pits) {
		int currCount = 0 , minCount = Integer.MAX_VALUE;
		  for (List<int[]> list : DungeonGameRepository.triggerToGoldWay) {
			     boolean isCorrectWay = true;
			  
			    	 intArray :	for(int[] array : list) {
			              
							for(int i = 0 ; i < pits.length ; i++) {
								  if(array[0] == pits[i][0] && array[1] == pits[i][1]) {
									  isCorrectWay = false;
									  break intArray;
								  } 
								}
							}
				       	
			     
			     if(isCorrectWay) {
	            	  currCount = list.size() - 1 ;
	            	  if(currCount <= minCount) {
	            		  minCount = currCount;
	            		 
	            		  DungeonGameRepository.triggerToGoldBestWay.add(list);
	            	  }
	              }
	
			
		}
		   System.out.println("The correct Minimim Path  is : ");
		  for(List <int[]> list : DungeonGameRepository.triggerToGoldBestWay) {
			  boolean isShortestPath = false;
			  for(int [] arr : list) {
				  if(list.size() == minCount + 1) {
					  isShortestPath = true;
					  System.out.print(Arrays.toString(arr)+" ");
				  }  
			  }
			  if(isShortestPath) {
				  System.out.println();
			  }
			   
		  }
		  return DungeonGameRepository.triggerToGoldBestWay.isEmpty() ?  -1 : minCount;
		
		
	}

}

package com.samprakash.application;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Stack;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
public class SamLaptopShowroom {
	public static final String SHOP_NAME = "Sam's Laptop Shop";
	public static JSONObject jsonRetreiver;
	public static JSONArray brandCollection, processorsVarient, ramVarient,laptopVarient;
	public static int stage = 1;
	public static Stack <LaptopList> traverse = new Stack<>();
	
	
	public static void brandNames() {
		int i, option;
		JSONObject obj =  (JSONObject) jsonRetreiver.get("Laptop's Name");
		brandCollection = (JSONArray) obj.get("Brand Name");
		System.out.println("BRAND NAME\n");
		for (i = 0; i < brandCollection.size(); i++) {
			String str = (String) brandCollection.get(i);
			System.out.println((i+1)+") "+str);
		}
		System.out.print((i + 1) + ") Exit\nChoose the brand name : \n"
		+ "=========================================================================");
		option = getInputFromUser(1, brandCollection.size() + 1);
		if (option <= brandCollection.size()) {
			upLevel((String)brandCollection.get(option-1));
		} else {
			stage = -1;
		}
		
	}

	private static int getInputFromUser(int minimum, int maximum) {
		Scanner input = new Scanner(System.in);
		int option = 0;
		do {
			try {
				option = input.nextInt();
				if (option < minimum || option > maximum) {
					System.out.print("Please given a valid input : ");
					continue;
				}
				//input.close();
				return option;
			} catch (InputMismatchException e) {
				System.out.print("Please given a valid input : ");
				input.next();
				continue;
			}
		} while (true);
		
	}

	private static void upLevel(String option) {
		if (traverse.isEmpty()) {
			traverse.push(new LaptopList(stage, option));
		} else {
			LaptopList temp = traverse.peek();
			traverse.push(new LaptopList(stage, temp.getOption()+" "+ option));
		}
		stage++;
		
	}

	public static void processorType() {
		int i, option;
		JSONObject obj = (JSONObject) jsonRetreiver.get("Laptop's Processors");
		
		processorsVarient = (JSONArray) obj.get(traverse.peek().getOption());
		System.out.println("LAPTOP'S PROCESSOR NAME\n");
		for (i = 0; i < processorsVarient.size(); i++) {
			String str = (String) processorsVarient.get(i);
			System.out.println((i+1)+") "+str);
		}
		System.out.print((i + 1) + ") back to Previous Menu \n" + (i + 2) 
				+ ") Exit\nChoose the processor : \n"
				+ "=========================================================================");
		option = getInputFromUser(1, processorsVarient.size() + 2);
		if (option <= processorsVarient.size()) {
			upLevel((String)processorsVarient.get(option-1));
		} else if (option == processorsVarient.size() + 1) {
			downLevel();
		} else {
			stage = -1;
		}
		
	}

	private static void downLevel() {
		if (traverse.isEmpty()) {
			stage = -1;
		} else {
			traverse.pop();
			stage--;
		}
		
	}

	public static void ramType() {
		int i, option;
		String temp = traverse.peek().getOption();
		JSONObject obj = (JSONObject) jsonRetreiver.get("Laptop's RamVarient");
		ramVarient = (JSONArray) obj.get(temp);
		System.out.println("Ram Type\n");
		for (i = 0; i < ramVarient.size(); i++) {
			String str = (String) ramVarient.get(i);
			System.out.println((i+1)+") "+str);
		}
		System.out.print((i + 1) + ") back to Previous Menu\n" + (i + 2) 
				+ ") Exit\nChoose the Ram varient : \n"
				+ "=========================================================================");
		option = getInputFromUser(1, ramVarient.size() + 2);
		if (option <= ramVarient.size()) {
			upLevel(option, (String) ramVarient.get(option - 1));
		} else if (option == ramVarient.size() + 1) {
			downLevel();
		} else {
			stage = -1;
		}
		
	}
	private static void upLevel2(int option, String string) {
		//LaptopList temp = traverse.peek();
		LaptopList myname = new LaptopList(stage,string);
		myname.setlaptopName(string);
		traverse.push(myname);
		stage++;
		
	}
	private static void upLevel(int option, String string) {
		LaptopList temp = traverse.peek();
		LaptopList myname = new LaptopList(stage, temp.getOption() +" "+string);
		myname.setlaptopName(string);
		traverse.push(myname);
		stage++;
		
	}

	public static void listOfLaptops() {
		int i, option;
		String temp = traverse.peek().getOption();
		JSONObject obj = (JSONObject) jsonRetreiver.get("List of Laptops");
		laptopVarient = (JSONArray) obj.get(temp);
		System.out.println("laptop Name\n");
		for (i = 0; i < laptopVarient.size(); i++) {
			String str = (String) laptopVarient.get(i);
			System.out.println((i+1)+") "+str);
		}
		System.out.print((i + 1) + ") back to Previous Menu\n" + (i + 2) 
				+ ") Exit\nChoose the Laptop : \n"
				+ "=========================================================================");
		option = getInputFromUser(1, laptopVarient.size() + 2);
		if (option <= laptopVarient.size()) {
			upLevel2(option, (String) laptopVarient.get(option - 1));
		} else if (option == laptopVarient.size() + 1) {
			downLevel();
		} else {
			stage = -1;
		}
		
	}

	public static void laptopPrice() {
		int option;
		String temp = traverse.peek().getlaptopName();
		JSONObject obj = (JSONObject) jsonRetreiver.get("Price of Laptops");
		System.out.println("You have Selected\n"+temp.substring(temp.indexOf('.') + 1).toUpperCase() 
			+ " Which Price is "+obj.get(temp.substring(temp.indexOf('.') + 1))+"\n");
		System.out.print("\n" + "1) back to Previous Menu\n2) Exit\nChoose the option : \n"
				+ "=========================================================================");
		option = getInputFromUser(1, 2);
		if (option == 1) {
			downLevel();
		} else {
			stage = -1;
		}
	}

}

package com.samprakash.application;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class LaptopDemo {

	public static void main(String[] args) {
		System.out.println("=======================================\n\nHi !! welcome to "
				+SamLaptopShowroom.SHOP_NAME+"\n\nhere we have "
				+"3 Different Brands laptops which is : \n\n"+Arrays.asList(LaptopList.ourLaptops)
				+"\n\n=======================================");
				gettingJSONObject();
				do {
					ListOfChoices();
					System.out.println("\n\n=========================================================================\n");
				} while (SamLaptopShowroom.stage != -1);
				System.out.print("if you purchase any laptop from here "
						+ "don't forgot to get free bag which is offer\n"
						+ "from our company.Please given your bill and get free bag in Reception \n\n"
						+ "========================THANK YOU COMING HERE,SEE YOU SOON AGAIN======================");
				
	}
	
	private static void ListOfChoices() {
		switch (SamLaptopShowroom.stage) {
		case 1: {
			SamLaptopShowroom.brandNames();
			break;
		}
		case 2: {
			SamLaptopShowroom.processorType();
			break;
		}
		case 3: {
			SamLaptopShowroom.ramType();
			break;
		}
		case 4: {
			SamLaptopShowroom.listOfLaptops();
			break;
		}
		case 5 : {
			SamLaptopShowroom.laptopPrice();
			break;
		}
		}
	}
	private static void gettingJSONObject() {
		String path;
		JSONParser jp = new JSONParser();
		try {
			path = new File(".").getCanonicalPath() 
		+ "\\src\\com\\samprakash\\application\\zohoSchoolForGraduateStudies\\MyLaptop.json";
		} catch (IOException ioe) {
			ioe.printStackTrace();
			System.out.println("Data not available : ");
			return;
		}
		try {
			SamLaptopShowroom.jsonRetreiver = (JSONObject) jp.parse(new FileReader(path));
		} catch (Exception expection) {
			 expection.printStackTrace();
			return;
		}
		
	}

}

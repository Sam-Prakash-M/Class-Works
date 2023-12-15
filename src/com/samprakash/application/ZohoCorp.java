package com.samprakash.application;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ZohoCorp {

	static String[] hr = { "Sam Prakash", "Mydheen", "Subramanian", "veeriyaPerumal" };
	static String[] listOfQuestions = { "why main method is static in java?", "what is RunTime polymorphism?",
			"what is Compile Time Polymorphism?", "what is the Usage of this Keyword?",
			"static keyword usage in java?" };
	static String[] solutions = { "jvm", "method overriding", "method overloading", "current object", "common" };

	static Queue<Candidates> listOfCandidates = new ArrayDeque<>();
	static List<Candidates> selectedCandidates = new ArrayList<>();

	private static Scanner sc = new Scanner(System.in);
	
	public static Scanner getSc() {

		return sc;
	}

	public static void interviewProcess() {
		sc.nextLine();
		if (listOfCandidates.isEmpty()) {
			System.out.println("No Candidates Available for interview : ");
			return;
		}
				while (!listOfCandidates.isEmpty()) {
					int i = 0;
					Candidates currCandidate = listOfCandidates.poll();
					String currcandidateName = currCandidate.getName();

		System.out.println(currcandidateName
		+ " Please Go the Interview hall to attend the Interview..... All the best\n\n");
	  System.out.println("Hi!!  " + currcandidateName + " take your Seat");
		System.out.println("My name is " + hr[i++] 
				+ " and my team members are " + hr[i++] + ", " + hr[i++]
					+ ", " + hr[i++] + ", ");
			boolean result = isClearedtheRound(currCandidate);
					if (result) {
						System.out.println("congradulation you have been shortlisted for further Round");
						selectedCandidates.add(currCandidate);
					} else {
						System.out.println("Thank you for participating zoho interview Process\n"
								+ "we regret to inform that we have NOT BEEN able to select you further Consideration");
					}
					
				}

	}

	private static boolean isClearedtheRound(Candidates currCandidate) {
		int score = 0;
		System.out.println("lets Start the Interview!!!\n");

		for (int i = 0; i < listOfQuestions.length; i++) {
			System.out.println(listOfQuestions[i]);
			String userInput = sc.nextLine();
			if (userInput.toLowerCase().contains(solutions[i])) {
				score++;
			}

		}
		System.out.println(" curr score is  : " + score);
		return score >= 3 ? true : false;
	}

	public static void resultAnnounceMent() {
		System.out.println("\n========================================================="
				+ "\n\nHi all thank you for coperating and patience"
				+ "\nnow we are going to announce the candidates who all are clear the rounds\n");
		if(!selectedCandidates.isEmpty()) {
			for (Candidates person : selectedCandidates) {
				System.out.println(
		person.getName() + " you have been Selcted for " 
				+ "further round stand in your own  Place");
			}

		}
		else {
			System.out.println("There is no Candidate selected : ");
		}
		
	}

	public static void addCandidates() {

		int choice;
		do {
			System.out.println("what is your name :");
			ZohoCorp.getSc().nextLine();
			String name = ZohoCorp.sc.nextLine();
			System.out.println("What is your age : ");
			int age = ZohoCorp.getSc().nextInt();
			System.out.println("What is your Qualification : ");
			ZohoCorp.getSc().nextLine();
			String qualification = ZohoCorp.sc.nextLine();
			Candidates c = new Candidates(name, age, qualification);
			ZohoCorp.listOfCandidates.add(c);
			System.out.println("Enter 1 for add Candidates : ");
			System.out.println("Enter 2 for exit from this : ");
			choice = sc.nextInt();
		} while (choice != 2);
		

	}

	public static void showAllCandidates() {
		System.out.println("Total Number of Candidates : " + listOfCandidates.size());

		for (Candidates c : listOfCandidates) {
			System.out.println(
					"===========================================\n" + "| Candidate Name          : " + c.getName()
							+ "\n" + "| Candidate Age           : " + c.getAge() + "\n" + "| Candidate Qualification : "
							+ c.getQualification() + "\n" + "===========================================");
		}

	}

	public static void showAllSelectedCandidates() {
		System.out.println("Total Number of Candidates : " + selectedCandidates.size());

		for (Candidates c : selectedCandidates) {
			System.out.println(
					"===========================================\n" + "| Candidate Name          : " + c.getName()
							+ "\n" + "| Candidate Age           : " + c.getAge() + "\n" + "| Candidate Qualification : "
							+ c.getQualification() + "\n" + "===========================================");
		}

	}

}

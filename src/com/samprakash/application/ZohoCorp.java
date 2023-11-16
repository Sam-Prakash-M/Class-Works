package com.samprakash.application;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

public class ZohoCorp {

	static String[] hr = { "Sam Prakash", "Mydheen", "Subramanian", "veeriyaPerumal" };
	static String[] listOfQuestions = { "why main method is static in java?", "what is RunTime polymorphism",
			"what is Compile Time Polymorphism?", "what is the Usage of this Keyword?",
			"static keyword usage in java?" };
	static String[] solutions = { "JVM", "Method Overriding", "Method OverLoading", "Current Object", "Comman" };

	static Queue<Candidates> listOfCandidates = new ArrayDeque<>();
	static List<Candidates> selectedCandidates = new ArrayList<>();

	private static Scanner sc = new Scanner(System.in);

	public static Scanner getSc() {
		return sc;
	}

	public static void interviewProcess(Candidates currCandidate) {
		int i = 0;
		System.out.println("Hi!!  " + currCandidate.getName() + " take your Seat");
		System.out.println("My name is " + hr[i++] + " and my team members are " + hr[i++] + ", " + hr[i++] + ", "
				+ hr[i++] + ", ");
		boolean result = isClearedtheRound(currCandidate);
		if (result) {
			System.out.println("congradulation you have been shortlisted for further Round");
			selectedCandidates.add(currCandidate);
		} else {
			System.out.println("Thank you for participating zoho interview Process\n"
					+ "we regret to inform that we have NOT BEEN able to select you further Consideration");
		}
	}

	private static boolean isClearedtheRound(Candidates currCandidate) {
		int score = 0;
		System.out.println("lets Start the Interview!!!\n");
		sc.nextLine();
		for (int i = 0; i < listOfQuestions.length; i++) {
			System.out.println(listOfQuestions[i]);
			String userInput = sc.nextLine();
			if (userInput.contains(solutions[i])) {
				score++;
			}

		}
		System.out.println(" curr score is  : "+score);
		return score >= 3 ? true : false;
	}

	public static void resultAnnounceMent() {
		System.out.println("\n========================================================="
				+ "\n\nHi all thank you for coperating and patience"
				+ "\nnow we are going to announce the candidates who all are clear the rounds\n"
	+"we read the name one by one please stand in your place\nalso one kind instructions"
	+ "those who all are not selected for the upcoming process don't loss your hope\n"
	+"Please take this as learning opprtunity and prepare well Accordingly\n"
	+"Also candidates those who are all not selected please go out one by one in that way only okay\n\n");
		for(Candidates person : selectedCandidates) {
			System.out.println(person.getName()+" you have been Selcted for "
					+ "further round stand in your own Place");
		}
		System.out.println("========================================================================="
				+"\n\nSelected Candidates all are go and take lunch in our office\n"
				+" and come shorply around 1:30 pm !! you all are have further round today itself\n\n"
				+"=========================================================================");
		
	}

}

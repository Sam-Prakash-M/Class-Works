package com.samprakash.application;

import java.util.Collections;
import java.util.Comparator;
public class InterviewDemo {

	public static void main(String[] args) {
		myMethod();

	}

	private static void myMethod() {
		
		System.out.println("=======================================================\n\n"
				+ "Hi all!! Welcome to Zoho Corporation Private Limited , Tenkasi..\n\n"+
				"=======================================================\nWe are counted the "
	+ "no of candidates appear for the level 1 interview which count is : "
	+ ""+Candidates.getNoOfCandidates()+"\nyou all are going to attend the interview in order"
			+ "\ncandidates please come to the reception and given your Details "
			+ "\nSo that we can proceed accordingly\n\n\"=======================================================");
		
		   for(int i = 1 ; i <= Candidates.getNoOfCandidates() ; i++) {
			   System.out.println("what is your name :");
			      String name = ZohoCorp.getSc().nextLine();
			      System.out.println("What is your age : ");
			      int age = ZohoCorp.getSc().nextInt();
			      System.out.println("What is your Qualification : ");
			      ZohoCorp.getSc().nextLine();
			      String qualification = ZohoCorp.getSc().nextLine();
			      System.out.println("What is your Contact Number : ");
			      String contactNo = ZohoCorp.getSc().nextLine();
			      System.out.println("What is your Email Id : ");
			      String emailID = ZohoCorp.getSc().nextLine();
			      Candidates c = new Candidates(name,age,qualification,contactNo,emailID);
			      ZohoCorp.listOfCandidates.add(c);
		   }
		   System.out.println("Interview Will be Start Immidiately Please sit here :\n"
				   +" we will name by one by one\n\n"
				   + "-----------------------------------------------------------------");
		     int choice;
		   do {  
			     Candidates currCandidate = ZohoCorp.listOfCandidates.poll();
			     String currcandidateName = currCandidate.getName();
	 System.out.println(currcandidateName+" Please Go the Interview hall to attend the Interview..... All the best\n\n"
				+"1) wish to attend the interview\n2) quit the interview");
			   choice = ZohoCorp.getSc().nextInt();
			   if(choice == 1) {
				   ZohoCorp.interviewProcess(currCandidate);
			   }
		   }
		   while(!ZohoCorp.listOfCandidates.isEmpty());
		   ZohoCorp.resultAnnounceMent();
		
		
	}

}

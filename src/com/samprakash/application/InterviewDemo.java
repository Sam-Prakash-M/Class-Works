package com.samprakash.application;

public class InterviewDemo {

	public static void main(String[] args) {
		
		InterviewDemo id = new InterviewDemo();
		System.out.println("=======================================================\n\n"
				+ "Hi all!! Welcome to Zoho Corporation Private Limited , Tenkasi..\n\n"
				+ "=======================================================\n");
				
	     id.getInputFromUser();
		
		
		ZohoCorp.resultAnnounceMent();

	}

	private void getInputFromUser() {
		ZohoCorp zc = new ZohoCorp();
		int choice;
		do {
			System.out.println("Enter 1 for add Candidates : ");
			System.out.println("Enter 2 for start the Interview : ");
			System.out.println("Enter 3 for show the list of Candidates : ");
			System.out.println("Enter 4 for list of Selected Candidates : ");
			System.out.println("Enter 5 for Exit : ");
			choice = ZohoCorp.getSc().nextInt();
			switch(choice) {
			case 1 : {
				ZohoCorp.addCandidates();
				
				break;
			}
			case 2 : {
				ZohoCorp.interviewProcess();
				break;
			}
			case 3 : {
				ZohoCorp.showAllCandidates();
				break;
			}
			case 4 : {
				ZohoCorp.showAllSelectedCandidates();
				break;
			}
			case 5 : {
				   System.out.println("Thank you ...........bye ");
				   break;
			}
			}
		}
		while(choice != 5);
		
		
		
	}

}

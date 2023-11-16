package com.samprakash.application;

public class Candidates  {
         private static int noOfCandidates =  2; 
         private int age;
         private String name,qualification,contactNo,emaiID;
		public Candidates(String name, int age, String qualification, String contactNo, String emailID) {
			this.name = name;
			this.age = age;
			this.qualification = qualification;
			this.contactNo = contactNo;
			this.emaiID = emailID;
		}
		public static int getNoOfCandidates() {
			return noOfCandidates;
		}
		public int getAge() {
			return age;
		}
		
		public String getName() {
			return name;
		}
		
		public String getQualification() {
			return qualification;
		}
		
		public String getContactNo() {
			return contactNo;
		}
		
		public String getEmaiID() {
			return emaiID;
		} 
}

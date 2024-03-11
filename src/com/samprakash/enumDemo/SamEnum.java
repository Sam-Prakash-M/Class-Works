package com.samprakash.enumDemo;



 interface Simple{
	 default SamEnum getObject() {
		 return new SamEnum();
	 }
	 static void justStatic() {}
	 void implement();
 }
 enum Actors implements Simple{
	
	 SAM,ANUSHA,MATHAN;

	@Override
	public void implement() {
		// TODO Auto-generated method stub
		
	}
}
public class SamEnum {

	public static void main(String[] args) {
		
		System.out.println(Actors.SAM);

	}

}

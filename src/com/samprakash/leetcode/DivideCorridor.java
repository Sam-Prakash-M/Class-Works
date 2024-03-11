package com.samprakash.leetcode;

public class DivideCorridor {

	public static void main(String[] args) {
		
		System.out.println(new DivideCorridor().numberOfWays("SSPPPSS"));
	}
	  public int numberOfWays(String corridor) {
	        int mod = 10_00_000_007;
	        long divCount = 1,numberOfWays = 1;
	        int chairCount = 0;
	        boolean entry = false;
	        for(int i = 0 ; i < corridor.length();i++) {
	              if(chairCount == 2) {
	                  if(corridor.charAt(i) == 'P') {
	                            divCount++;                   
	                  }
	              }
	               if(corridor.charAt(i) == 'S') {
	                   if(chairCount == 2) {
	                       numberOfWays = numberOfWays * divCount % mod;
	                       chairCount = 0;
	                       divCount = 1;
	                   }
	                   chairCount++;
	               }
	             }
	             return chairCount <= 1 ? 0 : (int)numberOfWays;
	             
	             }
}

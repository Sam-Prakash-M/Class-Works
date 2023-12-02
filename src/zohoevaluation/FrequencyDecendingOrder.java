package zohoevaluation;

import java.util.Arrays;
import java.util.Scanner;

public class FrequencyDecendingOrder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the String : ");
		String str = sc.nextLine();
		FrequencyDecendingOrder fdo = new FrequencyDecendingOrder();
		fdo.findTheFrequency(str);
		//System.out.println("ans is : "+fdo.changeLowerCase("KA..BKK"));
		
	}

	private void findTheFrequency(String str) {
		FrequencyDecendingOrder fdo = new FrequencyDecendingOrder();
		
		String eachString = "";
		int index = 0 , len = 0;
		for(int i = 0 ; i < str.length() ; i++) {
			if(str.charAt(i) ==' ') {
				  len++;
			  }
		}
		String[] sb = new String [len+1];
		for(int i = 0 ; i < str.length() ;i++) {
			  if(str.charAt(i) ==' ') {
				  
				  sb[index++] = eachString;
				  eachString = "";
			  }
			  else if(str.charAt(i) >= 65 && str.charAt(i) <= 90 
					  || str.charAt(i) >=97 && str.charAt(i) <= 122 ) {
				  eachString += str.charAt(i);
			  }
			  
		}
		sb[index++] = eachString;
		
		for(int i =0 ; i < sb.length -1; i++) {
			int count = 1;
			for(int j = i+1 ; j < sb.length; j++) {
				if(sb[j] != null && fdo.changeLowerCase(sb[i]).contains(fdo.changeLowerCase(sb[j]))) {
					sb[j] = null;
					count++;
				}
			}
			if(sb[i] != null) {
				sb[i] += "-"+count;
			}
			
		}
	
	for(int i = 0 ; i < sb.length ; i++) {
		     if(sb[i] != null)
			System.out.print(sb[i]+" ");
		
	}
		
	}
	private String changeLowerCase(String str) {
		String res = "";
		for(int i = 0 ; str != null && i < str.length() ;i++) {
			if(str.charAt(i) >= 65 && str.charAt(i) <= 90) {
				
				res += (char)(str.charAt(i) + 32);
			}
			else if(str.charAt(i) >= 97 && str.charAt(i) <= 122) {
				res += str.charAt(i);
			}
		}
		return res;
	}

}

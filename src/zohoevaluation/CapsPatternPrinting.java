package zohoevaluation;

public class CapsPatternPrinting {

	public static void main(String[] args) {

			new CapsPatternPrinting().printPattern("SamPrakash");

	}

	private  void printPattern(String str) {
		 
		int firstStart = 0;
		int capsIndex = this.getNextCapital(str);
		String left = "" , right = "";
		
		int nextStart = capsIndex , leftEnded = capsIndex; 
		
		 while(firstStart < leftEnded || nextStart  < str.length()) {
			
			   if(firstStart < leftEnded ) {
				   left += str.charAt(firstStart);
				   firstStart++;
			   }
			   if(nextStart < str.length()) {
				   right += str.charAt(nextStart);
				   nextStart++;
			   }
			   System.out.println((left+right).toUpperCase());
		 }
		
	}

	private  int  getNextCapital(String str) {
		  for(int i = 1 ; i < str.length() ; i++) {
			  if(Character.isUpperCase(str.charAt(i))) {
				  return i;
			  }
		  }
		return 0;
	}

}

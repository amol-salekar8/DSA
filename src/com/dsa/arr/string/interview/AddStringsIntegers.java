package com.dsa.arr.string.interview;

public class AddStringsIntegers {
	
	public static void main(String args[]) {
	    String st1 = "1";
	    String st2 = "11";
	    System.out.println(optimalApproach(st1,st2));
	    
	  }
	
	public static String bruteForce(String str1, String str2) {
		char[] str1Array = str1.toCharArray();
	    char[] str2Array = str2.toCharArray();
	    int lengthStr1 = str1Array.length-1;
	    int lengthStr2 = str2Array.length-1;
	    String stringBuff = "";
	    int carry = 0;
	    while( ( lengthStr1 >= 0 || lengthStr2 >= 0 ) || carry != 0){
	        int sum = 0;
	        if(lengthStr1 >= 0){
	            sum += ( str1Array[lengthStr1] - '0');
	            lengthStr1--;
	        }
	        if(lengthStr2 >= 0){
	            sum += ( str2Array[lengthStr2] - '0' );
	            lengthStr2--;
	        }
	        sum += carry;
	        carry = sum / 10;
	        stringBuff = sum % 10 + stringBuff;
	    }
	    return stringBuff;
	}
	
	public static String optimalApproach(String str1, String str2) {
		 int lengthStr1 = str1.length()-1;
		 int lengthStr2 = str2.length()-1;
		 StringBuilder stringBuff = new StringBuilder();
		    int carry = 0;
		    while( ( lengthStr1 >= 0 || lengthStr2 >= 0 ) || carry != 0){
		        int sum = 0;
		        if(lengthStr1 >= 0){
		            sum += ( str1.charAt(lengthStr1) - '0');
		            lengthStr1--;
		        }
		        if(lengthStr2 >= 0){
		            sum += ( str2.charAt(lengthStr2) - '0' );
		            lengthStr2--;
		        }
		        sum += carry;
		        carry = sum / 10;
		        stringBuff.append(sum%10);
		    }
		 return stringBuff.reverse().toString();
	}

}

package com.dsa.arr.binarySearch;

/**
 * Number should be equal to or greater than target number
 * 1) Array should in sorted 
 * 2) if lastIndex value is smaller than target then return -1
 * 
 * */
public class CeilingOfNumberFromArray {
	  public static void main(String args[]) {
		   int [] arr = {2,3,5,9,14,16,17,18};
		   int target = 15;
		   int ceil = ceilingOfNumber(arr, target);
		    System.out.println("Sum of x+y = " + ceil);
		  }
	  
	  static int ceilingOfNumber(int arr[], int target) {
		  int start =0;
		  int end = arr.length -1;
		  
		  if(arr[end ] < target)
			  return -1;
		  
		  while (start <= end ) {
			  int midElement = start + (end -start) /2;
			  
			  if( arr[midElement] == target )
				  return arr[midElement];
			  else if( arr[midElement] < target )
				  start = midElement +1;
			  else 
				  end = midElement -1;
		  }
		  /**
		   *  Q. why we used this arr[start % arr.length]?
		   *  => Because of if the number is less than arr.length its return the start position which we mention
		   *  eg : start = 5 and arr.length = 10 then remainder is 5
		   */
		  return arr[start % arr.length]; 
	  }
}

package com.dsa.arr.binarySearch;

/**
 * http://geeksforgeeks.org/dsa/find-position-element-sorted-array-infinite-numbers/
 * 
 * steps : 
 * 1) Create the first box as start =0 and end = 1
 * 2) Try to double the box with the use of reverse phycology of binary search
 * 
 * 
 * 
 */
public class FindElementFromInfiniteSortedArray {
	
	
	public static void main(String[] args) {
		int [] elementArr = {3, 5, 7, 9, 10, 90,
                100, 130, 140, 160, 170};
        int target = 170;
		System.out.println(boxSizeIncresing(target,elementArr));
		
	}
	
	public static int boxSizeIncresing(int target, int[] elementsArr) {
		int start =0;
		int end =1;
		// Below step is now recommended because we didn't have actual size 
		// this one also not recommended end < elementsArr.length-1
		while ( end < elementsArr.length-1 && target > elementsArr[end] ) {
			// store previous end +1 as newStart
			int newStart = end +1;
			
			// to calculate next box previousEnd + ( previousEnd - previousStart + 1 )
			int nextSizeOfBox = end - start +1;
			end = end + nextSizeOfBox * 2;
			start = newStart;
			
			// If we don't use below code then we got an error regarding array index out of bound exception
			if(end > elementsArr.length-1) 
				end = elementsArr.length-1;
		}
		return binarySearch(start, end , target, elementsArr);
		
	}
	
	public static int binarySearch(int start, int end, int target, int[] elementsArr) {
		while(start<= end) {
			int mid = start + (end -start)/2;
			if(elementsArr[mid] == target)
				return mid;
			else if( elementsArr[mid] > target )
				end = mid -1;
			else 
				start = mid +1;
		}
		return -1;
	}
}





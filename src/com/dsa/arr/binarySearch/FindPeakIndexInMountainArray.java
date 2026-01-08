package com.dsa.arr.binarySearch;


/**
 * Find the peak element in sorted array
 * 
 */
public class FindPeakIndexInMountainArray {
	
	public static void main(String[] args) {
		
		int [] elementArr = {1,2,3,1,2};
		int start =0;
		int end = elementArr.length -1;
		
		while(start < end ) {
			int mid = start + (end- start)/2;
			
			if(elementArr[mid] < elementArr[mid+1])
				start = mid +1;
			else 
				end = mid;
		}
		System.out.println(start);
	}

}

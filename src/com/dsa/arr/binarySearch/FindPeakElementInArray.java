package com.dsa.arr.binarySearch;


/***
 * https://leetcode.com/problems/find-peak-element/
 * 
 * 
 */
public class FindPeakElementInArray {
	public static void main(String[] args) {
		int [] mountainArr = {5,1,2};
		int target = 3;
		System.out.println(findInPeakElementArray(target, mountainArr));
	}

	
public static int findInPeakElementArray(int target, int [] mountainArr) {
        
	int start =0;
    int end = mountainArr.length -1;

	    while(start < end){
	        int mid = start + (end - start)/2;
	         if(mountainArr[mid] > mountainArr[mid +1]) 
	        	 end = mid;
	        else 
	        	start = mid +1;
	    }
	    return start;
    }
}

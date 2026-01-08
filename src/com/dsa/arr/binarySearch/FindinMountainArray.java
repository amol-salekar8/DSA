package com.dsa.arr.binarySearch;


/***
 * https://leetcode.com/problems/find-in-mountain-array/description/
 * 
 */
public class FindinMountainArray {
	
	public static void main(String[] args) {
		int [] mountainArr = {1,2,3,4,5,3,1};
		int target = 3;
		System.out.println(findInMountainArray(target, mountainArr));
	}

	
public static int findInMountainArray(int target, int [] mountainArr) {
        
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

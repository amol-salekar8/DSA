package com.dsa.arr.binarySearch;

import java.util.Arrays;

/**
 * https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/description/?envType=problem-list-v2&envId=binary-search
 * 
 */
public class FirstAndLastPositon {
	
	public static void main(String[] args) {
		int [] arr = {5,5,7,7,7,7,8,8,9};
		int target = 1;
		int [] postionIndex = {-1,-1};
		
		postionIndex[0] = search(arr,target,true);
		
		if(postionIndex[0] != -1)
			postionIndex[1] = search(arr,target,false);
		
		System.out.println(Arrays.toString(postionIndex));
	}
	
	static int search(int [] arr , int target, boolean firstIndex) {
		int start = 0;
		int index =-1;
		int end = arr.length -1;
		
		while(start <= end) {
			int mid = start + (end - start)/2;
			
			if(arr[mid] == target) {
				index = mid;
				if(firstIndex) 
					end = mid-1;
				else 
					start = mid +1;
			}else if(arr[mid] > target)
				end = mid -1;
			else 
				start = mid +1;
			
		}
		
		return index;
	}

}

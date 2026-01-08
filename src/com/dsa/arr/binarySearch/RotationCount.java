package com.dsa.arr.binarySearch;

/***
 * This example is just same as FindInRotate sorted array
 * the difference is 
 * FindInRotate we are finding element index
 * but in this we check the count of rotation
 */

/**
 *  Hints : 
 *  1) Find the Pivot
 *  	: 1) find in mid > mid +1
 *  	  2) find in mid < mid -1
 *  	: 3) check for start is greater than mid to shift the end -> mid -1 for run the loop
 *  	: 4) check for mid is greater than end to shift the start -> mid + 1 for run the loop
 * 
 */
public class RotationCount {
	
	public static void main(String[] args) {
		int[] nums = {10,12,12,13,13,0,1,2,3,4};
		int pivotIndex = findPivotfromDuplicatesForRotationCount(nums);
		System.out.println( pivotIndex+1 );
		
	}
	
	static int findPivotForRotationCount(int[] nums) {
		int start = 0;
		int end = nums.length-1;
		while(start <= end ) {
			int mid = start + (end - start)/2;
			if(end > mid && nums[mid] > nums[mid+1])
				return mid;
			else if(start < mid && nums[mid] < nums[mid-1])
				return mid-1;
			else if(nums[start] > nums[mid])
				end = mid -1;
			else 
				start = mid +1;
			
		}
		return -1;
	}
	
	static int findPivotfromDuplicatesForRotationCount(int[] nums) {
		
		int start =0;
		int end = nums.length-1;
		
		while(start <= end ) {
			int mid = start + (end -start)/2;
			if(end > mid && nums[mid] > nums[mid+1]) // for mid's next index
				return mid;
			else if( start < mid && nums[mid] < nums[mid-1]) // for mid's previous index
				return mid -1;
			if(nums[start] == nums[mid] && nums[mid] == nums[end]) { // for skipping duplicates value from array
				if( start < end  && nums[start] > nums[start+1]) // for start index duplicate values 
					return start;
				start ++;
				
				if(end > start && nums[end] < nums[end-1]) // for end index duplicate value
					return end -1;
				 end --;
			}else if(nums[start] > nums[mid] || (nums[start] == nums[mid] && nums[mid] > nums[end])) 
				// to check start is greater than mid or start and mid value are same and shift towards left side of an array
				end = mid - 1;
			else // for end 
				start = mid +1;
		}
		
		
		return -1;
	}

}

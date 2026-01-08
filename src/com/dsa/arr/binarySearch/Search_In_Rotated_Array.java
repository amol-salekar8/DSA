package com.dsa.arr.binarySearch;
/***
 * https://leetcode.com/problems/search-in-rotated-sorted-array/description/
 * 
 * 
 */
public class Search_In_Rotated_Array {
	
	public static void main(String[] args) {
		int [] nums = {10,12,12,13,13,0,1,2,3,4,5};
		
		System.out.println(search(nums,5));
	}
	
	public static int search(int[] nums, int target) {
        int peakElementIndex = findPivotForRotationCount(nums);
        
        if(peakElementIndex == -1)
        	return binarySearch(peakElementIndex+1, nums.length-1, nums, target);
        
        if(nums[peakElementIndex] == target)
        	return peakElementIndex;
        
        if(target >= nums[0])
        	return binarySearch(0,peakElementIndex-1, nums, target);
        
        return binarySearch(peakElementIndex+1, nums.length-1, nums, target);
    }   

    public static int binarySearch(int start, int end, int [] nums, int target){
        while(start <= end){
            int mid = start +(end-start)/2;
            if(nums[mid] ==  target)
                return mid;
            else if( nums[mid] < target)
                start = mid+1;
            else 
                end = mid-1;
        }
        return -1;
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

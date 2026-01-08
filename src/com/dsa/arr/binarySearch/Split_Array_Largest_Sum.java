package com.dsa.arr.binarySearch;

/**
 * https://leetcode.com/problems/split-array-largest-sum/description/
 * 
 */
public class Split_Array_Largest_Sum {
	public static void main(String[] args) {
		int[] nums = {7,2,5,8,10};
		System.out.println(splitArray(nums,2));
		
	}
	
	 public static int splitArray(int[] nums, int k) {
	        int start =0;
	        int end =0;
	        for(int i=0; i<nums.length; i++){
	            start = Math.max(start, nums[i]);
	            end += nums[i];
	        }
	        if( k == 1)return end;
	        if( k == nums.length) return start;
	        while(start < end) {
	            int mid = start + (end-start)/2;
	            if(canSplit(nums, k, mid))
	                start = mid +1;
	            else 
	                end = mid;
	        }
	        return start;
	    }

	    public static boolean canSplit(int[] nums, int noOfSplit, int target){
	        int sum =0;
	        int count = 1;
	        for(int num : nums){
	            if( (sum + num) > target){
	                count++;
	                sum = num;
	            }else {
	                sum += num;
	            }
	        }
	        return count > noOfSplit;
	    }
}

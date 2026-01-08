package com.dsa.arr.binarySearch;

public class Single_Element_In_Sorted_Array {
	
	public static void main(String[] args) {
		int [] nums = {1,1,2,2,3,4,4,5,5};
		System.out.println(singleNonDuplicate(nums));
		
		
	}

	public static int singleNonDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++){
            if(i == 0) {
               if(nums[i] != nums[i+1]) return nums[i];
            }else if( i == nums.length-1) {
                if( nums[i-1] != nums[i] ) return nums[i];  
            }else {
                if( nums[i] != nums[i-1] && nums[i+1] != nums[i] )
                 return nums[i];
            }
        }
      return -1;
    }
}

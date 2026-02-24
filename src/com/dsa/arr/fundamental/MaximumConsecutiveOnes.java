package com.dsa.arr.fundamental;

/**
 * Q. Given a binary array nums, return the maximum number of consecutive 1s in the array.
 * Example 1
 * Input: nums = [1, 1, 0, 0, 1, 1, 1, 0]
 * Output: 3
 * Explanation:
 * The maximum consecutive 1s are present from index 4 to index 6, amounting to 3 1s
 *
 * Example 2
 * Input: nums = [0, 0, 0, 0, 0, 0, 0, 0]
 * Output: 0
 * Explanation:
 * No 1s are present in nums, thus we return 0
 */
public class MaximumConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1, 1, 0, 1, 1, 1};
        System.out.println(findMaximumConsecutiveOnes(nums));
    }

    public static int findMaximumConsecutiveOnes(int [] nums){
        int maxCount = 0;
        int count =0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 1){
                count++;
                maxCount = Math.max(maxCount , count);
            }else {
                count = 0;
            }
        }
        return maxCount;
    }
}

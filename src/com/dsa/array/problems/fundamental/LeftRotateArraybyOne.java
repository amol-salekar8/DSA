package com.dsa.array.problems.fundamental;

import java.util.Arrays;

/***
 * Q. Given an integer array nums, rotate the array to the left by one.
 * Example 1
 * Input: nums = [1, 2, 3, 4, 5]
 * Output: [2, 3, 4, 5, 1]
 * Explanation:
 * Initially, nums = [1, 2, 3, 4, 5]
 * Rotating once to left -> nums = [2, 3, 4, 5, 1]
 *
 * Example 2
 * Input: nums = [-1, 0, 3, 6]
 * Output: [0, 3, 6, -1]
 * Explanation:
 * Initially, nums = [-1, 0, 3, 6]
 * Rotating once to left -> nums = [0, 3, 6, -1]
 *
 */
public class LeftRotateArraybyOne {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5};
        rotateArrayByOne(nums);
        Arrays.stream(nums).boxed().forEach(System.out::println);
    }

    public static void rotateArrayByOne(int[] nums) {
        if(nums.length < 0) return;
        int firstElement = nums[0];
        for(int i=1;i<nums.length;i++){
            nums[i-1] = nums[i];
            if(i==nums.length-1){
                nums[i]=firstElement;
            }
        }
    }
}

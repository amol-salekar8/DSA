package com.dsa.array.problems.fundamental;

/**
 * Q. Given an integer array nums and a non-negative integer k, rotate the array to the left by k steps.
 * Example 1
 * Input: nums = [1, 2, 3, 4, 5, 6], k = 2
 * Output: nums = [3, 4, 5, 6, 1, 2]
 * Explanation:
 * rotate 1 step to the left: [2, 3, 4, 5, 6, 1]
 * rotate 2 steps to the left: [3, 4, 5, 6, 1, 2]
 *
 * Example 2
 * Input: nums = [3, 4, 1, 5, 3, -5], k = 8
 * Output: nums = [1, 5, 3, -5, 3, 4]
 * Explanation:
 * rotate 1 step to the left: [4, 1, 5, 3, -5, 3]
 * rotate 2 steps to the left: [1, 5, 3, -5, 3, 4]
 * rotate 3 steps to the left: [5, 3, -5, 3, 4, 1]
 * rotate 4 steps to the left: [3, -5, 3, 4, 1, 5]
 * rotate 5 steps to the left: [-5, 3, 4, 1, 5, 3]
 * rotate 6 steps to the left: [3, 4, 1, 5, 3, -5]
 * rotate 7 steps to the left: [4, 1, 5, 3, -5, 3]
 * rotate 8 steps to the left: [1, 5, 3, -5, 3, 4]
 */
public class LeftRotateArraybyKPlaces {

    public static void main(String[] args) {

    }

    public static void rotateArray(int[] nums, int k) {
        int length = nums.length;
        k = k % length;
        if(k == 0) return;

        int [] temp = new int[k];

        // Store first k elements in a temporary array
        for(int i=0;i<k;i++){
            temp[i] = nums[i];
        }

        // Shift n-k elements of given array to the front
        for(int i = k; i<nums.length;i++){
            nums[i-k] = nums[i];
        }

        // Copy back the k elements at the end
        for(int i =0; i<temp.length;i++){
            nums[length-k+i] = temp[i];
        }

    }
}

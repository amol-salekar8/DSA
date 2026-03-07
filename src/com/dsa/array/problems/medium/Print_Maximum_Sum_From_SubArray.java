package com.dsa.array.problems.medium;

/**
 *  Q. Given an integer array nums, find the subarray with the largest sum and return the sum of the elements present in that subarray.
 *
 *
 */
public class Print_Maximum_Sum_From_SubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(optimalApproach(nums));
    }

    public static int bruteForceApproach(int[] nums){
        int maxiMum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += nums[k];
                    maxiMum = Math.max(maxiMum,sum);
                }
            }
        }
        return maxiMum;
    }

    public static int betterApproach(int[] nums){
        int maxiMum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                maxiMum = Math.max(maxiMum,sum);
            }
        }
        return maxiMum;
    }

    /** Kadane's Algorithm **/
    public static int optimalApproach(int[] nums){
        int maxiMum = Integer.MIN_VALUE;
        /* Current Sum */
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxiMum = Math.max(maxiMum,sum);
            /* Reset Sum */
            if(sum < 0) sum = 0;
        }
        return maxiMum;
    }
}

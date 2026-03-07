package com.dsa.array.problems.medium;

import java.util.ArrayList;
import java.util.List;

public class Print_Maximum_Sum_SubArray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(optimalApproach(nums));
    }

    public static List<Integer> bruteForceApproach(int[] nums){
        int maxiMum = Integer.MIN_VALUE;
        List<Integer> maxiMumSubArray = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {

            for (int j = i; j < nums.length; j++) {
                int sum = 0;
                for (int k = i; k < j; k++) {
                    sum += nums[k];
                    maxiMum = Math.max(maxiMum,sum);
                }
            }
        }
        return maxiMumSubArray;
    }

    /** Kadane's Algorithm **/
    public static List<Integer> optimalApproach(int[] nums){
        List<Integer> maxiMumSubArray = new ArrayList<>();
        int maxiMum = Integer.MIN_VALUE;
        /* Current Sum */
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            maxiMumSubArray.add(nums[i]);
            maxiMum = Math.max(maxiMum,sum);
            /* Reset Sum */
            if(sum < 0) {
                maxiMumSubArray.clear();
                sum = 0;
            }
        }
        return maxiMumSubArray;
    }
}

package com.dsa.array.problems.hard;

import java.util.Arrays;

/**
 *Q. Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.
 *
 * Note: You are not allowed to modify the original array.
 *
 * Example 1 :
 * Input: nums = [3, 5, 4, 1, 1]
 * Output: [1, 2]
 * Explanation: 1 appears two times in the array and 2 is missing from nums
 *
 */
public class FindRepeatingAndMissingNumber {
    public static void main(String[] args) {
        int[] nums = {3, 5, 4, 1, 1};
        Arrays.stream(optimalApproach_I(nums)).forEach(System.out::println);
    }

    /** Two For Loops **/
    public static int[] bruteForceApproach(int[] nums){
        int repeating = -1;
        int missing = -1;

        for (int i =1;i< nums.length;i++){
            int count =0;
            for (int j = 0; j < nums.length; j++) {
                if(i == nums[j] ){
                    count++;
                }
            }
            if(count == 2) repeating = i;
            if(count == 0) missing = i;
            if(repeating != -1 && missing != -1) break;
        }
        return  new int[]{repeating, missing};
    }

    /** With the help of hassing **/
    public static int[] betterApproach(int[] nums){
        /** we required hashed array with the size of original_array + 1
         * becuase of index at zero and our value start from 1*/
        int[] hashedArr = new int[nums.length+1];
        int missing =-1, repeating = -1;

        for (int i = 0; i < nums.length; i++) {
            hashedArr[nums[i]]++;
        }

        for (int i = 1; i < hashedArr.length; i++) {
            if (hashedArr[i]==2) repeating = i;
            if (hashedArr[i]==0) missing = i;
            if (repeating != -1 && missing != -1) {
                break;
            }
        }

        return new int[]{repeating, missing};
    }

    /** --- With The help of Mathematics equation --- */
    public static int[] optimalApproach_I(int [] nums){
        int length = nums.length;
        // Summation n natural number
        long sN = ( length * ( length +1 ) ) /2;
        // Summation of square of n natural number
        long s2N = ( length * ( length +1 )  * ( 2 * length + 1 ) ) /6;
        long s =0, s2 =0;

        for(int i=0; i<length; i++){
            s += nums[i];
            s2 += (long) nums[i]* (long) nums[i];
        }
        // (X - Y ) = S - SN
        long value1 = s - sN;
        // ( X^2 - Y^2) = S2 - S2N
        long value2 = s2 - s2N;
        /**( X^2 - Y^2) = S2 - S2N
         * (X - Y ) (X + Y ) = S2 - S2N
         *  (X + Y ) = S2 - S2N / (X - Y );
         */
        value2 = value2/value1;
        /***
         *  X - Y  = Value1
         *  X + Y  = Value2
         *  2X  = ( Value1 + Value 2)
         *  X = ( Value1 + Value 2) / 2
         *
         */
        long repeating_x = ( value1 + value2 )/2;
        /**
         *  X - Y  = Value1
         *  - Y = - X + Value1
         *   Y =  X - Value1
         */
        long missing_y = repeating_x - value1;
        return new int[]{(int)repeating_x, (int) missing_y}  ;
    }


}

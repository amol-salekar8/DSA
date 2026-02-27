package com.dsa.arr.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q.Given an integer array nums of even length consisting of an equal number of positive and negative integers.
 * conditions are met:
 * 1) Every consecutive pair of integers have opposite signs.
 * 2) For all integers with the same sign, the order in which they were present in nums is preserved.
 * 3) The rearranged array begins with a positive integer.
 *
 *  Example 1
 * Input : nums = [2, 4, 5, -1, -3, -4]
 * Output : [2, -1, 4, -3, 5, -4]
 * Explanation:
 * The positive number 2, 4, 5 maintain their relative positions and -1, -3, -4 maintain their relative positions
 *
 * Example 2
 * Input : nums = [1, -1, -3, -4, 2, 3]
 * Output : [1, -1, 2, -3, 3, -4]
 * Explanation:
 * The positive number 1, 2, 3 maintain their relative positions and -1, -3, -4 maintain their relative positions
 *
 * Note :
 * 1) Positive number at even position
 * 2) Negative number at odd position
 *
 * Hint 1 : Make separate list for positive and negative number than add both number alternatively
 * Hint 2 : Create 2 index positive and negative
 *
 *
 */
public class RearrangeArrayElementsBySign {
    public static void main(String[] args) {
        int[] nums = {1, 2, -4, -5};
        int [] rearrangeArry = optimal_withOddEvenIndex(nums);
        Arrays.stream(rearrangeArry).boxed().forEach(System.out::println);
    }

    public static int[] bruteForceApproach_3List(int[] nums){
        List<Integer> positiveNumber = new ArrayList<>();
        List<Integer> negativeNumber = new ArrayList<>();
        List<Integer> numbers = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) {
                positiveNumber.add(nums[i]);
            }else {
                negativeNumber.add(nums[i]);
            }
        }

        for (int i=0;i<positiveNumber.size();i++){
            numbers.add(positiveNumber.get(i));
            numbers.add(negativeNumber.get(i));
        }

        int leaderArr[] = new int[numbers.size()];
        int index =0;
        for(int num : numbers) {
            leaderArr[index++] = num;
        }
        return leaderArr;
    }

    public static int[] bruteForceApproach_withOddEvenIndex(int[] nums){
        List<Integer> positiveNumberList = new ArrayList<>();
        List<Integer> negativeNumberList = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            if(nums[i]>0) {
                positiveNumberList.add(nums[i]);
            }else {
                negativeNumberList.add(nums[i]);
            }
        }

        int [] reArrangedArr = new int[positiveNumberList.size()+negativeNumberList.size()];
        /*** Hint 1 **/
        for(int i=0;i<positiveNumberList.size();i++){
            int positiveIndex = 2*i;
            int negativeIndex = 2*i+1;
            reArrangedArr[positiveIndex] = positiveNumberList.get(i);
            reArrangedArr[negativeIndex] = negativeNumberList.get(i);
        }
        return  reArrangedArr;
    }

    public static int[] optimal_withOddEvenIndex(int[] nums){
        int [] reArrangedArr = new int[nums.length];
        int positiveIndex = 0;
        int negativeIndex = 1;
        for(int i=0;i< nums.length;i++){
            if(nums[i] >=  0){
                reArrangedArr[positiveIndex] = nums[i];
                positiveIndex+=2;
            }else {
                reArrangedArr[negativeIndex] = nums[i];
                negativeIndex+=2;
            }
        }
        return reArrangedArr;
    }
}

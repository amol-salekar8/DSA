package com.dsa.arr.fundamental;

import java.util.HashMap;
import java.util.Map;

/**
 * Q. Given an integer array nums of size n, return the majority element of the array.
 * Desc : The majority element of an array is an element that appears more than n/2 times in the array. The array is guaranteed to have a majority element.
 */
public class MajorityElement_I {
    public static void main(String[] args) {
        int[] nums = {2, 2, 1, 1, 1, 2, 2,3,3,3,3,3};
        System.out.println("Brute force approach :"+optimalApproach(nums));
    }

    /** With for loop inside another for loop
     * TC : O(n^2)
     *
     */
    public static int bruteForceApproach(int [] nums){
        int count = 0;
        for (int i=0; i< nums.length; i++){
            for (int j = 0; j < nums.length; j++) {
                if(nums[i] == nums[j]){
                    count++;
                }
            }
            if(count > nums.length/2) return nums[i];
        }
        return -1;
    }

    /** With HashMap
     * TC : O(n)
     * SC : O(n)
     *
     */
    public static int betterApproach(int[] nums){
        HashMap<Integer, Integer> map = new HashMap<>();
        int length = nums.length;
        for(int i=0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> entry : map.entrySet()){
            if(entry.getValue() > (length/2) ) return entry.getKey();
        }
        return -1;
    }

    /**
     * We use algorithm that count the same dishes if the dish is different the reduce that count by 1
     * 1) IF count = 0 then we need to  start count another dish
     *
     */
    public static  int optimalApproach(int[] nums){
        int element = 0;
        int count = 0;

        for (int i = 0; i < nums.length; i++) {
            if( count == 0){
                count = 1;
                element = nums[i];
            } else if (element == nums[i]){
                count++;
            }else {
                count --;
            }
        }

        int countElement =0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == element) countElement++;
        }

        if(countElement > (nums.length/2)) return element;

        return -1;
    }
}

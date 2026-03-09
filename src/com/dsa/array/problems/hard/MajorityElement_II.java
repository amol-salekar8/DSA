package com.dsa.array.problems.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Q. Given an integer array nums of size n. Return all elements which appear more than n/3 times in the array. The output can be returned in any order.
 *
 * Input: nums = [1, 2, 1, 1, 3, 2]
 * Output: [1]
 * Explanation:
 * Here, n / 3 = 6 / 3 = 2.
 * Therefore the elements appearing 3 or more times is : [1]
 *
 * */
public class MajorityElement_II {
    public static void main(String[] args) {
        int[] nums = {11, 33, 33, 11, 33, 11};
        optimalApproach(nums).stream().forEach(System.out::println);
    }
    /** -- Two loops with some logical concept -- */
    public static List<Integer> bruteForceApproach(int[] nums){
        List<Integer> resultList = new ArrayList<>();
        int limit = nums.length / 3;
        for (int i =0; i<nums.length;i++){
            /*-- Skip The present element --*/
            if(resultList.size() == 0 || resultList.get(0) != nums[i]){
                int count = 0;
                for (int j = 0; j < nums.length; j++) {
                    if(nums[i] == nums[j]) count++;
                }

                if(count > limit) resultList.add(nums[i]);
                /**--
                 * Suppose length of array is 6 and we are dividing with 2 then limit of occurring element become half or greator
                        in that  maximum 1 element can be present
                 * Suppose length of array is 6 and we are dividing with 3 then limit of occurring element become 2
                        in that  maximum 2 element can be present
                 --*/
                if(resultList.size() == 2) break;
            }
        }
        return resultList;
    }

    /* -- Using Data structure --*/
    public static List<Integer> betterApproach(int[] nums){
        List<Integer> resultList = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int limit = nums.length / 3;
        /* -- Collect the count -- */
        for(int i = 0; i<nums.length;i++){
            map.put(nums[i], map.getOrDefault(nums[i],0)+1);
        }

        /* -- Find greater than limit number -- */
        for(Map.Entry<Integer, Integer> entry :  map.entrySet() ){
            if(entry.getValue() > limit )
                resultList.add(entry.getKey());
        }

        return resultList;
    }
    /** Check repeated element concept */
    public static List<Integer> optimalApproach(int[] nums){
        List<Integer> resultList = new ArrayList<>();
        int count_1 = 0, count_2 = 0;
        int element_1 = Integer.MIN_VALUE, element_2 = Integer.MIN_VALUE;
        /* -- We use formula of N/2 means there is only one element who  present more than half --
         *  -- Check which element present more than other --
         * */
        for(int i=0; i< nums.length; i++){
            if(count_1 == 0 && nums[i] != element_2){
                count_1 = 1;
                element_1 = nums[i];
            }else if(count_2 == 0 && nums[i] != element_1){
                count_2 = 1;
                element_2 = nums[i];
            }else if(nums[i] == element_1){
                count_1++;
            }else if(nums[i] == element_2){
                count_2 ++;
            }else{
                count_1--;
                count_2--;
            }
        }
        /** Reset the Count */
        count_1 = 0;
        count_2 = 0;

        /** -- Check the element count -- */
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == element_1) count_1++;
            else if(nums[i] == element_2) count_2++;
        }

        int limit = nums.length / 3;
        /** Both element count is greator than limit then add into array list */
        if(count_1 > limit) resultList.add(element_1);
        if(count_2 > limit) resultList.add(element_2);

        return  resultList;
    }
}

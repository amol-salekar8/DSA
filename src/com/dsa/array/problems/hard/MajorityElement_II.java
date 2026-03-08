package com.dsa.array.problems.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MajorityElement_II {
    public static void main(String[] args) {
        int[] nums = {11, 33, 33, 11, 33, 11};
        bruteForceApproach(nums).stream().forEach(System.out::println);
    }

    public static List<Integer> bruteForceApproach(int[] nums){
        List<Integer> resultList = new ArrayList<>();
        int limit = nums.length / 3;
        for (int i =0; i<nums.length;i++){
            if(resultList.size() == 0 || resultList.get(0) != nums[0]){
                int count = 0;
                for (int j = 0; j < nums.length; j++) {
                    if(nums[i] == nums[j]) count++;
                }

                if(count > limit) resultList.add(nums[i]);

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
}

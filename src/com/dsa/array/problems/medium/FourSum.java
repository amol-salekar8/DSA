package com.dsa.array.problems.medium;

import java.text.CollationElementIterator;
import java.util.*;

public class FourSum {
    public static void main(String[] args) {
        int [] nums = {1, -2, 3, 5, 7, 9};
        int target = 7;
        optimalApproach(nums,target).stream().forEach(System.out::println);
    }
    /** 4 Loops */
    public static List<List<Integer>> bruteForceapproach(int [] nums, int target){
        Set<List<Integer>> resultSet = new HashSet<>();

        for (int i = 0; i < nums.length-3; i++) {
            for (int j = i+1; j < nums.length-2; j++) {
                for (int k = j+1; k < nums.length-1; k++) {
                    for (int l = k+1; l < nums.length; l++) {
                        int sum = nums[i] + nums[j] +nums[k] + nums[l];
                        if(sum == target){
                            List<Integer> targetList = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                            Collections.sort(targetList);
                            resultSet.add(targetList);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(resultSet);
    }
    /** 3 Loops + Hashing concept for getting fourth value*/
    public static List<List<Integer>> betterApproach(int [] nums, int target) {
        Set<List<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                Set<Integer> hashed = new HashSet<>();
                for (int k = j + 1; k < nums.length; k++) {
                    int fourth = target - ( nums[i] + nums[j] +nums[k] );
                    if(hashed.contains(fourth)){
                        List<Integer> targetList = Arrays.asList(nums[i], nums[j], nums[k], fourth);
                        Collections.sort(targetList);
                        resultSet.add(targetList);
                    }
                    hashed.add(nums[k]);
                }
            }
        }

        return  new ArrayList<>(resultSet);
    }

    /** 2 Loops + Two pointer approach */
    public static List<List<Integer>> optimalApproach(int [] nums, int target) {
        int length = nums.length;
        List<List<Integer>> resultList = new ArrayList<>();
        /* For Sorting */
        Arrays.sort(nums);
        for (int i = 0; i < length; i++) {
            /* For duplicates */
            if( i > 0 && nums[i] == nums[i-1]) continue;
            for (int j = i + 1; j < length; j++) {
                /* For duplicates */
                if( j > i+1 && nums[j] == nums[j-1]) continue;
                /* Two pointer Start*/
                int k = j+1;
                int l = length -1;
                while(k<l){
                    int sum = nums[i]+nums[j]+nums[k]+nums[l];
                    if(sum == target){
                        List<Integer> targetList = Arrays.asList(nums[i], nums[j], nums[k], nums[l]);
                        resultList.add(targetList);
                        k++;
                        l--;
                    }else if(sum > target) l--;
                    else  k++;
                }

            }
        }
        return resultList;
    }
}

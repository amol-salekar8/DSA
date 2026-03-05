package com.dsa.array.problems.medium;

import java.util.*;

public class ThreeSum {
    public static void main(String[] args) {
        int[] nums = {2, -2, 0, 3, -3, 5};
        optimalApproach(nums).stream().forEach(System.out::println);

    }

    /*** nested 3 For loops **/
    public static List<List<Integer>> bruteForce (int [] nums){
        Set<List<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < nums.length-2; i++) {
            for (int j = i+1; j < nums.length-1; j++) {
                for (int k = j+1; k < nums.length; k++) {
                    if((nums[i] + nums [j] + nums[k]) == 0){
                        List<Integer> result = Arrays.asList(nums[i], nums[j], nums[k]);
                        Collections.sort(result);
                        resultSet.add(result);
                    }
                }
            }
        }
        List<List<Integer>> resultList = new ArrayList<>(resultSet);
        return resultList;
    }

    /** 2 nested loops + hashing */
    public static List<List<Integer>>  betterApproach(int[] nums){
        Set<List<Integer>> resultSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            /** Hashing to store 3 element */
            Set<Integer> hashed = new HashSet<>();
            for (int j = i+1; j < nums.length; j++) {
                /** Calculate the third number
                 * a + b + c = 0
                 * a + b = - c
                 * c = - ( a + b)
                 */
                int thirdElement = - ( nums[i] + nums[j]);
                /** If third element present in hashed then value equal to zero*/
                if(hashed.contains(thirdElement)){
                    List<Integer> result = Arrays.asList(nums[i],nums[j],thirdElement);
                    Collections.sort(result);
                    resultSet.add(result);
                }
                /** store iterate value to hashed */
                hashed.add(nums[j]);
            }
        }
        List<List<Integer>> resultList = new ArrayList<>(resultSet);
        return resultList;
    }

    /** Sorting + Two pointer + without hashed */
    public static List<List<Integer>> optimalApproach(int [] nums){
        List<List<Integer>> resultList = new ArrayList<>();
        /** Sorting  */
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int j = i+1;
            int k = nums.length -1;
            /** Two Pointer  */
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    /** add data to list */
                    resultList.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                    /** --- Skip duplicates --- */
                    while(j<k && nums[j -1 ] == nums[j]) j++;
                    while(j<k && nums[k] == nums[k+1]) k--;
                }
                else if(sum > 0) k--;
                else j++;
            }
        }
        return resultList;
    }
}

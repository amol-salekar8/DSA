package com.dsa.arr.medium;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class LeadersInArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 5, 3, 1, 2};
        int [] leaderArr = optimalApproach(nums);
        for (int num : leaderArr){
            System.out.println(num);
        }
    }

    /**
     * Time Complexity O(n^2)
     * We loop array 2 times
     * */
    public static int[] bruteForceApproach(int[] nums){
        List<Integer> list = new ArrayList<>();
        for (int i=0;i< nums.length;i++){
            boolean leader = true;
            for (int j = i+1; j < nums.length; j++) {
                if(nums[j] >= nums[i]){
                    leader = false;
                    break;
                }
            }
            if(leader) list.add(nums[i]);
        }
        int leaderArr[] = new int[list.size()];
        int index =0;
        for(int num : list) {
            leaderArr[index++] = num;
        }
        return leaderArr;
    }

    /**
     * Time Complexity O(N)
     * 1) We are traversing a list in reverse direction
     * 2) Last element of array is always greater than next because after that there is element present
     * 3) Check If previous element is greater than last one if yes add them to list
     *
     */
    public static int[] optimalApproach(int[] nums){
        List<Integer> list = new ArrayList<>();
        int max = nums[nums.length-1];
        list.add(max);
        for(int i= nums.length-2; i >= 0; i--){
            if(nums[i] > max){
                list.add(nums[i]);
                max = nums[i];
            }
        }
        Collections.reverse(list);
        int leaderArr[] = new int[list.size()];
        int index =0;
        for(int num : list) {
            leaderArr[index++] = num;
        }
        return leaderArr;
    }
}

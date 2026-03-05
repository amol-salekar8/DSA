package com.dsa.array.problems.logicBuilding;

import java.util.Arrays;

/***
 * Q. Given an integer array nums sorted in non-decreasing order, remove all duplicates in-place so that each unique element appears only once.
 *
 *
 */
public class RemoveDuplicatesFromSortedArray {
    public static void main(String[] args) {
        int[] nums = {1, 1, 2, 2, 2, 3, 3};
        int count = removeDuplicatesWithWhile(nums);
        Arrays.stream(nums).boxed().forEach(System.out::println);

    }

    public static int removeDuplicatesWithFor(int[] nums) {
        int i=0;
        for(int j=1;j<nums.length;j++){
            if(nums[i] != nums[j]){
                nums[++i] = nums[j];
            }
        }
        return i+1;
    }

    public static int removeDuplicatesWithWhile(int[] nums) {
        int i = 0;
        int j = 1;
        while(j < nums.length){
            if(nums[i] == nums[j]){
                j++;
                continue;
            }
            if( i != j && nums[i] != nums[j]){
                nums[++i] = nums[j++];
            }
        }
        return i+1;
    }
}

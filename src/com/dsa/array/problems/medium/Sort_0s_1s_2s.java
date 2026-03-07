package com.dsa.array.problems.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Q. Given an array nums consisting of only 0, 1, or 2. Sort the array in non-decreasing order.
 *
 * Hint
 * 1) Sort the array
 * 2) Separate the 0's , 1's and 2's then merge
 * 3) Dutch national flag
 */
public class Sort_0s_1s_2s {
    public static void main(String[] args) {
        int [] nums = {1, 0, 2, 1, 0};
        dutchNationalFlag(nums);
        Arrays.stream(nums).forEach(System.out::println);
    }

    public static void sortTheArray(int [] nums){
        /** Selection Sort **/
        for(int i=0;i< nums.length;i++){
            int index = i;
            for(int j = i +1; j< nums.length; j++){
                if(nums[index] > nums[j])
                    index = j;
            }
            if(index != i){
                int temp = nums[i];
                nums[i] = nums[index];
                nums[index] = temp;
            }
        }
    }

    public static void separateOutThenMerge(int [] nums){
        List<Integer> zerosList = new ArrayList<>();
        List<Integer> onesList = new ArrayList<>();
        List<Integer> twosList = new ArrayList<>();

        for(int i=0;i< nums.length;i++){
            if(nums[i] == 0)
                zerosList.add(nums[i]);
            else if(nums[i] == 1)
                onesList.add(nums[i]);
            else
                twosList.add(nums[i]);
        }
        int index = 0;
        for (Integer num : zerosList)
            nums[index++] =  num;
        for (Integer num : onesList)
            nums[index++] =  num;
        for (Integer num : twosList)
            nums[index++] =  num;
    }

    public static void dutchNationalFlag(int[] nums){
        int left =0;
        int mid = 0;
        int high = nums.length-1;

        for(int i =0; i< nums.length;i++){
            if(nums[mid] == 0){
                int temp = nums[left];
                nums[left++] = nums[mid];
                nums[mid++] = temp;
            }else if (nums[mid] == 1)
                mid++;
            else {
                int temp = nums[high];
                nums[high--] = nums[mid];
                nums[mid] = temp;
            }
        }
    }

}

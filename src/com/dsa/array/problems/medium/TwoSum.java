package com.dsa.array.problems.medium;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {2, 6, 5, 8, 11};
        int target = 14;
        Arrays.stream(optimalApproach(nums,target)).boxed().forEach(System.out::println);
    }
    /** -- HashMAP
     * TC O(n^2)
     * --  */
    public static int[] bruteForceApproach(int[] nums, int target){
        int[] result = {-1 , -1};
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }
        return result;
    }

    /** -- HashMAP
     * TC O(n)
     * SC O(n)
     * --  */
    public static int[] betterApproach(int[] nums, int target){
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] indexArr = {-1, -1};
        for (int i = 0; i < nums.length; i++) {
            int result = target - nums[i];
            if(map.containsKey(result)){
                indexArr[0] = map.get(result);
                indexArr[1] = i;
                return indexArr;
            }else{
                map.put(nums[i], i);
            }
        }
        return indexArr;
    }

    /** -- 2D Array
     * TC O(n) + O (n log n)
     * SC O(n)
     * --  */
    public static int[] optimalApproach(int[] nums, int target){
        int[][] matrix = new int[nums.length][2];
        int[] resultArr = {-1, -1};
        /** Creating 2D matrix with [element, index] **/
        for (int i = 0; i < nums.length; i++) {
            matrix[i][0] = nums[i];
            matrix[i][1] = i;
        }

        /** -- Sorting  -- */
        Arrays.sort(matrix, new Comparator<int[]>(){
            public int compare(int[] a, int [] b){
                return  Integer.compare(a[0], b[0]);
            }
        });

        /** Two Pointer Approach */
        int left = 0, right = nums.length-1;
        while(left < right){
            int sum = matrix[left][0] + matrix[right][0];
            if(sum == target){
                resultArr[0] = left;
                resultArr[1] = right;
                return resultArr;
            }else if(sum > target) right --;
            else left ++;
        }
        return  resultArr;
    }

}

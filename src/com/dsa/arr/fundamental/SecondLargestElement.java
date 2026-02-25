package com.dsa.arr.fundamental;

/***
 *  Q. Given an array of integers nums, return the second-largest element in the array. If the second-largest element does not exist, return -1.
 *
 * Example 1
 * Input: nums = [8, 8, 7, 6, 5]
 * Output: 7
 * Explanation:
 * The largest value in nums is 8, the second largest is 7
 *
 * Example 2
 * Input: nums = [10, 10, 10, 10, 10]
 * Output: -1
 * Explanation:
 * The only value in nums is 10, so there is no second largest value, thus -1 is returned
 */
public class SecondLargestElement {
    public static void main(String[] args) {
        int [] nums = {8, 8, 7, 6, 5};
        System.out.println(secondLargestElement(nums));
    }

    public static int secondLargestElement(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for(int i=0;i<nums.length;i++){
            if(nums[i] > largest){
                secondLargest = largest;
                largest = nums[i];
            }
            if(nums[i] > secondLargest && largest > nums[i]){
                secondLargest = nums[i];
            }
        }
        return secondLargest == Integer.MIN_VALUE ? -1 : secondLargest;
    }

}

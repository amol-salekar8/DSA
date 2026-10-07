package com.dsa.array.problems.mergeSortProblem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/***
 * Example 1:
 * Input: nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * Output: [1,2,2,3,5,6]
 * Explanation: The arrays we are merging are [1,2,3] and [2,5,6].
 * The result of the merge is [1,2,2,3,5,6] with the underlined elements coming from nums1.
 *
 * Example 2:
 * Input: nums1 = [1], m = 1, nums2 = [], n = 0
 * Output: [1]
 * Explanation: The arrays we are merging are [1] and [].
 * The result of the merge is [1].
 *
 * Example 3:
 * Input: nums1 = [0], m = 0, nums2 = [1], n = 1
 * Output: [1]
 * Explanation: The arrays we are merging are [] and [1].
 * The result of the merge is [1].
 * Note that because m = 0, there are no elements in nums1. The 0 is only there to ensure the merge result can fit in nums1.
 */
public class MergeTwoSortedArray {
    public static void main(String[] args) {
        int nums1[] = {1,2,3,0,0,0};
        int nums2[] = {2,5,6};
        int m = 3;
        int n = 3;
        mergeWithoutExtraSpace(nums1,m,nums2,n);
        Arrays.stream(nums1).forEach(System.out::println);
    }

    /** Using Array list **/
    public static void mergeSortWithExtraSpace(int[] nums1, int m, int nums2[], int n){
        List<Integer> list = new ArrayList<>();
        int i=0,j=0;
        while(i<m && j<n){
            if(nums1[i]<nums2[j]) list.add(nums1[i++]);
            else list.add(nums2[j++]);
        }
        while(i<m) list.add(nums1[i++]);
        while(j<n) list.add(nums2[j++]);
        i=0;
        for(int ele:list) nums1[i++]=ele;
    }

    /** Optimal Approach **/
    public static void mergeWithoutExtraSpace(int[] nums1, int m, int nums2[], int n){
        int i = m-1;
        int j = n-1;
        int k = m+n-1;

        while(j>=0){
            if(i>=0 && nums1[i] > nums2[j]){
                nums1[k]= nums1[i];
                i--;
            }else{
                nums1[k]=nums2[j];
                j--;
            }
            k--;
        }
    }
}

package com.dsa.arr.logicBuilding;

import java.util.*;

/***
 * Q .Given two sorted arrays nums1 and nums2, return an array that contains the union of these two arrays.
   The elements in the union must be in ascending order.
 *
 *Example 1:
 * Input: nums1 = [1, 2, 3, 4, 5], nums2 = [1, 2, 7]
 * Output: [1, 2, 3, 4, 5, 7]
 * Explanation:
 * The elements 1, 2 are common to both, 3, 4, 5 are from nums1 and 7 is from nums2
 *
 * Example 2
 * Input: nums1 = [3, 4, 6, 7, 9, 9], nums2 = [1, 5, 7, 8, 8]
 * Output: [1, 3, 4, 5, 6, 7, 8, 9]
 * Explanation:
 * The element 7 is common to both, 3, 4, 6, 9 are from nums1 and 1, 5, 8 is from nums2
 *
 */

public class UnionOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] nums2 = {2, 3, 4, 4, 5, 11, 12};

        int [] unionSortedArray = unionByArrayList(nums1,nums2);
        Arrays.stream(unionSortedArray).boxed().forEach(System.out::println);

    }

    /**
     * Time Complexity
     * to insert and element into array list is O(n) and along with we are traversing two array b O(n + m)
     * so total time complexity is O( (n + m)^2 )
     *
     * Space Complexity
     * O(n) for storing an element
     */
    public static int[] unionByArrayList(int[] nums1, int[] nums2){
        List<Integer> unionList = new ArrayList<>();
        int indexNum1 = 0;
        int indexNum2 = 0;
        int lengthNum1 = nums1.length;
        int lengthNum2 = nums2.length;
        // Goes until one of the array become empty
        while(indexNum1 < lengthNum1 && indexNum2 < lengthNum2){
            if(nums1[indexNum1] <= nums2[indexNum2]){
                // To avoid duplicate element
                if(!unionList.contains(nums1[indexNum1])) unionList.add(nums1[indexNum1]);
                indexNum1++;
            }
            else if(nums1[indexNum1] > nums2[indexNum2]){
                // To avoid duplicate element
                if(!unionList.contains(nums2[indexNum2])) unionList.add(nums2[indexNum2]);
                indexNum2++;
            }
        }
        // Remaining element from nums1
        while( indexNum1 < lengthNum1){
            if(!unionList.contains(nums1[indexNum1])) unionList.add(nums1[indexNum1]);
            indexNum1++;
        }
        // Remaining element from nums2
        while( indexNum2 < lengthNum2){
            if(!unionList.contains(nums2[indexNum2])) unionList.add(nums2[indexNum2]);
            indexNum2++;
        }

        // Define an array
        int [] unionArray = new int[unionList.size()];
        int i = 0;

        // Add into array
        for(Integer value : unionList){
            unionArray[i++] = value;
        }
        return unionArray;

    }

    /**
     * Time Complexity : to insert and element into tree set is O( log n) and along with we are traversing into two array  O(n + m)
     * so total time complexity is O( (n + m) * (log (n + m) ) )
     *
     */
    public static int[] unionByTreeSet(int[] nums1, int[] nums2){
        Set<Integer> unionSet = new TreeSet<>();
        for(int nums : nums1){
            unionSet.add(nums);
        }

        for(int nums : nums2){
            unionSet.add(nums);
        }

        int [] unionArray = new int[unionSet.size()];
        int i = 0;
        for(Integer value : unionSet){
            unionArray[i++] = value;
        }
        return unionArray;
    }

    /**
     *  Time Complexity :  O(n + m) because we didn't use comparison just use array list and merge sort concept
     *  space complexity : O(n)
     *
     */
    public static int[] unionByMergeSortMerge(int[] nums1, int[] nums2){
        List<Integer> unionList = new ArrayList<>();
        int indexNum1 = 0;
        int indexNum2 = 0;
        int lengthNum1 = nums1.length;
        int lengthNum2 = nums2.length;

        while(indexNum1 < lengthNum1 && indexNum2 < lengthNum2){

            // Skip the element who's are duplicate from num1
            if(indexNum1 > 0 && nums1[indexNum1-1] == nums1[indexNum1]){
                indexNum1++;
                continue;
            }

            // Skip the element who's are duplicate from num2
            if(indexNum2 > 0 && nums2[indexNum2-1] == nums2[indexNum2]){
                indexNum2++;
                continue;
            }

            if(nums1[indexNum1] < nums2[indexNum2]){
                unionList.add(nums1[indexNum1++]);
            }else if(nums1[indexNum1] > nums2[indexNum2]) {
                unionList.add(nums2[indexNum2++]);
            } else {
                unionList.add(nums1[indexNum1++]);
                indexNum2++;
            }
        }

        // Remaining element from nums1
        while( indexNum1 < lengthNum1){
            // Skip the element who's are duplicate from num1
            if(indexNum1 > 0 && nums1[indexNum1-1] == nums1[indexNum1]){
                indexNum1++;
                continue;
            }
            unionList.add(nums1[indexNum1]);
            indexNum1++;
        }
        // Remaining element from nums2
        while( indexNum2 < lengthNum2){
            // Skip the element who's are duplicate from num2
            if(indexNum2 > 0 && nums2[indexNum2-1] == nums2[indexNum2]){
                indexNum2++;
                continue;
            }
            unionList.add(nums2[indexNum2]);
            indexNum2++;
        }

        // Define an array
        int [] unionArray = new int[unionList.size()];
        int i = 0;

        // Add into array
        for(Integer value : unionList){
            unionArray[i++] = value;
        }
        return unionArray;
    }
}

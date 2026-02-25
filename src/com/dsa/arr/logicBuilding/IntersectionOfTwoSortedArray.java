package com.dsa.arr.logicBuilding;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 *
 * The intersection of two arrays is an array where all values are present in both arrays.
 * Example 1
 * Input: nums1 = [1, 2, 2, 3, 5], nums2 = [1, 2, 7]
 * Output: [1, 2]
 * Explanation:
 * The elements 1, 2 are the only elements present in both nums1 and nums2
 *
 * Example 2
 * Input: nums1 = [1, 2, 2, 3, 3, 3], nums2 = [2, 3, 3, 4, 5, 7]
 * Output: [2, 3, 3]
 * Explanation:
 * The element 2 appears in both arrays only one time.
 * The element 3 appears in both arrays two times so we add element 3 equal to its number of occurrences.
 *
 */
public class IntersectionOfTwoSortedArray {
    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] nums2 = {2, 3, 4, 4, 5, 11, 12};
        int[] intersectionArray = intersectionUsingSet(nums1,nums2);
        Arrays.stream(intersectionArray).boxed().forEach(System.out::println);


    }

    /** -- We use Stream API for this */
    public static void intersectionUsingStream(int[] nums1, int[] nums2 ){
        Stream.concat(Arrays.stream(nums1).boxed(), Arrays.stream(nums2).boxed())
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet().stream().filter(entry -> entry.getValue() > 1)
                .forEach(System.out::println);
    }


    /***
     *
     *
     */
    public static int[] intersectionUsingSet(int[] nums1, int[] nums2){
        Set<Integer> intersectionSet = new TreeSet<>();
        int indexNum1 = 0;
        int indexNum2 = 0;
        int lengthNum1 = nums1.length;
        int lengthNum2 = nums2.length;

        while(indexNum1 < lengthNum1 && indexNum2 < lengthNum2){
            if(nums1[indexNum1] < nums2[indexNum2]) indexNum1++;
            else if(nums1[indexNum1] > nums2[indexNum2]) indexNum2++;
            else{
                intersectionSet.add(nums1[indexNum1]);
                indexNum2++;
                indexNum1++;
            }
        }

        // Define an array
        int [] unionArray = new int[intersectionSet.size()];
        int i = 0;
        // Add into array
        for(Integer value : intersectionSet){
            unionArray[i++] = value;
        }
        return unionArray;
    }





}

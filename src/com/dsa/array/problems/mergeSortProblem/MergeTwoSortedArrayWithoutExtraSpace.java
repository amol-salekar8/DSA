package com.dsa.array.problems.mergeSortProblem;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 *
 */

public class MergeTwoSortedArrayWithoutExtraSpace {
    public static void main(String[] args) {
        int arr1[] = {2, 4, 7, 10};
        int arr2[] = {2, 3};
        merge(arr1, arr2);
        Stream.concat(Arrays.stream(arr1).boxed(), Arrays.stream(arr2).boxed()).forEach(System.out::println);
    }

    public static void merge(int[] arr1, int[] arr2){
        int left = arr1.length-1;
        int right = arr2.length-1;
        while(left>= 0 && right >=0 ){
            if(arr1[left] > arr2[right]){
                int temp = arr2[right];
                arr2[right] = arr1[left];
                arr1[left]=temp;
                left--;
                right--;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
    }

}

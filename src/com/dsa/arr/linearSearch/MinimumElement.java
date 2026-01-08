package com.dsa.arr.linearSearch;

import java.util.Arrays;

public class MinimumElement {
	
	public static void main(String[] args) {
		int [] arr = {1,4,-7,18,0,5};
		System.out.print(findMinimum1 ( arr));
		
	}
	
	public static int findMinimum(int [] arr) {
		int min = Integer.MAX_VALUE;
		if(arr.length == 0)
			return -1;
		
		for(int value : arr) {
			min = Math.min(value, min);
		}
		
		
		return min;
	}

	public static int findMinimum1(int [] arr) {
		int min = Integer.MAX_VALUE;
		int secondMin = Integer.MAX_VALUE;
		if(arr.length == 0)
			return -1;
		
		for(int value : arr) {
			if(min > value) {
				secondMin = min;
				min  = value;
			}
			if (value < secondMin && value > min){
				secondMin = value;
			}
		}
		return secondMin;
	}
}

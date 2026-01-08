package com.dsa.arr.binarySearch;

/**
 * https://leetcode.com/problems/find-smallest-letter-greater-than-target/
 * 
 */

public class SmallestLetterGreaterThanTarget {
	public static void main(String[] args) {
		char [] charArr =  {'a','b','f','g','j','l'};
		char target = 'z';
		System.out.println(binarySearchArr(charArr, target));
	}
	
	static char linearSearchArr(char [] charArr, char target) {
		for(char charac : charArr) {
			if(charac == target) 
				return charac;
			if( (charac - target) > 0)
				return charac;
		}
		
		return 'a';
	}

	static char binarySearchArr(char [] charArr, char target) {
		
		int left = 0;
		int right = charArr.length -1;
		
		while(left <= right) {
			int mid = left + (right-left)/2;
			
			if(charArr[mid] > target)
				right = mid-1;
			else 
				left = mid +1;
		}
		if(charArr.length == left )
			return charArr[0];
		
		return charArr[left];
	}
}

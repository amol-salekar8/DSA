package com.dsa.string.Problem;

/**
 * Example 1:
 * Input: haystack = "sadbutsad", needle = "sad"
 * Output: 0
 * Explanation: "sad" occurs at index 0 and 6.
 * The first occurrence is at index 0, so we return 0.
 */
public class FindIndexFirstOccurrenceString {
    public static void main(String[] args) {
        String haystack = "sadbutsad"; String needle = "sad";
        System.out.println(twoPointerApproach(haystack,needle));
    }

    public static int twoPointerApproach(String haystack, String needle) {
        int i = 0, j = 0;
        int n = haystack.length();
        int nLength = needle.length();
        while (i < n) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            } else {
                i = i - j;
                j = 0;
            }
            if (nLength == j) return i - nLength + 1;
            i++;
        }
        return -1;
    }

    public  static int optimalApproach(String haystack, String needle) {
        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}

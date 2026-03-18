# Hard Problems


### Majority Elements ||



### Finding Repeating and Missing Number
- Q.Given an integer array nums of size n containing values from [1, n] and each value appears exactly once in the array, except for A, which appears twice and B which is missing.
- Return the values A and B, as an array of size 2, where A appears in the 0-th index and B in the 1st index.

```
Example 1
Input: nums = [3, 5, 4, 1, 1]
Output: [1, 2]
Explanation:
1 appears two times in the array and 2 is missing from nums

Example 2
Input: nums = [1, 2, 3, 6, 7, 5, 7]
Output: [7, 4]
Explanation:
7 appears two times in the array and 4 is missing from nums.

Example 3
Input: nums = [6, 5, 7, 1, 8, 6, 4, 3, 2]
Output: [6, 9]
```

- [**Problem :** Find the repeating and missing number](https://takeuforward.org/plus/dsa/problems/find-the-repeating-and-missing-number?subject=dsa&tab=description&approach=better)
- [**Solutions** : FindRepeatingAndMissingNumber.java](../problems/hard/FindRepeatingAndMissingNumber.java)
- **Explanation**
  - **Brute Force Approach (Two Loops)**
    - 1st loop to select the element
    - [ **INSIDE 1st** ]2nd loop to find selected 1st element  in the remaining array.
  - **Better Approach (HashMap Data structure) (Counting elements)**
    - 1st loop stored element as key and repeating count as value.
  - **Optimal Approach I (Mathematical Equations)**
    ![Find_Repeating_Missing_Number_Optiomal_I](image/Find_Repeating_Missing_Number_Optiomal_I.svg)
  - **Optimal Approach II (XOR)**

## Count Inversion

![CountInversion.svg](image/CountInversion.svg)

- [**Question** : Count Inversion](https://takeuforward.org/plus/dsa/problems/count-inversions?subject=dsa&tab=description&approach=optimal)
- [**Solution** : Count Inversion](../problems/hard/CountingInversion.java)
# Solutions

### LeaderInArray
![LeaderInArray](./image/LeaderInArray.svg)

### Re-Arrange Array Element by sign

![RearrangeArrayElementsBySign](./image/RearrangeArrayElementsBySign.svg)

### PrintTheMatrixInSpiralManner
![PrintTheMatrixInSpiralManner](./image/PrintTheMatrixInSpiralManner.svg)


#### Pascal Traingle

![](./image/PascalTriangle.svg)
![](./image/NumberOfCombinationFormula.svg)
#### I Q. Given two integers r and c, return the value at the rth row and cth column (1-indexed) in a Pascal's Triangle.
1) **Approach 1 :** A brute force way to solve this will be to generate the entire Pascal's Triangle up to the given row number and then return the element at the given position.
2) **Approach 2 :** nCr (number of combinations)
![](./image/PascalTriangle_I.svg)

#### II Q. Given an integer r, return all the values in the rth row (1-indexed) in Pascal's Triangle in correct order.
![](./image/PascalTriangle_II.svg)

#### III Q. Given an integer n, return the first n (1-Indexed) rows of Pascal's triangle.


#### 90 Degree Rotation Matrix
![](./image/90DegreeRotationMatrix.svg)

#### Two Sum 
**Q. Given an array of integers nums and an integer target. Return the indices(0 - indexed) of two elements in nums such that they add up to target.**
```java
int[] nums = {2, 6, 5, 8, 11};
int target = 14;
// Result : [1, 3];
```
1) **Approach 1:** Brute Force with two for loops
   - 1st loop for select an element
   - 2nd loop to iterate over remaining part of array
   - sum of 1st loop element and 2nd loop element is equal to target then return index of both
2) **Approach 2:** Using HashMap 
   - to reduce search space we use HashMap
   - Loop is for selecting an element
   - after selecting an element reduce that value from target
   - after reducing the value from taget check that value as key of hashmap present or not
   - if yes print the array with (hashMap_value, currentIndex)
   - if not put that in map as (elementAsKey, indexAsValue)
3) **Approach 3:** Using 2D array
    - Without hashmap.
    - we use 2D array to store element with their index value.
    - Sort 2D array based on index
    - using two pointer (left and right pointer) we iterate over the array to find the sum
    - if sum > target reduce right--
    - if sum < target increase left ++

#### 3 Sum
Q. Given an integer array nums. Return all triplets such that:
```
   i != j, i != k, and j != k
   nums[i] + nums[j] + nums[k] == 0.
   
   Example 1
   Input: nums = [2, -2, 0, 3, -3, 5]
   Output: [[-2, 0, 2], [-3, -2, 5], [-3, 0, 3]]
   Explanation:
   nums[1] + nums[2] + nums[0] = 0
   nums[4] + nums[1] + nums[5] = 0
   nums[4] + nums[2] + nums[3] = 0
```
**Approach 1 :** Brute force (With the help of 3 nested loops)

**Approach 2 :** Better (With the help of 2 nested loops + Hashing)
1) 1st loop to select an element **a** and 2nd loop **b** to iterate over the remaining element of the array 
2) Calculate the third number **c** logic 
  ``` 
a + b + c = 0
 a + b = - c
 c = - ( a + b)
```
3) After calculating the third number check that element present in hash or not
4) If yes then sum == 0 and add that 3 value after sorting to result list.
5) if not then store **b** element  to hash for further process.

**Approach 3 :** Optimal (Sorting + Outer loop + Two Pointer )
1) First Sort the array
2) First loop to select start element i.e. first pointer **i**
3) We use two pointer for middle **j** and last **k**  
4) if sum > 0 then last pointer **k** should reduce
5) if sum < 0 then middle pointer **j** should increase
6) if sum == 0 then it's a Three Sum
   - then increase middle pointer **j++**
   - and reduce decrease last pointer **k--**
   - if there is duplicate value middle pointer then **j++** 
   - if there is duplicate value last pointer then **k--** 




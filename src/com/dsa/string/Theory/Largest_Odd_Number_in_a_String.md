### Largest Odd Number in a String
#### Question
- Given a string s, representing a large integer, the task is to return the largest-valued odd integer (as a string) that is a substring of the given string s. 
- The number returned should not have leading zero's. But the given input string may have leading zero. (If no odd number is found, then return empty string.)
- **Example 1:**
  - Input : s = "5347"
  - Output : "5347"
  - Explanation :
    - The odd numbers formed by given strings are --> 5, 3, 53, 347, 5347. 
    - So the largest among all the possible odd numbers for given string is 5347.

- **Example 2:**
  - Input : s = "0214638"
  - Output : "21463"
  - Explanation :
    - The different odd numbers that can be formed by the given string are --> 1, 3, 21, 63, 463, 1463, 21463. 
    - We cannot include 021463 as the number contains leading zero. 
    - So largest odd number in given string is 21463.

#### Solution
- **Brute Force Approach**
  - I have used `StringBuffer` to append the string after removal of part
  - 1) I have removed the last even number from the string and add that into stringBuffer
  - 2) then I have `reverse()` string with the help of StringBuffer class method
  - 3) Then try to remove first zeros from the StringBuffer with the help of `deleteCharAt()`
- **Optimal Approach**
  - Using a **pointer** we can resolve this issue.
  - We need to iterate over the string from the last position to check where we can find out odd number and store that index in some field.
  - if that field doesn't change mean we have all even number
  - after that we need to start from 0th position to check is there any leading zero are available 
  - if yes then we need to substring that string from non-leading 0th position to last odd index position.  
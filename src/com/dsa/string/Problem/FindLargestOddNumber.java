package com.dsa.string.Problem;

/***
 * Example 1:
 * Input : s = "5347"
 * Output : "5347"
 *
 * Explanation :
 * The odd numbers formed by given strings are --> 5, 3, 53, 347, 5347.
 * So the largest among all the possible odd numbers for given string is 5347.
 *
 * Example 2:
 * Input : s = "0214638"
 * Output : "21463"
 *
 * Explanation :
 * The different odd numbers that can be formed by the given string are --> 1, 3, 21, 63, 463, 1463, 21463.
 * We cannot include 021463 as the number contains leading zero.
 * So largest odd number in given string is 21463.
 */
public class FindLargestOddNumber {
    public static void main(String[] args) {
        String num ="0214638";
        System.out.println(optimalApproach(num));
    }

    public static String bruteForceApproach(String num){
        //your code goes here
        StringBuffer buff = new StringBuffer();
        boolean findOdd = false;
        // To find the odd number at last then stop the loop
        for(int i=num.length()-1;i>=0;i--){
            if((num.charAt(i) -'0')%2 == 0 && !findOdd)
                continue;
            else{
                findOdd = true;
                buff.append(num.charAt(i));
            }
        }
        // reverse the stroed string
        buff.reverse();
        // removing leading zero
        for(int i=0;i<buff.length();i++){
            if((num.charAt(i) -'0')==0){
                buff.deleteCharAt(i);
            }else
                break;
        }

        return buff.toString();
    }

    public static String optimalApproach(String num){
        int index =-1;
        // finding the last Odd number
        for(int i=num.length()-1;i>= 0;i--){
            if((num.charAt(i)-'0') % 2 == 1){
                index = i;
                break;
            }
        }
        if(index == -1) return "";

        int i = 0;
        //for removing front zeros
         while(i <= index && num.charAt(i) == '0')i++;


        return num.substring(i,index+1);
    }

}

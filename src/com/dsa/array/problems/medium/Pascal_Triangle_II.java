package com.dsa.array.problems.medium;

import java.util.Arrays;

/***
 * Given an integer r, return all the values in the rth row (1-indexed) in Pascal's Triangle in correct order.
 *
 */
public class Pascal_Triangle_II {
    public static void main(String[] args) {
        int row = 6;
        Arrays.stream(pascalTriangle_II(row)).boxed().forEach(System.out::print);
    }

    public static int[] pascalTriangle_II(int row) {
        int [] pascalArr = new int[row];
        pascalArr[0] = 1;
        // Formula to generate column index value
        for(int col=1; col < row;col++){
            pascalArr[col] = (pascalArr[col-1]*(row-col)) / col;
        }
        return pascalArr;
    }
}

package com.dsa.array.problems.medium;

import java.util.ArrayList;
import java.util.List;

/***
 * Given an integer n, return the first n (1-Indexed) rows of Pascal's triangle.
 */
public class Pascal_Triangle_III {
    public static void main(String[] args) {
        int number = 6;
        List<List<Integer>> resultList = generateValueForRow(number);
        resultList.stream().forEach(list -> System.out.println(list.toString()));

    }

    public static List<List<Integer>> generateValueForRow(int number){
        List<List<Integer>> rowValue = new ArrayList<>();
        for(int row = 1; row <= number; row++){
            rowValue.add(generateValueForColumn(row));
        }
        return rowValue;
    }

    public static List<Integer> generateValueForColumn(int row){
        List<Integer> colValue = new ArrayList<>();
        colValue.add(1);
        // Previous value
        long result = 1;
        for(int col = 1; col < row; col++){
            result = result * (row - col);
            result = result / col;
            colValue.add((int)result);
        }
        return colValue;
    }

}

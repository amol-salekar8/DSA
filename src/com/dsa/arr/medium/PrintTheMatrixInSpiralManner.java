package com.dsa.arr.medium;

import java.util.ArrayList;
import java.util.List;

/***
 *
 *
 */
public class PrintTheMatrixInSpiralManner {
    public static void main(String[] args) {
        int[][] mattrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };
        List<Integer> spiralTraversalList = spiralTraversal(mattrix);
        spiralTraversalList.stream().forEach(System.out::print);
    }

    public static List<Integer> spiralTraversal(int[][] mattrix){
            List<Integer> spiralTraversalList = new ArrayList<>();
            int row = mattrix.length;
            int column = mattrix[0].length;
            int top = 0;
            int left = 0;
            int right = column-1;
            int bottom = row-1;

            while(top <= bottom && left <= right){
                /** Left -> Right where row(top) is fixed */
                for(int i=left; i<= right; i++ )
                    spiralTraversalList.add(mattrix[top][i]);
                top ++;

                /** Top -> bottom  where column(right) is fixed */
                for(int i=top; i<= bottom; i++)
                    spiralTraversalList.add(mattrix[i][right]);
                right--;

                /** Right -> Left  where row(bottom) is fixed */
                /***
                 * Input : [[1],[2],[4],[3],[5]]
                 * Output
                 * Without if condition Output
                 * 1 2 4 3 5 3 4 2
                 * With if condition
                 * 1 2 4 3 5
                 */
                if(top <= bottom) {
                    for (int i = right; i >= left; i--)
                        spiralTraversalList.add(mattrix[bottom][i]);
                    bottom--;
                }

                /** Bottom -> Top  where column(left) is fixed */
                if(left <= right) {
                    for (int i = bottom; i >= top; i--)
                        spiralTraversalList.add(mattrix[i][left]);
                    left++;
                }
            }
            return spiralTraversalList;
    }
}

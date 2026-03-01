package com.dsa.arr.medium;

public class NintyDegreeRotationMatrix {
    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

    }

    public static void reverseApproach(int[][] matrix){
        int number = matrix.length;
        int [][] rotate = new int[number][number];
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number; j++) {
                rotate[j][number-i-1] = matrix[i][j];
            }
        }

        for (int i = 0; i < number; i++) {
            System.arraycopy(rotate[i],0,matrix[i],0,number);
        }
    }

    public static void traverseApproach(int[][] matrix){
        int n = matrix.length;

        // Transpose the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {

                // Swap elements across the diagonal
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;

            }
        }

        // Reverse each row of the matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n / 2; j++) {

                // Swap elements symmetrically
                int temp = matrix[i][j];
                matrix[i][j] = matrix[i][n - 1 - j];
                matrix[i][n - 1 - j] = temp;

            }
        }
    }


}

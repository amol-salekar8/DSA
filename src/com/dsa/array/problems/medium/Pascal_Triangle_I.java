package com.dsa.array.problems.medium;

public class Pascal_Triangle_I {
    public static void main(String[] args) {
        int row = 10;
        int column = 3;
        System.out.println(pascalTriangle_I(row,column));
    }

    public static int pascalTriangle_I(int row,int column){
        return  formula_nCr(row-1,column-1);
    }

    /** Number of combination formula */
    public static int formula_nCr(int n, int r){
        // Choose the smaller value for iteration
        if(r > n-r) r = n-r;
        if(r==1) return n;
        int result = 1;
        // Formula to generate that number
        for(int i=0; i<r; i++){
            result = result * (n-i);
            result = result / (i+1);
        }
        return result;
    }
}

package com.dsa.arr;

import java.util.Arrays;
import java.util.Scanner;

public class TwoDArray {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Enter the row size : ");
		int length = scan.nextInt();
		
		int [][] arr = new int[length][];
		for(int i=0;i<length;i++) {
			
			System.out.println("Enter the column size : "); 
			int column = scan.nextInt();
			
			int [] columnArr = new int[column];
			 
			for(int j=0; j<column; j++) {
				System.out.println("Enter the column value : "); 
				int columnvalue = scan.nextInt();
				columnArr[j]= columnvalue;
			}
			arr[i]= columnArr;
		}
		
		for(int [] column : arr) {
			System.out.println(Arrays.toString(column));
		}
	}

}

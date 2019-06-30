package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class Day11 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int arr[][] = new int[6][6];
        for(int i=0; i < 6; i++){
            for(int j=0; j < 6; j++){
                arr[i][j] = in.nextInt();
            }
        }
        in.close();
        
        // 6-1 is last element, but we need to go till 3 (from zero). 
        // 4th element cannot create hour-glass
        int imax = (6-1)-2; 
        int jmax = (6-1)-2;
        
        int maxSum = 0, tempSum = 0;
        
        for (int i = 0; i <= imax; i++) {
        	for (int j = 0; j <= jmax; j++) {
        		tempSum = hourGlassSum(arr, i, j);
        		if (i == 0 && j == 0) 
        			maxSum = tempSum;
        		else 
        			maxSum = Math.max(maxSum, tempSum);
        	}
        }
        
        System.out.println(maxSum);
    }
    
    static int hourGlassSum(int[][] arr, int iStart, int jStart) {
    	int sum = 0;
    	
    	for (int j = jStart; j < jStart + 3; j++) {
    		sum = sum + arr[iStart][j] + arr[iStart+2][j];
    	}
    	
    	sum += arr[iStart+1][jStart+1];
    	
    	return sum;
    }
}

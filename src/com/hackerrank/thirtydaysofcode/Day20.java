package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class Day20 {
	public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] a = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        in.close();
        
        int numSwap = 0;
        int tmp = 0;
        
        for (int i = 0; i < n; i++) {
            
            for (int j = 0; j < n-1; j++) {
                if (a[j] > a[j+1]) {
                    tmp = a[j+1];
                    a[j+1] = a[j];
                    a[j] = tmp;
                    numSwap++;
                }
            }
            
            if (numSwap == 0) {
                break; // already sorted array
            }
        }
        
        System.out.println("Array is sorted in " + numSwap + " swaps.");
        System.out.println("First Element: " + a[0]);
        System.out.println("Last Element: " + a[n-1]);
    }
}

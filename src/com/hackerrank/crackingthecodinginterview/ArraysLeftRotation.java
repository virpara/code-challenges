package com.hackerrank.crackingthecodinginterview;

import java.util.Scanner;

public class ArraysLeftRotation {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
    	int[] temp = new int[k];
    	
    	for (int i = 0; i < k; i++) {
    		temp[i] = a[i];
    	}
    	
    	int j = 0;
    	for (int i = k; i < n; i++, j++) {
    		a[j] = a[i];
    	}
    	
    	for (int i = 0; j < n; j++, i++) {
    		a[j] = temp[i];
    	}
    	
    	return a;
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        in.close();
        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");
      
        System.out.println();
      
    }
}

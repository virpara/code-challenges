package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class Day25 {
	
	public static void isPrime(int x) {
        if (x == 1 || x == 0) {
            System.out.println("Not prime");
            return;
        }
        
//        ---------------------------
//        for (int i = 2; i < (x/2) + 1; i++) { // O(n/2)
//            if (x % i == 0) {
//                System.out.println("Not prime");
//                return;
//            }
//        }
//        ---------------------------
        
//        -----------------------------
//        int sq = (int) Math.sqrt(x);
//        
//        if (x == 2) {
//        	System.out.println("Prime");
//        	return;
//        } else if (x % 2 == 0) { // O(1) for even numbers
//        	System.out.println("Not prime");
//        	return;
//        }
//        
//        for (int i = 3; i <= sq; i += 2 ) { // eliminate even numbers
//        	if (x % i == 0) {
//        		System.out.println("Not prime");
//        		return;
//        	}
//        }
//        --------------------------------
        
//        // ----- O(sqrt(n)) -------
        for (int i = 2; i * i <= x; i++) {  
        	if (x % i == 0) {
        		System.out.println("Not prime");
        		return;
        	}
        }
//        ---------------------------
        System.out.println("Prime");
        
        /* doesn't work
        int i = 2;
        int j = 2;
        for (;;) {
            int p = i*j;
            if (p == x) {
                System.out.println("Not prime" + x);
                break;
            } else if (p < x) {
                j++;
            } else if (p > x) {
                if (j == 2) {
                    System.out.println("Prime");
                    break;
                }
                
                i++;
                j = 2;
            }
        }*/
    }
    
    public static void main(String[] args) {
    	
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        
        int[] num = new int[n];
        for (int i = 0; i < n; i++) {
            num[i] = sc.nextInt();
        }
        sc.close();
        
        for (int i = 0; i < n; i++) {
            isPrime(num[i]);
        }
        
    }
}

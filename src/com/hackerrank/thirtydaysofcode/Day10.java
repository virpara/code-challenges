package com.hackerrank.thirtydaysofcode;

import java.util.Scanner;

public class Day10 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.close();
        
        String bin = binary(n);
        
        int max1 = 0, temp1 = 0;
        
        char[] ch = bin.toCharArray();
        
//        for (int i = 0; i < ch.length; ) {
//        	char c = ch[i];
//        	
//        	if (c == '1') {
//        		int max = 1;
//        		
//        		i++;
//        		while (i < ch.length && ch[i] == '1') {
//        			max++;
//        			i++;
//        		}
//        		
//        		if (max > max1)
//        			max1 = max;
//        		
//        	} else {
//        		i++;
//        	}
//        }
        for (int i = 0; i < ch.length; i++) {
        	char c = ch[i];
        	
        	if (c == '1') {
        		temp1++;
        		if (temp1 > max1)
        			max1 = temp1;

        	} else {
        		temp1 = 0;
        	}
        }
        
        System.out.println(max1);
        
    }
    
    static String binary(int n) {
    	
    	if (n <= 0) {
    		return "";
    	} else {
    		
    		int mod = n % 2;
    		int nextn = n / 2;
    		
    		return binary(nextn) + mod;
    	}
    }
}
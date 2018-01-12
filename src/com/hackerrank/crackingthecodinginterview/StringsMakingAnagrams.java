package com.hackerrank.crackingthecodinginterview;

import java.util.Arrays;
import java.util.Scanner;

public class StringsMakingAnagrams {
    public static int numberNeeded(String first, String second) {
    	char[] f = first.toCharArray();
    	char[] s = second.toCharArray();
    	
    	Arrays.sort(f);
    	Arrays.sort(s);
    	
    	int numDel = 0;
    	int fLen = f.length;
    	int sLen = s.length;
    	
    	int i = 0, j = 0;
    	
    	while ( i < fLen && j < sLen) {
    		if (f[i] != s[j]) {
    			numDel++;
    			
    			if (f[i] > s[j]) {
    				j++;
    			} else {
    				i++;
    			}
    		} else {
    			i++;
    			j++;
    		}
    	}
    	
    	if (i < fLen) numDel += (fLen - i);
    	if (j < sLen) numDel += (sLen - j);
    	
    	return numDel;
    }
  
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        in.close();
        System.out.println(numberNeeded(a, b));
    }
}

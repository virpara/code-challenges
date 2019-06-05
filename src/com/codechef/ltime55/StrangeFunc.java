package com.codechef.ltime55;

import java.util.Scanner;

public class StrangeFunc {

	// TODO: gained 10 points. optimize the approach
	public static void main(String[] args) throws java.lang.Exception {
		
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int a = s.nextInt();
			int n = s.nextInt();
			
			long ans = f((long) Math.pow(a, n));
			
			System.out.println(ans);
		}
		s.close();
	}
	
	static long f(long a) {
		long s = sum(a); 
	    if (s < 10) return s;
	    else {
	    	return f(s);
	    }
	}

	static long sum(long a) {
	    long sum = 0l;
	    
	    while (a > 0) {
	    	//System.out.println(a%10);
	        sum += a%10;
	        a = a / 10;
	    }
	    
	    return sum;
	}
}

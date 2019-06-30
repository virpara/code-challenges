package com.misc;

public class EuclidGcd {

	public static void main(String[] args) {
		System.out.println(gcd(9900, 9));

	}
	
	public static int gcd(int p, int q) {
		if (q == 0) return p;
		
		int r = p % q;
		return gcd(q, r);
	}
}

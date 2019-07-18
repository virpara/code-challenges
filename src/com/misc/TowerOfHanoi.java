package com.misc;


public class TowerOfHanoi {
	
	public static void main(String[] args) {
		int n = 10;
		char a = 'A', b = 'B', c = 'C';
		
		solve(n, a, b, c);
		
	}
	
	private static void solve(int n, char a, char b, char c) {
		if (n == 1) {
			printStep(n, a, c);
		} else {
			solve(n-1, a, c, b);
			printStep(n, a, c);
			solve(n-1, b, a, c);
		}
		
	}

	public static void printStep(int n, char x, char y) {
		System.out.println("move " + n + " from " + x + " to " + y);
	}
	
}
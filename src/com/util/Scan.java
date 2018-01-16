package com.util;

import java.util.Scanner;

public class Scan {
	private static final Scanner s = new Scanner(System.in);
	
	public static void close() {
		s.close();
	}
	
	
	public static int[] nia(int n) {
		int[] a = new int[n];
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		
		return a;
	}
	
	public static int ni() {
		return s.nextInt();
	}
}

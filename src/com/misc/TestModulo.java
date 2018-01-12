package com.misc;

public class TestModulo {
	
	public static void main(String[] args) {
		int i = 1 << 30;
		long s = 0l;
		long e = 0l;
		
		int x = 20;
		while(x-- >= 0) {
			s = System.currentTimeMillis();
			myModulo(i);
			e = System.currentTimeMillis();
			System.out.println("myModulo: " + (e - s) + " ms");
			
			s = System.currentTimeMillis();
			simpleModulo(i);
			e = System.currentTimeMillis();
			System.out.println("simpleModulo: " + (e - s) + " ms");
		}
		
	}

	private static void myModulo(int n) {
		for (int i = 0; i < n; i++) {
			if (n % 2 == 0){
				
			}
		}
	}

	private static void simpleModulo(int n) {
		for (int i = 0; i < n; i++) {
			if ((n & 1) == 0) {
				
			}
		}
	}
	
	
}

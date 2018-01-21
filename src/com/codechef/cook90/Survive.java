package com.codechef.cook90;

import java.util.Scanner;

public class Survive {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int s = sc.nextInt();
			
			survive(n, k, s);
			
		}
		sc.close();
	}
	
	static void survive(int n, int k, int s) {
		int notBuyDay = s / 7;
		int buyDay = s - notBuyDay;
		
		int canBuy = buyDay * n;
		int needSurvive = s * k;
		
		if (canBuy >= needSurvive) {
			int minDays = (int) Math.ceil(((double) needSurvive)/n);
			System.out.println(minDays);
		} else {
			System.out.println("-1");
		}
	}

}

package com.codechef.challenge;

import java.util.Scanner;

public class FootballMatch {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		try {
		for (int i = 0; i < t; i++) {
			int n = sc.nextInt();
			sc.nextLine();
			String m1 = "";
			String m2 = "";
			
			int c1 = 0, c2 = 0;
			for (int j = 0; j < n; j++) {
				String s = sc.nextLine();
				if (j == 0) {
					m1 = s;
					c1++;
				} else {
					if (!m1.equals(s)) {
						m2 = s;
						c2++;
					} else {
						c1++;
					}
				}
			}
			
			if (c1 == c2) {
				System.out.println("Draw");
			} else if (c1 > c2) {
				System.out.println(m1);
			} else {
				System.out.println(m2);
			}
		}
		
		sc.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}

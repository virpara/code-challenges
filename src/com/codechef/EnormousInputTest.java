package com.codechef;

import java.util.Scanner;

public class EnormousInputTest {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		try {

			int n = sc.nextInt();
			int k = sc.nextInt();
			
			int ti = 0;
			int numOfDivisible = 0;
			for (int i = 0; i < n; i++) {
				ti = sc.nextInt();

				if (ti % k == 0)
					numOfDivisible++;
			}

			System.out.println(numOfDivisible);
			
		} finally {
			sc.close();
		}
	}

}

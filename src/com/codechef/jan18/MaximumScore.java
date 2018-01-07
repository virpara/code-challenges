package com.codechef.jan18;

import java.util.Arrays;
import java.util.Scanner;

public class MaximumScore {
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			long[][] rec = new long[n][n];
			for (int j = 0; j < n; j++) {
				for (int k = 0; k < n; k++) {
					rec[j][k] = s.nextLong();
				}
				Arrays.sort(rec[j]);
			}

			long sum = 0l;
			long prev = rec[0][0];

//			if (sum != -1) {
				for (int j = n - 1; j >= 0; j--) {
					if (j == n - 1) {
						sum = rec[j][n - 1];
						prev = rec[j][n - 1];
					} else {
						int x = n - 1;
						while (x >= 0 && rec[j][x] >= prev) {
							x--;
						}

						if (x == -1) {
							sum = -1l;
							break;
						}

						sum += rec[j][x];
						prev = rec[j][x];

					}

				}
//			}

			System.out.println(sum);

		}
	}
}

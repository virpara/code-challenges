package com.codechef.jan18;

import java.util.Scanner;

public class PartitionNumbers {

	// TODO: 1 TLE, 4 WA
	public static void main(String[] args) throws java.lang.Exception {
		Scanner s = new Scanner(System.in);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int x = s.nextInt();
			int n = s.nextInt();

			long sum = ((n * (n + 1)) / 2) - x;
			if (sum % 2 != 0 || n <= 2) {
				System.out.println("impossible");
				continue;
			}

			long setsize = sum / 2;
			long biggest = n;
			if (x == n) {
				biggest = n - 1;
			}

			long tempsum = 0l;
			long tmp = biggest;

			while (tempsum < setsize) {
				if (tmp == x)
					continue;

				tempsum += tmp;
				tmp--;

			}

			if (tempsum > setsize) {
				tmp++;
				tempsum -= tmp++;

				int missingElem = (int) (setsize - tempsum);
				// 1..missingElem-1..missingElem+1..tmp-1 -> 0
				// missingElem, tmp..n -> 1
				for (int k = 1; k <= n; k++) {
					if (k == x)
						System.out.print("2");
					else if (k == missingElem || k >= tmp)
						System.out.print("1");
					else
						System.out.print("0");
				}

			} else {
				tmp++;
				// equal
				// 1..tmp-1 -> 0
				// tmp..n -> 1
				for (int k = 1; k <= n; k++) {
					if (k == x)
						System.out.print("2");
					else if (k < tmp)
						System.out.print("0");
					else
						System.out.print("1");
				}
			}

			System.out.println();
		}
	}

}

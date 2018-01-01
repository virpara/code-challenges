package com.codechef.challenge;

import java.util.Scanner;

public class MinimumSubarray {
	static int[] map; 
	
	// TODO optimize with segment tree
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		try {
			int t = sc.nextInt();
//			long start = System.currentTimeMillis();
			
			for (int i = 0; i < t; i++) {
				int n = sc.nextInt();
				int d = sc.nextInt();
				
				int[] ints = new int[n];
				
				// if d is in the array
				boolean isFound = false;
				for (int j = 0; j < n; j++) {
					ints[j] = sc.nextInt();
					if (ints[j] == d) {
						isFound = true;
					}
				}
				
				if (isFound) {
					System.out.println(1);
					continue;
				} else {
					map = new int[n];
					summer: for (int p = 2; p <= n; p++) {
						for (int q = 0; q <= n-p; q++) {
							int sum = sumNextn(ints, p, q);
//							System.out.println("q=" + q + "p=" + p + "sum=" + sum);
							if (sum >= d) {
								System.out.println(p);
								isFound = true;
								break summer;
							}
						}
					}
				}
				
				if (!isFound) System.out.println(-1);
			}
			
//			long end = System.currentTimeMillis();
//			System.out.println("time taken: " + (end-start));
		} catch (Exception e) {
			e.printStackTrace();
		}
		sc.close();
		
		
	}
	
	static int sumNextn(int[] arr, int n, int pos) {
		int sum = 0;
		if (n == 2) {			
			for (int i = pos; i < pos + n; i++) {
				if (i == pos)
					sum = arr[i];
				else
					sum += arr[i];
			}
			map[pos] = sum;
		} else {
			map[pos] = map[pos] + arr[pos + n-1];
		}
		
		return map[pos];
	}
}

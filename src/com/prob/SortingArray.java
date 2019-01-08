package com.prob;

import java.util.*;

public class SortingArray {
	public static void main(String[] args) {
		// input 0,1,1,1,0,0,1,0
		// O(n) time sorting for user input containing only zero and one
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();

		Integer[] vals = new Integer[n];
		for (int i = 0; i < n; i++) {
			vals[i] = s.nextInt();
		}

		s.close();

		Integer[] zero = new Integer[n];
		Integer[] one = new Integer[n];
		int j = 0, k = 0;
		for (int i = 0; i < n; i++) {
			if (vals[i] == 0) {
				zero[j++] = vals[i];
			} else if (vals[i] == 1) {
				one[k++] = vals[i];
			}
		}

		for (int i = 0; i < k; i++) {
			zero[j++] = one[i];
		}

		System.out.println("sorted: " + Arrays.asList(zero));
	}
}
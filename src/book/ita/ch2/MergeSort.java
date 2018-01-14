package book.ita.ch2;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Integer[] a = new Integer[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		s.close();
		
		int p = 0, r = n - 1;
		
		merge(a, p, r);
		
		System.out.println(Arrays.asList(a));
	}

	private static void merge(Integer[] a, int p, int r) {
		System.out.println("merge: p=" + p + " r=" + r);
		
		if (p < r) {
			int q = (p + r) / 2;
			merge(a, p, q);
			merge(a, q + 1, r);
			mergeSort(a, p, q, r);
			
		}
		
	}

	private static void mergeSort(Integer[] a, int p, int q, int r) {
		System.out.println("mergeSort: p=" + p + " q=" + q +" r=" + r);
		
		// Can we do it without making left and right copies
		int[] left = new int[q-p+1]; // p to q elements inclusive
		int[] right = new int[r-q]; // q+1 to r elements inclusive
		
		
		for (int i = 0; i < (q-p + 1); i++) {
			left[i] = a[p+i];
		}
		
		for (int i = 0; i < r-q; i++) {
			right[i] = a[q + 1 + i];
		}
		
		int i = 0, j = 0;
		
		while (i < left.length && j < right.length) {
			if (left[i] < right[j]) {
				a[p] = left[i];
				p++;
				i++;
			} else {
				a[p] = right[j];
				p++;
				j++;
			}
			
			System.out.println("while: p=" + p + " i=" + i + " j=" + j);
		}
		
		// only one loop from the below two runs, because either i == left.length or j == right.length
		// if there is still elements in left, but none in right, copy all of them to a
		while (i < left.length) {
			a[p++] = left[i++];
		}
		
		// or if there are elements in right, but none in left, copy all of them to a  
		while (j < right.length) {
			a[p++] = right[j++];
		}
	}

}

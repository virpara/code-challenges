package book.ita.ch2;

import java.util.Scanner;

/**
 * Exercise 2.3-5: LinearSearch can be improved using Binary Search
 * if the array elements are sorted.
 * @author Rahul
 *
 */
public class BinarySearch {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int v = s.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = s.nextInt();
		s.close();
		
		int idx = binarySearch(a, v, 0, a.length-1);
		System.out.println(idx);
	}

	private static int binarySearch(int[] a, int v, int beg, int end) {
		if (beg == end && a[beg] != v) return -1;
		if (beg == end && a[beg] == v) return beg;
		
		int mid = (beg + end) / 2;
		if (a[mid] == v) return mid;
		else {
			if (a[mid] < v) return binarySearch(a, v, mid+1, end);
			else return binarySearch(a, v, beg, mid-1);
		}
		
	}

}

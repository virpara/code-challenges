package book.ita.ch2;

import java.util.Scanner;

/**
 * Exercise 2.1-3: return array index of value v using linear search
 * @author Rahul
 *
 */
public class LinearSearch {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		int v = s.nextInt();
		
		int[] a = new int[n];
		for (int i = 0; i < n; i++) a[i] = s.nextInt();
		s.close();
		
		int idx = search(a, v, 0);
		System.out.println(idx);
		
	}

	private static int search(int[] a, int v, int i) {
		if (i == a.length) {
			return -1;
		} else if (a[i] == v) {
			return i;
		} else {
			return search(a, v, ++i);
		}
	}

}

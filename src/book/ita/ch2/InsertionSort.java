package book.ita.ch2;

import java.util.Arrays;
import java.util.Scanner;

public class InsertionSort {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Integer[] a = new Integer[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		s.close();
		
		insertionSort(a);
		System.out.println("asc: " + Arrays.asList(a));
		
		insertionSortDescending(a);
		System.out.println("desc: " + Arrays.asList(a));
		
		insertionSortRecur(a);
		System.out.println("recursive asc: " + Arrays.asList(a));
	}
	
	
	// Exercise 2.1-2: based on nondecreasing order procedure
	static void insertionSortDescending(Integer[] a) {
		for (int i = 1; i < a.length; i++) {
			int x = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] < x) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = x;
		}
	}
	
	static void insertionSort(Integer[] a) {
		for (int i = 1; i < a.length; i++) {
			int x = a[i];
			int j = i - 1;
			while (j >= 0 && a[j] > x) {
				a[j+1] = a[j];
				
				j--;
			}
			
			a[j+1] = x;
		}
		
	}

	// Exercise 2.3-4: Recursive insertion sort
	static void insertionSortRecur(Integer[] a) {
		sort(a, a.length-1);
	}
	
	static void sort(Integer[] a, int j) {
		if (j > 0) {
			sort(a, j-1);

			int x = a[j];
			insert(a, j-1, x);
		} 
	}
	
	static void insert(Integer[] a, int i, int x) {
		if (i == 0) {
			a[i+1] = a[i];
			a[i] = x;
		} else {
			if (a[i] > x) {
				a[i+1] = a[i];
				insert(a, i-1, x);
			}
			
		}
	}
	
	
}

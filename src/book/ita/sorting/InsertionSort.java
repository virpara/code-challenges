package book.ita.sorting;

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
		
		insertionSort(a);

		System.out.println(Arrays.asList(a));
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

}

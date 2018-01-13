package book.ita.ch2;

import java.util.Arrays;
import java.util.Scanner;


/**
 * Exercises 2.2-2
 * @author Rahul
 *
 */
public class SelectionSort {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		int n = s.nextInt();
		Integer[] a = new Integer[n];
		
		for (int i = 0; i < n; i++) {
			a[i] = s.nextInt();
		}
		s.close();
		
		selectionSort(a);

		System.out.println(Arrays.asList(a));
	}

	private static void selectionSort(Integer[] a) {
		for (int i = 0; i < a.length-1; i++) {
			int tmp = a[i];
//			int smallest = tmp;
			int smallestIdx = i; 

			// find the smallest element from the remaining(i+1..n) elements
			for (int j = i+1; j < a.length; j++) {
				if (a[j] < tmp) {
//					smallest = a[j];
					smallestIdx = j;
				}
			}
			
			//swap if smallest is in the remaining elements
			if (smallestIdx != i) {
				a[i] = a[smallestIdx];
				a[smallestIdx] = tmp;
			}
		}
	}

}

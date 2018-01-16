package book.ita.ch2;

import com.util.Scan;

/**
 * 2-4 Inversions
 * c. Using similar to insertion sort
 * TODO: d. In O (n log n) time using merge sort 
 * @author Rahul
 *
 */
public class Inversions {

	public static void main(String[] args) {
		int n = Scan.ni();
		int[] a = Scan.nia(n);
		Scan.close();
		
		System.out.println("simple inversion");
		simpleInversion(a);
		
		System.out.println("recursive inversion");
		divideConquer(a, 1);
		
	}

	/**
	 * 
	 * @param a
	 * @param i compare i th element
	 */
	private static void divideConquer(int[] a, int i) {
		// compare with all the elements less than i
		if (i < a.length) {
			checkPrintPair(a, i, i-1);
			
			divideConquer(a, i+1);
		}
		
	}
	
	/**
	 * Checks i th element with the elements from j to 0
	 * it acts similar to the inner for loop in the simpleInversion
	 * 
	 * @param a
	 * @param i checks i th element
	 * @param j checks with elements j to 0
	 */
	private static void checkPrintPair(int[] a, int i, int j) {
		if (a[j] > a[i]) {
			System.out.println(a[j] + ", " + a[i]);
		}
		
		if (j == 0) {
			return;
		} else {
			checkPrintPair(a, i, j - 1);
		}
	}

	private static void simpleInversion(int[] a) {
		
		for (int i = a.length-1; i > 0; i--) {
			for (int j = i-1; j >= 0; j--) {
				if (a[j] > a[i]) {					
					System.out.println(a[j] + ", " + a[i]);
				}
			}
		}
	}

}

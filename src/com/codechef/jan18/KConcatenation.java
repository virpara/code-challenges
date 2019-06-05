package com.codechef.jan18;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class KConcatenation {
	private static File f = new File("input.txt");

	public static void main(String[] args) throws FileNotFoundException {
//		generateTests();

		Scanner s = new Scanner(System.in);
//		Scanner s = new Scanner(f);
		int t = s.nextInt();
		for (int i = 0; i < t; i++) {
			int n = s.nextInt();
			int k = s.nextInt();

			int[] num = new int[n];
			for (int j = 0; j < n; j++) {
				num[j] = s.nextInt();
			}

			long sum = 0;
			long maxSum = 0;
			boolean isNeg = false;

			long sumStart = 0;
			int lastNegIdx = 0;

			for (int j = 0; j < n; j++) {
				if (num[j] > 0) {
					sum += num[j];
				} else if (num[j] < 0) {
					maxSum = sum > maxSum ? sum : maxSum;

					// store sum before first negative num
					if (!isNeg) {
						sumStart = sum;
						lastNegIdx = j;
					}

					sum = 0;
					isNeg = true;
				}
			}

			// if last digit is positive
			maxSum = sum > maxSum ? sum : maxSum;

			if (lastNegIdx > 0) {
				for (int j = lastNegIdx + 1; j < n; j++) {
					sumStart += num[j];
				}

				maxSum = sumStart > maxSum ? sumStart : maxSum;
			}

			if (!isNeg) {
				maxSum = maxSum > 0 ? maxSum * k : sum * k;
			} else {
				maxSum = maxSum > 0 ? maxSum : sum;
			}

			System.out.println(maxSum);

		}
		s.close();

	}

	private static void generateTests() {
		// InputStream is = System.in;
		Random rn = new Random();
		
		BufferedWriter br = null;
		try {
			br = new BufferedWriter(new FileWriter(f));
			
			int t = rn.nextInt(9) + 1 ;
			br.write(t + "\n");
			for (int j = 0; j < t; j++) {
				int k = rn.nextInt(1000000);
				int n = rn.nextInt(1000000);
				br.write(n + " " + k + "\n");
//				System.out.println(n + " " + k);

				int a;
				for (int i = 0; i < n; i++) {
					a = rn.nextInt(10000000) * (Math.random() > 0.5 ? 1 : 1);
//					System.out.print(a + " ");
					br.write(a + " ");
				}
				br.write("\n");
//				System.out.println();
			}
			
			br.flush();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (br != null) {
				try {
					br.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}

	}

}

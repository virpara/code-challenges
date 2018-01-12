package com.hackerrank.challenges;

import java.util.Arrays;
import java.util.Scanner;

public class BirthdayCakeCandles {

  static int birthdayCakeCandles(int n, int[] ar) {
    if (n == 0)
      return 0;

    if (n == 1)
      return 1;

    Arrays.sort(ar);
    int tallest = 1;
    int last = ar[n - 1];

    for (int i = n - 2; i >= 0; i--) {
      if (last == ar[i])
        tallest++;
      else
        break;

    }

    return tallest;
  }

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int[] ar = new int[n];
    for (int ar_i = 0; ar_i < n; ar_i++) {
      ar[ar_i] = in.nextInt();
    }
    in.close();
    int result = birthdayCakeCandles(n, ar);
    System.out.println(result);
  }
}

package com.hackerrank.datastructure;

import java.util.Scanner;

public class TwoDArrayDS {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int arr[][] = new int[6][6];
    for (int arr_i = 0; arr_i < 6; arr_i++) {
      for (int arr_j = 0; arr_j < 6; arr_j++) {
        arr[arr_i][arr_j] = in.nextInt();
      }
    }
    in.close();

    int maxSum = 0;

    for (int i = 0; i < 6 - 2; i++) {
      for (int j = 0; j < 6 - 2; j++) {
        int sum = arr[i][j] + arr[i][j + 1] + arr[i][j + 2] + arr[i + 1][j + 1] + arr[i + 2][j]
            + arr[i + 2][j + 1] + arr[i + 2][j + 2];
        if (i == 0 && j == 0)
          maxSum = sum;
        else
          maxSum = Math.max(maxSum, sum);
      }
    }

    System.out.println(maxSum);
  }

}

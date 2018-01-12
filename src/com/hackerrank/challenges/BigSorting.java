package com.hackerrank.challenges;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class BigSorting {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    String[] unsorted = new String[n];
    for (int unsorted_i = 0; unsorted_i < n; unsorted_i++) {
      unsorted[unsorted_i] = in.next();
    }
    in.close();

    Arrays.sort(unsorted);
    Arrays.sort(unsorted, new LengthComparator());

    for (int i = 0; i < unsorted.length; i++) {
      System.out.println(unsorted[i]);
    }
  }

  static class LengthComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
      int l1 = o1.length();
      int l2 = o2.length();

      if (l1 == l2)
        return 0;
      else if (l1 < l2)
        return -1;
      else
        return 1;

    }
  }
}

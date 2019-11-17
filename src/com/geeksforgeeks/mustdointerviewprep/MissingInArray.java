package com.geeksforgeeks.mustdointerviewprep;

import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/missing-number-in-array/0/?track=md-arrays&batchId=144
public class MissingInArray {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);

        // Using Scanner.nextInt was causing timeout. It took more than 2.9 seconds
        int t = Integer.parseInt(s.nextLine());

        for (int x = 0; x < t; x++) {
            int n = Integer.parseInt(s.nextLine());
            int[] a = new int[n];

            int missing = 0;
            int sum = 0;
            int expected = n * (n + 1) / 2;

            String[] nums = s.nextLine().split(" ");

            for (int i = 0; i < n-1; i++) {
                a[i] = Integer.parseInt(nums[i]);

//                if (a[i] != i + 1) missing = i + 1; // works if array is sorted
                 sum += a[i];
            }

//            System.out.println(missing);
             System.out.println(expected - sum);
        }
    }
}

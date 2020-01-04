package com.geeksforgeeks.mustdointerviewprep;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

// https://practice.geeksforgeeks.org/problems/majority-element/0/?track=md-arrays&batchId=144
public class MajorityElement {

    public static void main (String[] args) throws Exception {
        // reached time limit using scanner 1.45 secs
        // executed in 0.56 secs
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());

        for (int x = 0; x < t; x++) {
            int n = Integer.parseInt(br.readLine());
            int[] a = new int[n];
            String[] nums = br.readLine().split(" ");

            int[] elemCount = new int[1000000];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(nums[i]);
                elemCount[a[i]]++;
            }

            int max = -1;
            int thresold = n / 2;
            for (int i = 1; i < n; i++) {
                if (elemCount[a[i-1]] > elemCount[a[i]] && elemCount[a[i-1]] > thresold) max = a[i-1];
                if (elemCount[a[i]] > elemCount[a[i-1]] && elemCount[a[i]] > thresold) max = a[i];
            }

            System.out.println(max);
        }
    }
}

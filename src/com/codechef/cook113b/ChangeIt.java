package com.codechef.cook113b;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// https://www.codechef.com/COOK113B/problems/CHNGIT
// Solved!
public class ChangeIt {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int n = sc.nextInt();
            int[] a = new int[n];

            for (int j = 0; j < n; j++) {
                a[j] = sc.nextInt();
            }

            System.out.println(countChange(a));

        }
        sc.close();
    }

    private static int countChange(int[] a) {
        int count = 0;

        Map<Integer, Integer> numCount = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            numCount.put(a[i], numCount.getOrDefault(a[i], 0) + 1);
        }

        int max = 0;
        if (numCount.size() != 1) {
            for (Integer i : numCount.values()) {
                if (i > max) {
                    count += max;
                    max = i;
                } else {
                    count += i;
                }
            }
        }

        return count;
    }
}

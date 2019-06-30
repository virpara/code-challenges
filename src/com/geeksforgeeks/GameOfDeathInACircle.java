/*package whatever //do not write package name here */
package com.geeksforgeeks;

import java.util.*;

// https://practice.geeksforgeeks.org/problems/game-of-death-in-a-circle/0

class GFG {
    public static void main (String[] args) {
        Scanner s = new Scanner(System.in);

        int t = s.nextInt();

        for (int i = 0; i < t; i++) {
            int n = s.nextInt();
            int k = s.nextInt();

            System.out.println(solve(n, k));
        }

        s.close();
    }

    public static int solve(int n, int k) {
        if (n == 1) return 1;

        return (solve(n - 1, k) + k - 1) % n + 1;
    }
}

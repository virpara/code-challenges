package com.misc;

import java.util.Arrays;

// 8 queen problem

public class Backtracking {

    private static Integer[] row = new Integer[8];
    private static Boolean[] used = new Boolean[8];
    private static int count_arrangements = 0;

    // simple backtracking.
    // checks 8! arrangements. total operations are 8! * 8 * 36
    static int queens(int i) {
        if (i == 8) {
//            System.out.println(Arrays.asList(row));
            count_arrangements++;  // number of arrangements checked

//              0   1   2   3   4   5   6   7
//          0   x
//          1       x
//          2
//          3
//          4
//          5
//          6
//          7

            // placed 8 queens. check diagonals and verify queens don't attach each other in this arrangement
            for (int j = 0; j < 8; j++) {
                for (int k = j + 1; k < 8; k++) {
                    if (row[j] + j == row[k] + k) return 0;
                    if (row[j] - j == row[k] - k) return 0;
                }
            }
            return 1;
        }

        int total = 0;
        for (row[i] = 0; row[i] < 8; row[i]++) {
            // ensure we are not sharing row
            if (used[row[i]]) continue;

            //place the queen and recurse on the rest
            used[row[i]] = true;
            total += queens(i + 1);

            // mark row as unused again
            used[row[i]] = false;
        }
        return total;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 8; i++)
            used[i] = false;

        // start placing the queens from first row
        System.out.println("Answer: " + queens(0));

        System.out.println("Number of Arrangements Checked: " + count_arrangements);
    }
}

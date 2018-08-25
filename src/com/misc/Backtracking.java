package com.misc;

// 8 queen problem

import java.util.Arrays;

public class Backtracking {
    private static int board_size = 8;

    private static Integer[] row = new Integer[board_size];
    private static Boolean[] row_used = new Boolean[board_size];
    private static int arrangements = 0;
    private static int numCalls = 0;
    private static int bb_arrangements = 0;

    public static void main(String[] args) {
        for (int i = 0; i < board_size; i++)
            row_used[i] = false;

        // start placing the queens from first row
        long start = System.currentTimeMillis();
        System.out.println("answer: " + queens(0));
        long end = System.currentTimeMillis();

        System.out.println("arrangements checked: " + arrangements);
        System.out.println("number of times queens called: " + numCalls);
        System.out.println("time taken: " + (end - start));

        // branch and bound solution. init as false
        for (int i = 0; i < board_size; i++) row_used[i] = false;
        for (int i = 0; i < board_size*2 - 1; i++) {
            slashcode[i] = false;
            backslashcode[i] = false;
        }

        start = System.currentTimeMillis();
        System.out.println("branch and bound: " + branchBoundSolution(0));
        end = System.currentTimeMillis();
        System.out.println("branch & bound arrangements checked: " + bb_arrangements);
        System.out.println("time taken: " + (end - start));
    }

    // simple backtracking.
    // checks 8! arrangements. total operations are 8! * 8 * 36
    static int queens(int i) {
        if (i == board_size) {
//            System.out.println(Arrays.asList(row));
            arrangements++;  // number of arrangements checked

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
            for (int j = 0; j < board_size; j++) {
                for (int k = j + 1; k < board_size; k++) {
                    if (row[j] + j == row[k] + k) return 0;
                    if (row[j] - j == row[k] - k) return 0;
                }
            }
            return 1;
        }

        int total = 0;
        for (row[i] = 0; row[i] < board_size; row[i]++) {
            // ensure we are not sharing row
            if (row_used[row[i]]) continue;

            //place the queen and recurse on the rest
            row_used[row[i]] = true;
            numCalls++;
            total += queens(i + 1);

            // mark row as unused again
            row_used[row[i]] = false;
        }
        return total;
    }

    // slash code (r+c) for / diagonal attack check
    private static Boolean[] slashcode = new Boolean[board_size*2 - 1];

    // back slash code (r-c+7) for \ diagonal attack check
    private static Boolean[] backslashcode = new Boolean[board_size*2 - 1];

    private static int branchBoundSolution(int queen) {
        // we decide row of queen using row[queen] and column is same as queen.

        // we have placed 8 queens. it means they are not attacking each
        // other since the slashcode and backslashcode check make sure about it, so it is a valid arrangement
        if (queen == board_size) {
            return 1;
        }

        int total = 0;
        for (row[queen] = 0; row[queen] < board_size; row[queen]++) {
            // ensure we are not sharing row
            if (row_used[row[queen]]) continue;

            // stop building the arrangement, if currently placed queens are
            // already attacking each other.
            if (slashcode[row[queen] + queen] || backslashcode[row[queen] - queen + (board_size-1)])
                //return 0;
                continue;

            row_used[row[queen]] = true;
            slashcode[row[queen] + queen] = true;
            backslashcode[row[queen] - queen + (board_size-1)] = true;

            bb_arrangements++;  // calculation number of arrangements explore by branch and bound
            total += branchBoundSolution(queen + 1);

            // mark row as unused again
            row_used[row[queen]] = false;
            slashcode[row[queen] + queen] = false;
            backslashcode[row[queen] - queen + (board_size-1)] = false;
        }
        return total;

    }
}

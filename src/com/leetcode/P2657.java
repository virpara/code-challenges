package com.leetcode;

import java.util.Arrays;

public class P2657 {
    public static void main(String[] args) {
        int[] A = {1, 3, 2, 4}, B = {3, 1, 2, 4};

        System.out.println(Arrays.toString(new P2657().findThePrefixCommonArray(A, B)));
    }

    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int[] res = new int[A.length];
        long abits = 0, bbits = 0;
        for (int i = 0; i < A.length; i++) {
            int a = A[i], b = B[i];

            abits |= 1L << a - 1;
            bbits |= 1L << b - 1;

            res[i] = Long.bitCount(abits & bbits);
        }

        return res;
    }
}

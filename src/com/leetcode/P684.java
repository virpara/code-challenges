package com.leetcode;

import java.util.Arrays;

public class P684 {

    private int[] set;

    public int[] findRedundantConnection(int[][] edges) {
        set = new int[edges.length + 1];
        Arrays.fill(set, -1);

        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0], b = edges[i][1];
            if (!addToSet(a, b)) {
                return new int[]{a, b};
            }
        }

        return null;

    }

    private boolean addToSet(int x, int y) {
        while (set[x] != -1) x = set[x];
        while (set[y] != -1) y = set[y];

        if (x != y) {
            set[x] = y;
            return true;
        } else {
            return false;
        }
    }
}

package com.leetcode;

public class P1769 {
    public static void main(String[] args) {

    }

    public int[] minOperations(String boxes) {
        int[] ans = new int[boxes.length()];

        for (int i = 0; i < boxes.length(); i++) {
            int steps = 0;
            for (int j = 0; j < boxes.length(); j++) {
                if (j == i) continue;

                char c = boxes.charAt(j);
                if (c == '1') steps += Math.abs(i - j);
            }

            ans[i] = steps;
        }

        return ans;
    }
}

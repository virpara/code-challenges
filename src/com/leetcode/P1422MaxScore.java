package com.leetcode;

public class P1422MaxScore {
    public static void main(String[] args) {
        String s = "011101";
        s = "00";
        System.out.println(new P1422MaxScore().maxScore(s));
    }

    public int maxScore(String s) {
        int max = 0;

        if (s.length() < 2) return 0;

        int l = 0;
        int r = (int) s.chars()
                .filter(c -> c == '1')
                .count();

        for (int i = 0; i < s.length() - 1; i++) {
            char c = s.charAt(i);
            if (c == '0') {
                l++;
            } else {
                r--;
            }

            max = Math.max(max, l + r);
        }

        return max;
    }

}

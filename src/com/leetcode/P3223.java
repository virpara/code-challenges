package com.leetcode;

public class P3223 {

    // if you count each char, you can delete only if there are more than 2 chars,
    // if there are more than 2 chars and
    //  1. if the count is odd, you will be left with 1 char
    //  2. if the count is even, you will be left with 2 chars
    public int minimumLength(String s) {
        int[] freq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            freq[c]++;
        }

        int len = 0;
        for (int i = 0; i < freq.length; i++) {
            int f = freq[i];
            if (f <= 2) len += f;
            else if (f % 2 == 1) len += 1;
            else if (f % 2 == 0) len += 2;
        }

        return len;
    }
}

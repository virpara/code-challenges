package com.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class P1930Unique3LengthPalindromicSubsequence {
    public static void main(String[] args) {
        String s = "aabca";
        s = "adc";
        System.out.println(new P1930Unique3LengthPalindromicSubsequence().countPalindromicSubsequence(s));
    }

    public int countPalindromicSubsequence(String s) {
        Map<Character, Integer> f = new HashMap<>();
        Map<Character, Integer> l = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);

            f.putIfAbsent(ch, i);
            l.put(ch, i);
        }

        int count = 0;
        for (char ch : f.keySet()) {
            int fidx = f.get(ch);
            int lidx = l.get(ch);

            if (fidx == lidx) continue;

            Set<Character> uniq = new HashSet<>();
            for (int i = fidx + 1; i < lidx; i++) {
                uniq.add(s.charAt(i));
            }

            count += uniq.size();
        }

        return count;
    }
}

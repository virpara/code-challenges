package com.leetcode;

import java.util.Arrays;

public class VowelStrings {
    public static void main(String[] args) {
        String[] words = {"aba", "bcb", "ece", "aa", "e"};
        int[][] queries = {{0, 2}, {1, 4}, {1, 1}};

        String[] words2 = {"a", "e", "i"};
        int[][] queries2 = {{0, 2}, {0, 1}, {2, 2}};

        System.out.println(Arrays.toString(new VowelStrings().vowelStrings(words2, queries2)));
    }

    public int[] vowelStrings(String[] words, int[][] queries) {
        int[] ans = new int[queries.length];

        int[] prefix = new int[words.length + 1];

        for (int i = 0; i < words.length; i++) {
            prefix[i + 1] = prefix[i];

            if (isVowel(words[i])) {
                prefix[i + 1] = prefix[i] + 1;
            }
        }

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            ans[i] = prefix[r + 1] - prefix[l];
        }

        return ans;
    }

    private boolean isVowel(String word) {
        return !word.isEmpty() && isVowel(word.charAt(0)) && isVowel(word.charAt(word.length() - 1));
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}

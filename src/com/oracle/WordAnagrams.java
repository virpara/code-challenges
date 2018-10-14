package com.oracle;

import com.util.Scan;

/**
 * Generate all the anagrams of the given word.
 */

public class WordAnagrams {
    private static boolean[] isChsIUsed;

    private static void word(int idx, char[] chs, char[] word) {
        // we have shuffled all the characters, so just print them now
        if (idx == chs.length) {
            System.out.println(new String(word));
            return;
        }

        for (int i = 0; i < chs.length; i++) {
            if (isChsIUsed[i]) continue;

            word[idx] = chs[i];
            isChsIUsed[i] = true;

            word(idx + 1, chs, word);

            isChsIUsed[i] = false;
        }
    }

    public static void main(String[] args) {
        System.out.print("Enter a word: ");
        String word = Scan.ns();
        char[] chs = word.toCharArray();

        // tmp var to hold an anagram
        char[] tmp = new char[word.length()];
        isChsIUsed = new boolean[chs.length];

        word(0, chs, tmp);

    }
}

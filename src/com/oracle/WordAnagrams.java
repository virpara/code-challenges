package com.oracle;

import com.util.Scan;

/**
 * Generate all the anagrams of the given word.
 */

public class WordAnagrams {
    private static boolean[] isChsIUsed;
    private static int counter = 0;

    private static void word(int idx, char[] chs, char[] word) {
        // we have shuffled all the characters, so just print them now
        if (idx == chs.length) {
            System.out.println(new String(word));
            return;
        }

        for (int i = 0; i < chs.length; i++) {
            counter++;
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

//        // tmp var to hold an anagram
//        char[] tmp = new char[word.length()];
//        isChsIUsed = new boolean[chs.length];
//
//        word(0, chs, tmp);
//        System.out.println("counter: " + counter);

        // better approach
        anagram(chs, 0, chs.length - 1);
//        System.out.println("counter: " + counter);
    }

    private static void anagram(char[] word, int l, int r) {
        counter++;
//        System.out.println("l=" + l + " r=" + r);
        if (l == r) {
            System.out.println(new String(word));
            return;
        }

        for (int k = l; k <= r; k++) {
            swap(word, l, k);
            anagram(word, l+1, r);
            swap(word, l, k);
        }
    }

    private static void swap(char[] word, int i, int j ) {
        char c = word[i];
        word[i] = word[j];
        word[j] = c;
    }


}

package com.oracle;

import com.util.Scan;

/**
 * Generate all the anagrams of the given word.
 */

public class WordAnagrams {

    private static int counter = 0;

    public static void main(String[] args) {
        System.out.print("Enter a word: ");
        String word = Scan.ns();
        char[] chs = word.toCharArray();

        anagram(chs, 0, chs.length - 1);
        System.out.println("counter: " + counter);
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

package com.misc;

public class PossibleWords {
    public static void main(String[] args) {
        int word_length = 2;
        char[] s = new char[word_length];

        for (int i = 0; i < word_length; i++) {
            word(0, s, i + 1);
        }
    }

    /** Generates all the possible words of the specified word length
     *
     * @param i word index to assign character
     * @param word array to hold assigned character
     * @param word_length length of the generated word
     */
    private static void word(int i, char[] word, int word_length) {
        if (i == word_length) {
            // offset and count parameter allows excluding blank character
            // in words smaller than allocated array size
            System.out.println(new String(word, 0, word_length));
            return;
        }

        // iterate over 'A' to 'Z', then initialize c with 'a' - 1
        // to start iteration from 'a' and stop after 'z'
        for (char c = 'A'; c <= 'z'; c++) {
            word[i] = c;
            word(i + 1, word, word_length);
            if (c == 'Z') c = 'a' - 1;  // increment portion will make it 'a'
        }
    }
}

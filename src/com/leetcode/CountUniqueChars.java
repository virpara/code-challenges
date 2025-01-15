package com.leetcode;

public class CountUniqueChars {
    public static void main(String[] args) {
        String s = "filttttttter#^&\n";

        System.out.println(countUniqueChars(s));
    }

    private static long countUniqueChars(String s) {
        return s.chars()
                .distinct()
                .filter(Character::isLetterOrDigit)
                .count();
    }
}
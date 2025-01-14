package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

public class P2116 {

    public static void main(String[] args) {
        String s = "))()))", locked = "010100";
        System.out.println(new P2116().canBeValid(s, locked));
    }

    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 == 1) return false;

        Deque<Integer> openIndices = new ArrayDeque<>();
        Deque<Integer> unlockedIndices = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            char l = locked.charAt(i);

            if (l == '0') unlockedIndices.push(i);
            else if (c == '(') openIndices.push(i);
            else if (c == ')') {
                if (!openIndices.isEmpty()) {
                    openIndices.pop();
                } else if (!unlockedIndices.isEmpty()) {
                    unlockedIndices.pop();
                } else {
                    return false;
                }
            }
        }

        while (!openIndices.isEmpty() && !unlockedIndices.isEmpty()
                && openIndices.peek() < unlockedIndices.peek()) {
            openIndices.pop();
            unlockedIndices.pop();
        }

        if (openIndices.isEmpty() && !unlockedIndices.isEmpty()) {
            return unlockedIndices.size() % 2 == 0;
        }

        return openIndices.isEmpty();
    }
}

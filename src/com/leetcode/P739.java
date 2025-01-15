package com.leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

public class P739 {

    @Test
    public void test() {
        int[] temp = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] expected = {1, 1, 4, 2, 1, 1, 0, 0};

        Assertions.assertArrayEquals(expected, new P739().dailyTemperatures(temp));
    }

    public int[] dailyTemperatures(int[] t) {
        Deque<Integer> stack = new ArrayDeque<>();
        int[] ans = new int[t.length];

        for (int i = 0; i < t.length; i++) {
            while (!stack.isEmpty() && t[i] > t[stack.peekFirst()]) {
                ans[stack.peekFirst()] = i - stack.peekFirst();
                stack.removeFirst();
            }

            stack.addFirst(i);
        }

        while (!stack.isEmpty()) {
            ans[stack.peekFirst()] = 0;
            stack.removeFirst();
        }

        return ans;

    }
}

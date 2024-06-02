package com.leetcode;

import java.util.*;

public class NextGreaterElementRight {

    public static void main(String[] args) {

        int[] nums1 = {4, 1, 2};
        int[] nums2 = {1, 3, 4, 2};
        int[] ans = new NextGreaterElementRight().nextGreaterElement(nums1, nums2);
        System.out.println("ans=" + Arrays.toString(ans));
    }

    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Deque<Integer> stack = new ArrayDeque<>();

        Map<Integer, Integer> map = new HashMap<>();

        int[] ans = new int[nums1.length];

        for (int i = nums2.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums2[i] > stack.peekFirst()) {
                stack.removeFirst();
            }

            if (stack.isEmpty()) map.put(nums2[i], -1);
            else map.put(nums2[i], stack.peekFirst());

            stack.addFirst(nums2[i]);
        }

        for (int i = 0; i < nums1.length; i++) {
            ans[i] = map.get(nums1[i]);
        }

        return ans;
    }

}

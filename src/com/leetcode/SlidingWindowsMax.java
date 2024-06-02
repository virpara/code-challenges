package com.leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 239. Sliding Window Maximum
public class SlidingWindowsMax {

    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] b = new SlidingWindowsMax().maxSlidingWindow(a, k);
        System.out.println(Arrays.toString(b));
    }

    // TLE
//    public int[] maxSlidingWindow(int[] nums, int k) {
//
//        if (nums.length == 0) return new int[0];
//
//        int[] ans = new int[nums.length - k + 1];
//        for (int i = 0; i < nums.length - k + 1; i++) {
//
//            int max = Integer.MIN_VALUE;
//            for (int j = i; j < i + k; j++) {
//                max = Math.max(max, nums[j]);
//            }
//            ans[i] = max;
//        }
//
//        return ans;
//    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int[] ans = new int[nums.length - k + 1];

        Deque<Integer> st = new ArrayDeque<>();
        int[] nge = new int[nums.length];

        for (int i = nums.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && nums[i] > nums[st.peekFirst()]) {
                st.removeFirst();
            }

            if (st.isEmpty()) {
                nge[i] = nums.length;
            } else {
                nge[i] = st.peekFirst();
            }

            st.addFirst(i);
        }

        int j = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            if (j < i) {
                j = i;
            }

            while (nge[j] < i + k) {
                j = nge[j];
            }

            ans[i] = nums[j];
        }

        return ans;
    }

}

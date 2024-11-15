package com.leetcode;

import java.util.*;

// 239. Sliding Window Maximum
public class SlidingWindowsMax {

    public static void main(String[] args) {
        int[] a = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

        int[] b = new SlidingWindowsMax().maxSlidingWindow(a, k);
        System.out.println(Arrays.toString(b));

        b = new SlidingWindowsMax().maxSlidingWindowPQ(a, k);
        System.out.println(Arrays.toString(b));
    }

    // PriorityQueue
    public int[] maxSlidingWindowPQ(int[] nums, int k) {

        if (nums == null || k == 0) return nums;

        int n = nums.length;

        int[] ans = new int[n - k + 1];

        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a, b) -> b.get(0) - a.get(0));

        for (int i = 0; i < n; i++) {
            pq.offer(List.of(nums[i], i));

            while (!pq.isEmpty() && pq.peek().get(1) < i - k + 1) {
                pq.poll();
            }

            if (i >= k - 1) {
                ans[i - k + 1] = pq.peek().get(0);
            }
        }

        return ans;
    }

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

package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class P300LongestIncreasingSubsequence {

    public static void main(String[] args) {
        int[] nums = {10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(new P300LongestIncreasingSubsequence().lengthOfLIS(nums));
    }

    public int lengthOfLIS(int[] nums) {
        List<Integer> res = new ArrayList<>();
        res.add(nums[0]);

        for (int i = 1; i < nums.length; i++) {
            int last = res.get(res.size() - 1);

            if (nums[i] > last) res.add(nums[i]);
            else {
                int greater = bsearch(res, nums[i]);
                res.set(greater, nums[i]);
            }
        }

        return res.size();
    }

    public int bsearch(List<Integer> list, int target) {
        int ans = -1, s = 0, e = list.size() - 1;

        while (s <= e) {
            int m = (s + e) / 2;
            if (list.get(m) >= target) {
                ans = m;
                e = m - 1;
            } else {
                s = m + 1;
            }
        }

        return ans;
    }
}

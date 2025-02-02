package com.leetcode.easy;

public class P1752 {
    public boolean check(int[] nums) {
        int diff = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > nums[(i + 1) % nums.length]) diff++;
        }

        return diff <= 1;
    }
}

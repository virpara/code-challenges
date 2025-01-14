package com.leetcode;

public class P153MinInRotatedSortedArray {

    public static void main(String[] args) {
        int[] a = {3, 4, -1, 0, 1, 2};
        int min = new P153MinInRotatedSortedArray().findMin(a);
        System.out.println("min: " + min);
    }

    public int findMin(int[] nums) {
        int s = 0, e = nums.length - 1, m = -1;

        while (s < e) {
            m = (s + e) / 2;

            if (nums[m] > nums[e]) {
                s = m + 1;
            } else {
                e = m;
            }
        }

        return nums[e];
    }
}

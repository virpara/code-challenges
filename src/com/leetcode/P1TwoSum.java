package com.leetcode;

import java.util.Arrays;

public class P1TwoSum {

    public static void main(String[] args) {

        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = new P1TwoSum().twoSum(nums, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public int[] twoSum(int[] nums, int target) {
        Pair[] pairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            pairs[i] = new Pair(nums[i], i);
        }

        Arrays.sort(pairs);

        int[] res = new int[2];

        int li = 0;
        int ri = nums.length - 1;

        while (li < ri) {
            int n = pairs[li].val + pairs[ri].val;

            if (n == target) {
                res[0] = pairs[li].idx;
                res[1] = pairs[ri].idx;
                break;
            } else if (n > target) {
                ri--;
            } else {
                li++;
            }
        }

        return res;
    }

    class Pair implements Comparable<Pair> {
        int val;
        int idx;

        Pair(int val, int idx) {
            this.val = val;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair o) {
            if (this.val > o.val) {
                return 1;
            } else if (this.val < o.val) {
                return -1;
            } else {
                return 0;
            }
        }
    }

//    public int[] twoSum(int[] nums, int target) {
//        int[] result = new int[2];
//        for (int i = 0; i < nums.length; i++) {
//            for (int j = i + 1; j < nums.length; j++) {
//                if (nums[i] + nums[j] == target) {
//                    result[0] = i;
//                    result[1] = j;
//                }
//            }
//        }
//        return result;
//    }
}

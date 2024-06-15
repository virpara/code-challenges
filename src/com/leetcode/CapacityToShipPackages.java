package com.leetcode;

public class CapacityToShipPackages {

    public static boolean possible(int target, int[] weights, int days) {
        int currDays = 1;
        int currShipPackages = 0;
        for (int i = 0; i < weights.length; i++) {
            currShipPackages += weights[i];
            if (currShipPackages > target) {
                currDays++;
                currShipPackages = weights[i];

                if (currDays > days) {
                    return false;
                }
            }

        }

        return true;
    }

    public int shipWithinDays(int[] weights, int days) {
        if (weights.length < days) return -1;

        int start = Integer.MIN_VALUE;
        int end = 0;
        for (int i = 0; i < weights.length; i++) {
            end += weights[i];
            start = Math.max(start, weights[i]);
        }

        int ans = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (possible(mid, weights, days)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return ans;
    }
}

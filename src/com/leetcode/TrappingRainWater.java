package com.leetcode;

public class TrappingRainWater {

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();

        int[] heights = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};

        System.out.println("trapped water: " + t.trap(heights));
    }

    public int trap(int[] heights) {

        if (heights.length < 3) {
            return 0;
        }
        int trappedWater = 0;

        int[] lMax = new int[heights.length];
        int[] rMax = new int[heights.length];

        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            if (heights[i] > max) {
                lMax[i] = max;
                max = heights[i];
            } else {
                lMax[i] = max;
            }
        }

//        System.out.println("lmax: " + Arrays.toString(lMax));

        max = 0;

        for (int i = heights.length - 1; i > 0; i--) {
            if (heights[i] > max) {
                rMax[i] = max;
                max = heights[i];
            } else {
                rMax[i] = max;
            }
        }

//        System.out.println("rmax: " + Arrays.toString(rMax));

        for (int i = 0; i < heights.length; i++) {
            int water = Math.min(lMax[i], rMax[i]) - heights[i];
            if (water > 0) trappedWater += water;
        }

        return trappedWater;
    }
}

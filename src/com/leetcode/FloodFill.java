package com.leetcode;

import java.util.Arrays;

class FloodFill {
    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 1, 1, 1, 0},
                {1, 1, 0, 1, 0},
                {1, 1, 0, 0, 1},
                {0, 0, 0, 1, 1}
        };

//        grid = new int[][]{
//                {1, 1, 1},
//                {1, 1, 0},
//                {1, 0, 1}};

//        grid = new int[][]{
//                {0, 0, 0},
//                {0, 0, 0},
//                {0, 0, 0}};

        System.out.println(Arrays.deepToString(grid).replace("],", "]\n"));

        FloodFill c = new FloodFill();
        c.floodFill(grid, 0, 0, 0);

        System.out.println("After Flood fill:");
        System.out.println(Arrays.deepToString(grid).replace("],", "]\n"));

    }

    public int[][] floodFill(int[][] matrix, int x, int y, int newColor) {
        int oldColor = matrix[x][y];
        dfs(matrix, x, y, newColor, oldColor);

        return matrix;
    }

    public void dfs(int[][] matrix, int x, int y, int newColor, int oldColor) {
        if (x < 0 || x >= matrix.length
                || y < 0 || y >= matrix[x].length
                || matrix[x][y] != oldColor
                || matrix[x][y] == newColor) return;

        matrix[x][y] = newColor;

        dfs(matrix, x + 1, y, newColor, oldColor);
        dfs(matrix, x - 1, y, newColor, oldColor);
        dfs(matrix, x, y + 1, newColor, oldColor);
        dfs(matrix, x, y - 1, newColor, oldColor);
    }
}
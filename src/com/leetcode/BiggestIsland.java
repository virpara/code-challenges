package com.leetcode;

import java.util.ArrayDeque;
import java.util.Deque;

class BiggestIsland {
    static int area = 0;

    public static void main(String[] args) {
        BiggestIsland c = new BiggestIsland();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int ans = c.maxAreaOfIsland(grid);

        System.out.println(ans);
    }

    public int maxAreaOfIsland(char[][] grid) {
        int max = -1;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                area = 0;

                if (grid[i][j] == '1') {
                    visitBFS(grid, i, j);
                }

                max = Math.max(max, area);
            }
        }

        return max;
    }

    public void visitBFS(char[][] grid, int x, int y) {
        Deque<Pair> q = new ArrayDeque<>();
        q.add(new Pair(x, y));

        while (!q.isEmpty()) {
            int r = q.peek().first;
            int c = q.peek().second;
            q.remove();

            if (r < 0 || r >= grid.length || c < 0 || c >= grid[0].length) continue;
            if (grid[r][c] == '0') continue;

            grid[r][c] = '0';
            area++;

            q.add(new Pair(r + 1, c));
            q.add(new Pair(r - 1, c));
            q.add(new Pair(r, c + 1));
            q.add(new Pair(r, c - 1));
        }
    }

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
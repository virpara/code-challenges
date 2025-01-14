import java.util.ArrayDeque;
import java.util.Deque;

class CountIsland {

    public static void main(String[] args) {
        CountIsland c = new CountIsland();
        char[][] grid = new char[][]{
                {'1', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };

        int ans = c.numIslands(grid);

        System.out.println(ans);
    }

    public int numIslands(char[][] grid) {
        int count = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    count++;
                    visitBFS(grid, i, j);
                }
            }
        }

        return count;
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
            q.add(new Pair(r + 1, c));
            q.add(new Pair(r - 1, c));
            q.add(new Pair(r, c + 1));
            q.add(new Pair(r, c - 1));
        }
    }

    public void dfs(char[][] grid, int i, int j) {
        int top = i - 1;
        int bottom = i + 1;
        int left = j - 1;
        int right = j + 1;

        grid[i][j] = '2';

        if (top > -1 && top < grid.length && grid[top][j] == '1') {
            dfs(grid, top, j);
        }

        if (bottom > -1 && bottom < grid.length && grid[bottom][j] == '1') {
            dfs(grid, bottom, j);
        }

        if (left > -1 && left < grid[i].length && grid[i][left] == '1') {
            dfs(grid, i, left);
        }

        if (right > -1 && right < grid[i].length && grid[i][right] == '1') {
            dfs(grid, i, right);
        }
    }


    // dfs solution
//    public int numIslands(char[][] grid) {
//        int count = 0;
//
//        for (int i = 0; i < grid.length; i++) {
//            for (int j = 0; j < grid[i].length; j++) {
//                int x = grid[i][j];
//
//                if (x == '1') {
//                    dfs(grid, i, j);
//                    count++;
//                }
//            }
//        }
//
//        return count;
//    }

    static class Pair {
        int first, second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }
}
import java.util.*;

class Solution {

    public List<String> findPath(int[][] grid) {

        List<String> ans = new ArrayList<>();

        int n = grid.length;

        if (grid[0][0] == 0) {
            return ans;
        }

        boolean[][] visited = new boolean[n][n];

        solve(0, 0, grid, n, visited, "", ans);

        return ans;
    }

    private void solve(int row, int col,
                       int[][] grid,
                       int n,
                       boolean[][] visited,
                       String path,
                       List<String> ans) {

        if (row == n - 1 && col == n - 1) {
            ans.add(path);
            return;
        }

        visited[row][col] = true;

        // Down
        if (isSafe(row + 1, col, grid, visited, n)) {
            solve(row + 1, col, grid, n, visited, path + "D", ans);
        }

        // Left
        if (isSafe(row, col - 1, grid, visited, n)) {
            solve(row, col - 1, grid, n, visited, path + "L", ans);
        }

        // Right
        if (isSafe(row, col + 1, grid, visited, n)) {
            solve(row, col + 1, grid, n, visited, path + "R", ans);
        }

        // Up
        if (isSafe(row - 1, col, grid, visited, n)) {
            solve(row - 1, col, grid, n, visited, path + "U", ans);
        }

        visited[row][col] = false; // Backtracking
    }

    private boolean isSafe(int row, int col,
                           int[][] grid,
                           boolean[][] visited,
                           int n) {

        return row >= 0 &&
               col >= 0 &&
               row < n &&
               col < n &&
               grid[row][col] == 1 &&
               !visited[row][col];
    }
}
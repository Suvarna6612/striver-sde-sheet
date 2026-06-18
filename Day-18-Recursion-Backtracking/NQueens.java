import java.util.*;

class Solution {

    public List<List<String>> solveNQueens(int n) {

        List<List<String>> ans = new ArrayList<>();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        solve(0, board, ans);

        return ans;
    }

    private void solve(int row, char[][] board, List<List<String>> ans) {

        if (row == board.length) {

            List<String> temp = new ArrayList<>();

            for (char[] r : board) {
                temp.add(new String(r));
            }

            ans.add(temp);
            return;
        }

        for (int col = 0; col < board.length; col++) {

            if (isSafe(row, col, board)) {

                // Place Queen
                board[row][col] = 'Q';

                // Explore
                solve(row + 1, board, ans);

                // Backtrack
                board[row][col] = '.';
            }
        }
    }

    private boolean isSafe(int row, int col, char[][] board) {

        int r = row;
        int c = col;

        // Check upper column
        while (r >= 0) {
            if (board[r][c] == 'Q')
                return false;
            r--;
        }

        r = row;
        c = col;

        // Check upper-left diagonal
        while (r >= 0 && c >= 0) {
            if (board[r][c] == 'Q')
                return false;
            r--;
            c--;
        }

        r = row;
        c = col;

        // Check upper-right diagonal
        while (r >= 0 && c < board.length) {
            if (board[r][c] == 'Q')
                return false;
            r--;
            c++;
        }

        return true;
    }
}
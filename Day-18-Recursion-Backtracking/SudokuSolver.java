class Solution {

    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                if (board[row][col] == '.') {

                    for (char ch = '1'; ch <= '9'; ch++) {

                        if (isSafe(board, row, col, ch)) {

                            // Choose
                            board[row][col] = ch;

                            // Explore
                            if (solve(board))
                                return true;

                            // Undo
                            board[row][col] = '.';
                        }
                    }

                    return false;
                }
            }
        }

        return true;
    }

    private boolean isSafe(char[][] board, int row, int col, char ch) {

        for (int i = 0; i < 9; i++) {

            // Row Check
            if (board[row][i] == ch)
                return false;

            // Column Check
            if (board[i][col] == ch)
                return false;

            // 3x3 Box Check
            int r = 3 * (row / 3) + i / 3;
            int c = 3 * (col / 3) + i % 3;

            if (board[r][c] == ch)
                return false;
        }

        return true;
    }
}
package Java.leetcode;

/**
 * @Author: kp1nz
 * @Date: 2020/8/11 11:25 下午
 */
public class _130 {
    public void solve(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                boolean isEdge = i == 0 || j == 0 || i == board.length - 1 || j == board[i].length - 1;
                if (isEdge && board[i][j] == 'O') {
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'F') board[i][j] = 'O';
            }
        }

    }

    private void dfs(char[][] board, int i, int j) {
        if (i <= 0 || j <= 0 || i > board.length || j > board[i].length || board[i][j] == 'X' || board[i][j] == 'F')
            return;
        board[i][j] = 'F';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

}

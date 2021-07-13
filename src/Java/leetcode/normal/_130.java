package Java.leetcode.normal;

import java.util.Arrays;

/**
 * 深度优先
 * 从边缘入手，将所有和o相连的o打上false，最后替换回o
 * 其余的o就是被包围的，替换为x
 * @Author: kp1nz
 * @Date: 2020/8/11 11:25 下午
 */
public class _130 {
    public static void solve(char[][] board) {
        if (board == null || board.length == 0) return;
        int x = board.length;
        int y = board[0].length;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                boolean isEdge = i == 0 || j == 0 || i == x - 1 || j == y - 1;
                if (isEdge && board[i][j] == 'O') {
                    dfs(board, i, j);
                }
            }
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'O') board[i][j] = 'X';
                if (board[i][j] == 'F') board[i][j] = 'O';
            }
        }

    }

    private static void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[i].length || board[i][j] == 'X' || board[i][j] == 'F')
            return;
        board[i][j] = 'F';
        dfs(board, i - 1, j);
        dfs(board, i + 1, j);
        dfs(board, i, j - 1);
        dfs(board, i, j + 1);
    }

    public static void main(String[] args) {
        char[][] board = {{'O'}};
        solve(board);
        System.out.println(Arrays.deepToString(board));
    }

}

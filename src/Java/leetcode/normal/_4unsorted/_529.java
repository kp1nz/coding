package Java.leetcode.normal._4unsorted;

import java.util.Arrays;

/**
 *
 * 扫雷游戏
 *
 * @Author: kp1nz
 * @Date: 2020/8/20 11:49
 */
public class _529 {
    // 雷
    static int x = 0;

    public static char[][] updateBoard(char[][] board, int[] click) {
        if (board[click[0]][click[1]] == 'M') {
            board[click[0]][click[1]] = 'X';
        }
        handlerBlocks(click[0], click[1], board);
        return board;
    }

    private static void handlerBlocks(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == 'B') return;
        handlerBlock(i - 1, j - 1, board);
        handlerBlock(i - 1, j, board);
        handlerBlock(i - 1, j + 1, board);
        handlerBlock(i, j - 1, board);
        handlerBlock(i, j + 1, board);
        handlerBlock(i + 1, j - 1, board);
        handlerBlock(i + 1, j, board);
        handlerBlock(i + 1, j + 1, board);
        if (x != 0) board[i][j] = (char) (x + 48);
        else board[i][j] = 'B';
        x = 0;
        if (board[i][j] == 'B') {
            handlerBlocks(i - 1, j - 1, board);
            handlerBlocks(i - 1, j, board);
            handlerBlocks(i - 1, j + 1, board);
            handlerBlocks(i, j - 1, board);
            handlerBlocks(i, j + 1, board);
            handlerBlocks(i + 1, j - 1, board);
            handlerBlocks(i + 1, j, board);
            handlerBlocks(i + 1, j + 1, board);
        }
    }

    private static void handlerBlock(int i, int j, char[][] board) {
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length) return;
        if (board[i][j] == 'M') x++;
    }

    public static void main(String[] args) {
        char[][] board = {{'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'M', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'},
                {'E', 'E', 'E', 'E', 'E'}};
        int[] click = {3, 0};
        char[][] board2 = {{'B', '1', 'E', '1', 'B'},
                {'B', '1', 'M', '1', 'B'},
                {'B', '1', '1', '1', 'B'},
                {'B', 'B', 'B', 'B', 'B'}};
        int[] click2 = {1,2};
        System.out.println(Arrays.deepToString(updateBoard(board2, click2)));
    }
}

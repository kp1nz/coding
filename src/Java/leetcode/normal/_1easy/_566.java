package Java.leetcode.normal._1easy;

import java.util.Arrays;

/**
 * 566. 重塑矩阵
 *
 * @Author: kp1nz
 * @Date: 2021/7/27 3:46 PM
 */
public class _566 {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int m = mat.length;
        int n = mat[0].length;
        if (n * m != r * c)
            return mat;
        int[][] ans = new int[r][c];
        int row = 0, col = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (col >= c) {
                    row++;
                    col = 0;
                }
                ans[row][col++] = mat[i][j];
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _566 v = new _566();
        int[][] ints = v.matrixReshape(new int[][]{{1, 2}, {3, 4}}, 4, 1);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}

package Java.leetcode.normal._2mid;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 542. 01 矩阵
 *
 * @Author: kp1nz
 * @Date: 2021/7/19 6:08 PM
 */
public class _542 {
    public static int[][] updateMatrix(int[][] mat) {
        Queue<int[]> ints = new LinkedList<>();
        int m = mat.length;
        int n = mat[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 0) {
                    ints.offer(new int[]{i, j});
                } else {
                    mat[i][j] = -1;
                }
            }
        }
        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};
        while (!ints.isEmpty()) {
            int[] poll = ints.poll();
            int ox = poll[0];
            int oy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = ox + x[i];
                int ny = oy + y[i];
                if (nx>=0 && ny>=0 && nx < m && ny < n && mat[nx][ny] == -1){
                    mat[nx][ny] = mat[ox][oy] + 1;
                    ints.offer(new int[]{nx,ny});
                }
            }
        }
        return mat;
    }

    public static void main(String[] args) {
        int[][] ints = updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}});
        for (int[] a : ints) {
            System.out.println(Arrays.toString(a));
        }
    }
}

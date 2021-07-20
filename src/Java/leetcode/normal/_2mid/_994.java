package Java.leetcode.normal._2mid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 994. 腐烂的橘子
 *
 * @Author: kp1nz
 * @Date: 2021/7/20 11:52 AM
 */
public class _994 {
    public static int orangesRotting(int[][] grid) {
        if (check(grid))
            return 0;
        Queue<int[]> ints = new LinkedList<>();
        Queue<int[]> backups = new LinkedList<>();
        int m = grid.length;
        int n = grid[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 2) {
                    ints.offer(new int[]{i, j});
                }
            }
        }
        int[] x = new int[]{1, -1, 0, 0};
        int[] y = new int[]{0, 0, 1, -1};
        int mins = 0;
        while (!ints.isEmpty() || !backups.isEmpty()) {
            if (ints.isEmpty()){
                while (!backups.isEmpty())
                    ints.offer(backups.poll());
                mins++;
            }
            int[] poll = ints.poll();
            int ox = poll[0];
            int oy = poll[1];
            for (int i = 0; i < 4; i++) {
                int nx = ox + x[i];
                int ny = oy + y[i];
                if (nx >=0 && ny >=0 && nx < m && ny < n && grid[nx][ny] == 1){
                    grid[nx][ny] = 2;
                    backups.offer(new int[]{nx,ny});
                }
            }
        }
        for (int i = 0; i < grid.length; i++) {
            System.out.println(Arrays.toString(grid[i]));
        }
        if (check(grid))
            return mins;
        else
            return -1;
    }

    private static boolean check(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1)
                    return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
    }
}

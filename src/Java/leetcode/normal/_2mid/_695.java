package Java.leetcode.normal._2mid;

/**
 * 695. Max Area of Island
 *
 * @Author: kp1nz
 * @Date: 2021/7/19 3:11 PM
 */
public class _695 {
    public static int maxAreaOfIsland(int[][] grid) {
        int sum = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                sum = Math.max(dfs(grid, i, j), sum);
            }
        }
        return sum;
    }

    private static int dfs(int[][] grid, int x, int y) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] == 0 || grid[x][y] != 1)
            return 0;
        int sum = 1;
        grid[x][y] = -1;
        sum += dfs(grid, x - 1, y);
        sum += dfs(grid, x, y - 1);
        sum += dfs(grid, x + 1, y);
        sum += dfs(grid, x, y + 1);
        return sum;
    }

    public static void main(String[] args) {
        int[][] ints = {{0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0}, {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0}, {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}};
        int i = maxAreaOfIsland(ints);
        System.out.println(i);
    }
}

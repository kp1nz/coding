package Java.leetcode.normal._1easy;

import java.util.Arrays;

/**
 * 733. Flood Fill
 *
 * @Author: kp1nz
 * @Date: 2021/7/19 2:10 PM
 */
public class _733 {
    public static int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        dfs(image, sr, sc, image[sr][sc], newColor);
        return image;
    }

    private static void dfs(int[][] image, int x, int y, int oriColor, int newColor) {
        if (x < 0 || y < 0 || x >= image.length || y >= image[0].length
                || image[x][y] != oriColor || image[x][y] == newColor)
            return;
        image[x][y] = newColor;
        dfs(image, x - 1, y, oriColor, newColor);
        dfs(image, x, y - 1, oriColor, newColor);
        dfs(image, x + 1, y, oriColor, newColor);
        dfs(image, x, y + 1, oriColor, newColor);
    }

    public static void main(String[] args) {
        int[][] ints = floodFill(new int[][]{{0, 0, 0}, {0, 1, 0}}, 0, 2, 2);
        for (int i = 0; i < ints.length; i++) {
            System.out.println(Arrays.toString(ints[i]));
        }
    }
}

package Java.leetcode.normal._2mid;

import java.util.ArrayList;
import java.util.List;

/**
 * 120. 三角形最小路径和
 *
 * @Author: kp1nz
 * @Date: 2021/7/26 11:21 AM
 */
public class _120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        /**
         * dp[i][j] 表示该点到底的最小路径
         * dp[i][j]=min(dp[i+1][j],dp[i+1][j+1])+triangle[i][j]
         */
        int len = triangle.size();
        int[][] dp = new int[len + 1][len + 1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = Math.min(dp[i + 1][j], dp[i + 1][j + 1]) + triangle.get(i).get(j);
            }
        }
        return dp[0][0];
    }

    public int minimumTotalBetter(List<List<Integer>> triangle){
        int len = triangle.size();
        int[] dp = new int[len+1];
        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j <= i; j++){
                dp[j] = Math.min(dp[j], dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }

    public static void main(String[] args) {
        List<List<Integer>> arrayLists = new ArrayList<>();
        arrayLists.add(new ArrayList<Integer>() {{
            add(2);
        }});
        arrayLists.add(new ArrayList<Integer>() {{
            add(3);
            add(4);
        }});
        arrayLists.add(new ArrayList<Integer>() {{
            add(6);
            add(5);
            add(7);
        }});
        arrayLists.add(new ArrayList<Integer>() {{
            add(4);
            add(1);
            add(8);
            add(3);
        }});
        System.out.println(new _120().minimumTotalBetter(arrayLists));
    }
}

package Java.leetcode.normal._1easy;

/**
 * 70. 爬楼梯
 *
 * @Author: kp1nz
 * @Date: 2021/7/24 10:16 PM
 */
public class _70 {
    public int climbStairs(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static void main(String[] args) {
        _70 v = new _70();
        int i = v.climbStairs(3);
        System.out.println(i);
    }
}

package Java.leetcode.normal._2mid;

/**
 * 198. 打家劫舍
 * 输入：[1,2,3,1]
 * 输出：4
 * 解释：偷窃 1 号房屋 (金额 = 1) ，然后偷窃 3 号房屋 (金额 = 3)。
 * 偷窃到的最高金额 = 1 + 3 = 4 。
 *
 * @Author: kp1nz
 * @Date: 2021/7/26 10:29 AM
 */
public class _198 {
    public int rob(int[] nums) {
        int dp[] = new int[nums.length + 1];
        dp[0] = 0;
        dp[1] = nums[0];
        for (int i = 2; i < nums.length + 1; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i - 1]);
        }
        return dp[nums.length];
    }

    public static void main(String[] args) {
        _198 v = new _198();
        int rob = v.rob(new int[]{2, 7, 9, 3, 1});
        System.out.println(rob);
    }
}

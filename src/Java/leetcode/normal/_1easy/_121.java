package Java.leetcode.normal._1easy;

/**
 * 121. 买卖股票的最佳时机
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * @Author: kp1nz
 * @Date: 2021/7/27 1:59 PM
 */
public class _121 {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE, ans = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }else if (prices[i] - min > ans){
                ans  = prices[i] - min;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        _121 v = new _121();
        System.out.println(v.maxProfit(new int[]{7,1,5,3,6,4}));
    }
}

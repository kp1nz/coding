package Java.leetcode.normal._1easy;

/**
 * 53. 最大子序和
 *
 * @Author: kp1nz
 * @Date: 2021/7/26 5:20 PM
 */
public class _53 {
    public int maxSubArray(int[] nums) {
        if (nums.length == 1) return nums[0];
        int sum = nums[0], res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (sum >= 0)
                sum += nums[i];
            else
                sum = nums[i];
            res = Math.max(sum, res);
        }
        return res;
    }

    public static void main(String[] args) {
        _53 v = new _53();
        System.out.println(v.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
    }
}

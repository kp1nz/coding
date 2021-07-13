package Java.leetcode.normal._1easy;

/**
 * @Author: kp1nz
 * @Date: 2020/8/2 9:05 下午
 */
public class _1 {
    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (target == nums[i] + nums[j]) {
                    return new int[]{i, j};
                }
            }
        }
        return null;
    }
}

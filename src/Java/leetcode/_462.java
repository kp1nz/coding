package Java.leetcode;

import java.util.Arrays;

/**
 * @Author: kp1nz
 * @Date: 2020/7/1 11:57 下午
 */
public class _462 {
    public static int minMoves2(int[] nums) {
        Arrays.sort(nums);
        int tmp = 0;
        int max = 0;
        for (int i = 1; i <= nums.length - 1; i++) {
            if (nums[i - 1] == nums[i]) {
                tmp++;
                max = Math.max(max, tmp);
            } else tmp = 0;
        }
        return nums.length - max - 1;
    }

    public static void main(String[] args) {
        int[] a = {1, 4, 3};
        System.out.println(minMoves2(a));
    }

}

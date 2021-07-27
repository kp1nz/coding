package Java.leetcode.normal._1easy;

import java.util.Arrays;

/**
 * 88. 合并两个有序数组
 * <p>
 * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
 * 输出：[1,2,2,3,5,6]
 *
 * @Author: kp1nz
 * @Date: 2021/7/27 10:11 AM
 */
public class _88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        for (int i = 0; i < nums2.length; i++) {
            nums1[m+i] = nums2[i];
        }
        Arrays.sort(nums1);
        return;
    }
}

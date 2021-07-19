package Java.leetcode.normal._2mid;

import java.util.Arrays;

/**
 * 1818. 绝对差值和
 *
 * @Author: kp1nz
 * @Date: 2021/7/14 10:18 AM
 */
public class _1818 {
    public static int minAbsoluteSumDiff(int[] nums1, int[] nums2) {
        int mod = (int) 1e9 + 7;
        int[] clone = nums1.clone();
        Arrays.sort(clone);
        int maxDiff = 0, sum = 0;
        int len = nums1.length;
        for (int i = 0; i < len; i++) {
            int a = nums1[i];
            int b = nums2[i];
            if (a == b) {
                continue;
            }
            sum += Math.abs(a - b);
            int s = 0, e = len - 1;
            int mid = s + e + 1 >> 1;
            while (s + 1 != e) {
                mid = s + e + 1 >> 1;
                if (clone[mid] >= b) e = mid;
                else s = mid;
            }
            int diff = Math.min(Math.abs(clone[s] - b), Math.abs(clone[e] - b));
            int target = diff + b;
            maxDiff = Math.max(maxDiff, Math.abs(Math.abs(target - b) - Math.abs(a - b)));
        }
        return (int)(sum - maxDiff) % mod;
    }
}



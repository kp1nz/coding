package Java.leetcode;

/**
 * @Author: kp1nz
 * @Date: 2020/8/17 2:38 下午
 */
public class _4 {
    // odd medianIndex: (len1 + len2 + 1) / 2
    // even medianIndex: (len1 + len2 + 1) / 2 (len1 + len2 + 1) / 2 + 1
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length + nums2.length;
        if (n % 2 == 1) {
            return find(n / 2 + 1, nums1, nums2, 0, 0);
        } else {
            return ((double) find(n / 2, nums1, nums2, 0, 0)
                    + (double) find(n / 2 + 1, nums1, nums2, 0, 0)) / 2.0;
        }
    }

    private static int find(int n, int[] nums1, int[] nums2, int start1, int start2) {
        if (start1 >= nums1.length)
            return nums2[start2 + n - 1];
        if (start2 >= nums2.length)
            return nums1[start1 + n - 1];
        // 相对较小的数在前面
        if (n == 1)
            return Math.min(nums1[start1], nums2[start2]);
        int half = Math.min(n / 2, Math.min(nums1.length - start1, nums2.length - start2));
        if (nums1[start1 + half - 1] < nums2[start2 + half - 1]) {
            return find(n - half, nums1, nums2, start1 + half, start2);
        } else {
            return find(n - half, nums1, nums2, start1, start2 + half);
        }
    }

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
    }
}

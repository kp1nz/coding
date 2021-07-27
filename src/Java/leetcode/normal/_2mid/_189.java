package Java.leetcode.normal._2mid;

/**
 * 旋转数组 双指针
 * 输入: nums = [1,2,3,4,5,6,7], k = 3
 * 输出: [5,6,7,1,2,3,4]
 *
 * @Author: kp1nz
 * @Date: 2021/7/12 2:07 PM
 */
public class _189 {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) return;
        k = k > n ? k % n : k;
        nums = reverse(nums, 0, n - 1);
        nums = reverse(nums, 0, k - 1);
        nums = reverse(nums, k, n - 1);
    }

    private static int[] reverse(int[] nums, int s, int e) {
        for (; s <= e; s++, e--) {
            int tmp = nums[s];
            nums[s] = nums[e];
            nums[e] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5,6};
        rotate(nums, 11);
        //int[] reverse = reverse(new int[]{1, 2, 3, 4, 5}, 0, 5);
        for (int i : nums) {
            System.out.println(i);
        }

    }


}

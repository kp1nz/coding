package Java.leetcode;

/**
 * 有序数组的平方 双指针
 * 输入：nums = [-4,-1,0,3,10]
 * 输出：[0,1,9,16,100]
 * @Author: kp1nz
 * @Date: 2021/7/12 10:29 AM
 */
public class _977 {
    public static int[] sortedSquares(int[] nums) {
        int[] res = new int[nums.length];
        for (int i = 0, j = nums.length - 1, pos = nums.length - 1; i <= j; ) {
            if (nums[i] * nums[i] < nums[j] * nums[j]) {
                res[pos] = nums[j] * nums[j];
                j--;
            }else {
                res[pos] =nums[i] * nums[i];
                i++;
            }
            pos--;
        }
        return res;
    }

    public static void main(String[] args) {
        int[] ints = sortedSquares(new int[]{-4, -1, 0, 3, 10});
        for (int a : ints) {
            System.out.println(a);
        }
    }
}

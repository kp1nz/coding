package Java.leetcode.normal._4unsorted;

/**
 * 两数之和 II - 输入有序数组
 * 输入：numbers = [2,7,11,15], target = 9
 * 输出：[1,2]
 * 解释：2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 *
 * @Author: kp1nz
 * @Date: 2021/7/13 10:19 AM
 */
public class _167 {
    /**
     * 执行用时：302 ms, 在所有 Java 提交中击败了5.00%的用户
     * 内存消耗：38.7 MB, 在所有 Java 提交中击败了37.17%的用户
     * zzz...
     */
    public static int[] twoSum(int[] numbers, int target) {
        int res[] = new int[2];
        int count = 0;
        for(int s = 0, e = s + 1; e < numbers.length;){
            if (numbers[s] + numbers[e] == target){
                res[0] = s + 1;
                res[1] = e + 1;
                return res;
            }
            if (e == numbers.length-1){
                s++;
                e = s + 1;
                count++;
                continue;
            }
            e++;
            count++;
        }
        System.out.println(count);
        return res;
    }
    public static int[] twoSumBetter(int[] numbers, int target){
        int s = 0, e = numbers.length - 1;
        int count = 0;
        while (s < e) {
            int sum = numbers[s] + numbers[e];
            if (sum == target) {
                count++;
                return new int[]{s + 1, e + 1};
            }
            if (sum < target) {
                s++;
            } else {
                e--;
            }
            count++;
        }
        System.out.println(count);
        return null;
    }

    public static void main(String[] args) {
        int[] ints = twoSum(new int[]{5, 25, 75}, 100);
        int[] ints1 = twoSumBetter(new int[]{5, 25, 75}, 100);
        for (int a :
                ints) {
            System.out.println(a);
        }
    }
}

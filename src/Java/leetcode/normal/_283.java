package Java.leetcode.normal;

/**
 * 移动零
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 *
 * @Author: kp1nz
 * @Date: 2021/7/13 10:01 AM
 */
public class _283 {
    public static void moveZeroes(int[] nums) {
        for (int s = 0, e = s + 1; e < nums.length; ) {
            if (nums[s] == 0){
                if (nums[e] != 0){
                    int tmp = nums[s];
                    nums[s] = nums[e];
                    nums[e] = tmp;
                }else {
                    e++;
                    continue;
                }
            }
            s++;
            e++;
        }
    }

    public static void main(String[] args) {
        int[] nums = {0, 1, 0, 3, 12};
        moveZeroes(nums);
        for (int a :
             nums) {
            System.out.println(a);
        }
    }
}

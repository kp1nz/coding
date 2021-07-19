package Java.leetcode.normal._1easy;

/**
 * 7. 整数反转
 * 示例 1：
 * <p>
 * 输入：x = 123
 * 输出：321
 *
 * @Author: kp1nz
 * @Date: 2021/7/15 1:58 PM
 */
public class _7 {
    public static int reverse(int x) {
        boolean t = false;
        if (x < 0) {
            x = -x;
            t = !t;
        }
        int res = 0;
        while (x > 0) {
            if (res> Integer.MAX_VALUE/10
                    ||res<Integer.MIN_VALUE/10) return 0;
            res *= 10;
            res += x % 10;
            x /= 10;
        }
        if (t) return -res;
        else return res;
    }

    public static void main(String[] args) {
        System.out.println(reverse(-987));
        System.out.println((reverse(1534236469)));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.MIN_VALUE);
    }
}

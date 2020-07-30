package Java.leetcode;

/**
 * K>=17 超时。。。
 *
 * @Author: kp1nz
 * @Date: 2020/7/31 12:01 上午
 */
public class _1015 {
    public static int smallestRepunitDivByK(int K) {
        if (K % 2 == 0 || K % 5 == 0) return -1;
        int x = 1;
        int len = 1;
        while (x % K != 0) {
            x = x * 10 + 1;
            len++;
        }
        return len;
    }

    public static void main(String[] args) {
        System.out.println(smallestRepunitDivByK(17));
    }
}

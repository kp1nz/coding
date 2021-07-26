package Java.leetcode.normal._1easy;

/**
 * 231. 2 的幂
 *
 * @Author: kp1nz
 * @Date: 2021/7/26 2:18 PM
 */
public class _231 {
    /**
     * 2的幂次方n一定满足以下两个条件
     * 1、大于等于1
     * 2、n的二进制最高位一定是1，且其余位全是0
     *         即n-1的二进制必然全是1
     */
    public boolean isPowerOfTwo(int n) {
        return n >= 1 && (n & (n - 1)) == 0;
    }
}

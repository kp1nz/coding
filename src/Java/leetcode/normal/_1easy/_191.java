package Java.leetcode.normal._1easy;

/**
 * 191. 位1的个数
 *
 * @Author: kp1nz
 * @Date: 2021/7/26 2:35 PM
 */
public class _191 {
    // you need to treat n as an unsigned value

    /**
     * 算术右移 >> ：舍弃最低位，高位用符号位填补；
     * 逻辑右移 >>> ：舍弃最低位，高位用 0 填补。
     */
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            count += n & 1;
            n >>>= 1;
        }
        return count;
    }

    public int hammingWeightBetter(int n) {
        if (n == 0) return 0;
        int count = 1;
        while ((n = (n & (n - 1))) != 0)
            count++;
        return count;
    }
}

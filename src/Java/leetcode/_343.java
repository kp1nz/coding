package Java.leetcode;

/**
 * @Author: kp1nz
 * @Date: 2020/7/30 10:50 下午
 */
public class _343 {
    // n/3 --> {n%3=1  n%3=2}
    public static int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        int p = n / 3;
        int l = n % 3;
        if (l == 1) return (int) Math.pow(3, p - 1) * 4;
        else if (l == 2) return (int) Math.pow(3, p) * 2;
        else return (int) Math.pow(3, p);
    }

    public static void main(String[] args) {
        System.out.println(integerBreak(2));
        System.out.println(integerBreak(3));
        System.out.println(integerBreak(4));
    }
}

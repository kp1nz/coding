package leetcode;

/**
 * @author kp1nz
 * @create 2019-04-14 19:14
 */
public class ReverseInteger {

    public static int reverse(int x) {

        if (x == 0) return x;
        if (x <= Integer.MIN_VALUE || x >= Integer.MAX_VALUE) {
            return 0;
        }
        boolean neg = false;
        if (x < 0) {
            neg = !neg;
            x = -x;
        }
        StringBuilder sb = new StringBuilder();
        while (x > 0) {
            int a = x % 10;
            sb.append(a);
            x /= 10;
        }
        if (neg)
            return Integer.valueOf(sb.toString());
        else return Math.abs(Integer.valueOf(sb.toString()));
    }

    public static void main(String[] args) {
    }
}

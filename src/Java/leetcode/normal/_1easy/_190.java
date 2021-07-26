package Java.leetcode.normal._1easy;

/**
 * 190. 颠倒二进制位
 *
 * @Author: kp1nz
 * @Date: 2021/7/26 3:26 PM
 */
public class _190 {
    // you need treat n as an unsigned value
    public int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }


    private static final int M1 = 0x55555555; // 01010101010101010101010101010101
    private static final int M2 = 0x33333333; // 00110011001100110011001100110011
    private static final int M4 = 0x0f0f0f0f; // 00001111000011110000111100001111
    private static final int M8 = 0x00ff00ff; // 00000000111111110000000011111111

    public int reverseBitsBetter(int n) {
        int res = n;
        // 交换前后16位
        res = (res >>> 16) | (res << 16);
        // 在每个16位中再交换8位
        res = ((res & 0xff00ff00) >>> 8) | ((res & 0x00ff00ff) << 8);
        // 在每个8位中再交换4位
        res = ((res & 0xf0f0f0f0) >>> 4) | ((res & 0x0f0f0f0f) << 4);
        // ... 1100110011001100...          0011001100110011...
        res = ((res & 0xcccccccc) >>> 2) | ((res & 0x33333333) << 2);
        //     1010101010101010...          0101010101010101...
        res = ((res & 0xaaaaaaaa) >>> 1) | ((res & 0x55555555) << 1);
        return res;
    }



    public static void main(String[] args) {
        _190 v = new _190();
        System.out.println(v.reverseBitsBetter(43261596));
    }
}

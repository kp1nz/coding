package kyu_6p;

/**
 * A digital root is the recursive sum of all the digits in a number.
 * Given n, take the sum of the digits of n.
 * If that value has more than one digit, continue reducing in this way until a single-digit number is produced.
 * This is only applicable to the natural numbers.
 * digital_root(16)
 * => 1 + 6
 * => 7
 * <p>
 * digital_root(942)
 * => 9 + 4 + 2
 * => 15 ...
 * => 1 + 5
 * => 6
 *
 * @author kp1nz
 * @create 2019-03-18 10:39
 */
public class Digital_Root {

    public static void main(String[] args) {
        System.out.println(digital_root(942));

    }

    public static int digital_root(int n) {
        return root(n);
    }
    private static int digital(int N){
        String s = String.valueOf(N);
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int num = c - '0';
            res += num;
        }
        return res;
    }
    private static int root(int N){
        if (N<10){
            return N;
        }
        N = digital(N);
        return root(N);
    }
}

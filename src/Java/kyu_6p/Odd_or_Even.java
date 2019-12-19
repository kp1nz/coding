package kyu_6p;

import static java.util.Arrays.stream;

/**
 * java8新特性初识
 * stream(array).sum()
 *
 * @author kp1nz
 * @create 2019-03-19 15:32
 */
public class Odd_or_Even {

    public static String oddOrEven (final int[] array) {
        return stream(array).sum() % 2 == 0 ? "even" : "odd";
    }

    public static void main(String[] args) {
        System.out.println(oddOrEven(new int[] {2, 5, 34, 6}));
    }
}

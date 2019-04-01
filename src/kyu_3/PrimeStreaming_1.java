package kyu_3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.IntStream;

/**
 * @author kp1nz
 * @create 2019-04-01 16:26
 */
public class PrimeStreaming_1 {
    private static final int SIZE = 20000001;   //应付测试，需要更大再重新定义
    private static final boolean[] VALUES = new boolean[SIZE];
    private static final Set<Integer> PROCESSED_PRIMES = new HashSet<>();

    static {
        //给boolean[]赋值
        Arrays.fill(VALUES, true);
        rejectByDivider(2);
    }

    public static IntStream stream() {
        return IntStream.iterate(2, prev -> {
            for (int next = prev + 1; next < SIZE; next++) {
                if (VALUES[next]) {
                    rejectByDivider(next);
                    return next;
                }
            }
            throw new RuntimeException("范围过大！");
        });
    }

    private static void rejectByDivider(int divider) {
        if (PROCESSED_PRIMES.contains(divider)) {
            return;
        }

        for (int i = divider * 2; i < SIZE; i += divider) {
            VALUES[i] = false;
        }

        PROCESSED_PRIMES.add(divider);
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int[] primes = PrimeStreaming_1.stream().skip(1000).limit(10).toArray();
        for (int a :
                primes) {
            System.out.print(a + ",");
        }
        long l1 = System.currentTimeMillis();
        System.err.println(l1-l);


    }

}
package kyu_3;

import java.util.stream.IntStream;

/**
 * @author kp1nz
 * @create 2019-04-01 17:00
 */
public class PrimeStreaming_2 {
    private static final int N = 20000000;
    private static final boolean[] SIEVE = new boolean[N + 1];//让数组位置与其大小相同

    static {
        //所有因数都是成对出现的，且其中一个因数必然小于该数的开平方
        for (int i = 2; i * i <= N; i++) {
            //初始值为false
            if (!SIEVE[i]) {
                for (int j = i; i * j <= N; j++) {
                    SIEVE[i * j] = true;
                }
            }
        }
    }

    public static IntStream stream() {
        return IntStream.range(2, N).filter(x -> !SIEVE[x]);
    }

    public static void main(String[] args) {
        long l = System.currentTimeMillis();
        int[] primes = PrimeStreaming_2.stream().skip(1000).limit(10).toArray();
        for (int a :
                primes) {
            System.out.print(a + ",");
        }
        long l1 = System.currentTimeMillis();
        System.err.println(l1-l);
    }
}

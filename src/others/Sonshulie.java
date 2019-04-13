package others;

import java.util.Scanner;

/**
 * @author kp1nz
 * @create 2019-04-10 20:21
 */
public class Sonshulie {
    public static int maxSub(int[] arr, int N) {
        int sum = 0;
        for (int i = 0; i < N; i++) {
            for (int j = i; j < N; j++) {
                int asum = 0;
                for (int k = i; k <= j; k++) {
                    asum += arr[k];
                    if (asum > sum)
                        sum = asum;
                }
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            int[] arr = new int[a];
            for (int i = 0; i < a; i++) {
                arr[i] = in.nextInt();
            }
            System.out.println(maxSub(arr, a));
        }
    }
}

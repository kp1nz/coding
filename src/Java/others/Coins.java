package others;

import java.util.Scanner;

/**
 * @author kp1nz
 * @create 2019-03-16 10:48
 */
public class Coins {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int N = in.nextInt();
            System.out.println(compute(N));
        }
    }

    private static int compute(int N) {
        int total =1024;
        int m_64 = 0;
        int m_16 = 0;
        int m_4 = 0;
        int m_1 = 0;
        int res = 1024-N;
        m_64 = res/64;
        res = res-m_64*64;
        m_16 = res/16;
        res = res-m_16*16;
        m_4 = res/4;
        res = res-m_4*4;
        m_1 = res/1;
        res = res-m_1*1;
        if (res!=0){
            System.out.println("error!");
        }
        return m_1+m_4+m_16+m_64;
    }
}

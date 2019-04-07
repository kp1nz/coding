package study;

/**
 * @author kp1nz
 * @create 2019-04-02 16:36
 */
public class Test {
    public static void resolve() {

        int num, temp, m;
        for (int i = 1; i < 256; i++) {
            num = i * i;
            m = 0;
            while (num > 0) {
                temp = num % 10;
                m = temp + m * 10;
                num = num / 10;
            }
            if (m == i * i)
                System.out.println(i);
        }
    }

    public static void main(String[] args) {
//        resolve();
        System.out.println(1-'0'+48);
    }
}

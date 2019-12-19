package others;

import java.util.Scanner;

/**
 * @author kp1nz
 * @create 2019-04-10 20:05
 */
public class Num2018 {
    public static int get(int num) {
        int res = 0;
        for (int i = 0; i <= num; i++) {
            String s = String.valueOf(i);
            if (s.indexOf("2") < s.indexOf("0")
                    && s.indexOf("0") < s.indexOf("1")
                    && s.indexOf("1") < s.indexOf("8"))
                res++;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {
            int a = in.nextInt();
            System.out.println(get(a));
        }

//        String string = "2018";
//        System.out.println(String.valueOf(string.indexOf("2")));
//        System.out.println(String.valueOf(string.indexOf("0"));
//        System.out.println(String.valueOf(string.indexOf("1"));
//        System.out.println(String.valueOf(string.indexOf("8"));

    }
}

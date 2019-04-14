package others;

import java.util.Scanner;

/**
 * @author kp1nz
 * @create 2019-04-14 10:24
 */
public class ByteDance_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        String input = scanner.nextLine();
        int[] array = new int[n];
        String[] inputs = input.split(" ");
        for (int i = 0; i < inputs.length; i++) {
            array[i] = Integer.valueOf(inputs[i]);
        }
        System.out.println(resolve(array));
    }

    public static int resolve(int[] s1) {
        int a = s1[0];
        int a1 = getA(s1,a);
        if(a1<0){
            a1=(-a1)/2;
        }
        while (a1>0){
            a--;
            a1 = getA(s1,a);
        }
        return ++a;
    }

    public static int getA(int[] s1, int a) {
        for (int i = 1; i < s1.length; i++) {
            int def =s1[i] - a;
            if (def > 0) {
                a -= def;
            } else a += def;
        }
        return a;
    }


}

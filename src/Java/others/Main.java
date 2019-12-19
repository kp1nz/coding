package others;

import java.util.Scanner;

/**
 * @author kp1nz
 * @create 2019-04-15 23:18
 */
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N = scan.nextInt();
        int M = scan.nextInt();
        int P = scan.nextInt();
        int food[] = new int[1000];
        //每种食物的个数，循环读入数组中
        for (int i = 0; i < N; i++) {
            food[i] = scan.nextInt();
        }
        int k = 0;
        while (k < M) {
            char input1 = scan.next().charAt(0);
            int input2 = scan.nextInt();
            switch (input1){
                //数组下标请注意-1，从零开始的
                case 'B':food[input2-1]--;
                    break;
                case 'A':food[input2-1]++;
                    break;
            }
            k++;
        }
        int  aar_index = 1;
        for (int i = 0; i < N; i++) {
            if (food[i] > food[P-1]) {
                aar_index ++;
            }
        }
        System.out.println(aar_index);
    }
}
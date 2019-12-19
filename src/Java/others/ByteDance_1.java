package others;

import java.util.Scanner;

/**
 * @author kp1nz
 * @create 2019-04-14 10:09
 */
public class ByteDance_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[][] input = null;
        while (sc.hasNextLine() && sc.nextLine() != null || sc.nextLine() != "") {
            String s = sc.nextLine();
            String[] s1 = s.split(" ");
            input = new int[s1.length][s1.length];
        }
        System.out.println(solution(input));
    }
    public static int solution(int[][] input) {
        int[] col = new int[]{0, 0, 1, -1};
        int[] row = new int[]{1, -1, 0, 0};
        int change = 0;
        for (int i = 0; i < input.length; i++) {
            for (int j = 0; j < input[i].length; j++) {
                // 进行字符的判断
                int temp = input[i][j];
                if (temp == 2) {
                    for (int k = 0; k < 4; k++) {
                        change = change(input, i + col[k], j + row[k]);
                    }
                }
            }
        }return change;
    }

    public static int change(int[][] input, int i, int j) {
        int count = 0;
        if (i >= input.length || i < 0 || j >= input[i].length || j < 0) return -1;
        if (input[i][j] == 1){
            input[i][j] = 2;
            count++;
        }
        return count;
    }

}

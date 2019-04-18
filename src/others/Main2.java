package others;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author kp1nz
 * @create 2019-04-16 19:45
 */
public class Main2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextLine()){
            String s = scanner.nextLine();
            System.out.println(solution(s));
        }
    }
    public static String solution(String string){
        if (string ==null || string==" ") throw new InputMismatchException("输入有误！");
        String[] s = string.split(" ");
        int count = 0;
        for (int i = 0;i<s.length-1;i++){
            if (Integer.valueOf(s[i])>Integer.valueOf(s[i+1]))
                count++;
        }
        if (count>1)
            return "No";
        else return "Yes";
    }
}

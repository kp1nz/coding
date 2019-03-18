import java.util.Scanner;

/**
 * @author kp1nz
 * @create 2019-03-08 11:03
 */
public class 击鼓传花 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            //人数
            int num = scanner.nextInt();
            //次数
            int count = scanner.nextInt();
            System.out.println(compute(num,count));
        }
    }
    private static int compute(int num,int count){
        if (count == 0) return 1;
        if (count == 1) return 0;
        return 0;
    }
}
